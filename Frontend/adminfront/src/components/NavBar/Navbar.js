import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { GoSearch } from "react-icons/go";
import { AiOutlineShoppingCart } from "react-icons/ai";
import { GiHamburgerMenu } from "react-icons/gi"; 
import Login from '../login/Login'; // Asegúrate de importar tu componente Login
import './Navbar.css';

const Navbar = ({ userRole, setUserRole }) => {
  const [menu, setMenu] = useState("inicio");
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [showLoginModal, setShowLoginModal] = useState(false); // Estado para controlar el modal de login
  const navigate = useNavigate();

  // Leer el estado de localStorage cuando el componente se monta
  useEffect(() => {
    const storedRole = localStorage.getItem('userRole');
    if (storedRole) {
      setUserRole(storedRole); // Restaurar el estado de userRole desde localStorage
    }
  }, [setUserRole]);

  const handleLogout = () => {
    setUserRole(null);
    localStorage.removeItem('userRole'); // Eliminar el userRole de localStorage al cerrar sesión
    navigate('/');
  };

  const handleMenuClick = (menuItem) => {
    setMenu(menuItem);
    setIsMenuOpen(false);
  };

  const openLoginModal = () => setShowLoginModal(true); // Abre el modal de login
  const closeLoginModal = () => setShowLoginModal(false); // Cierra el modal de login

  const handleLogin = (role) => {
    localStorage.setItem('userRole', role); // Guardar el userRole en localStorage
    setUserRole(role); // Establecer el userRole en el estado
    closeLoginModal(); // Cerrar el modal de login
  };

  return (
    <div className="navbar">
      <Link to="/" className="logo">PorkyCakes</Link>
      <button className="hamburger-menu" onClick={() => setIsMenuOpen(!isMenuOpen)}>
        <GiHamburgerMenu />
      </button>
      <ul className={`navbar-menu ${isMenuOpen ? "open" : ""}`}>
        <li onClick={() => handleMenuClick("inicio")} className={menu === "inicio" ? "active" : ""}>
          <Link to="/">Inicio</Link>
        </li>
        <li onClick={() => handleMenuClick("menu")} className={menu === "menu" ? "active" : ""}>
          <Link to="/menu">Menú</Link>
        </li>
        <li onClick={() => handleMenuClick("contacto")} className={menu === "contacto" ? "active" : ""}>
          <Link to="/contacto">Contacto</Link>
        </li>
        {userRole === 'admin' && (
          <li onClick={() => handleMenuClick("paneladmin")} className={menu === "paneladmin" ? "active" : ""}>
            <Link to="/paneladmin">Panel Admin</Link>
          </li>
        )}
      </ul>
      <div className="navbar-right">
        <GoSearch className="busqueda" />
        <div className="navbar-search-icon">
          <AiOutlineShoppingCart className="carrito" />
          <div className="dot"></div>
        </div>

        {userRole ? (
          <div className="user-options">
            <span className="navbar-text">{`Bienvenido, ${userRole}`}</span>
            <button onClick={handleLogout}>Salir</button>
          </div>
        ) : (
          <button onClick={openLoginModal}>Login</button> // Al hacer clic, se abre el modal
        )}
      </div>

      {showLoginModal && <Login closeModal={closeLoginModal} handleLogin={handleLogin} />} {/* Mostrar modal si showLoginModal es true */}
    </div>
  );
};

export default Navbar;
