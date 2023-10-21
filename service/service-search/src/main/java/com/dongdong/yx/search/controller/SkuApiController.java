package com.dongdong.yx.search.controller;

import com.dongdong.yx.client.product.ProductFeignClient;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.search.service.SkuApiService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/search/sku")
public class SkuApiController {

    @Autowired
    private SkuApiService skuApiService;

    @ApiOperation(value = "上架商品")
    @GetMapping("inner/upperSku/{skuId}")
    public Result upperGoods(@PathVariable("skuId") Long skuId) {
        skuApiService.upperSku(skuId);
        return Result.success(null);
    }

    @ApiOperation(value = "下架商品")
    @GetMapping("inner/lowerSku/{skuId}")
    public Result lowerGoods(@PathVariable("skuId") Long skuId) {
        skuApiService.lowerSku(skuId);
        return Result.success(null);
    }
}