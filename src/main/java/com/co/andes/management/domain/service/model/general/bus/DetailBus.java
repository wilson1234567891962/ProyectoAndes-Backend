package com.co.andes.management.domain.service.model.general.bus;


public class DetailBus {
    private String id;
    public String hourStarted;
    public int averageTime;
    private String hourArrived;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHourStarted() {
        return hourStarted;
    }

    public void setHourStarted(String hourStarted) {
        this.hourStarted = hourStarted;
    }

    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    public String getHourArrived() {
        return hourArrived;
    }

    public void setHourArrived(String hourArrived) {
        this.hourArrived = hourArrived;
    }
}
