package com.co.andes.management.domain.service.model.general;

import com.co.andes.management.domain.service.model.general.bus.Bus;
import com.co.andes.management.domain.service.model.general.driver.Driver;
import com.co.andes.management.domain.service.model.general.home.DetailHome;
import com.co.andes.management.domain.service.model.general.issue.IncidentDTO;
import com.co.andes.management.domain.service.model.general.login.DetailUser;
import com.co.andes.management.domain.service.model.general.maps.Google;
import com.co.andes.management.domain.service.model.general.passenger.Passenger;

public class UMB {
    private DetailUser users;
    private DetailHome home;
    private Google google;
    private Bus bus;
    private Driver driver;
    private Passenger passenger;
    private IncidentDTO issue;

    public IncidentDTO getIssue() {
        return issue;
    }

    public void setIssue(IncidentDTO issue) {
        this.issue = issue;
    }

    public DetailUser getUsers() {
        return users;
    }

    public void setUsers(DetailUser users) {
        this.users = users;
    }

    public DetailHome getHome() {
        return home;
    }

    public void setHome(DetailHome home) {
        this.home = home;
    }

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
