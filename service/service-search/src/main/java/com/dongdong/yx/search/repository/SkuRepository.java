package com.dongdong.yx.search.repository;

import com.dongdong.yx.model.search.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SkuRepository extends ElasticsearchRepository<SkuEs, Long> {

}