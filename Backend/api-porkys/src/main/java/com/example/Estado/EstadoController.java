package com.example.Estado;

import java.util.List;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class EstadoController {
    private static final Gson gson = new Gson();
    private static final EstadoDAO estadoDAO = new EstadoDAO();

    // Obtener todos los estados
    public static Route getTodosEstados = (Request request, Response response) -> {
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
    // Crear nuevo estado
    public static Route crearEstado = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Estado nuevoEstado = gson.fromJson(request.body(), Estado.class);
            estadoDAO.crearEstado(nuevoEstado);
            response.status(201);
            return gson.toJson(nuevoEstado);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear cliente: " + e.getMessage());
        }
    };

    // Controlador para eliminar estado
    public static Route eliminarEstado = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Estado estadoAEliminar = gson.fromJson(request.body(), Estado.class);
            boolean eliminado = estadoDAO.eliminarEstado(estadoAEliminar);

            if (eliminado) {
                response.status(200);
                return gson.toJson("Estado eliminado exitosamente");
            } else {
                response.status(400);
                return gson.toJson("No se pudo eliminar el estado.");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar el estado: " + e.getMessage());
        }
    };

    // Controlador para modificar estado
public static Route modificarEstado = (Request request, Response response) -> {
    response.type("application/json");
    try {
        Estado estadoModificado = gson.fromJson(request.body(), Estado.class);            
        boolean modificado = estadoDAO.modificarEstado(estadoModificado);

        if (modificado) {
            response.status(200); 
            return gson.toJson("Estado modificado exitosamente");
        } else {
            response.status(400);
            return gson.toJson("No se pudo modificar el estado.");
        }
    } catch (Exception e) {
        response.status(500);
        return gson.toJson("Error al modificar el estado: " + e.getMessage());
    }
};



}