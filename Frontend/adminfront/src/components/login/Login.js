import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Login({ setUserRole }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    // Llama a tu backend para autenticar el usuario
    try {
      const response = await fetch('http://localhost:4567/porkys/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }), // Enviar las credenciales como JSON
      });

      const data = await response.json();

      if (response.status === 200) {
        setUserRole(data.role); // Guarda el rol de usuario
        if (data.role === 'admin') {
          navigate('/paneladmin');
        } else if (data.role === 'cliente') {
          navigate('/');
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
    <div>
      <h2>Iniciar sesión</h2>
      <input 
        type="email" 
        value={email} 
        onChange={(e) => setEmail(e.target.value)} 
        placeholder="Correo electrónico" 
      />
      <input 
        type="password" 
        value={password} 
        onChange={(e) => setPassword(e.target.value)} 
        placeholder="Contraseña" 
      />
      <button onClick={handleLogin}>Iniciar sesión</button>
    </div>
  );
}

export default Login;
