package com.inditex.sisu.domain.price.service;

import com.inditex.sisu.common.Page;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;

import org.springframework.data.domain.Pageable;

import java.sql.SQLException;

public interface PriceService {
    Page<PriceDto> getAllByFilter(PriceRequestFilterDto filter, Pageable pageable) throws SQLException;
}
