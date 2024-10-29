package com.example.Producto;

import java.util.List;
import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class ProductoDAO {
    // Seleccionar todos los productos
    public List<Producto> selectAll() {
        String selectAllSQL = "SELECT * FROM producto ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Producto.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }

    // Método para crear un nuevo producto
    public boolean crearProducto(Producto producto) {
        String insertSQL = "INSERT INTO producto (Nombre_Producto, precio_vta, cant_porciones, descripcion_producto) VALUES (:Nombre_Producto, :precio_vta, :cant_porciones, :descripcion_producto);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("Nombre_Producto", producto.getNombre_Producto())
                    .addParameter("precio_vta", producto.getPrecio_vta())
                    .addParameter("cant_porciones", producto.getCant_porciones())
                    .addParameter("descripcion_producto", producto.getDescripcion_producto())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el producto: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un producto
    public boolean modificarProducto(Producto producto) {
        String updateSQL = "UPDATE producto SET Nombre_Producto = :Nombre_Producto, precio_vta = :precio_vta, cant_porciones = :cant_porciones, descripcion_producto = :descripcion_producto WHERE id_Producto = :id_Producto;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_Producto", producto.getId_Producto())
                    .addParameter("Nombre_Producto", producto.getNombre_Producto())
                    .addParameter("precio_vta", producto.getPrecio_vta())
                    .addParameter("cant_porciones", producto.getCant_porciones())
                    .addParameter("descripcion_producto", producto.getDescripcion_producto())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el producto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un producto
    public boolean eliminarProducto(int id_Producto) {
        String deleteSQL = "DELETE FROM producto WHERE id_Producto = :id_Producto;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_Producto", id_Producto)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

}
