package com.inditex.sisu.domain.price.repository;

import com.inditex.sisu.domain.price.dao.PriceDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceDao, Long>, JpaSpecificationExecutor<PriceDao> {


    private List<PriceDao> findByFilter() {

        return null;
    }

}
