/*
 * This file is generated by jOOQ.
 */
package com.sample.model;


import com.sample.model.tables.FlywaySchemaHistory;
import com.sample.model.tables.ProductOffering;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.sample.model.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.product_offering</code>.
     */
    public static final ProductOffering PRODUCT_OFFERING = com.sample.model.tables.ProductOffering.PRODUCT_OFFERING;
}