package com.inditex.sisu.domain.price.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequestFilterDto {
    private Long brandId;
    private Timestamp date;
    private Long productId;
}
