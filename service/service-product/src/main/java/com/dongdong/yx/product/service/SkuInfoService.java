package com.dongdong.yx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.product.SkuInfo;
import com.dongdong.yx.vo.product.SkuInfoQueryVo;
import com.dongdong.yx.vo.product.SkuInfoVo;

public interface SkuInfoService extends IService<SkuInfo> {

    IPage<SkuInfo> selectPage(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo);

    boolean saveSkuInfo(SkuInfoVo skuInfoVo);

    SkuInfoVo getSkuInfoVo(Long id);

    boolean updateSkuInfo(SkuInfoVo skuInfoVo);

    boolean check(Long skuId, Integer status);

    boolean publish(Long skuId, Integer status);

    boolean isNewPerson(Long skuId, Integer status);

}