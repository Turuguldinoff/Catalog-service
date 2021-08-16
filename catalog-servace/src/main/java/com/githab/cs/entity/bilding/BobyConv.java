package com.githab.cs.entity.bilding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.githab.cs.entity.ProductOfferingBodyEntity;

import org.jooq.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class BobyConv implements Converter<JSONB, ProductOfferingBodyEntity>{

    @Override
    public ProductOfferingBodyEntity from(JSONB databaseObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return databaseObject == null ? null : objectMapper.readValue("" + databaseObject, ProductOfferingBodyEntity.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public JSONB to(ProductOfferingBodyEntity userObject) {        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return userObject == null ? null : JSONB.valueOf(objectMapper.writeValueAsString(userObject));
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public Class<JSONB> fromType() {
        return JSONB.class;
    }

    @Override
    public Class<ProductOfferingBodyEntity> toType() {
        return ProductOfferingBodyEntity.class;
    }

    
}
