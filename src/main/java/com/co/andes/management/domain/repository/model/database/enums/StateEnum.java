package com.co.andes.management.domain.repository.model.database.enums;

public enum StateEnum {
     PENDING("PENDING"),
     IN_PROCESS("IN_PROCESS"),
     CANCELED("CANCELED");

    private String state;

    StateEnum(String state) {
        this.state = state;
    }

    public String  getRol() {
        return state;
    }
}
