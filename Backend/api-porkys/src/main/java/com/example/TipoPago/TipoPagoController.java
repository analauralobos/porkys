package com.example.TipoPago;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class TipoPagoController {
    private static final Gson gson = new Gson();
    private static final TipoPagoDAO tipoPagoDAO = new TipoPagoDAO();

    // Obtener todos los tipo pago
    public static Route getTodosTipoPago = (Request request, Response response) -> {
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
    // Crear nuevo tipo de pago
    public static Route crearTipoPago = (request, response) -> {
        response.type("application/json");
        try {
            TipoPago nuevoTipoPago = gson.fromJson(request.body(), TipoPago.class);
            tipoPagoDAO.crearTipoPago(nuevoTipoPago);
            response.status(201);
            return gson.toJson(nuevoTipoPago);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear el tipo de pago: " + e.getMessage());
        }
    };

    // Modificar un tipo de pago
    public static Route modificarTipoPago = (request, response) -> {
        response.type("application/json");
        try {
            TipoPago tipoPagoModificado = gson.fromJson(request.body(), TipoPago.class);
            if (tipoPagoDAO.modificarTipoPago(tipoPagoModificado)) {
                response.status(200);
                return gson.toJson(tipoPagoModificado);
            } else {
                response.status(404);
                return gson.toJson("Tipo de pago no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al modificar el tipo de pago: " + e.getMessage());
        }
    };

    // Eliminar un tipo de pago
    public static Route eliminarTipoPago = (request, response) -> {
        response.type("application/json");
        try {
            int id_TipoPago = Integer.parseInt(request.params(":id"));
            if (tipoPagoDAO.eliminarTipoPago(id_TipoPago)) {
                response.status(204);
                return gson.toJson("Tipo de pago eliminado");
            } else {
                response.status(404);
                return gson.toJson("Tipo de pago no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar el tipo de pago: " + e.getMessage());
        }
    };

}
