package com.example.MateriaPrima;

import java.util.List;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class MateriaPrimaController {
    // Obtener todas las Mat Primas
    public static Route getTodasMatPrimas = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        MateriaPrimaDAO p = new MateriaPrimaDAO();
        List<MateriaPrima> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
