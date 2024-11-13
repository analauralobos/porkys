import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/HomePage';
import Login from './components/login/Login';
import Navbar from './components/NavBar/Navbar';
import PanelAdmin from './pages/PanelAdmin';
import Inicio from './pages/inicio/Inicio';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductDetail from './components/productos/ProductDetail';
import Footer from './components/Footer';

function App() {
  const [userRole, setUserRole] = useState(null); 

  return (
    <Router>
      <Navbar userRole={userRole} setUserRole={setUserRole} />
           
      <Routes>
        <Route path="/" element={<Home userRole={userRole} />} /> 
        <Route path="/login" element={<Login setUserRole={setUserRole} />} /> 
        <Route path="/paneladmin" element={<PanelAdmin userRole={userRole} />} /> 
        <Route path="/inicio" element={<Inicio/>} /> 
        <Route path="/edit-product/:id" element={<ProductDetail/>} /> 
        
      </Routes>
      <Footer/>
    </Router>
  );
}


export default App;
