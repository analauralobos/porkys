package com.example.Proveedor;

import java.util.List;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProveedorController {
    private static final Gson gson = new Gson();
    private static final ProveedorDAO proveedorDAO = new ProveedorDAO();

    // Obtener todos los proveedor
    public static Route getTodosProveedor = (Request request, Response response) -> {
        response.type("application/json");
        try {
            ProveedorDAO p = new ProveedorDAO();
            List<Proveedor> res = p.selectAll();
            return new Gson().toJson(res);
        } catch (Exception e) {
            response.status(500);
            return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };

    // Crear nuevo proveedor
    public static Route crearProveedor = (request, response) -> {
        response.type("application/json");
        try {
            Proveedor nuevoProveedor = gson.fromJson(request.body(), Proveedor.class);
            proveedorDAO.crearProveedor(nuevoProveedor);
            response.status(201);
            return gson.toJson(nuevoProveedor);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear el proveedor: " + e.getMessage());
        }
    };

    // Modificar un proveedor
    public static Route modificarProveedor = (request, response) -> {
        response.type("application/json");
        try {
            Proveedor proveedorModificado = gson.fromJson(request.body(), Proveedor.class);
            if (proveedorDAO.modificarProveedor(proveedorModificado)) {
                response.status(200);
                return gson.toJson(proveedorModificado);
            } else {
                response.status(404);
                return gson.toJson("Proveedor no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al modificar el proveedor: " + e.getMessage());
        }
    };

    // Eliminar un proveedor
    public static Route eliminarProveedor = (request, response) -> {
        response.type("application/json");
        try {
            int id_Proveedor = Integer.parseInt(request.params(":id"));
            if (proveedorDAO.eliminarProveedor(id_Proveedor)) {
                response.status(204);
                return gson.toJson("Proveedor eliminado");
            } else {
                response.status(404);
                return gson.toJson("Proveedor no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar el proveedor: " + e.getMessage());
        }
    };

}
