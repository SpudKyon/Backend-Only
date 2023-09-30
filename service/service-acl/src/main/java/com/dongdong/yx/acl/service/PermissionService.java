package com.dongdong.yx.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.acl.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {

    /**
     * 树形结构返回list
     */
    List<Permission> listAllMenu();

    boolean removeChildById(Long id);
}
