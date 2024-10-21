package com.example.ProductosPorPedido;

import java.util.List;

import org.sql2o.Connection;

import com.example.db.Sql2oDAO;

public class ProductosPorPedidoDAO {
    // Seleccionar todos los productosXPedido
    public List<ProductosPorPedido> selectAll() {
        String selectAllSQL = "SELECT * FROM productosxpedido ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(ProductosPorPedido.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
