package com.example;

import static spark.Spark.*;
import org.sql2o.Sql2o;

import com.example.Administrador.AdministradorController;
import com.example.Cliente.ClienteController;
import com.example.Compra.CompraController;
import com.example.Estado.EstadoController;
import com.example.Ingrediente.IngredienteController;
import com.example.MateriaPrima.MateriaPrimaController;
import com.example.PasosReceta.PasosRecetaController;
import com.example.Pedido.PedidoController;
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

        // Rutas para Administradores
        get("porkys/administrador/todos", AdministradorController.getTodosAdmins);
        post("porkys/administrador/crear", AdministradorController.crearAdmin);        
        post("porkys/administrador/login", AdministradorController.loginAdmin);
        // Rutas para Clientes
        get("porkys/clientes/todos", ClienteController.getTodosClientes);
        post("porkys/clientes/crear", ClienteController.crearCliente);        
        post("porkys/clientes/login", ClienteController.loginCliente);
        
        // Compras
        get("porkys/compras/todas", CompraController.getTodasCompras);
        //post("porkys/compras/crear", CompraController.crearCompra);        
        //delete("porkys/compras/eliminar/:id", CompraController.eliminarCompra);

        // Estados
        get("porkys/estados/todos", EstadoController.getTodosEstados);
        //post("porkys/estados/crear", EstadoController.crearEstado);        
        //delete("porkys/estados/eliminar/:id", EstadoController.eliminarEstado);

        // Ingredientes
        get("porkys/ingredientes/todos", IngredienteController.getTodosIngredientes);
        //post("porkys/ingredientes/crear", IngredienteController.crearIngrediente);        
        //delete("porkys/ingredientes/eliminar/:id", IngredienteController.eliminarIngrediente);

        // Materia Prima
        get("porkys/matprimas/todas", MateriaPrimaController.getTodasMatPrimas);
        //post("porkys/matprimas/crear", MateriaPrimaController.crearMatPrimas);        
        //delete("porkys/matprimas/eliminar/:id", MateriaPrimaController.eliminarMatPrima);

        // Pasos Recetas
        get("porkys/pasosrecetas/todos", PasosRecetaController.getTodosPasosRecetas);
        //post("porkys/pasosrecetas/crear", PasosRecetaController.crearPasos);        
        //delete("porkys/pasosrecetas/eliminar/:id", PasosRecetaController.eliminarPasos);
        
        // Pedidos
        get("porkys/pedidos/todos", PedidoController.getTodosPedidos);
        //post("porkys/pedidos/crear", PedidoController.crearPedido);        
        //delete("porkys/pedidos/eliminar/:id", PedidoController.eliminarPedido);
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
