import React, { useState } from 'react'
import './Navbar.css'
import { GoSearch } from "react-icons/go";
import { AiOutlineShoppingCart } from "react-icons/ai";


const Navbar = () => {

    const [menu, setMenu] = useState("inicio");

    return (
        <div className='navbar'>
            <a className='logo'>PorkyCakes</a>
            <ul className='navbar-menu'>
                <li onClick={()=>setMenu("inicio")} className={menu==="inicio"?"active":""}>inicio</li>
                <li onClick={()=>setMenu("menu")} className={menu==="menu"?"active":""}>menu</li>
                <li onClick={()=>setMenu("contacto")} className={menu==="contacto"?"active":""}>contacto</li>
            </ul>
            <div className='navbar-right'>
                <GoSearch className='busqueda'/>
                <div className='navbar-search-icon'>
                    <AiOutlineShoppingCart className='carrito'/>
                    <div className='dot'></div>
                </div>
                <button>sign in</button>
            </div>

        </div>
    )
}

export default Navbar
