/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.db.AccesoDB;
import com.mycompany.model.Clothe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClotheService {

    // Obtener todas las prendas
    public List<Clothe> getAllClothes() throws SQLException {
    List<Clothe> clothes = new ArrayList<Clothe>();
    String query = "SELECT * FROM CLOTHE";
    try (Connection connection = AccesoDB.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        // Verificar si la consulta devuelve resultados
        if (!rs.next()) {
            System.out.println("No se encontraron prendas.");
            return clothes;  // Si no hay resultados, devolver lista vacía
        }

        // Si hay resultados, recorrer el ResultSet
        do {
            Clothe clothe = new Clothe();
            clothe.setClotheId(rs.getInt("clothe_id"));
            clothe.setBrand(rs.getString("brand"));
            clothe.setType(rs.getString("type"));
            clothe.setSize(rs.getString("size"));
            clothe.setGender(rs.getString("gender"));
            clothes.add(clothe);
        } while (rs.next());

    } catch (SQLException e) {
        System.err.println("Error SQL: " + e.getMessage());
        throw new SQLException("Error al obtener las prendas: " + e.getMessage(), e);
    }
    return clothes;
}


    // Obtener una prenda por ID
    public Clothe getClotheById(int id) throws SQLException {
        String query = "SELECT * FROM CLOTHE WHERE clothe_id = ?";
        try (Connection connection = AccesoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Clothe clothe = new Clothe();
                    clothe.setClotheId(rs.getInt("clothe_id"));
                    clothe.setBrand(rs.getString("brand"));
                    clothe.setType(rs.getString("type"));
                    clothe.setSize(rs.getString("size"));
                    clothe.setGender(rs.getString("gender"));
                    return clothe;
                }
            }
        }
        return null;
    }

    // Guardar una nueva prenda
    public void saveClothe(Clothe clothe) throws SQLException {
    String query = "INSERT INTO CLOTHE (brand, type, size, gender) VALUES (?, ?, ?, ?)";
    try (Connection connection = AccesoDB.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, clothe.getBrand());
        stmt.setString(2, clothe.getType());
        stmt.setString(3, clothe.getSize());
        stmt.setString(4, clothe.getGender());

        // Ejecutar la actualización
        int rowsAffected = stmt.executeUpdate();
        
        if (rowsAffected == 0) {
            throw new SQLException("No se pudo insertar la prenda.");
        }
        
        System.out.println("Prenda registrada con éxito.");
    } catch (SQLException e) {
        System.err.println("Error SQL: " + e.getMessage());
        throw new SQLException("Error al guardar la prenda: " + e.getMessage(), e);
    }
}


    // Eliminar prenda
    public void deleteClothe(int id) throws SQLException {
        String query = "DELETE FROM CLOTHE WHERE clothe_id = ?";
        try (Connection connection = AccesoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
