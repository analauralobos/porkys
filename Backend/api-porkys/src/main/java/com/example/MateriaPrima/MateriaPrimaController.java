package com.example.MateriaPrima;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class MateriaPrimaController {
    private static final Gson gson = new Gson();
    private static final MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
    // Obtener todas las Mat Primas
    public static Route getTodasMatPrimas = (Request request, Response response) -> {
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
    // Ver materia prima por id de materia prima
    public static Route getMatPrimasId = (Request request, Response response) -> {
        response.type("application/json");
        try {
            int idMP = Integer.parseInt(request.params(":id"));
            MateriaPrima materiaPrima = materiaPrimaDAO.selectMPId(idMP);

            if (materiaPrima != null) {
                response.status(200);
                return gson.toJson(materiaPrima);
            } else {
                response.status(404);
                return gson.toJson("No se encontró una materia prima para el ID especificado.");
            }
        } catch (NumberFormatException e) {
            response.status(400);
            return gson.toJson("ID de materia prima inválido");
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al obtener la materia prima: " + e.getMessage());
        }
    };

    // Crear nueva materia prima
    public static Route crearMateriaPrima = (Request request, Response response) -> {
        response.type("application/json");
        try {
            MateriaPrima nuevaMP = gson.fromJson(request.body(), MateriaPrima.class);
            materiaPrimaDAO.crearMateriaPrima(nuevaMP);
            response.status(201);
            return gson.toJson(nuevaMP);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear materia prima: " + e.getMessage());
        }
    };

    // Controlador para eliminar una materia prima
    public static Route eliminarMateriaPrima = (Request request, Response response) -> {
        response.type("application/json");
        try {
            int idMateriaPrima = Integer.parseInt(request.params(":id"));
            MateriaPrima materiaPrima = new MateriaPrima();
            materiaPrima.setId_MateriaPrima(idMateriaPrima);
            boolean eliminado = materiaPrimaDAO.eliminarMateriaPrima(materiaPrima);

            if (eliminado) {
                response.status(204); // No Content
                return "";
            } else {
                response.status(404); // Not Found
                return gson.toJson("Materia Prima no encontrada.");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar la materia prima: " + e.getMessage());
        }
    };

    // Controlador para modificar una materia prima
    public static Route modificarMateriaPrima = (Request request, Response response) -> {
        response.type("application/json");
        try {
            MateriaPrima materiaPrima = gson.fromJson(request.body(), MateriaPrima.class);
            boolean modificado = materiaPrimaDAO.modificarMateriaPrima(materiaPrima);
            if (modificado) {
                response.status(200); // OK
                return gson.toJson(materiaPrima);
            } else {
                response.status(404); // Not Found
                return gson.toJson("Materia Prima no encontrada.");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al modificar la materia prima: " + e.getMessage());
        }
    };

}
