package com.codegnan.service;

import java.util.List;
import com.codegnan.dto.Vehicle;

public interface VehicleService {

    String addVehicle(Vehicle vehicle);

    Vehicle getVehicleById(int id);

    List<Vehicle> getAllVehicles();

    String updateVehicle(Vehicle vehicle);

    String deleteVehicle(int id);
}
