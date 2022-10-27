package com.inditex.sisu.domain.price.service;


import com.inditex.sisu.common.Page;
import com.inditex.sisu.domain.price.converter.PriceConverter;
import com.inditex.sisu.domain.price.converter.PriceMapper;
import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.dto.PriceResponse;
import com.inditex.sisu.domain.price.repository.PriceRepositoryCustom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PriceServiceImpl implements PriceService {
    private final PriceMapper priceMapper;
    private final PriceRepositoryCustom priceRepositoryCustom;

    private final PriceConverter priceConverter;
    @Autowired
    public PriceServiceImpl(PriceMapper priceMapper, PriceRepositoryCustom priceRepositoryCustom,
                            PriceConverter priceConverter) {
        this.priceMapper = priceMapper;
        this.priceRepositoryCustom = priceRepositoryCustom;
        this.priceConverter = priceConverter;
    }

    @Override
    public Page<PriceResponse> getAllByFilter(PriceRequestFilterDto filter, Pageable pageable) {

        org.springframework.data.domain.Page<PriceDao> pricesPage = priceRepositoryCustom.findAllByFilter(filter, pageable);
        List<PriceResponse> list = priceConverter.toResponse(pricesPage.getContent());
        return new com.inditex.sisu.common.Page<>(list, pricesPage.getSize(), pricesPage.getTotalElements());
    }
}
