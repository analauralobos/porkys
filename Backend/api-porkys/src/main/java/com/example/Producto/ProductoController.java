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

    // Ver un producto por id
    public static Route getProductoId = (Request request, Response response) -> {
        response.type("application/json");
        try {            
            int idProducto = Integer.parseInt(request.params(":id"));            
            Producto producto = productoDAO.selectProductoId(idProducto);
            if (producto != null) {
                response.status(200);
                return gson.toJson(producto); 
            } else {
                response.status(404);
                return gson.toJson("Producto no encontrado");
            }
        } catch (NumberFormatException e) {
            response.status(400);
            return gson.toJson("ID de producto inválido");
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al seleccionar el producto: " + e.getMessage());
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

    public static Route modificarProducto = (Request request, Response response) -> {
        response.type("application/json");
        try {
            int idProducto = Integer.parseInt(request.params(":id")); // Obtener el id de la URL
            Producto producto = gson.fromJson(request.body(), Producto.class); // Obtener los datos del producto desde el body
    
            boolean actualizado = productoDAO.modificarProducto(idProducto, producto);
    
            if (actualizado) {
                response.status(200);
                return gson.toJson("Producto actualizado con éxito.");
            } else {
                response.status(400);
                return gson.toJson("No se pudo actualizar el producto.");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al actualizar producto: " + e.getMessage());
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
