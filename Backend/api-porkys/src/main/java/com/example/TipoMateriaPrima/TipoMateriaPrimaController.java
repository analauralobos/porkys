package com.example.TipoMateriaPrima;

import java.util.List;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class TipoMateriaPrimaController {
    // Obtener todos los tipo MP
    public static Route getTodosTipoMP = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        TipoMateriaPrimaDAO p = new TipoMateriaPrimaDAO();
        List<TipoMateriaPrima> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
