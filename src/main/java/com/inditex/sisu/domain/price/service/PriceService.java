package com.inditex.sisu.domain.price.service;

import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;

import java.util.List;

public interface PriceService {
    List<PriceDto> getAll();
    List<PriceDto> getByFilter(PriceRequestFilterDto filter);
}
