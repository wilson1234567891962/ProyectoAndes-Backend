package com.co.andes.management.domain.service.model.response.alert;

public class ContentAlertDTO {
    private String kind;
    private String backgroundKind;
    private String owner;
    private String backgroundKindOwner;
    private String register;
    private String backGroundRegister;

    public ContentAlertDTO() {
    }

    public ContentAlertDTO(String kind, String backgroundKind, String owner, String backgroundKindOwner, String register, String backGroundRegister) {
        this.kind = kind;
        this.backgroundKind = backgroundKind;
        this.owner = owner;
        this.backgroundKindOwner = backgroundKindOwner;
        this.register = register;
        this.backGroundRegister = backGroundRegister;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBackgroundKind() {
        return backgroundKind;
    }

    public void setBackgroundKind(String backgroundKind) {
        this.backgroundKind = backgroundKind;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBackgroundKindOwner() {
        return backgroundKindOwner;
    }

    public void setBackgroundKindOwner(String backgroundKindOwner) {
        this.backgroundKindOwner = backgroundKindOwner;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getBackGroundRegister() {
        return backGroundRegister;
    }

    public void setBackGroundRegister(String backGroundRegister) {
        this.backGroundRegister = backGroundRegister;
    }
}
