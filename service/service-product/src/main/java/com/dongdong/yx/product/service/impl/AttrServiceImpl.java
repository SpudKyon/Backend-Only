package com.dongdong.yx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.model.product.Attr;
import com.dongdong.yx.product.mapper.AttrMapper;
import com.dongdong.yx.product.service.AttrService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {
    @Override
    public List<Attr> findByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId, attrGroupId);
        return baseMapper.selectList(wrapper);
    }
}
