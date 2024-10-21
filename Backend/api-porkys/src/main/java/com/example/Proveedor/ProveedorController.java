package com.example.Proveedor;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProveedorController {
    // Obtener todos los proveedor
    public static Route getTodosProveedor = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        ProveedorDAO p = new ProveedorDAO();
        List<Proveedor> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
