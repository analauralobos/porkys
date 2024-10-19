package com.example.PasosReceta;

import java.util.List;

import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class PasosRecetaDAO {
    // Seleccionar todos los pasos recetas
    public List<PasosReceta> selectAll() {
        String selectAllSQL = "SELECT * FROM pasos_receta ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(PasosReceta.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
