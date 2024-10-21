package com.example.Pedido;

import java.util.List;

import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class PedidoDAO {
    // Seleccionar todos los pedidos
    public List<Pedido> selectAll() {
        String selectAllSQL = "SELECT * FROM pedido ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Pedido.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
