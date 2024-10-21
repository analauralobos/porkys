package com.example.Valoracion;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class ValoracionDAO {
    // Seleccionar todos las valoraciones
    public List<Valoracion> selectAll() {
        String selectAllSQL = "SELECT * FROM valoracion ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Valoracion.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
