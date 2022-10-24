package com.inditex.sisu.domain.price.repository;

import com.inditex.sisu.domain.price.dao.PriceDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceDao, Long>, QuerydslPredicateExecutor<PriceDao> {

}
