package com.codegnan.service;

import java.util.List;
import com.codegnan.dao.VehicleDao;
import com.codegnan.dao.VehicleDaoImpl;
import com.codegnan.dto.Vehicle;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleDao dao = new VehicleDaoImpl();

    @Override
    public String addVehicle(Vehicle vehicle) {
        return dao.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dao.findAll();
    }

    @Override
    public String updateVehicle(Vehicle vehicle) {
        return dao.update(vehicle);
    }

    @Override
    public String deleteVehicle(int id) {
        return dao.delete(id);
    }
}
