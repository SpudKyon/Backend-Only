package com.dongdong.yx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.product.SkuAttrValue;

import java.util.List;

public interface SkuAttrValueService extends IService<SkuAttrValue> {

    //根据id查询商品属性信息列表
    List<SkuAttrValue> getAttrValueListBySkuId(Long id);
}
