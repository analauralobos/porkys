package com.example.TipoPago;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class TipoPagoDAO {
    // Seleccionar todos los tipo pago
    public List<TipoPago> selectAll() {
        String selectAllSQL = "SELECT * FROM tipo_pago ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(TipoPago.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }
}
