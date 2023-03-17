package com.co.andes.management.domain.service.model.response.driver;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverResponseDTO {

    private int id;
    private int document;
    private String name;


    public DriverResponseDTO(int id, int document, String name) {
        this.id = id;
        this.document = document;
        this.name = name;
    }
}