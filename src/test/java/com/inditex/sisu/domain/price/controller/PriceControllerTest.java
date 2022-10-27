package com.inditex.sisu.domain.price.controller;

import com.inditex.sisu.common.JSONResult;
import com.inditex.sisu.common.Page;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.inditex.sisu.domain.price.dto.PriceResponse;
import com.inditex.sisu.domain.price.service.PriceService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class PriceControllerTest {

    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    private PriceResponse priceResponse = new PriceResponse();

    private List<PriceResponse> list = new ArrayList<>();
    private Timestamp getTimestamp(String date) {
        return Timestamp.valueOf(date);
    }

    @Test
    void Test1() throws SQLException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        PriceResponse Test1 = new PriceResponse(35455L,1L,4,getTimestamp("2020-06-15 14:00:00"),getTimestamp("2020-12-31 22:59:59"),38.95);

        PriceRequestFilterDto requestFilter = new PriceRequestFilterDto();
        requestFilter.setBrandId(1L);
        requestFilter.setDate(getTimestamp("2020-06-14 10:00:00"));
        requestFilter.setProductId(35455L);
        
        Pageable pageable = PageRequest.of(0,20);
        List<PriceResponse> priceList = new ArrayList<>();
        priceList.add(Test1);

        Mockito.when(priceService.getAllByFilter(Mockito.any(PriceRequestFilterDto.class),Mockito.any(Pageable.class))).thenReturn(new Page<>(priceList,1,1));
        JSONResult<Page<PriceResponse>> result = priceController.getByFilter(requestFilter,pageable);
        Assertions.assertEquals(1,result.getResponse().getTotalElements());
    }
}