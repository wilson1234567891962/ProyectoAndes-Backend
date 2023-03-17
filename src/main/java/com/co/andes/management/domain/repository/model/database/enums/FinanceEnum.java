package com.co.andes.management.domain.repository.model.database.enums;

public enum FinanceEnum {
     BLOCKED("BLOCKED"),
     ACTIVE("ACTIVE");

    private String state;

    FinanceEnum(String state) {
        this.state = state;
    }

    public String  getState() {
        return state;
    }
}
