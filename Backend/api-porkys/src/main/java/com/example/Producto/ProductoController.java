package com.example.Producto;

import com.google.gson.Gson;
import java.util.List;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProductoController {
    // Obtener todos los productos
    public static Route getTodosProductos = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        ProductoDAO p = new ProductoDAO();
        List<Producto> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
