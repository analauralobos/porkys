package com.example.Proveedor;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class ProveedorDAO {
    // Seleccionar todos los proveedor
    public List<Proveedor> selectAll() {
        String selectAllSQL = "SELECT * FROM proveedor ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Proveedor.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
