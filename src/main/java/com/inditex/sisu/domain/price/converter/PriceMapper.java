package com.inditex.sisu.domain.price.converter;

import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {
    @Mapping(target = "currency", ignore = true)
    @Mapping(target = "priority", ignore = true)
    PriceDto toDto(PriceDao priceDao);
    @Mapping(target = "id", ignore = true)
    PriceDao toDao(PriceDto priceDto);
    List<PriceDto> map(List<PriceDao> list);
}
