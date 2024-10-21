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
}
