package com.example.Proveedor;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class ProveedorDAO {
    // Seleccionar todos los proveedor
    public List<Proveedor> selectAll() {
        String selectAllSQL = "SELECT * FROM proveedor ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Proveedor.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }

    // Método para crear un nuevo proveedor
    public boolean crearProveedor(Proveedor proveedor) {
        String insertSQL = "INSERT INTO proveedor (CUIT, Nombre_Prov, Direccion_Prov, email_Prov, Telefono_Prov) VALUES (:CUIT, :Nombre_Prov, :Direccion_Prov, :email_Prov, :Telefono_Prov);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("CUIT", proveedor.getCUIT())
                    .addParameter("Nombre_Prov", proveedor.getNombre_Prov())
                    .addParameter("Direccion_Prov", proveedor.getDireccion_Prov())
                    .addParameter("email_Prov", proveedor.getEmail_Prov())
                    .addParameter("Telefono_Prov", proveedor.getTelefono_Prov())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el proveedor: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un proveedor
    public boolean modificarProveedor(Proveedor proveedor) {
        String updateSQL = "UPDATE proveedor SET CUIT = :CUIT, Nombre_Prov = :Nombre_Prov, Direccion_Prov = :Direccion_Prov, email_Prov = :email_Prov, Telefono_Prov = :Telefono_Prov WHERE id_Proveedor = :id_Proveedor;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_Proveedor", proveedor.getId_Proveedor())
                    .addParameter("CUIT", proveedor.getCUIT())
                    .addParameter("Nombre_Prov", proveedor.getNombre_Prov())
                    .addParameter("Direccion_Prov", proveedor.getDireccion_Prov())
                    .addParameter("email_Prov", proveedor.getEmail_Prov())
                    .addParameter("Telefono_Prov", proveedor.getTelefono_Prov())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el proveedor: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un proveedor
    public boolean eliminarProveedor(int id_Proveedor) {
        String deleteSQL = "DELETE FROM proveedor WHERE id_Proveedor = :id_Proveedor;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_Proveedor", id_Proveedor)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el proveedor: " + e.getMessage());
            return false;
        }
    }

}
