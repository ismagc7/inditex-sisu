package com.inditex.sisu.domain.price.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceResponse {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("brand_id")
    private Long brandId;
    @JsonProperty("price_list")
    private Integer priceList;
    @JsonProperty("start_date")
    private Timestamp startDate;
    @JsonProperty("end_date")
    private Timestamp endDate;
    private Double price;
}
