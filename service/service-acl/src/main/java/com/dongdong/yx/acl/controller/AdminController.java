package com.dongdong.yx.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongdong.common.utils.MD5;
import com.dongdong.yx.acl.service.AdminService;
import com.dongdong.yx.common.result.Result;
import com.dongdong.yx.model.acl.Admin;
import com.dongdong.yx.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/acl/user")
@Api(tags = "管理员管理")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取管理员列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<Admin>> index(
            @ApiParam(name = "page", value = "当前页", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页数目", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "userQueryVo", value = "查询对象", required = true)
            AdminQueryVo userQueryVo
    ) {
        Page<Admin> adminPage = new Page<>(page, limit);
        IPage<Admin> selected = adminService.selectPage(adminPage, userQueryVo);
        return Result.success(selected);
    }

    @ApiOperation(value = "获取管理员")
    @GetMapping("get/{id}")
    public Result<Admin> get(@PathVariable Long id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @ApiOperation(value = "新增管理员")
    @PostMapping("save")
    public Result<String> save(@RequestBody Admin user) {
        user.setPassword(MD5.encrypt(user.getPassword()));
        boolean saved = adminService.save(user);
        return saved ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "修改管理员")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody Admin user) {
        boolean updated = adminService.updateById(user);
        return updated ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "删除管理员")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        boolean removed = adminService.removeById(id);
        return removed ? Result.success(null) : Result.fail(null);
    }

    @ApiOperation(value = "根据id列表删除管理员")
    @DeleteMapping("batchremove")
    public Result<String> batchRemove(@RequestBody List<Long> idList) {
        boolean removed = adminService.removeByIds(idList);
        return removed ? Result.success(null) : Result.fail(null);
    }
}
