package com.inditex.sisu.domain.price.repository;

import com.inditex.sisu.common.repository.AbstractRepositoryPaginator;
import com.inditex.sisu.domain.price.dao.PriceDao;
import com.inditex.sisu.domain.price.dao.QPriceDao;
import com.inditex.sisu.domain.price.dto.PriceRequestFilterDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceRepositoryCustomImpl extends AbstractRepositoryPaginator implements PriceRepositoryCustom{

   private static final QPriceDao qPriceDao = QPriceDao.priceDao;

    public PriceRepositoryCustomImpl() {
        super(PriceRepositoryCustom.class);
    }

    @Override
    public PageImpl<PriceDao> findAllByFilter(PriceRequestFilterDto filter, Pageable pageable) {

        JPQLQuery<PriceDao> query = from(qPriceDao);
        applyFiltering(filter, query);
        applyPagination(pageable, query);
        query.orderBy(qPriceDao.startDate.desc());

        List<PriceDao> result = query.fetch();
        return new PageImpl<PriceDao>(result,pageable,result.size());
    }

    private void applyFiltering(PriceRequestFilterDto filter, JPQLQuery<?> query) {
        BooleanBuilder builder = new BooleanBuilder();

        if (filter != null) {
            if (filter.getBrandId() != null) {
                builder.and(qPriceDao.brandId.eq(filter.getBrandId()));
            }
           if (filter.getProductId() != null) {
               builder.and(qPriceDao.productId.eq(filter.getProductId()));
           }
           if (filter.getDate() != null) {
               builder.and(qPriceDao.startDate.after(filter.getDate()).and(qPriceDao.startDate.before(filter.getDate())));
           }
        }
        query.where(builder);
    }
}
