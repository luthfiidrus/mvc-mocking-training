package ardi.springintro.service;

import ardi.springintro.model.Vehicle;

import java.util.List;

public interface VehicleProvider {
    List<Vehicle> getVehicles();

    Vehicle getVehicle(int index);
}
