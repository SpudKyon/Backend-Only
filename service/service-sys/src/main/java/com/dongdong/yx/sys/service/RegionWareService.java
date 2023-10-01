package com.dongdong.yx.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.sys.RegionWare;
import com.dongdong.yx.vo.sys.RegionWareQueryVo;

public interface RegionWareService extends IService<RegionWare> {

    IPage<RegionWare> selectPage(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo);

    boolean saveRegionWare(RegionWare regionWare);

    boolean updateStatus(Long id, Integer status);

}