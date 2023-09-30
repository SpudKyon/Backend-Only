package com.dongdong.yx.acl.service.impl;

import  com.dongdong.common.utils.PermissionHelper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.acl.mapper.PermissionMapper;
import com.dongdong.yx.acl.service.PermissionService;
import com.dongdong.yx.model.acl.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public List<Permission> listAllMenu() {
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));

        List<Permission> result = PermissionHelper.build(allPermissionList);
        return result;
    }

    @Override
    public boolean removeChildById(Long id) {
        return false;
    }
}
