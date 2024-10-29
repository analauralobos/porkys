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
    // Método para seleccionar una receta por id
    public List<PasosReceta> selectRecetaId(int id_Producto) {
        String selectSQL = "SELECT * FROM pasos_receta WHERE id_Producto = :id_Producto;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {            
            List<PasosReceta> receta = con.createQuery(selectSQL)
                    .addParameter("id_Producto", id_Producto)
                    .executeAndFetch(PasosReceta.class);
            return receta;
        } catch (Exception e) {
            System.err.println("Error al seleccionar los receta: " + e.getMessage());
            return null;
        }
    }
    // Método para registrar un nuevo paso
    public boolean crearPasos(PasosReceta pasosReceta) {
        String insertSQL = "INSERT INTO pasos_receta (id_Producto, paso_nro, descripcion) VALUES (:id_Producto, :paso_nro, :descripcion);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("id_Producto", pasosReceta.getId_Producto())
                    .addParameter("paso_nro", pasosReceta.getPaso_nro())
                    .addParameter("descripcion", pasosReceta.getDescripcion())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el paso de la receta: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un paso
    public boolean eliminarPaso(int id_Producto, int paso_nro) {
        String deleteSQL = "DELETE FROM pasos_receta WHERE id_Producto = :id_Producto AND paso_nro = :paso_nro;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_Producto", id_Producto)
                    .addParameter("paso_nro", paso_nro)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el paso de la receta: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un paso
    public boolean modificarPaso(PasosReceta pasosReceta) {
        String updateSQL = "UPDATE pasos_receta SET descripcion = :descripcion WHERE id_Producto = :id_Producto AND paso_nro = :paso_nro;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_Producto", pasosReceta.getId_Producto())
                    .addParameter("paso_nro", pasosReceta.getPaso_nro())
                    .addParameter("descripcion", pasosReceta.getDescripcion())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el paso de la receta: " + e.getMessage());
            return false;
        }
    }

}
