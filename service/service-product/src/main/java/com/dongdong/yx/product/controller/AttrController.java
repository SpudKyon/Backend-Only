package com.dongdong.yx.product.controller;

import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.product.Attr;
import com.dongdong.yx.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Attr管理", tags = "平台属性管理")
@RestController
@RequestMapping(value = "/admin/product/attr")
@CrossOrigin
public class AttrController {

    @Autowired
    private AttrService attrService;

    @ApiOperation(value = "获取列表")
    @GetMapping("{attrGroupId}")
    public Result<List<Attr>> index(
            @ApiParam(name = "attrGroupId", value = "分组id", required = true)
            @PathVariable Long attrGroupId) {
        return Result.success(attrService.findByAttrGroupId(attrGroupId));
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<Object> get(@PathVariable Long id) {
        Attr attr = attrService.getById(id);
        return Result.success(attr);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result<String> save(@RequestBody Attr attr) {
        boolean saved = attrService.save(attr);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody Attr attr) {
        boolean removed = attrService.updateById(attr);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = attrService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result<String> batchRemove(@RequestBody List<Long> idList) {
        boolean removed = attrService.removeByIds(idList);
        return removed ? Result.success(null) : Result.fail(null);
    }
}