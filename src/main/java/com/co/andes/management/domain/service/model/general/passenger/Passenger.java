package com.co.andes.management.domain.service.model.general.passenger;
import java.util.List;

public class Passenger {
    private List<ActivePassenger> detailPassenger;


    public List<ActivePassenger> getDetailPassenger() {
        return detailPassenger;
    }

    public void setDetailPassenger(List<ActivePassenger> detailPassenger) {
        this.detailPassenger = detailPassenger;
    }
}
