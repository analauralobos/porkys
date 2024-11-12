import React, { useState } from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import HomePage from "./pages/HomePage";
import Login from "./components/login/Login";
import Productos from "./pages/ProductoPage";
import AdminHomePage from "./pages/AdminHomePage";
import ProductForm from "./components/productos/ProductForm";
import DetailProduct from "./components/productos/ProductDetail"
function App() {
  const [userRole, setUserRole] = useState(null); 

  return (
    <Router>
      <Navbar userRole={userRole} setUserRole={setUserRole} /> 
      <Routes>
        <Route path="/" element={<Home userRole={userRole} />} /> 
        <Route path="/login" element={<Login setUserRole={setUserRole} />} /> 
        <Route path="/paneladmin" element={<PanelAdmin userRole={userRole} />} /> 
      </Routes>
    </Router>
  );
}

export default App;
*/