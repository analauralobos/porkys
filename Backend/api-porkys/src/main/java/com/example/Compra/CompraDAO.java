package com.example.Compra;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class CompraDAO {
     // Seleccionar todos los clientes
    public List<Compra> selectAll() {
        String selectAllSQL = "SELECT * FROM compra ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Compra.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
