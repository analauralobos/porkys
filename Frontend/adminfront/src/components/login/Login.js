import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';

function Login({ closeModal, handleLogin }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async () => {
    try {
      const response = await fetch('http://localhost:4567/porkys/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });

      const data = await response.json();

      if (response.status === 200) {
        // Aquí estamos usando la función handleLogin pasada como prop
        handleLogin(data.role); // Pasa el rol recibido para guardarlo
        closeModal(); // Cierra el modal de login
        if (data.role === 'admin') {
          navigate('/paneladmin'); // Redirige al panel de admin si es un admin
        } else if (data.role === 'cliente') {
          navigate('/'); // Redirige al inicio si es un cliente
        }
      } else {
        alert(data.message || 'Credenciales inválidas');
      }
    } catch (error) {
      console.error('Error de login:', error);
      alert('Hubo un error al intentar hacer login');
    }
  };

  return (
    <div className="login-modal-overlay" onClick={closeModal}> {/* Cierra el modal si se hace clic fuera */}
      <div className="login-modal" onClick={(e) => e.stopPropagation()}> {/* Previene el cierre si se hace clic dentro del modal */}
        <div className="login-card">
          <h2 className="text-gradient">Iniciar sesión</h2>
          <div className="form">
            <div className="form-group mb-3">
              <input
                type="email"
                className="form-control"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="Correo electrónico"
              />
            </div>
            <div className="form-group mb-3">
              <input
                type="password"
                className="form-control"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Contraseña"
              />
            </div>
          </div>
          <button className="btn-pink" onClick={handleSubmit}>
            Iniciar sesión
          </button>
        </div>
      </div>
    </div>
  );
}

export default Login;
