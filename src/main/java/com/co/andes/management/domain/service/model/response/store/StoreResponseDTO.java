package com.co.andes.management.domain.service.model.response.store;

import com.co.andes.management.domain.repository.model.database.StoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreResponseDTO {

    private List<StoreEntity> store;

    public StoreResponseDTO() {
    }


    public StoreResponseDTO(List<StoreEntity> store) {
        this.store = store;
    }

    public List<StoreEntity> getStore() {
        return store;
    }

    public void setStore(List<StoreEntity> store) {
        this.store = store;
    }
}