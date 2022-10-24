package com.inditex.sisu.domain.price.service;

import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PriceService {
    Page<PriceDto> getAllByFilter(PriceRequestFilterDto filter, Pageable pageable);
}
