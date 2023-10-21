package com.dongdong.yx.product.api;

import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.product.Category;
import com.dongdong.yx.model.product.SkuInfo;
import com.dongdong.yx.product.service.CategoryService;
import com.dongdong.yx.product.service.SkuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "内部远程调用")
@RequestMapping("/api/product")
public class ProductInnerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation(value = "根据id获取分类信息")
    @GetMapping("getCatagory/{categoryId}")
    public Result getCategory(@PathVariable long categoryId) {
        Category category = categoryService.getById(categoryId);
        return category == null ? Result.fail(null) : Result.success(null);
    }

    @ApiOperation(value = "根据skuID获取sku信息")
    @GetMapping("getskuInfo/{skuId}")
    public Result getSkuInfo(@PathVariable long skuId) {
        SkuInfo skuInfo = skuInfoService.getById(skuId);
        return skuInfo == null ? Result.fail(null) : Result.success(null);
    }
}
