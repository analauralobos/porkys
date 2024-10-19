package com.example.Ingrediente;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class IngredienteDAO {
    // Seleccionar todos los ingredientes
    public List<Ingrediente> selectAll() {
        String selectAllSQL = "SELECT * FROM ingrediente ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Ingrediente.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
