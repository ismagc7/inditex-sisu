package com.inditex.sisu.domain.price.service;


import com.inditex.sisu.domain.price.converter.PriceMapper;
import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.repository.PriceRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {


    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private PriceRepository priceRepository;
    @Override
    public Page<PriceDto> getAllByFilter(PriceRequestFilterDto filter, Pageable pageable) {
        Page<PriceDao> resultList =priceRepository.findAll(getBuilderByFilter(filter), pageable);

        return null;
    }

    private BooleanBuilder getBuilderByFilter(PriceRequestFilterDto filter) {
        BooleanBuilder builder = new BooleanBuilder();
        //Optional.ofNullable(filter.getPrice()).ifPresent(price -> builder.and());

        return null;
    }


}
