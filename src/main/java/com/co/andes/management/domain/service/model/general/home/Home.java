package com.co.andes.management.domain.service.model.general.home;

import java.util.List;

public class Home {
    private String id;
    private int idDriver;
    private String name;
    private String image;
    private int activeBus;
    private int activeDriver;
    private BusDetail busDetail;
    private String position;
    private List<Menu> menu;
    private String lastName;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getActiveBus() {
        return activeBus;
    }

    public void setActiveBus(int activeBus) {
        this.activeBus = activeBus;
    }

    public int getActiveDriver() {
        return activeDriver;
    }

    public void setActiveDriver(int activeDriver) {
        this.activeDriver = activeDriver;
    }

    public BusDetail getBusDetail() {
        return busDetail;
    }

    public void setBusDetail(BusDetail busDetail) {
        this.busDetail = busDetail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
