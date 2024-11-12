import React from 'react'
import './Inicio.css'
import Header from '../../components/Header/Header'
import Menu from '../../components/Menu/Menu'

const Inicio = () => {
  return (
    <div>
      <Header/>
      <Menu/>
      <hr className='divisor'></hr>
    </div>
  )
}

export default Inicio
