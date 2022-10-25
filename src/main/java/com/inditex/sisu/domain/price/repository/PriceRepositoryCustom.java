package com.inditex.sisu.domain.price.repository;

import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface PriceRepositoryCustom {
    PageImpl<PriceDao> findAllByFilter(PriceRequestFilterDto filter, Pageable pageable);
}
