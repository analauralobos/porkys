import React, { useEffect, useState } from "react";
import { getAllProducts } from "../../services/ProductoService";
import { useNavigate } from "react-router-dom";
import "./ProductList.css";
import { getCategoriasId } from "../../services/CateogriaService";

const ProductList = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [categorias, setCategorias] = useState({});
  const [searchTerm, setSearchTerm] = useState(""); // Estado para el término de búsqueda
  const navigate = useNavigate();

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await getAllProducts();
        setProducts(response || []);
        // Cargar categorías para cada producto
        response.forEach((product) => {
          fetchCategoriaNombre(product.p_categoria);
        });
      } catch (error) {
        console.error("Error fetching products: ", error);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  // Función para obtener la categoría por ID y almacenarla en caché
  const fetchCategoriaNombre = async (id_categoria) => {
    if (categorias[id_categoria]) {
      return; // Si ya existe en caché, no realizar otra petición
    }
    try {
      const categoria = await getCategoriasId(id_categoria);
      setCategorias((prev) => ({ ...prev, [id_categoria]: categoria }));
    } catch (error) {
      console.error(`Error fetching categoria with ID ${id_categoria}:`, error);
    }
  };

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value.toLowerCase()); // Actualiza el término de búsqueda
  };

  // Filtrar productos según el término de búsqueda
  const filteredProducts = products.filter((product) =>
    product.Nombre_Producto.toLowerCase().includes(searchTerm)
  );

  if (loading) {
    return <div className="loading">Cargando productos...</div>;
  }

  return (
    <div className="product-list-container">
      <div className="header">
        <label>
          <input
            type="text"
            className="input"
            placeholder="Buscar productos..."
            value={searchTerm}
            onChange={handleSearchChange}
          />
        </label>
        <button
          className="add-product-button"
          onClick={() => navigate("/add-product")}
        >
          Agregar Producto
        </button>
      </div>

      {filteredProducts.length === 0 ? (
        <p className="no-products-message">No hay productos disponibles.</p>
      ) : (
        <table className="product-table">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Precio</th>
              <th>Porciones</th>
              <th>Categoría</th>
              <th>Acción</th>
            </tr>
          </thead>
          <tbody>
            {filteredProducts.map((product) => (
              <tr key={product.id_Producto}>
                <td>{product.Nombre_Producto}</td>
                <td>{product.precio_vta} $</td>
                <td>{product.cant_porciones}</td>
                <td>
                  {categorias[product.p_categoria]?.nombre || (
                    <span>Cargando...</span>
                  )}
                </td>
                <td>
                  <button
                    className="action-button edit"
                    onClick={(e) => {
                      e.stopPropagation();
                      navigate(`/edit-product/${product.id_Producto}`);
                    }}
                  >
                    Editar
                  </button>
                  <button
                    className="action-button delete"
                    onClick={(e) => {
                      e.stopPropagation();
                      alert(`Eliminar producto ${product.Nombre_Producto}`);
                    }}
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default ProductList;
