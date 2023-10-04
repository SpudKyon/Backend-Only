package com.dongdong.yx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.product.Category;
import com.dongdong.yx.vo.product.CategoryQueryVo;

import java.util.List;

public interface CategoryService extends IService<Category> {

    IPage<Category> selectPage(Page<Category> pageParam, CategoryQueryVo categoryQueryVo);

    List<Category> findAllList();
}