package com.example.Cliente;
import java.util.List;

import org.sql2o.Connection;

import com.example.db.Sql2oDAO;

public class ClienteDAO {
    // Seleccionar todos los clientes
    public List<Cliente> selectAll() {
        String selectAllSQL = "SELECT * FROM cliente ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Cliente.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}


