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

    // Método para registrar un nuevo estado
    public boolean crearEstado(Estado estado) {
        String insertSQL = "INSERT INTO estado (id_Estado, descripcion_Estado ) VALUES (:id_Estado, :descripcion_Estado);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("id_Estado", estado.getId_Estado())
                    .addParameter("descripcion_Estado", estado.getDescripcion_Estado())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el estado: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un estado existente
    public boolean eliminarEstado(Estado estado) {
        String deleteSQL = "DELETE FROM estado WHERE id_Estado = :id_Estado;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_Estado", estado.getId_Estado())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el estado: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un estado existente
    public boolean modificarEstado(Estado estado) {
        String updateSQL = "UPDATE estado SET descripcion_Estado = :descripcion_Estado WHERE id_Estado = :id_Estado;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("descripcion_Estado", estado.getDescripcion_Estado())
                    .addParameter("id_Estado", estado.getId_Estado())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el estado: " + e.getMessage());
            return false;
        }
    }

}
