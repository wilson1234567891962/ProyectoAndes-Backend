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
    private int id;
    private String product;
    private String imageProduct;
    private String store;
    private String supplier;
    private String importer;
    private long amount;
    private DetailResponseDTO detail;

    public StoreResponseDTO(int id, String product, String imageProduct, String store, String supplier, String importer, long amount, DetailResponseDTO detail) {
        this.id = id;
        this.product = product;
        this.imageProduct = imageProduct;
        this.store = store;
        this.supplier = supplier;
        this.importer = importer;
        this.amount = amount;
        this.detail = detail;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}