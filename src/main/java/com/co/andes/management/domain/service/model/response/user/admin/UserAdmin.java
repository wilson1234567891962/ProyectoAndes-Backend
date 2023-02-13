package com.co.andes.management.domain.service.model.response.user.admin;

import com.co.andes.management.domain.service.model.general.bus.Field;

import java.util.List;

public class UserAdmin {
    private String id;
    private String nameRuta;
    private String name;
    private List<Field> fields;
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameRuta() {
        return nameRuta;
    }

    public void setNameRuta(String nameRuta) {
        this.nameRuta = nameRuta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserAdmin(String id, String nameRuta, String name, List<Field> fields, String image) {
        this.id = id;
        this.nameRuta = nameRuta;
        this.name = name;
        this.fields = fields;
        this.image = image;
    }

    public UserAdmin() {
    }
}
