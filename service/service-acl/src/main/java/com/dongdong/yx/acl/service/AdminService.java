package com.dongdong.yx.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.acl.Admin;
import com.dongdong.yx.vo.acl.AdminQueryVo;

public interface AdminService extends IService<Admin> {

    IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo);
}
