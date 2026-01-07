package com.codegnan.dao;

import java.util.List;
import com.codegnan.dto.Vehicle;

public interface VehicleDao {

    String save(Vehicle vehicle);

    Vehicle findById(int id);

    List<Vehicle> findAll();

    String update(Vehicle vehicle);

    String delete(int id);
}
