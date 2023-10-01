package com.dongdong.yx.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.sys.Region;

import java.util.List;

public interface RegionService extends IService<Region> {
    List<Region> findRegionByKeyword(String keyword);
}
