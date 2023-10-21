package com.dongdong.yx.search.service;

public interface SkuApiService {

    /**
     * 上架商品列表
     */
    void upperSku(Long skuId);

    /**
     * 下架商品列表
     */
    void lowerSku(Long skuId);

}
