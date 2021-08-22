package com.githab.cs.repository;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.searchParams.SearchParams;
import com.sample.model.Tables;
import com.sample.model.tables.records.ProductOfferingRecord;

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
        List<ProductOfferingRecord> p = dsl.selectFrom(Tables.PRODUCT_OFFERING)
                .where(condition)
                .fetch();
        List<ProductOfferingEntity> prod = new ArrayList<ProductOfferingEntity>();
        for (ProductOfferingRecord productOfferingRecord : p) {
            prod.add(productOfferingRecord.into(ProductOfferingEntity.class));
            prod.get(prod.size()-1).setLastTime(productOfferingRecord.getLastUpdate().atOffset(ZoneOffset.UTC));  
        }
        return prod;
    }
    

    @Override
    public List<ProductOfferingEntity> searchAll() {
        List<ProductOfferingRecord> p = dsl.selectFrom(Tables.PRODUCT_OFFERING)
                .fetch();
        List<ProductOfferingEntity> prod = new ArrayList<ProductOfferingEntity>();
        for (ProductOfferingRecord productOfferingRecord : p) {
            prod.add(productOfferingRecord.into(ProductOfferingEntity.class));
            prod.get(prod.size()-1).setLastTime(productOfferingRecord.getLastUpdate().atOffset(ZoneOffset.UTC));  
        }
        return prod;
    }

    
}
