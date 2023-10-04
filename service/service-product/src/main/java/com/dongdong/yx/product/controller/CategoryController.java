package com.dongdong.yx.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.product.Category;
import com.dongdong.yx.product.service.CategoryService;
import com.dongdong.yx.vo.product.CategoryQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Category管理", tags = "商品分类管理")
@RestController
@RequestMapping(value = "/admin/product/category")
@SuppressWarnings({"unchecked", "rawtypes"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取商品分类分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "categoryQueryVo", value = "查询对象", required = false)
            CategoryQueryVo categoryQueryVo) {
        IPage<Category> pageModel = categoryService.selectPage(new Page<>(page, limit), categoryQueryVo);
        return Result.success(pageModel);
    }

    @ApiOperation(value = "获取商品分类信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        return Result.success(category);
    }

    @ApiOperation(value = "新增商品分类")
    @PostMapping("save")
    public Result<String> save(@RequestBody Category category) {
        boolean saved = categoryService.save(category);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "修改商品分类")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody Category category) {
        boolean updated = categoryService.updateById(category);
        return updated ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除商品分类")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = categoryService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "根据id列表删除商品分类")
    @DeleteMapping("batchRemove")
    public Result<String> batchRemove(@RequestBody List<Long> idList) {
        boolean removed = categoryService.removeByIds(idList);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "获取全部商品分类")
    @GetMapping("findAllList")
    public Result<List<Category>> findAllList() {
        return Result.success(categoryService.findAllList());
    }
}