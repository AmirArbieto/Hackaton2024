/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Clothe;
import com.mycompany.service.ClotheService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clothes")
public class ClotheController extends HttpServlet {

    private ClotheService clotheService;

    @Override
    public void init() {
        clotheService = new ClotheService(); // No es necesario pasar la conexión, ya que se maneja en el servicio
    }

    // Mostrar todas las prendas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Clothe> clothes = clotheService.getAllClothes();
            request.setAttribute("clothes", clothes);
            request.getRequestDispatcher("/clothes.jsp").forward(request, response);  // Redirigir a la JSP
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener las prendas: " + e.getMessage());
        }
    }

    // Mostrar formulario para agregar una prenda
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí manejamos el registro de una nueva prenda (POST)
        try {
            String brand = request.getParameter("brand");
            String type = request.getParameter("type");
            String size = request.getParameter("size");
            String gender = request.getParameter("gender");

            // Crear un objeto Clothe
            Clothe clothe = new Clothe();
            clothe.setBrand(brand);
            clothe.setType(type);
            clothe.setSize(size);
            clothe.setGender(gender);

            // Llamar al servicio para guardar la prenda
            clotheService.saveClothe(clothe);

            // Redirigir a la página de lista de prendas
            response.sendRedirect("clothes");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al guardar la prenda.");
        }
    }

    // Eliminar prenda
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clotheId = Integer.parseInt(request.getParameter("id"));

        try {
            clotheService.deleteClothe(clotheId);
            response.sendRedirect("clothes");  // Redirigir a la lista de prendas
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar la prenda");
        }
    }
}

