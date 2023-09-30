package com.dongdong.yx.acl.controller;

import com.dongdong.yx.acl.service.PermissionService;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.acl.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/acl/permission")
@Api(tags = "菜单管理")
@CrossOrigin
public class PermissionAdminController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取菜单")
    @GetMapping
    public Result<List<Permission>> index() {
        List<Permission> list = permissionService.listAllMenu();
        return Result.success(list);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping("save")
    public Result<String> save(@RequestBody Permission permission) {
        boolean saved = permissionService.save(permission);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody Permission permission) {
        boolean updated = permissionService.updateById(permission);
        return updated ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "递归删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = permissionService.removeChildById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }
}
