package com.co.andes.management.domain.service.model.response.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailOrderResponseDTO {

    private int idStore;
    private String product;
    private long availableAmount;

    public DetailOrderResponseDTO() {
    }

    public DetailOrderResponseDTO(int id, String product, long availableAmount) {
        this.idStore = id;
        this.product = product;
        this.availableAmount = availableAmount;
    }

    public int getId() {
        return idStore;
    }

    public void setId(int id) {
        this.idStore = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getAmount() {
        return availableAmount;
    }

    public void setAmount(long availableAmount) {
        this.availableAmount = availableAmount;
    }
}