package com.co.andes.management.domain.service.model.general.bus;

public class Field {
    private String description;
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Field() {
    }

    public Field(String description, String title) {
        this.description = description;
        this.title = title;
    }
}
