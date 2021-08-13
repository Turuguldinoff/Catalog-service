package com.githab.cs.repository;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.searchParams.SearchParams;
import com.sample.model.Tables;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RepositoryProductOffering implements RepositoryBase<String, ProductOfferingEntity> {

    private DSLContext dsl;
    // private final

    @Override
    public ProductOfferingEntity create(ProductOfferingEntity product) {
        ObjectMapper m = new ObjectMapper();
        String jsonb;
        try {
            jsonb = m.writeValueAsString(product);
            Timestamp time = Timestamp.valueOf(product.getLacttime().toLocalDateTime());
            ProductOfferingEntity p = dsl.insertInto(Tables.PRODUCT_OFFERING)
            .set(Tables.PRODUCT_OFFERING.ID, product.getId())
            .set(Tables.PRODUCT_OFFERING.BODY, jsonb)
            .set(Tables.PRODUCT_OFFERING.LAST_UPDATE, time)
            .returning().fetchOne().into(ProductOfferingEntity.class);
            return p;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductOfferingEntity update(ProductOfferingEntity product) {
        ObjectMapper m = new ObjectMapper();
        String jsonb;
        try {
            jsonb = m.writeValueAsString(product);
            Timestamp time = Timestamp.valueOf(product.getLacttime().toLocalDateTime());
            ProductOfferingEntity p = dsl.update(Tables.PRODUCT_OFFERING)
            .set(Tables.PRODUCT_OFFERING.BODY, jsonb)
            .set(Tables.PRODUCT_OFFERING.LAST_UPDATE, time)
            .where(Tables.PRODUCT_OFFERING.ID.eq(product.getId()))
            .returning().fetchOne().into(ProductOfferingEntity.class);
            return p;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductOfferingEntity getId(ProductOfferingEntity product) {
        ProductOfferingEntity p = dsl.selectFrom(Tables.PRODUCT_OFFERING)
            .where(Tables.PRODUCT_OFFERING.ID.eq(product.getId()))
            .fetchOne().into(ProductOfferingEntity.class);
        return p;
    }

    @Override
    public ProductOfferingEntity delete(ProductOfferingEntity product) {
            ProductOfferingEntity p = dsl.delete(Tables.PRODUCT_OFFERING)
            .where(Tables.PRODUCT_OFFERING.ID.eq(product.getId()))
            .returning().fetchOne().into(ProductOfferingEntity.class);
            return p;
    }

    @Override
    public List<ProductOfferingEntity> search(SearchParams params) {
        // TODO Auto-generated method stub
        return null;
    }

}
