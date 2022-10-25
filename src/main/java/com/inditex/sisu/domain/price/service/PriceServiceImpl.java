package com.inditex.sisu.domain.price.service;


import com.inditex.sisu.common.Page;
import com.inditex.sisu.domain.price.converter.PriceMapper;
import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.repository.PriceRepositoryCustom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private PriceRepositoryCustom priceRepositoryCustom;

    @Override
    public Page<PriceDto> getAllByFilter(PriceRequestFilterDto filter, Pageable pageable) {

        org.springframework.data.domain.Page<PriceDao> pricesPage = priceRepositoryCustom.findAllByFilter(filter,pageable);
       List<PriceDto> list = priceMapper.map(pricesPage.getContent());
       return new com.inditex.sisu.common.Page<PriceDto>(list, pricesPage.getSize(),pricesPage.getTotalElements());
    }
}
