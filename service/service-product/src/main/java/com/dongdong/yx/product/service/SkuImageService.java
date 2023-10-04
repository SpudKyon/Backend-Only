package com.dongdong.yx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.product.SkuImage;

import java.util.List;

public interface SkuImageService extends IService<SkuImage> {

    //根据id查询商品图片列表
    List<SkuImage> getImageListBySkuId(Long id);
}
