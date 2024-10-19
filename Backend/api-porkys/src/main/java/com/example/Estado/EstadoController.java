package com.example.Estado;
import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class EstadoController {
    // Obtener todas las compras
    public static Route getTodosEstados = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        EstadoDAO p = new EstadoDAO();
        List<Estado> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}