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

    // Método para crear un nuevo tipo de pago
    public boolean crearTipoPago(TipoPago tipoPago) {
        String insertSQL = "INSERT INTO tipo_pago (descripcion_TP) VALUES (:descripcion_TP);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("descripcion_TP", tipoPago.getDescripcion_TP())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el tipo de pago: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un tipo de pago
    public boolean modificarTipoPago(TipoPago tipoPago) {
        String updateSQL = "UPDATE tipo_pago SET descripcion_TP = :descripcion_TP WHERE id_TipoPago = :id_TipoPago;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_TipoPago", tipoPago.getId_TipoPago())
                    .addParameter("descripcion_TP", tipoPago.getDescripcion_TP())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el tipo de pago: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un tipo de pago
    public boolean eliminarTipoPago(int id_TipoPago) {
        String deleteSQL = "DELETE FROM tipo_pago WHERE id_TipoPago = :id_TipoPago;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_TipoPago", id_TipoPago)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el tipo de pago: " + e.getMessage());
            return false;
        }
    }
}
