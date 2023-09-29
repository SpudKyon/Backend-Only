package com.dongdong.yx.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongdong.yx.acl.service.RoleService;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.acl.Role;
import com.dongdong.yx.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/acl/role")
@Api(tags = "用户管理")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<Role>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页数目", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "roleQueryVo", value = "查询对象", required = true)
            RoleQueryVo roleQueryVo) {
        Page<Role> rolePage = new Page<>(page, limit);
        IPage<Role> selected = roleService.selectPage(rolePage, roleQueryVo);
        return Result.success(selected);
    }

    @ApiOperation(value = "获取角色")
    @GetMapping("get/{id}")
    public Result<Role> get(@PathVariable Long id) {
        Role role = roleService.getById(id);
        return Result.success(role);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public Result<String> save(@RequestBody Role role) {
        boolean saved = roleService.save(role);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "更新角色")
    @PostMapping("update")
    public Result update(@RequestBody Role role) {
        boolean updated = roleService.updateById(role);
        return updated ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable Long id) {
        boolean removed = roleService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "根据ID批量删除角色")
    @DeleteMapping("batchremove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        boolean removed = roleService.removeByIds(idList);
        return removed ? Result.success(null) : Result.fail(null);
    }
}
