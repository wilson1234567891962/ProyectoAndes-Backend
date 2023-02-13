package com.co.andes.management.domain.service.model.general.driver;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Driver {

    private List<DriverActive> driversActive;

    public List<DriverActive> getDriversActive() {
        return driversActive;
    }

    public void setDriversActive(List<DriverActive> driversActive) {
        this.driversActive = driversActive;
    }
}
