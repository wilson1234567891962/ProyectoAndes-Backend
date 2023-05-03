package com.co.andes.management.domain.service.model.response.delivery;
import com.co.andes.management.domain.repository.model.database.ClientEntity;
import com.co.andes.management.domain.repository.model.database.StoreEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import com.co.andes.management.domain.repository.model.database.enums.StateEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sun.istack.NotNull;

import javax.persistence.*;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponseDTO {

    private Integer id;
    private int  amount;
    private String state;

    private String client;


    public DeliveryResponseDTO(Integer id, int amount, String state, String client) {
        this.id = id;
        this.amount = amount;
        this.state = state;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}