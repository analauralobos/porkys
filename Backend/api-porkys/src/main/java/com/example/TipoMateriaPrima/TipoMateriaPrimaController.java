package com.example.TipoMateriaPrima;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class TipoMateriaPrimaController {
    private static final Gson gson = new Gson();
    private static final TipoMateriaPrimaDAO tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();
    // Obtener todos los tipo MP
    public static Route getTodosTipoMP = (Request request, Response response) -> {
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

    // Crear nuevo tipo de materia prima
    public static Route crearTipoMateriaPrima = (request, response) -> {
        response.type("application/json");
        try {
            TipoMateriaPrima nuevoTipoMP = gson.fromJson(request.body(), TipoMateriaPrima.class);
            tipoMateriaPrimaDAO.crearTipoMateriaPrima(nuevoTipoMP);
            response.status(201);
            return gson.toJson(nuevoTipoMP);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear el tipo de materia prima: " + e.getMessage());
        }
    };

    // Modificar un tipo de materia prima
    public static Route modificarTipoMateriaPrima = (request, response) -> {
        response.type("application/json");
        try {
            TipoMateriaPrima tipoMPModificado = gson.fromJson(request.body(), TipoMateriaPrima.class);
            if (tipoMateriaPrimaDAO.modificarTipoMateriaPrima(tipoMPModificado)) {
                response.status(200);
                return gson.toJson(tipoMPModificado);
            } else {
                response.status(404);
                return gson.toJson("Tipo de materia prima no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al modificar el tipo de materia prima: " + e.getMessage());
        }
    };

    // Eliminar un tipo de materia prima
    public static Route eliminarTipoMateriaPrima = (request, response) -> {
        response.type("application/json");
        try {
            int id_TipoMP = Integer.parseInt(request.params(":id"));
            if (tipoMateriaPrimaDAO.eliminarTipoMateriaPrima(id_TipoMP)) {
                response.status(204);
                return gson.toJson("Tipo de materia prima eliminado");
            } else {
                response.status(404);
                return gson.toJson("Tipo de materia prima no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar el tipo de materia prima: " + e.getMessage());
        }
    };

}
