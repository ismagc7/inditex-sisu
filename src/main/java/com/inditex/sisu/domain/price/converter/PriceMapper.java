package com.inditex.sisu.domain.price.converter;

import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {


    PriceDto toDto(Optional<PriceDao> priceDao);
    @Mapping(target = "id", ignore = true)
    PriceDao toDao(PriceDto priceDto);
    List<PriceDto> map(List<PriceDao> list);
}
