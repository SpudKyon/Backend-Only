package com.dongdong.yx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dongdong.yx.model.product.Attr;

import java.util.List;

public interface AttrService extends IService<Attr> {
    List<Attr> findByAttrGroupId(Long attrGroupId);

}
