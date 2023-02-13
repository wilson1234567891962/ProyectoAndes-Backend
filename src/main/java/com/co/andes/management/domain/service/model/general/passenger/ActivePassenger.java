package com.co.andes.management.domain.service.model.general.passenger;

import com.co.andes.management.domain.service.model.general.bus.Field;

import java.util.List;

public class ActivePassenger {
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
}
