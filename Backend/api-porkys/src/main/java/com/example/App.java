package com.example;

import static spark.Spark.*;
import org.sql2o.Sql2o;
import com.example.Cliente.ClienteController;
import com.example.Compra.CompraController;
import com.example.Estado.Estado;
import com.example.Estado.EstadoController;
import com.example.Ingrediente.IngredienteController;
import com.example.db.Sql2oDAO;


public class App {
    public static void main(String[] args) {
        try {
            Sql2o sql2o = Sql2oDAO.getSql2o();
            System.out.println("Conexión exitosa a la base de datos");
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos: " + e.getMessage());
        }

        // Habilitar CORS antes de definir las rutas
        enableCORS("http://localhost:3000", "*", "*");

        // Definir las rutas de tu API
        get("porkis/clientes/todos", ClienteController.getTodosClientes);
       // post("porkis/clientes/crear", ClienteController.crearCliente);        
        //delete("porkis/clientes/eliminar/:id", ClienteController.eliminarCliente);

        // Compras
        get("porkis/compras/todas", CompraController.getTodasCompras);
        //post("porkis/compras/crear", CompraController.crearCompra);        
        //delete("porkis/compras/eliminar/:id", CompraController.eliminarCompra);

        // Estados
        get("porkis/estados/todos", EstadoController.getTodosEstados);
        //post("porkis/estados/crear", EstadoController.crearEstado);        
        //delete("porkis/estados/eliminar/:id", EstadoController.eliminarEstado);

        // Ingredientes
        get("porkis/ingredientes/todos", IngredienteController.getTodosIngredientes);
        //post("porkis/ingredientes/crear", IngredienteController.crearIngrediente);        
        //delete("porkis/ingredientes/eliminar/:id", IngredienteController.eliminarIngrediente);


    }

    // Método para habilitar CORS
    private static void enableCORS(final String origin, final String methods, final String headers) {
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
        });
    }
}

