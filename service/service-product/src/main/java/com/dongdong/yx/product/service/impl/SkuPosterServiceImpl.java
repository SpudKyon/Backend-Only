package com.dongdong.yx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.model.product.SkuPoster;
import com.dongdong.yx.product.mapper.SkuPosterMapper;
import com.dongdong.yx.product.service.SkuPosterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuPosterServiceImpl extends ServiceImpl<SkuPosterMapper, SkuPoster> implements SkuPosterService {

    //根据id查询商品海报列表
    @Override
    public List<SkuPoster> getPosterListBySkuId(Long id) {
        LambdaQueryWrapper<SkuPoster> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuPoster::getSkuId, id);
        return baseMapper.selectList(wrapper);
    }
}
