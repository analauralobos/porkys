package com.example.PasosReceta;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class PasosRecetaController {
    // Obtener todos los pasos
    public static Route getTodosPasosRecetas = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        PasosRecetaDAO p = new PasosRecetaDAO();
        List<PasosReceta> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
