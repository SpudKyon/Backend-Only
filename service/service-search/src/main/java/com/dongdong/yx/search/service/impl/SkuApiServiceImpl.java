package com.dongdong.yx.search.service.impl;

import com.alibaba.fastjson2.JSON;
import com.dongdong.yx.client.product.ProductFeignClient;
import com.dongdong.yx.enums.SkuType;
import com.dongdong.yx.model.product.Category;
import com.dongdong.yx.model.product.SkuInfo;
import com.dongdong.yx.model.search.SkuEs;
import com.dongdong.yx.search.repository.SkuRepository;
import com.dongdong.yx.search.service.SkuApiService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SkuApiServiceImpl implements SkuApiService {
    @Autowired
    @Lazy
    private ProductFeignClient productFeignClient;

    @Autowired
    private SkuRepository skuEsRepository;

    /**
     * 上架商品列表
     */
    @Override
    public void upperSku(Long skuId) {
        log.info("upperSku：" + skuId);
        SkuEs skuEs = new SkuEs();

        //查询sku信息
        SkuInfo skuInfo = productFeignClient.getSkuInfo(skuId);
        if (null == skuInfo) return;

        // 查询分类
        Category category = productFeignClient.getCategory(skuInfo.getCategoryId());
        if (category != null) {
            skuEs.setCategoryId(category.getId());
            skuEs.setCategoryName(category.getName());
        }
        skuEs.setId(skuInfo.getId());
        skuEs.setKeyword(skuInfo.getSkuName() + "," + skuEs.getCategoryName());
        skuEs.setWareId(skuInfo.getWareId());
        skuEs.setIsNewPerson(skuInfo.getIsNewPerson());
        skuEs.setImgUrl(skuInfo.getImgUrl());
        skuEs.setTitle(skuInfo.getSkuName());
        if (skuInfo.getSkuType() == SkuType.COMMON.getCode()) {
            skuEs.setSkuType(0);
            skuEs.setPrice(skuInfo.getPrice().doubleValue());
            skuEs.setStock(skuInfo.getStock());
            skuEs.setSale(skuInfo.getSale());
            skuEs.setPerLimit(skuInfo.getPerLimit());
        } else {
            //TODO 待完善-秒杀商品

        }
        SkuEs save = skuEsRepository.save(skuEs);
        log.info("upperSku：" + JSON.toJSONString(save));
    }

    /**
     * 下架商品列表
     */
    @Override
    public void lowerSku(Long skuId) {
        this.skuEsRepository.deleteById(skuId);
    }
}
