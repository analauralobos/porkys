import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css';

function Navbar({ userRole, setUserRole }) {
  const navigate = useNavigate();

  const handleLogout = () => {
    setUserRole(null); 
    navigate('/'); // Redirige al Home después de hacer logout
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-light">
      <div className="container-fluid d-flex justify-content-between">
        <Link className="navbar-brand" to="/">
          Porky Cakes
        </Link>

        <div className="d-flex justify-content-center w-100">
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav mx-auto">
              <li className="nav-item">
                <Link className="nav-link" to="/">Inicio</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/menu">Menú</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/contacto">Contacto</Link>
              </li>
              {userRole === 'admin' && (
                <li className="nav-item">
                  <Link className="nav-link" to="/paneladmin">Panel Admin</Link>
                </li>
              )}
            </ul>
          </div>
        </div>

        {/* Botón Login a la derecha */}
        <div className="d-flex ms-auto">
          {userRole ? (
            <>
              <span className="navbar-text me-3">{`Bienvenido, ${userRole}`}</span>
              <button className="btn btn-danger" onClick={handleLogout}>Salir</button>
            </>
          ) : (
            <>
              <Link className="btn btn-danger ms-2" to="/login">Login</Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
