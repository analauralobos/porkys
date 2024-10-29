import axios from "axios";
const API_URL = "http://localhost:4567/porkys/pasosrecetas";

// Obtener todos los pasos de receta
export const getAllPasosReceta = async () => {
  try {
    const response = await axios.get(`${API_URL}/todos`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener los pasos de receta:", error);
    throw error;
  }
};

// Crear un nuevo paso de receta
export const createPasoReceta = async (pasoRecetaData) => {
  try {
    const response = await axios.post(`${API_URL}/crear`, pasoRecetaData);
    return response.data;
  } catch (error) {
    console.error("Error al crear el paso de receta:", error);
    throw error;
  }
};

// Obtener un paso de receta por id
export const getPasoRecetaById = async (id) => {
  try {
    const response = await axios.get(`${API_URL}/detalles/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error al ver el paso de receta con ID ${id}:`, error);
    throw error;
  }
};

// Actualizar un paso de receta existente
export const updatePasoReceta = async (id_Producto, paso_nro, pasoRecetaData) => {
  try {
    const response = await axios.put(
      `${API_URL}/modificar/${id_Producto}/${paso_nro}`,
      pasoRecetaData
    );
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar el paso de receta con ID_Producto ${id_Producto} y paso_nro ${paso_nro}:`, error);
    throw error;
  }
};

// Eliminar un paso de receta
export const deletePasoReceta = async (id_Producto, paso_nro) => {
  try {
    const response = await axios.delete(`${API_URL}/eliminar/${id_Producto}/${paso_nro}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar el paso de receta con ID_Producto ${id_Producto} y paso_nro ${paso_nro}:`, error);
    throw error;
  }
};
