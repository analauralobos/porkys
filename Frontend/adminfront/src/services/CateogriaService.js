import axios from "axios";
const API_URL = "http://localhost:4567/porkys/categorias";

// Obtener todas las categorias
export const getAllCategorias = async () => {
    try {
      const response = await axios.get(`${API_URL}/todas`);
      return response.data;
    } catch (error) {
      console.error("Error al obtener las categorias:", error);
      throw error;
    }
};