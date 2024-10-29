import React, { useEffect, useState } from "react";
import { getAllProducts } from "../../services/ProductoService";
import { useNavigate } from "react-router-dom";

const ProductList = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await getAllProducts();
        setProducts(response || []);
      } catch (error) {
        console.error("Error fetching products: ", error);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  const handleProductClick = (id) => {
    navigate(`/detail-product/${id}`);
  };

  if (loading) {
    return <p>Cargando productos...</p>;
  }

  return (
    <div>
      <h2>Lista de Productos</h2>
      {products.length === 0 ? (
        <p>No hay productos disponibles.</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Nombre del Producto</th>
              <th>Precio de Venta</th>
              <th>Cantidad de Porciones</th>
              <th>Descripción</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr
                key={product.id_Producto}
                onClick={() => handleProductClick(product.id_Producto)}
                style={{ cursor: "pointer" }}
              >
                <td>{product.Nombre_Producto}</td>
                <td>{product.precio_vta} $</td>
                <td>{product.cant_porciones}</td>
                <td>{product.descripcion_producto}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default ProductList;
