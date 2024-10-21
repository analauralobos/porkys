package com.example.ProductosPorPedido;

import java.util.List;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class ProductosPorPedidoController {
    // Obtener todos los productosXpedido
    public static Route getTodosProductosXpedido = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        ProductosPorPedidoDAO p = new ProductosPorPedidoDAO();
        List<ProductosPorPedido> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
