package com.example.Valoracion;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class ValoracionController {
    private static final Gson gson = new Gson();
    private static final ValoracionDAO valoracionDAO = new ValoracionDAO();
    // Obtener todos las valoraciones
    public static Route getTodasValoraciones = (Request request, Response response) -> {
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

    // Crear nueva valoración
    public static Route crearValoracion = (request, response) -> {
        response.type("application/json");
        try {
            Valoracion nuevaValoracion = gson.fromJson(request.body(), Valoracion.class);
            valoracionDAO.crearValoracion(nuevaValoracion);
            response.status(201);
            return gson.toJson(nuevaValoracion);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear la valoración: " + e.getMessage());
        }
    };

    // Modificar una valoración
    public static Route modificarValoracion = (request, response) -> {
        response.type("application/json");
        try {
            Valoracion valoracionModificada = gson.fromJson(request.body(), Valoracion.class);
            if (valoracionDAO.modificarValoracion(valoracionModificada)) {
                response.status(200);
                return gson.toJson(valoracionModificada);
            } else {
                response.status(404);
                return gson.toJson("Valoración no encontrada");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al modificar la valoración: " + e.getMessage());
        }
    };

    // Eliminar una valoración
    public static Route eliminarValoracion = (request, response) -> {
        response.type("application/json");
        try {
            int id_Cliente = Integer.parseInt(request.params(":id_cliente"));
            int id_Producto = Integer.parseInt(request.params(":id_producto"));
            String fecha_valoracion = request.params(":fecha_valoracion");
            if (valoracionDAO.eliminarValoracion(id_Cliente, id_Producto, fecha_valoracion)) {
                response.status(204);
                return gson.toJson("Valoración eliminada");
            } else {
                response.status(404);
                return gson.toJson("Valoración no encontrada");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar la valoración: " + e.getMessage());
        }
    };
}
