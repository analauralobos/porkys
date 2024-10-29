import React from "react";
import { Link } from "react-router-dom";

function Navbar({ onLogout }) {
  return (
    <nav className="navbar">
      <ul className="navbar-links">
        <li className="navbar-item">
          <Link to="/admin" className="navbar-button">Inicio</Link>
        </li>
        <li className="navbar-item">
          <Link to="/productos" className="navbar-button">Productos</Link>
        </li>        
        <li className="navbar-item">
          <input type="text" className="search-input" placeholder="Buscar..." />
          <button className="search-button">🔍</button>
        </li>
        <li className="navbar-item">
          <Link to="/stock" className="navbar-button">Proveedores</Link>
        </li>
        <li className="navbar-item">
          <Link to="/recetas" className="navbar-button">Pedidos</Link>
        </li>
        <li className="navbar-item">
          <Link to="/stock" className="navbar-button">Stock</Link>
        </li>
        <li className="navbar-item">
          <Link to="/recetas" className="navbar-button">Recetas</Link>
        </li>
        <li className="navbar-item">
          <div className="user-info">            
            <button className="logout-button" onClick={onLogout}>Cerrar Sesión</button>
          </div>
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;
