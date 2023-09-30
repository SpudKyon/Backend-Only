package com.dongdong.yx.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.acl.mapper.AdminRoleMapper;
import com.dongdong.yx.acl.service.AdminRoleService;
import com.dongdong.yx.model.acl.AdminRole;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
    @Override
    public boolean save(AdminRole entity) {
        return super.save(entity);
    }

}
