package com.co.andes.management.domain.repository.model.database.enums;

public enum StateEnum {
     PENDING("PENDING"),
     PROCESSED("PROCESSED"),
     EXECUTING("EXECUTING"),
     CANCELED("CANCELED");

    private String state;

    StateEnum(String state) {
        this.state = state;
    }

    public String  getState() {
        return state;
    }
}
