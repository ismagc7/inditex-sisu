package com.inditex.sisu.domain.price.controller;

import com.inditex.sisu.common.CommonController;
import com.inditex.sisu.common.CommonUrl;
import com.inditex.sisu.common.JSONResult;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CommonUrl.API_BASE+"/prices")
public class PriceController extends CommonController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public JSONResult<List<PriceDto>> getAll() {
        List<PriceDto> priceList = priceService.getAll();
        return new JSONResult<List<PriceDto>>(priceList);
    }

    @GetMapping
    public JSONResult<List<PriceDto>> getByFilter(@ModelAttribute PriceRequestFilterDto filter) {
        List<PriceDto> priceList = priceService.getByFilter(filter);
        return new JSONResult<List<PriceDto>>(priceList);
    }

}
