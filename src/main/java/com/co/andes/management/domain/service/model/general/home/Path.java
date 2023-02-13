package com.co.andes.management.domain.service.model.general.home;

public class Path {
    private int id_rutas;
    private int brand;
    private int numberOfChair;
    private double latitude;
    private double longitude;
    private int idDriver;
    private int stateBus;

    public int getId_rutas() {
        return id_rutas;
    }

    public void setId_rutas(int id_rutas) {
        this.id_rutas = id_rutas;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getNumberOfChair() {
        return numberOfChair;
    }

    public void setNumberOfChair(int numberOfChair) {
        this.numberOfChair = numberOfChair;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getStateBus() {
        return stateBus;
    }

    public void setStateBus(int stateBus) {
        this.stateBus = stateBus;
    }
}
