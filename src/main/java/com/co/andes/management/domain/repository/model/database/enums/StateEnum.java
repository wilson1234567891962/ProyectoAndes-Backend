package com.co.andes.management.domain.repository.model.database.enums;

public enum StateEnum {
     PENDING("PENDING"),
     PROCESSED("PROCESSED"),
     RUNNING("RUNNING"),
     CANCELED("CANCELED");

    private String state;

    StateEnum(String state) {
        this.state = state;
    }

    public String  getRol() {
        return state;
    }
}
