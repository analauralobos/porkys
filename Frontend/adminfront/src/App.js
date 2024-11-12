import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/HomePage';
import Login from './components/login/Login';
import Navbar from './components/Navbar';
import PanelAdmin from './pages/AdminHomePage';
import 'bootstrap/dist/css/bootstrap.min.css';

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
