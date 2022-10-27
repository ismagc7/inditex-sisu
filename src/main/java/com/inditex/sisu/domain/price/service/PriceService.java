package com.inditex.sisu.domain.price.service;

import com.inditex.sisu.common.Page;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.dto.PriceResponse;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;

public interface PriceService {
    Page<PriceResponse> getAllByFilter(PriceRequestFilterDto filter, Pageable pageable) throws SQLException;
}
