package com.inditex.sisu.domain.price.service;


import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.inditex.sisu.domain.price.converter.PriceMapper;
import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<PriceDto> getAll() {
        return priceMapper.listtoDto(priceRepository.findAll());
    }

    @Override
    public List<PriceDto> getByFilter(PriceRequestFilterDto filter) {
        
    }


}
