package com.example.Compra;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;


public class CompraController {
    // Obtener todas las compras
    public static Route getTodasCompras = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        CompraDAO p = new CompraDAO();
        List<Compra> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
