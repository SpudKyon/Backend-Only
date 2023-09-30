package com.dongdong.yx.acl.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.acl.service.AdminRoleService;
import com.dongdong.yx.acl.service.RoleService;
import com.dongdong.yx.acl.mapper.RoleMapper;
import com.dongdong.yx.model.acl.AdminRole;
import com.dongdong.yx.model.acl.Role;
import com.dongdong.yx.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private AdminRoleService adminRoleService;

    @Override
    public IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo) {
        String roleName = roleQueryVo.getRoleName();
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(roleName)) {
            wrapper.like(Role::getRoleName, roleName);
        }
        IPage<Role> pageModel = baseMapper.selectPage(pageParam, wrapper);
        return pageModel;
    }

    @Override
    public boolean saveUserRoleRelationShip(Long adminId, Long[] roleIds) {
        adminRoleService.remove(new QueryWrapper<AdminRole>().eq("admin_id", adminId));
        ArrayList<AdminRole> adminRoles = new ArrayList<>();
        for (Long roleId : roleIds) {
            if (StringUtils.isEmpty(roleId))
                continue;
            AdminRole adminRole = new AdminRole();
            adminRole.setRoleId(adminId);
            adminRole.setRoleId(roleId);
            adminRoles.add(adminRole);
        }
        return adminRoleService.saveBatch(adminRoles);
    }

    @Override
    public Map<String, Object> findRoleByUserId(Long adminId) {
        List<Role> allRolesList =baseMapper.selectList(null);

        List<AdminRole> existUserRoleList = adminRoleService.list(
                new QueryWrapper<AdminRole>().eq(
                        "admin_id", adminId).select("role_id"));
        List<Long> existRoleList = existUserRoleList.stream().map(c->c.getRoleId()).collect(Collectors.toList());

        List<Role> assignRoles = new ArrayList<Role>();
        for (Role role : allRolesList) {
            if(existRoleList.contains(role.getId())) {
                assignRoles.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignRoles", assignRoles);
        roleMap.put("allRolesList", allRolesList);
        return roleMap;
    }
}
