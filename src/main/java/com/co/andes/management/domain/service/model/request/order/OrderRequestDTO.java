package com.co.andes.management.domain.service.model.request.order;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequestDTO {

    private int idOrder;
    private String name;
    private String address;
    private String phone;
    private String state;
    private int amount;
    private DetailOrderRRequestDTO detail;
    private int driver;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(int idOrder, String name, String address, String phone, String state, int amount, DetailOrderRRequestDTO detail, int driver) {
        this.idOrder = idOrder;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.state = state;
        this.amount = amount;
        this.detail = detail;
        this.driver = driver;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DetailOrderRRequestDTO getDetail() {
        return detail;
    }

    public void setDetail(DetailOrderRRequestDTO detail) {
        this.detail = detail;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }
}