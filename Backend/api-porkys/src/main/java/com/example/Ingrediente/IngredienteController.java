package com.example.Ingrediente;

import java.util.List;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class IngredienteController {
    // Obtener todas los ingredientes
    public static Route getTodosIngredientes = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        IngredienteDAO p = new IngredienteDAO();
        List<Ingrediente> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
