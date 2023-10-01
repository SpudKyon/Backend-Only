package com.dongdong.yx.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongdong.yx.model.sys.Ware;
import com.dongdong.yx.sys.mapper.WareMapper;
import com.dongdong.yx.sys.service.WareService;
import org.springframework.stereotype.Repository;

@Repository
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {
}
