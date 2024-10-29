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

    // Método para crear una nueva valoración
    public boolean crearValoracion(Valoracion valoracion) {
        String insertSQL = "INSERT INTO valoracion (id_Cliente, id_Producto, fecha_valoracion, cant_estrellas, comentario) VALUES (:id_Cliente, :id_Producto, :fecha_valoracion, :cant_estrellas, :comentario);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("id_Cliente", valoracion.getId_Cliente())
                    .addParameter("id_Producto", valoracion.getId_Producto())
                    .addParameter("fecha_valoracion", valoracion.getFecha_valoracion())
                    .addParameter("cant_estrellas", valoracion.getCant_estrellas())
                    .addParameter("comentario", valoracion.getComentario())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar la valoración: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar una valoración
    public boolean modificarValoracion(Valoracion valoracion) {
        String updateSQL = "UPDATE valoracion SET cant_estrellas = :cant_estrellas, comentario = :comentario WHERE id_Cliente = :id_Cliente AND id_Producto = :id_Producto AND fecha_valoracion = :fecha_valoracion;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_Cliente", valoracion.getId_Cliente())
                    .addParameter("id_Producto", valoracion.getId_Producto())
                    .addParameter("fecha_valoracion", valoracion.getFecha_valoracion())
                    .addParameter("cant_estrellas", valoracion.getCant_estrellas())
                    .addParameter("comentario", valoracion.getComentario())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar la valoración: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una valoración
    public boolean eliminarValoracion(int id_Cliente, int id_Producto, String fecha_valoracion) {
        String deleteSQL = "DELETE FROM valoracion WHERE id_Cliente = :id_Cliente AND id_Producto = :id_Producto AND fecha_valoracion = :fecha_valoracion;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_Cliente", id_Cliente)
                    .addParameter("id_Producto", id_Producto)
                    .addParameter("fecha_valoracion", fecha_valoracion)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar la valoración: " + e.getMessage());
            return false;
        }
    }

}
