package com.githab.cs.repository;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.githab.cs.entity.ProductOfferingEntity;
import com.sample.model.Tables;
import com.sample.model.tables.records.ProductOfferingRecord;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RepositoryProductOffering implements RepositoryBase<String, ProductOfferingEntity> {

    @Autowired
    private DSLContext dsl;

    @Override
    public ProductOfferingEntity create(ProductOfferingEntity product) {
        return dsl.insertInto(Tables.PRODUCT_OFFERING)
        .set(Tables.PRODUCT_OFFERING.ID, product.getId())
        .set(Tables.PRODUCT_OFFERING.BODY, product.getBody())
        .set(Tables.PRODUCT_OFFERING.LAST_UPDATE, OffsetDateTime.now().toLocalDateTime())
        .returning().fetchOne().into(ProductOfferingEntity.class);
    }

    @Override
    public ProductOfferingEntity update(ProductOfferingEntity product, String id) {
            ProductOfferingEntity p = dsl.update(Tables.PRODUCT_OFFERING)
            .set(Tables.PRODUCT_OFFERING.BODY, product.getBody())
            .set(Tables.PRODUCT_OFFERING.LAST_UPDATE, OffsetDateTime.now().toLocalDateTime())
            .where(Tables.PRODUCT_OFFERING.ID.eq(id))
            .returning().fetchOne().into(ProductOfferingEntity.class);
            return p;
    }

    @Override
    public ProductOfferingEntity getId(String id) {
        ProductOfferingRecord p = dsl.selectFrom(Tables.PRODUCT_OFFERING)
            .where(Tables.PRODUCT_OFFERING.ID.eq(id))
            .fetchOne();
        if (p == null)
            return null;
        ProductOfferingEntity prod = p.into(ProductOfferingEntity.class);
        prod.setLastTime(p.getLastUpdate().atOffset(ZoneOffset.UTC));
        return prod;
    }

    @Override
    public void delete(String id) {
            dsl.delete(Tables.PRODUCT_OFFERING)
            .where(Tables.PRODUCT_OFFERING.ID.eq(id))
            .returning().fetchOne();
    }
}
