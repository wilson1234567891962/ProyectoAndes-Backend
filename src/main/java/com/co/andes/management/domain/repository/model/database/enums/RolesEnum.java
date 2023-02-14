package com.co.andes.management.domain.repository.model.database.enums;

public enum RolesEnum {
     OPERATOR("OPERATOR"),
     ADMINISTRATOR("ADMINISTRATOR");

    private String rol;

    RolesEnum(String rol) {
        this.rol = rol;
    }

    public String  getRol() {
        return rol;
    }
}
