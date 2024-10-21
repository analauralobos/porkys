package com.example.Administrador;

import java.util.List;

import com.example.Security.AuthService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class AdministradorController {
    private static final Gson gson = new Gson();
    private static final AdministradorDAO adminDAO = new AdministradorDAO();

    // Obtener todos los administradores
    public static Route getTodosAdmins = (Request request, Response response) -> {
        response.type("application/json");
        try {
            List<Administrador> res = adminDAO.selectAll();
            return gson.toJson(res);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error controlador: " + e.getMessage());
        }
    };

    // Crear nuevo administrador
    public static Route crearAdmin = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Administrador nuevoAdmin = gson.fromJson(request.body(), Administrador.class);
            adminDAO.crearAdmin(nuevoAdmin); // Debes implementar este método en AdminDAO
            response.status(201); // Created
            return gson.toJson(nuevoAdmin);
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error al crear administrador: " + e.getMessage());
        }
    };

    // Login de administrador
    public static Route loginAdmin = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Administrador loginAdmin = gson.fromJson(request.body(), Administrador.class);
            String token = AuthService.loginAdmin(loginAdmin.getEmail(), loginAdmin.getPassword()); // Debes implementar este método
            if (token != null) {
                response.status(200);
                return gson.toJson("Token: " + token);
            } else {
                response.status(401);
                return gson.toJson("Credenciales inválidas");
            }
        } catch (Exception e) {
            response.status(500);
            return gson.toJson("Error en el login: " + e.getMessage());
        }
    };
}

