package com.co.andes.management.domain.service.model.response.order;
import com.co.andes.management.domain.repository.model.database.ClientEntity;
import com.co.andes.management.domain.repository.model.database.DriverEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponseDTO {

    private int idOrder;
    private String name;
    private String address;
    private String phone;
    private String state;
    private int amount;
    private DetailOrderResponseDTO detail;
    private DriverEntity driver;
    private String  comment;


    public OrderResponseDTO(int idOrder, String name, String address, String phone, String state, int amount, DetailOrderResponseDTO detail) {
        this.idOrder = idOrder;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.state = state;
        this.amount = amount;
        this.detail = detail;
    }

    public OrderResponseDTO(int idOrder, String name, String address, String phone, String state, int amount, DetailOrderResponseDTO detail, DriverEntity driver, String comment) {
        this.idOrder = idOrder;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.state = state;
        this.amount = amount;
        this.detail = detail;
        this.driver = driver;
        this.comment = comment;
    }


    public int getId() {
        return idOrder;
    }

    public void setId(int id) {
        this.idOrder = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DetailOrderResponseDTO getDetail() {
        return detail;
    }

    public void setDetail(DetailOrderResponseDTO detail) {
        this.detail = detail;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}