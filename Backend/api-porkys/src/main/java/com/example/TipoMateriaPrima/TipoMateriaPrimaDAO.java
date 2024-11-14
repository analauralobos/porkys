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

// Método para seleccionar una mp por id
    public TipoMateriaPrima selectMPId(int id_TipoMP) {
        String selectSQL = "SELECT * FROM tipo_materiaprima WHERE id_TipoMP = :id_TipoMP;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            TipoMateriaPrima materiaPrima = con.createQuery(selectSQL)
                    .addParameter("id_TipoMP", id_TipoMP)
                    .executeAndFetchFirst(TipoMateriaPrima.class); // Cambiado a executeAndFetchFirst
            return materiaPrima;
        } catch (Exception e) {
            System.err.println("Error al seleccionar la materia prima: " + e.getMessage());
            return null;
        }
    }


    // Método para crear un nuevo tipo de materia prima
    public boolean crearTipoMateriaPrima(TipoMateriaPrima tipoMP) {
        String insertSQL = "INSERT INTO tipo_materiaprima (descripcion_TipoMP) VALUES (:descripcion_TipoMP);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("descripcion_TipoMP", tipoMP.getDescripcion_TipoMP())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el tipo de materia prima: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un tipo de materia prima
    public boolean modificarTipoMateriaPrima(TipoMateriaPrima tipoMP) {
        String updateSQL = "UPDATE tipo_materiaprima SET descripcion_TipoMP = :descripcion_TipoMP WHERE id_TipoMP = :id_TipoMP;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_TipoMP", tipoMP.getId_TipoMP())
                    .addParameter("descripcion_TipoMP", tipoMP.getDescripcion_TipoMP())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el tipo de materia prima: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un tipo de materia prima
    public boolean eliminarTipoMateriaPrima(int id_TipoMP) {
        String deleteSQL = "DELETE FROM tipo_materiaprima WHERE id_TipoMP = :id_TipoMP;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_TipoMP", id_TipoMP)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el tipo de materia prima: " + e.getMessage());
            return false;
        }
    }

}
