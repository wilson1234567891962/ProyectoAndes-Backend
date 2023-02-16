package com.co.andes.management.domain.repository.model.database.enums;

public enum CategoryEnum {
     PERISHABLE("PERISHABLE"),
     ADMINISTRATOR("ADMINISTRATOR");

    private String category;

    CategoryEnum(String category) {
        this.category = category;
    }

    public String  getCategory() {
        return category;
    }
}
