package com.example.Pedido;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class PedidoController {
    // Obtener todos los pedidos
    public static Route getTodosPedidos = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        PedidoDAO p = new PedidoDAO();
        List<Pedido> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
