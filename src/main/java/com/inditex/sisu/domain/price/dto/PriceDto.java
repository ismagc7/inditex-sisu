package com.inditex.sisu.domain.price.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Currency;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto implements Serializable {

    @JsonProperty("brand_id")
    private Long brandId;
    @JsonProperty("start_date")
    private Timestamp startDate;
    @JsonProperty("end_date")
    private Timestamp endDate;
    @JsonProperty("price_list")
    private Integer priceList;
    @JsonProperty("product_id")
    private Long productId;
    private Integer priority;
    private Double price;
    private Currency currency;
}
