package com.dongdong.yx.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.product.SkuInfo;
import com.dongdong.yx.product.service.SkuInfoService;
import com.dongdong.yx.vo.product.SkuInfoQueryVo;
import com.dongdong.yx.vo.product.SkuInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SkuInfo管理", tags = "商品Sku管理")
@RestController
@RequestMapping(value = "/admin/product/skuInfo")
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation(value = "获取sku分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<SkuInfo>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "skuInfoQueryVo", value = "查询对象", required = false)
            SkuInfoQueryVo skuInfoQueryVo) {
        Page<SkuInfo> pageParam = new Page<>(page, limit);
        IPage<SkuInfo> pageModel = skuInfoService.selectPage(pageParam, skuInfoQueryVo);
        return Result.success(pageModel);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result<String> save(@RequestBody SkuInfoVo skuInfoVo) {
        boolean removed = skuInfoService.saveSkuInfo(skuInfoVo);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<SkuInfoVo> get(@PathVariable Long id) {
        SkuInfoVo skuInfoVo = skuInfoService.getSkuInfoVo(id);
        return Result.success(skuInfoVo);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody SkuInfoVo skuInfoVo) {
        boolean removed = skuInfoService.updateSkuInfo(skuInfoVo);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = skuInfoService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result<String> batchRemove(@RequestBody List<Long> idList) {
        boolean removed = skuInfoService.removeByIds(idList);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "商品审核")
    @GetMapping("check/{skuId}/{status}")
    public Result<String> check(@PathVariable("skuId") Long skuId, @PathVariable("status") Integer status) {
        boolean checked = skuInfoService.check(skuId, status);
        return checked ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "商品上下架")
    @GetMapping("publish/{skuId}/{status}")
    public Result<String> publish(@PathVariable("skuId") Long skuId,
                                  @PathVariable("status") Integer status) {
        boolean published = skuInfoService.publish(skuId, status);
        return published ? Result.success(null) : Result.fail(null);
    }

    @GetMapping("isNewPerson/{skuId}/{status}")
    public Result<String> isNewPerson(@PathVariable("skuId") Long skuId,
                                      @PathVariable("status") Integer status) {
        boolean newed = skuInfoService.isNewPerson(skuId, status);
        return newed ? Result.success(null) : Result.fail(null);
    }
}