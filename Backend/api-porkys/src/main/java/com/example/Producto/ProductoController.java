package com.example.Producto;

import com.google.gson.Gson;
import java.util.List;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProductoController {
    private static final Gson gson = new Gson();
    private static final ProductoDAO productoDAO = new ProductoDAO();

    // Obtener todos los productos
    public static Route getTodosProductos = (Request request, Response response) -> {
        response.type("application/json");
        try {
            ProductoDAO p = new ProductoDAO();
            List<Producto> res = p.selectAll();
            return new Gson().toJson(res);
        } catch (Exception e) {
            response.status(500);
            return new Gson().toJson("Error controlador: " + e.getMessage());
        }
    };
    // Crear nuevo producto
    public static Route crearProducto = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Producto nuevoProducto = gson.fromJson(request.body(), Producto.class);
            productoDAO.crearProducto(nuevoProducto);
            response.status(201);
            return gson.toJson(nuevoProducto);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear el producto: " + e.getMessage());
        }
    };

    // Modificar un producto
    public static Route modificarProducto = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Producto productoModificado = gson.fromJson(request.body(), Producto.class);
            if (productoDAO.modificarProducto(productoModificado)) {
                response.status(200);
                return gson.toJson(productoModificado);
            } else {
                response.status(404);
                return gson.toJson("Producto no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al modificar el producto: " + e.getMessage());
        }
    };

    // Eliminar un producto
    public static Route eliminarProducto = (Request request, Response response) -> {
        response.type("application/json");
        try {
            int id_Producto = Integer.parseInt(request.params(":id"));
            if (productoDAO.eliminarProducto(id_Producto)) {
                response.status(204);
                return gson.toJson("Producto eliminado");
            } else {
                response.status(404);
                return gson.toJson("Producto no encontrado");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al eliminar el producto: " + e.getMessage());
        }
    };

}
