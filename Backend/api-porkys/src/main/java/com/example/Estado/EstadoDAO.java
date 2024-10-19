package com.example.Estado;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class EstadoDAO {
    // Seleccionar todos los estados
    public List<Estado> selectAll() {
        String selectAllSQL = "SELECT * FROM estado ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Estado.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
