package com.co.andes.management.domain.repository.model.database.enums;

public enum EventEnum {
      REGISTER_USER("REGISTER EMAIL AND PASSWORD"),
      LOGIN_USER("LOGIN WITH EMAIL AND PASSWORD THE WAY SUCCESS"),
      EMAIL_FORGET("SEND EMAIL TO RECOVERY THE PASSWORD");

    private String event;

    EventEnum(String event) {
        this.event = event;
    }

    public String  getEvent() {
        return event;
    }
}
