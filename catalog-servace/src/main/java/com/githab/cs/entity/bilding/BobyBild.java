package com.githab.cs.entity.bilding;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.Objects;

import com.githab.cs.entity.ProductOfferingBodyEntity;

import org.jooq.*;
import org.jooq.conf.ParamType;
import org.jooq.impl.DSL;

public class BobyBild implements Binding<JSONB, ProductOfferingBodyEntity>{

    @Override
    public Converter<JSONB, ProductOfferingBodyEntity> converter() {
        return new BobyConv();
    }

    @Override
    public void sql(BindingSQLContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        if (ctx.render().paramType() == ParamType.INLINED)
            ctx.render().visit(DSL.inline(ctx.convert(converter()).value())).sql("::json");
        else
            ctx.render().sql("?::json");
    }

    @Override
    public void register(BindingRegisterContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR);
        
    }

    @Override
    public void set(BindingSetStatementContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        ctx.statement().setString(ctx.index(), Objects.toString(ctx.convert(converter()).value(), null));
        
    }

    @Override
    public void set(BindingSetSQLOutputContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        throw new SQLFeatureNotSupportedException();
        
    }

    @Override
    public void get(BindingGetResultSetContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        ctx.convert(converter()).value(JSONB.valueOf(ctx.resultSet().getString(ctx.index())));
        
    }

    @Override
    public void get(BindingGetStatementContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        ctx.convert(converter()).value(JSONB.valueOf(ctx.statement().getString(ctx.index())));
        
    }

    @Override
    public void get(BindingGetSQLInputContext<ProductOfferingBodyEntity> ctx) throws SQLException {
        throw new SQLFeatureNotSupportedException();
        
    }
    
}
