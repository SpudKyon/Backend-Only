package com.dongdong.yx.sys.controller;

import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.sys.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "区域接口")
@RestController
@RequestMapping("/admin/sys/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation(value = "根据关键字获取地区列表")
    @GetMapping("findRegionByKeyword/{keyword}")
    public Result findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        return Result.success(regionService.findRegionByKeyword(keyword));
    }
}