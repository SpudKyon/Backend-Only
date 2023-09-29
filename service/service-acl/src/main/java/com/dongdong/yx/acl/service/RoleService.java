package com.dongdong.yx.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.acl.Role;
import com.dongdong.yx.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;

public interface RoleService extends IService<Role> {
    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo);

}
