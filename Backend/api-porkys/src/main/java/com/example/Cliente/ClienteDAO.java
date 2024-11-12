package com.example.Cliente;

import org.sql2o.Connection;
import com.example.db.Sql2oDAO;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

public class ClienteDAO {

    // Seleccionar todos los clientes
    public List<Cliente> selectAll() {
        String selectAllSQL = "SELECT * FROM cliente;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(selectAllSQL).executeAndFetch(Cliente.class);
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    }

    // Método para registrar un nuevo cliente
    public boolean crearCliente(Cliente cliente) {
        String insertSQL = "INSERT INTO cliente (nombre_cliente, telefono_cliente, email_cliente, direccion_cliente, fecha_nac_cliente, pass_cliente) VALUES (:nombre, :telefono, :email, :direccion, :fecha_nac, :password);";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            String hashedPassword = BCrypt.hashpw(cliente.getPass_cliente(), BCrypt.gensalt());
            con.createQuery(insertSQL)
                    .addParameter("nombre", cliente.getNombre_Cliente())
                    .addParameter("telefono", cliente.getTelefono_cliente())
                    .addParameter("email", cliente.getEmail_cliente())
                    .addParameter("direccion", cliente.getDireccion_cliente())
                    .addParameter("fecha_nac", cliente.getFecha_nac_cliente())
                    .addParameter("password", hashedPassword) // Almacena la contraseña encriptada
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar el cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para buscar un cliente por email
    public Optional<Cliente> buscarPorEmail(String email) {
        String selectSQL = "SELECT * FROM cliente WHERE email_cliente = :email;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            Cliente cliente = con.createQuery(selectSQL)
                    .addParameter("email", email)
                    .executeAndFetchFirst(Cliente.class);
            return Optional.ofNullable(cliente);
        } catch (Exception e) {
            System.err.println("Error al buscar el cliente: " + e.getMessage());
            return Optional.empty();
        }
    }

    // Método para autenticar a un cliente
    public boolean authenticateCliente(String email, String password) {
        Optional<Cliente> clienteOpt = buscarPorEmail(email);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            return BCrypt.checkpw(password, cliente.getPass_cliente()); // Compara la contraseña encriptada
        }
        return false; // El cliente no existe o la contraseña es incorrecta
    }

    // Método para modificar un cliente
    public boolean modificarCliente(Cliente cliente) {
        String updateSQL = "UPDATE cliente SET nombre_cliente = :nombre, telefono_cliente = :telefono, email_cliente = :email, direccion_cliente = :direccion, fecha_nac_cliente = :fecha_nac WHERE id_cliente = :idCliente;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(updateSQL)
                    .addParameter("idCliente", cliente.getId_Cliente())
                    .addParameter("nombre", cliente.getNombre_Cliente())
                    .addParameter("telefono", cliente.getTelefono_cliente())
                    .addParameter("email", cliente.getEmail_cliente())
                    .addParameter("direccion", cliente.getDireccion_cliente())
                    .addParameter("fecha_nac", cliente.getFecha_nac_cliente())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar el cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un cliente
    public boolean eliminarCliente(int id_cliente) {
        String deleteSQL = "DELETE FROM cliente WHERE id_cliente = :idCliente;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(deleteSQL)
                    .addParameter("idCliente", id_cliente)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }
}
