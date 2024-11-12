import React from 'react'
import Navbar from './components/NavBar/Navbar'; 
import { Route, Routes } from 'react-router-dom';
import Inicio from './pages/inicio/Inicio';
import Carrito from './pages/carrito/Carrito';
import Pedidos from './pages/pedidos/Pedidos';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
const App = () => {
  return (
    <div className='app'>
      <Navbar/>
      <Routes>
        <Route path='/' element={<Inicio/>} />
        <Route path='/carrito' element={<Carrito/>} />
        <Route path='/pedido' element={<Pedidos/>} />
      </Routes>
    </div>
  )
}

export default App





/*import React, { useState } from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import HomePage from "./pages/HomePage";
import Login from "./components/login/Login";
import Productos from "./pages/ProductoPage";
import AdminHomePage from "./pages/AdminHomePage";
import ProductForm from "./components/productos/ProductForm";
import DetailProduct from "./components/productos/ProductDetail"
function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(
    !!localStorage.getItem("token")
  );

  const handleLoginSuccess = () => setIsAuthenticated(true);

  const handleLogout = () => {
    localStorage.removeItem("token");
    setIsAuthenticated(false);
  };

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route
          path="/login"
          element={
            isAuthenticated ? (
              <Navigate to="/admin" />
            ) : (
              <Login onLoginSuccess={handleLoginSuccess} />
            )
          }
        />
        <Route
          path="/admin"
          element={
            isAuthenticated ? (
              <AdminHomePage onLogout={handleLogout} />
            ) : (
              <Navigate to="/" />
            )
          }
        />
        <Route
          path="/productos"
          element={
            isAuthenticated ? (
              <Productos onLogout={handleLogout} />
            ) : (
              <Navigate to="/" />
            )
          }
        />
        <Route
          path="/form-product"
          element={isAuthenticated ? <ProductForm /> : <Navigate to="/" />}
        />
        <Route
          path="/detail-product/:id"
          element={isAuthenticated ? <DetailProduct /> : <Navigate to="/productos" />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
*/