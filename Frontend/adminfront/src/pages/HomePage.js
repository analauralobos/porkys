import React from 'react';

function Home({ userRole }) {
  if (userRole === 'cliente') {
    return (
      <div>
        <h1>Bienvenido, Cliente</h1>
        <p>Contenido exclusivo para clientes.</p>
      </div>
    );
  }
  
  // Si no es cliente, se muestra una bienvenida genérica
  return (
    <div>
      <h1>Bienvenido a la tienda</h1>
    </div>
  );
}

export default Home;
