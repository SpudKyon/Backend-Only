package com.dongdong.yx.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.common.exception.YxException;
import com.dongdong.yx.common.result.ResultEnum;
import com.dongdong.yx.model.sys.RegionWare;
import com.dongdong.yx.sys.mapper.RegionWareMapper;
import com.dongdong.yx.sys.service.RegionWareService;
import com.dongdong.yx.vo.sys.RegionWareQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare> implements RegionWareService {

    @Override
    public IPage<RegionWare> selectPage(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo) {
        String keyword = regionWareQueryVo.getKeyword();
        LambdaQueryWrapper<RegionWare> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(RegionWare::getRegionName, keyword)
                    .or()
                    .like(RegionWare::getWareName, keyword);
        }
        return baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public boolean saveRegionWare(RegionWare regionWare) {
        LambdaQueryWrapper<RegionWare> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RegionWare::getRegionId, regionWare.getRegionId());
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new YxException(ResultEnum.REGION_OPEN);
        }
        return baseMapper.insert(regionWare) != 0;
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        RegionWare regionWare = baseMapper.selectById(id);
        regionWare.setStatus(status);
        return baseMapper.updateById(regionWare) != 0;
    }
}