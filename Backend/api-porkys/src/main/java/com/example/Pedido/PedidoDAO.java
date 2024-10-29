package com.example.Pedido;

import java.util.List;

import org.sql2o.Connection;
import com.example.db.Sql2oDAO;

public class PedidoDAO {

    // Seleccionar todos los pedidos
    public List<Pedido> selectAll() {
        String selectAllSQL = "SELECT * FROM pedido ;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Pedido.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }

    // Método para crear un nuevo pedido
    public boolean crearPedido(Pedido pedido) {
        String insertSQL = "INSERT INTO pedido (id_Cliente, fecha_pedido, fecha_entrega, lugar_entrega, id_Estado, id_TipoPago) VALUES (:id_Cliente, :fecha_pedido, :fecha_entrega, :lugar_entrega, :id_Estado, :id_TipoPago);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL)
                    .addParameter("id_Cliente", pedido.getId_Cliente())
                    .addParameter("fecha_pedido", pedido.getFecha_pedido())
                    .addParameter("fecha_entrega", pedido.getFecha_entrega())
                    .addParameter("lugar_entrega", pedido.getLugar_entrega())
                    .addParameter("id_Estado", pedido.getId_Estado())
                    .addParameter("id_TipoPago", pedido.getId_TipoPago())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el pedido: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar un pedido
    public boolean modificarPedido(Pedido pedido) {
        String updateSQL = "UPDATE pedido SET id_Cliente = :id_Cliente, fecha_pedido = :fecha_pedido, fecha_entrega = :fecha_entrega, lugar_entrega = :lugar_entrega, id_Estado = :id_Estado, id_TipoPago = :id_TipoPago WHERE id_Pedido = :id_Pedido;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("id_Pedido", pedido.getId_Pedido())
                    .addParameter("id_Cliente", pedido.getId_Cliente())
                    .addParameter("fecha_pedido", pedido.getFecha_pedido())
                    .addParameter("fecha_entrega", pedido.getFecha_entrega())
                    .addParameter("lugar_entrega", pedido.getLugar_entrega())
                    .addParameter("id_Estado", pedido.getId_Estado())
                    .addParameter("id_TipoPago", pedido.getId_TipoPago())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el pedido: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un pedido
    public boolean eliminarPedido(int id_Pedido) {
        String deleteSQL = "DELETE FROM pedido WHERE id_Pedido = :id_Pedido;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("id_Pedido", id_Pedido)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el pedido: " + e.getMessage());
            return false;
        }
    }

}
