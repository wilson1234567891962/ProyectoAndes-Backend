package com.co.andes.management.domain.repository.model.database.enums;

public enum EventEnum {
      REGISTER_USER("REGISTER EMAIL AND PASSWORD"),
      ADMINISTRATOR("ADMINISTRATOR");

    private String event;

    EventEnum(String event) {
        this.event = event;
    }

    public String  getEvent() {
        return event;
    }
}
