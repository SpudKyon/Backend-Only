package com.dongdong.yx.sys.controller;

import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.sys.Ware;
import com.dongdong.yx.sys.service.WareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/sys/ware")
@Api(tags = "仓库管理")
public class WareController {
    @Autowired
    private WareService wareService;

    @ApiOperation("查询所有仓库列表")
    @GetMapping("findAllList")
    public Result findAllList() {
        List<Ware> list = wareService.list();
        return Result.success(list);
    }
}
