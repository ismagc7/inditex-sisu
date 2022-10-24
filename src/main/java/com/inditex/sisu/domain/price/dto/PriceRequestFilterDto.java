package com.inditex.sisu.domain.price.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Currency;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequestFilterDto {
    private Long brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private Currency currency;
}
