package com.githab.cs.repository;

import java.util.List;

import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.searchParams.SearchParams;
import com.sample.model.Tables;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RepositorySearchServiceImpl implements RepositorySearchService<SearchParams, ProductOfferingEntity>{

    @Autowired
    private DSLContext dsl;
    
    @Override
    public List<ProductOfferingEntity> searchC(Condition condition) {
        return dsl.selectFrom(Tables.PRODUCT_OFFERING)
                .where(condition)
                .fetch()
                .into(ProductOfferingEntity.class);
    }
    

    @Override
    public List<ProductOfferingEntity> searchAll() {
        return dsl.selectFrom(Tables.PRODUCT_OFFERING)
                .fetch().into(ProductOfferingEntity.class);
    }

    
}
