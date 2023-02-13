package com.co.andes.management.domain.service.model.general.bus;

import java.util.List;

public class Bus {
    private List<DetailBus> detailBus;
    private List<ActiveBus> activeBus;

    public List<DetailBus> getDetailBus() {
        return detailBus;
    }

    public void setDetailBus(List<DetailBus> detailBus) {
        this.detailBus = detailBus;
    }

    public List<ActiveBus> getActiveBus() {
        return activeBus;
    }

    public void setActiveBus(List<ActiveBus> activeBus) {
        this.activeBus = activeBus;
    }
}
