package com.example.TipoPago;

import java.util.List;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class TipoPagoController {
    // Obtener todos los tipo pago
    public static Route getTodosTipoPago = (Request request, Response response) ->
    {
        response.type("application/json");
        try {
        TipoPagoDAO p = new TipoPagoDAO();
        List<TipoPago> res = p.selectAll();
        return new Gson().toJson(res);
        } catch (Exception e) {
        response.status(500);
        return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
}
