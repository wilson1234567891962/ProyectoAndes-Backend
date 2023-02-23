package com.co.andes.management.domain.service.model.request.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailOrderRRequestDTO {

    private int idStore;
    private String product;
    private long availableAmount;

    public DetailOrderRRequestDTO() {
    }

    public DetailOrderRRequestDTO(int id, String product, long availableAmount) {
        this.idStore = id;
        this.product = product;
        this.availableAmount = availableAmount;
    }


    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(long availableAmount) {
        this.availableAmount = availableAmount;
    }
}