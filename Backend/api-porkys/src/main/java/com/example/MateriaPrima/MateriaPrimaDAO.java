package com.example.MateriaPrima;

import java.util.List;

import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class MateriaPrimaDAO {
    // Seleccionar todos las mp
    public List<MateriaPrima> selectAll() {
        String selectAllSQL = "SELECT * FROM materia_prima ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(MateriaPrima.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
