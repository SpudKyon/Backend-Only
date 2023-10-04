package com.dongdong.yx.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.product.AttrGroup;
import com.dongdong.yx.product.service.AttrGroupService;
import com.dongdong.yx.vo.product.AttrGroupQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "AttrGroup管理", tags = "平台属性分组管理")
@RestController
@RequestMapping(value="/admin/product/attrGroup")
@CrossOrigin
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<AttrGroup>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "attrGroupQueryVo", value = "查询对象", required = false)
            AttrGroupQueryVo attrGroupQueryVo) {
        IPage<AttrGroup> pageModel = attrGroupService.selectPage(new Page<>(page, limit), attrGroupQueryVo);
        return Result.success(pageModel);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<AttrGroup> get(@PathVariable Long id) {
        AttrGroup attrGroup = attrGroupService.getById(id);
        return Result.success(attrGroup);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result<String> save(@RequestBody AttrGroup attrGroup) {
        boolean saved = attrGroupService.save(attrGroup);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody AttrGroup attrGroup) {
        boolean updated = attrGroupService.updateById(attrGroup);
        return updated ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = attrGroupService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result<String> batchRemove(@RequestBody List<Long> idList) {
        boolean removed = attrGroupService.removeByIds(idList);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "获取全部属性分组")
    @GetMapping("findAllList")
    public Result<List<AttrGroup>> findAllList() {
        return Result.success(attrGroupService.findAllList());
    }
}