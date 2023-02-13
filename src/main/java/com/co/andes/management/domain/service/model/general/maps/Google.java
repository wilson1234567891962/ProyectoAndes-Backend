package com.co.andes.management.domain.service.model.general.maps;

import java.util.List;

public class Google {
    private int id;
    private double lat;
    private double lng;
    private int zoom;
    private List<ItemGoogle> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public List<ItemGoogle> getItems() {
        return items;
    }

    public void setItems(List<ItemGoogle> items) {
        this.items = items;
    }
}
