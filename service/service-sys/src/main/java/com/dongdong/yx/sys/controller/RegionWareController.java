package com.dongdong.yx.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.sys.RegionWare;
import com.dongdong.yx.sys.service.RegionWareService;
import com.dongdong.yx.vo.sys.RegionWareQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;


@RestController
@RequestMapping("/admin/sys/regionware")
@Api(value = "region管理", tags = "城市仓库")
public class RegionWareController {

    @Autowired
    private RegionWareService regionWareService;

    @ApiOperation(value = "获取开通区域")
    @GetMapping("{page}/{limit}")
    public Result<IPage<RegionWare>> index(
            @ApiParam(name = "page", value = "页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页数目", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "regionWareVo", value = "查询对象", required = false)
            @RequestBody(required = false)
            RegionWareQueryVo regionWareQueryVo) {
        IPage<RegionWare> selected = regionWareService.selectPage(new Page<RegionWare>(page, limit), regionWareQueryVo);
        return Result.success(selected);
    }

    @ApiOperation(value = "新增开通区域")
    @PostMapping("save")
    public Result<String> save(@RequestBody RegionWare regionWare) {
        boolean saved = regionWareService.saveRegionWare(regionWare);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除区域")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = regionWareService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "取消开通区域")
    @PostMapping("updateStatus/{id}/{status}")
    public Result<String> updateStatus(@PathVariable Long id,@PathVariable Integer status) {
        boolean updated = regionWareService.updateStatus(id, status);
        return updated ? Result.success(null) : Result.fail(null);
    }
}
