package com.example.Valoracion;

import java.util.List;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class ValoracionController {
    // Obtener todos las valoraciones
    public static Route getTodasValoraciones = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        ValoracionDAO p = new ValoracionDAO();
        List<Valoracion> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
