package com.dongdong.yx.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.model.sys.Region;
import com.dongdong.yx.sys.mapper.RegionMapper;
import com.dongdong.yx.sys.service.RegionService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
    @Override
    public List<Region> findRegionByKeyword(String keyword) {
        LambdaQueryWrapper<Region> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Region::getName, keyword);
        return baseMapper.selectList(wrapper);
    }
}
