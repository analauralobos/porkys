import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getProductById, updateProduct } from '../../services/ProductoService';
import { getIngredientById } from '../../services/IngredienteService';

const ProductDetail = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(null);
    const [ingredients, setIngredients] = useState([]);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const data = await getProductById(id);
                setProduct(data);
            } catch (error) {
                console.error('Error fetching product details:', error);
            }
        };

        const fetchIngredients = async () => {
            try {
                const data = await getIngredientById(id);
                setIngredients(data);
            } catch (error) {
                console.error('Error fetching ingredients details:', error);
            }
        };

        const fetchData = async () => {
            await Promise.all([fetchProduct(), fetchIngredients()]);
            setLoading(false);
        };

        fetchData();
    }, [id]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await updateProduct(id, product); 
            alert('Producto actualizado con éxito');
            navigate('/productos'); 
        } catch (error) {
            console.error('Error al actualizar el producto:', error);
            alert('Error al actualizar el producto, por favor intenta nuevamente.');
        }
    };

    if (loading) {
        return <p>Cargando detalles del producto y ingredientes...</p>;
    }

    return (
        <div>
            <h2>Detalles de Producto</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Nombre del Producto:</label>
                    <input 
                        type="text" 
                        value={product.Nombre_Producto} 
                        onChange={(e) => setProduct({ ...product, Nombre_Producto: e.target.value })} 
                        required 
                    />
                </div>
                <div>
                    <label>Ingredientes:</label>
                    <ul>
                        {ingredients.map((ingredient) => (
                            <li key={ingredient.id_MateriaPrima}>
                                {`${ingredient.cantidad} ${ingredient.unidades}`}
                            </li>
                        ))}
                    </ul>
                </div>
                <div>
                    <label>Receta:</label>
                    <textarea 
                        value={product.Receta} 
                        onChange={(e) => setProduct({ ...product, Receta: e.target.value })} 
                        required 
                    />
                </div>
                <button type="submit">Actualizar Producto</button>
            </form>
        </div>
    );
};

export default ProductDetail;
