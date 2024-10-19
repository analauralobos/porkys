package com.example.Cliente;

import java.util.List;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class ClienteController {
    // Obtener todos los clientes
    public static Route getTodosClientes = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        ClienteDAO p = new ClienteDAO();
        List<Cliente> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}

