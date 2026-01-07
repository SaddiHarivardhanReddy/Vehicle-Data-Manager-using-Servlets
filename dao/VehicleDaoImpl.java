package com.codegnan.dao;

import java.sql.*;
import java.util.*;
import com.codegnan.dto.Vehicle;
import com.codegnan.util.ConnectionFactory;

public class VehicleDaoImpl implements VehicleDao {

    @Override
    public String save(Vehicle v) {

        System.out.println(">>> DAO SAVE CALLED");

        String sql = "INSERT INTO vehicle (brand, model, price) VALUES (?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getBrand());
            ps.setString(2, v.getModel());
            ps.setDouble(3, v.getPrice());

            ps.executeUpdate();
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

    @Override
    public Vehicle findById(int id) {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 con.prepareStatement("SELECT * FROM vehicle WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Vehicle(
                    rs.getInt("id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getDouble("price")
                );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> list = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 con.prepareStatement("SELECT * FROM vehicle");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Vehicle(
                    rs.getInt("id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String update(Vehicle v) {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(
                     "UPDATE vehicle SET brand=?, model=?, price=? WHERE id=?")) {

            ps.setString(1, v.getBrand());
            ps.setString(2, v.getModel());
            ps.setDouble(3, v.getPrice());
            ps.setInt(4, v.getId());

            return ps.executeUpdate() == 1 ? "success" : "failure";

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

    @Override
    public String delete(int id) {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 con.prepareStatement("DELETE FROM vehicle WHERE id=?")) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1 ? "success" : "failure";

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
