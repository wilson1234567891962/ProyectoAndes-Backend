package com.co.andes.management.domain.repository.model.database.enums;

public enum EventEnum {
      REGISTER_USER("REGISTER EMAIL AND PASSWORD"),
      LOGIN_USER("LOGIN WITH EMAIL AND PASSWORD THE WAY SUCCESS"),
      TRY_TO_LOGIN_WITH_WRONG_EMAIL_AND_PASSWORD("TRY TO LOGIN WITH WRONG EMAIL OR PASSWORD"),
      EMAIL_FORGET("SEND EMAIL TO RECOVERY THE PASSWORD");

    private String event;

    EventEnum(String event) {
        this.event = event;
    }

    public String  getEvent() {
        return event;
    }
}
