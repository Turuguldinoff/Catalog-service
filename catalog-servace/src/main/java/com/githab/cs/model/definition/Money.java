package com.githab.cs.model.definition;

import java.math.BigDecimal;

public class Money {
    private BigDecimal value;
    private String type;

    public Money(BigDecimal value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.value + " " + this.type;
    }
}
