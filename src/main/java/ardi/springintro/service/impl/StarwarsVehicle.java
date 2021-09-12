package ardi.springintro.service.impl;

import ardi.springintro.model.Vehicle;
import ardi.springintro.model.swapi.model.SwapiVehicle;
import ardi.springintro.service.SwapiClient;
import ardi.springintro.service.VehicleProvider;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StarwarsVehicle implements VehicleProvider {
    SwapiClient swapiClient;

    public StarwarsVehicle(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Vehicle> getVehicles() {
        List<SwapiVehicle> swapiVehicles = swapiClient.getVehicles();
        List<Vehicle> response = new ArrayList<>();
        for (SwapiVehicle swapiVehicle: swapiVehicles) {
            Vehicle vehicle = new Vehicle();
            BeanUtils.copyProperties(swapiVehicle, vehicle);

            response.add(vehicle);
        }

        return response;
    }

    @Override
    public Vehicle getVehicle(int index) {
        SwapiVehicle swapiVehicle = swapiClient.getSpecificVehicle(index);
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(swapiVehicle, vehicle);
        return vehicle;
    }
}
