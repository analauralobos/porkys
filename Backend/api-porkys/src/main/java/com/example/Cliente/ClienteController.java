

package com.example.Cliente;

import java.util.List;

import com.example.Security.AuthService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class ClienteController {
    private static final Gson gson = new Gson();
    private static final ClienteDAO clienteDAO = new ClienteDAO();

    // Obtener todos los clientes
    public static Route getTodosClientes = (Request request, Response response) -> {
        response.type("application/json");
        try {
            List<Cliente> res = clienteDAO.selectAll();
            return gson.toJson(res);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error controlador: " + e.getMessage());
        }
    };

    // Crear nuevo cliente
    public static Route crearCliente = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Cliente nuevoCliente = gson.fromJson(request.body(), Cliente.class);
            // Aquí puedes agregar validaciones y lógica de negocio
            clienteDAO.crearCliente(nuevoCliente); // Debes implementar este método en ClienteDAO
            response.status(201); // Created
            return gson.toJson(nuevoCliente);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear cliente: " + e.getMessage());
        }
    };

    // Login de cliente
    public static Route loginCliente = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Cliente loginCliente = gson.fromJson(request.body(), Cliente.class);
            String token = AuthService.loginCliente(loginCliente.getEmail_cliente(), loginCliente.getPass_cliente()); // Debes implementar este método
            if (token != null) {
                response.status(200);
                return gson.toJson("Token: " + token);
            } else {
                response.status(401);
                return gson.toJson("Credenciales inválidas");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error en el login: " + e.getMessage());
        }
    };
}

