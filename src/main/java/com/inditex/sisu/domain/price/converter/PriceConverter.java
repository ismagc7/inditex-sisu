package com.inditex.sisu.domain.price.converter;

import com.inditex.sisu.common.CommonUtils;
import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dto.PriceResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceConverter {

    public List<PriceResponse> toResponse (List<PriceDao> daoList) {
        return daoList.stream().map(PriceConverter::toResponseItem).collect(Collectors.toList());
    }

    private static PriceResponse toResponseItem (PriceDao dao) {
        PriceResponse response = new PriceResponse();
        CommonUtils.updateField(response::setBrandId, dao.getBrandId());
        CommonUtils.updateField(response::setPrice, dao.getPrice());
        CommonUtils.updateField(response::setProductId, dao.getProductId());
        CommonUtils.updateField(response::setStartDate, dao.getStartDate());
        CommonUtils.updateField(response::setEndDate, dao.getEndDate());
        CommonUtils.updateField(response::setPriceList, dao.getPriceList());

        return response;
    }
}
