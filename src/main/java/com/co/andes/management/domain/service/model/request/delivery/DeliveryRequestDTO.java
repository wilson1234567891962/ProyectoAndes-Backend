package com.co.andes.management.domain.service.model.request.delivery;
import com.co.andes.management.domain.service.model.request.order.DetailOrderRRequestDTO;
import com.co.andes.management.domain.service.model.request.order.OrderRequestDTO;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryRequestDTO {

    private int id;
    private int amount;
    private int client;
    private int idUser;

    public DeliveryRequestDTO() {
    }

    public DeliveryRequestDTO(int id, int amount, int client, int idUser) {
        this.id = id;
        this.amount = amount;
        this.client = client;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}