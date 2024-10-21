package com.example.TipoMateriaPrima;

import java.util.List;

import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class TipoMateriaPrimaDAO {
    // Seleccionar todos los proveedor
    public List<TipoMateriaPrima> selectAll() {
        String selectAllSQL = "SELECT * FROM tipo_materiaprima ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(TipoMateriaPrima.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
