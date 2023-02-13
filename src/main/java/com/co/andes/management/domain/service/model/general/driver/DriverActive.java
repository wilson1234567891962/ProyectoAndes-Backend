package com.co.andes.management.domain.service.model.general.driver;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverActive {
    private String id;
    private String nameRuta;
    private String name;
    private List<FieldDriver> fields;
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

    public List<FieldDriver> getFields() {
        return fields;
    }

    public void setFields(List<FieldDriver> fields) {
        this.fields = fields;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
