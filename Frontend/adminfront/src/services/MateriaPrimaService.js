import axios from "axios";
const API_URL = "http://localhost:4567/porkys/matprima";

// Obtener todas las materias primas
export const getAllMatPrimas = async () => {
  try {
    const response = await axios.get(`${API_URL}/todas`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener las materias primas:", error);
    throw error;
  }
};

// Crear una nueva materia prima
export const createMatPrima = async (matPrimaData) => {
  try {
    const response = await axios.post(`${API_URL}/crear`, matPrimaData);
    return response.data;
  } catch (error) {
    console.error("Error al crear la materia prima:", error);
    throw error;
  }
};

// Obtener una materia prima por ID
export const getMatPrimaById = async (id) => {
    try {
      const response = await axios.get(`${API_URL}/detalles/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Error al ver la materia prima con ID ${id}:`, error);
      throw error;
    }
  };

// Actualizar una materia prima existente
export const updateMatPrima = async (id, matPrimaData) => {
  try {
    const response = await axios.put(`${API_URL}/modificar/${id}`, matPrimaData);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar la materia prima con ID ${id}:`, error);
    throw error;
  }
};

// Eliminar una materia prima
export const deleteMatPrima = async (id) => {
  try {
    const response = await axios.delete(`${API_URL}/eliminar/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar la materia prima con ID ${id}:`, error);
    throw error;
  }
};
