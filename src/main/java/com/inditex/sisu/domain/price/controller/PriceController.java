package com.inditex.sisu.domain.price.controller;

import com.inditex.sisu.common.CommonController;
import com.inditex.sisu.common.CommonUrl;
import com.inditex.sisu.common.JSONResult;
import com.inditex.sisu.common.Page;
import com.inditex.sisu.domain.price.dto.PriceDto;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(CommonUrl.API_BASE+"/prices")
public class PriceController extends CommonController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public JSONResult<Page<PriceDto>> getByFilter(@ModelAttribute PriceRequestFilterDto filter, Pageable pageable) throws SQLException {
        return new JSONResult<>(priceService.getAllByFilter(filter,pageable));
    }

}
