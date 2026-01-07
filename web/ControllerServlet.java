package com.codegnan.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.codegnan.dto.Vehicle;
import com.codegnan.service.VehicleService;
import com.codegnan.service.VehicleServiceImpl;

public class ControllerServlet extends HttpServlet {

    private final VehicleService service = new VehicleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.endsWith("add.do")) {
            Vehicle v = new Vehicle(
                0,
                req.getParameter("brand"),
                req.getParameter("model"),
                Double.parseDouble(req.getParameter("price"))
            );
            forward(service.addVehicle(v), req, resp);
            return;
        }

        if (uri.endsWith("search.do")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Vehicle v = service.getVehicleById(id);
            if (v == null)
                req.getRequestDispatcher("notexisted.html").forward(req, resp);
            else {
                req.setAttribute("vehicle", v);
                req.getRequestDispatcher("searchresult.jsp").forward(req, resp);
            }
            return;
        }

        if (uri.endsWith("delete.do")) {
            int id = Integer.parseInt(req.getParameter("id"));
            forward(service.deleteVehicle(id), req, resp);
            return;
        }

        if (uri.endsWith("update.do")) {
            Vehicle v = new Vehicle(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("brand"),
                req.getParameter("model"),
                Double.parseDouble(req.getParameter("price"))
            );
            forward(service.updateVehicle(v), req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (req.getRequestURI().endsWith("list.do")) {
            req.setAttribute("vehicles", service.getAllVehicles());
            req.getRequestDispatcher("listall.jsp").forward(req, resp);
        }
    }

    private void forward(String status, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if ("success".equals(status))
            req.getRequestDispatcher("success.html").forward(req, resp);
        else
            req.getRequestDispatcher("failure.html").forward(req, resp);
    }
}
