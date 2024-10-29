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

    // Método para registrar una nueva MP
    public boolean crearMateriaPrima(MateriaPrima materiaPrima) {
        String insertSQL = "INSERT INTO materia_prima (Nombre_MP, unidades, Fecha_Vto_Proxima, Un_de_Medida, id_TipoMP) VALUES (:Nombre_MP, :unidades, :Fecha_Vto_Proxima, :Un_de_Medida, :id_TipoMP);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("Nombre_MP", materiaPrima.getNombre_MP())
                    .addParameter("unidades", materiaPrima.getUnidades())
                    .addParameter("Fecha_Vto_Proxima", materiaPrima.getFecha_Vto_Proxima())
                    .addParameter("Un_de_Medida", materiaPrima.getUn_de_Medida())
                    .addParameter("id_TipoMP", materiaPrima.getId_TipoMP())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar la materia prima: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una materia prima
    public boolean eliminarMateriaPrima(MateriaPrima materiaPrima) {
        String deleteSQL = "DELETE FROM materia_prima WHERE id_MateriaPrima = :id_MateriaPrima;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_MateriaPrima", materiaPrima.getId_MateriaPrima())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar la materia prima: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar una materia prima
    public boolean modificarMateriaPrima(MateriaPrima materiaPrima) {
        String updateSQL = "UPDATE materia_prima SET Nombre_MP = :Nombre_MP, unidades = :unidades, Fecha_Vto_Proxima = :Fecha_Vto_Proxima, Un_de_Medida = :Un_de_Medida, id_TipoMP = :id_TipoMP WHERE id_MateriaPrima = :id_MateriaPrima;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("Nombre_MP", materiaPrima.getNombre_MP())
                    .addParameter("unidades", materiaPrima.getUnidades())
                    .addParameter("Fecha_Vto_Proxima", materiaPrima.getFecha_Vto_Proxima())
                    .addParameter("Un_de_Medida", materiaPrima.getUn_de_Medida())
                    .addParameter("id_TipoMP", materiaPrima.getId_TipoMP())
                    .addParameter("id_MateriaPrima", materiaPrima.getId_MateriaPrima())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar la materia prima: " + e.getMessage());
            return false;
        }
    }

}
