-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2024 a las 07:37:48
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `porkis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_administrador` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_administrador`, `nombre`, `apellido`, `email`, `password`, `rol`) VALUES
(1, 'Juan', 'Pérez', 'juan.perez@pasteleria.com', 'hashedPassword', 'dueño');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_Cliente` int(11) NOT NULL,
  `Nombre_Cliente` char(30) DEFAULT NULL,
  `telefono_cliente` char(15) DEFAULT NULL,
  `email_cliente` char(30) DEFAULT NULL,
  `direccion_cliente` char(20) DEFAULT NULL,
  `fecha_nac_cliente` date DEFAULT NULL,
  `pass_cliente` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_Cliente`, `Nombre_Cliente`, `telefono_cliente`, `email_cliente`, `direccion_cliente`, `fecha_nac_cliente`, `pass_cliente`) VALUES
(1, 'Juan Perez', '2302456789', 'juanp@gmail.com', 'calle 9 234', '1975-11-25', '$2a$10$Vwgk/Ch2Fv8VW3JKPTIcYegJ70AVRrdOUoqTVwqKo/4TaWOMrak0m'),
(2, 'Pedro Gonzalez', '2302987654', 'pedrog@gmail.com', 'calle 11 345', '1963-03-12', '$2a$10$HXJTTTGBb1vkmbG50cGlwe/gPz/r8W1I1FZ/kjNLzl3.5LugVxXTS'),
(3, 'Lorena Rodriguez', '2302111111', 'lorenar@gmail.com', 'calle 34 y 21', '1987-02-23', '$2a$10$ddUn9.MyAmDxEjPSUQ6Ij.gV1aDBOd/r6Er9FFNijR7YsKXtA/caS'),
(4, 'Emilia Perez', '230222222', 'emiliap@gmail.com', 'calle 44 y 17', '1975-04-23', '$2a$10$JRiZYRwU2djsrxIwW7BmVOSD.5sDFZ2smlYf9nLZCe.2NYrSgTsYu'),
(5, 'Juan Gonzalez', '2302333333', 'juang@gmail.com', 'calle 5 456', '1998-12-06', '$2a$10$1H3zacCuNcbUp79Oof5zxujBvkYFifI/8oFPgjgxP0xyN1SrDxsMS'),
(6, 'Roberto Perez', '2302444444', 'robertop@gmail.com', 'calle 6 1345', '1988-07-06', '$2a$10$9g/roxfdN263IzoRga/EOuJQhbVTdobR9vENbcLwAYU8kWpA.tNzW');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_Compra` int(11) NOT NULL,
  `id_Proveedor` int(11) NOT NULL,
  `id_MateriaPrima` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `cantidad_compra` float DEFAULT NULL,
  `precio_compra` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id_Compra`, `id_Proveedor`, `id_MateriaPrima`, `fecha_compra`, `cantidad_compra`, `precio_compra`) VALUES
(1, 1, 6, '2023-03-17', 3, 1230),
(2, 1, 7, '2023-03-17', 500, 560),
(3, 1, 15, '2023-03-12', 1000, 340),
(4, 2, 3, '2023-03-19', 12, 780),
(5, 2, 4, '2023-03-19', 3, 2210),
(6, 2, 5, '2023-03-12', 1, 230),
(7, 2, 6, '2023-03-20', 6, 2678),
(8, 3, 11, '2023-03-10', 10, 970),
(9, 3, 12, '2023-03-10', 500, 400),
(10, 3, 13, '2023-03-10', 1000, 3500),
(11, 3, 16, '2023-03-17', 4, 1320),
(12, 4, 1, '2023-03-12', 2000, 530),
(13, 4, 2, '2023-03-12', 2000, 490),
(14, 4, 8, '2023-03-15', 1000, 300),
(15, 4, 9, '2023-03-15', 200, 230),
(16, 4, 10, '2023-03-15', 200, 450),
(17, 4, 14, '2023-03-15', 500, 350);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id_Estado` int(11) NOT NULL,
  `descripcion_Estado` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id_Estado`, `descripcion_Estado`) VALUES
(1, 'Pendiente'),
(2, 'En Produccion'),
(3, 'Terminado'),
(4, 'Anulado'),
(5, 'Entregado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE `ingrediente` (
  `id_MateriaPrima` int(11) NOT NULL,
  `id_Producto` int(11) NOT NULL,
  `cantidad` float DEFAULT NULL,
  `unidades` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`id_MateriaPrima`, `id_Producto`, `cantidad`, `unidades`) VALUES
(1, 1, 90, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(6, 1, 50, 'gramos'),
(3, 2, 2, 'unidad'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros'),
(1, 1, 90, 'gramos'),
(14, 1, 30, 'gramos'),
(8, 1, 300, 'gramos'),
(3, 1, 4, 'unidad'),
(5, 1, 1, 'litros'),
(11, 1, 35, 'unidad'),
(6, 1, 50, 'gramos'),
(18, 1, 7, 'unidad'),
(3, 2, 2, 'unidad'),
(12, 2, 100, 'gramos'),
(6, 2, 150, 'gramos'),
(8, 2, 250, 'gramos'),
(2, 2, 100, 'gramos'),
(13, 3, 400, 'gramos'),
(3, 3, 1, 'unidad'),
(1, 3, 400, 'gramos'),
(8, 3, 200, 'gramos'),
(12, 3, 200, 'gramos'),
(1, 4, 200, 'gramos'),
(3, 4, 2, 'unidad'),
(12, 4, 100, 'gramos'),
(15, 4, 400, 'gramos'),
(14, 4, 150, 'gramos'),
(8, 4, 230, 'gramos'),
(3, 5, 3, 'unidad'),
(1, 5, 500, 'gramos'),
(8, 5, 250, 'gramos'),
(4, 5, 0.25, 'litros'),
(18, 5, 2, 'unidad'),
(1, 6, 500, 'gramos'),
(3, 6, 2, 'unidad'),
(17, 6, 5, 'unidad'),
(5, 6, 0.25, 'litros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia_prima`
--

CREATE TABLE `materia_prima` (
  `id_MateriaPrima` int(11) NOT NULL,
  `Nombre_MP` char(30) DEFAULT NULL,
  `unidades` float(10,0) DEFAULT NULL,
  `Fecha_Vto_Proxima` date DEFAULT NULL,
  `Un_de_Medida` varchar(20) NOT NULL,
  `id_TipoMP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia_prima`
--

INSERT INTO `materia_prima` (`id_MateriaPrima`, `Nombre_MP`, `unidades`, `Fecha_Vto_Proxima`, `Un_de_Medida`, `id_TipoMP`) VALUES
(1, 'Harina Leudante', 3000, '2023-04-28', 'gramos', 1),
(2, 'Harina 0000', 2000, '2023-05-15', 'gramos', 1),
(3, 'Huevo', 25, '2023-04-04', 'unidad', 5),
(4, 'Aceite', 8, '2023-09-07', 'litros', 5),
(5, 'Crema', 2, '2023-04-05', 'litros', 3),
(6, 'Chocolate', 7, '2023-05-26', 'unidad', 4),
(7, 'Cacao', 1000, '2023-07-05', 'gramos', 2),
(8, 'Azucar', 5000, '2023-08-31', 'gramos', 2),
(9, 'Maicena', 300, '2023-06-22', 'gramos', 1),
(10, 'Levadura', 300, '2023-04-15', 'gramos', 1),
(11, 'Cereza', 34, '2023-03-31', 'unidad', 4),
(12, 'Manteca', 2500, '2023-05-18', 'gramos', 3),
(13, 'Dulce de membrillo', 2000, '2023-07-06', 'gramos', 4),
(14, 'Coco', 500, '2023-05-29', 'gramos', 4),
(15, 'Dulce de leche', 5000, '2023-04-12', 'gramos', 3),
(16, 'Leche', 15, '2023-04-11', 'litros', 3),
(17, 'Limon', 20, '2023-04-29', 'unidad', 5),
(18, 'Frutillas', 30, '2023-04-12', 'unidad', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasos_receta`
--

CREATE TABLE `pasos_receta` (
  `id_Producto` int(11) NOT NULL,
  `paso_nro` int(11) NOT NULL,
  `descripcion` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasos_receta`
--

INSERT INTO `pasos_receta` (`id_Producto`, `paso_nro`, `descripcion`) VALUES
(1, 1, 'hervir cerezas'),
(1, 2, 'mezclar crema y chocolate'),
(1, 3, 'preparar bizcochuelo'),
(1, 4, 'cubrir con chocolate y almibar'),
(1, 5, 'decorar'),
(2, 1, 'mezclar manteca con azucar y h'),
(2, 2, 'incorporar cacao y harina'),
(2, 3, 'hornear'),
(3, 1, 'mezclar manteca con azucar y h'),
(3, 2, 'añadir harina y enfriar en la'),
(3, 3, 'pisar membrillo con agua calie'),
(3, 4, 'decorar'),
(4, 1, 'mezclar manteca y azucar'),
(4, 2, 'incorporar harina'),
(4, 3, 'agregar huevos'),
(4, 4, 'mezclar coco, huevos y azucar'),
(4, 5, 'hornear'),
(5, 1, 'mezclar manteca con azucar y h'),
(5, 2, 'agregar harina y leche'),
(5, 3, 'hornear'),
(5, 4, 'decorar'),
(6, 1, 'preparar masa'),
(6, 2, 'batir crema'),
(6, 3, 'incorporar limon'),
(6, 4, 'quemar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_Pedido` int(11) NOT NULL,
  `id_Cliente` int(11) NOT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `lugar_entrega` char(20) DEFAULT NULL,
  `id_Estado` int(11) NOT NULL,
  `id_TipoPago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_Pedido`, `id_Cliente`, `fecha_pedido`, `fecha_entrega`, `lugar_entrega`, `id_Estado`, `id_TipoPago`) VALUES
(1, 1, '2023-02-10', '2023-03-10', 'calle 9 234', 5, 1),
(2, 2, '2023-02-17', '2023-03-17', 'calle 11 345', 4, 4),
(3, 3, '2023-02-25', '2023-03-25', 'calle 34 y 21', 5, 2),
(4, 1, '2023-02-28', '2023-03-28', 'calle 9 234', 5, 3),
(5, 4, '2023-03-05', '2023-04-05', 'calle 44 y 17', 3, 1),
(6, 5, '2023-03-16', '2023-04-16', 'calle 5 456', 2, 2),
(7, 6, '2023-03-16', '2023-04-16', 'calle 6 1345', 1, 3),
(8, 3, '2023-03-25', '2023-03-29', 'calle 34 y 21', 2, 5),
(9, 5, '2023-03-25', '2023-04-25', 'calle 5 456', 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_Producto` int(11) NOT NULL,
  `Nombre_Producto` char(30) DEFAULT NULL,
  `precio_vta` float DEFAULT NULL,
  `cant_porciones` int(11) DEFAULT NULL,
  `descripcion_producto` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_Producto`, `Nombre_Producto`, `precio_vta`, `cant_porciones`, `descripcion_producto`) VALUES
(1, 'Selva Negra', 3500, 6, 'Chocolate, crema y cerezas'),
(2, 'Brownie', 2300, 8, 'Chocolate'),
(3, 'Pasta Frola', 1500, 6, 'Membrillo'),
(4, 'Tarta coco', 2400, 6, 'Coco y dulce de leche'),
(5, 'Moffins', 250, 1, 'Ideal para merendar'),
(6, 'Lemon Pie', 2300, 6, 'Limon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosxpedido`
--

CREATE TABLE `productosxpedido` (
  `id_Pedido` int(11) NOT NULL,
  `id_Producto` int(11) NOT NULL,
  `cantidad_pedido` int(11) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `observacion` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productosxpedido`
--

INSERT INTO `productosxpedido` (`id_Pedido`, `id_Producto`, `cantidad_pedido`, `precio`, `observacion`) VALUES
(1, 1, 1, 3500, NULL),
(2, 3, 1, 1500, 'para regalo'),
(3, 2, 2, 4600, NULL),
(4, 5, 5, 1250, 'para regalo'),
(5, 4, 2, 4800, NULL),
(6, 2, 1, 2300, NULL),
(7, 3, 1, 3000, NULL),
(8, 6, 1, 2678, NULL),
(9, 6, 2, 5356, 'para regalo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_Proveedor` int(11) NOT NULL,
  `CUIT` int(11) NOT NULL,
  `Nombre_Prov` char(30) NOT NULL,
  `Direccion_Prov` char(30) DEFAULT NULL,
  `email_Prov` char(20) DEFAULT NULL,
  `Telefono_Prov` char(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_Proveedor`, `CUIT`, `Nombre_Prov`, `Direccion_Prov`, `email_Prov`, `Telefono_Prov`) VALUES
(1, 2147483647, 'Bonafide', 'calle 17 O 1011', 'bonafide@gmail.com', '2302122334'),
(2, 2147483647, 'Chango mas', 'av 319 y calle 308', 'chango_mas@gmail.com', '2302112233'),
(3, 2147483647, 'De Leon', 'calle 20 590', 'de_Leon@gmail.com', '2302334455'),
(4, 2147483647, 'Diarco', 'Ruta P N°1', 'diarco@gmail.com', '2302667788');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_materiaprima`
--

CREATE TABLE `tipo_materiaprima` (
  `id_TipoMP` int(11) NOT NULL,
  `descripcion_TipoMP` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_materiaprima`
--

INSERT INTO `tipo_materiaprima` (`id_TipoMP`, `descripcion_TipoMP`) VALUES
(1, 'harinas'),
(2, 'endulzante'),
(3, 'lacteos'),
(4, 'decoracion'),
(5, 'otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pago`
--

CREATE TABLE `tipo_pago` (
  `id_TipoPago` int(11) NOT NULL,
  `descripcion_TP` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_pago`
--

INSERT INTO `tipo_pago` (`id_TipoPago`, `descripcion_TP`) VALUES
(1, 'Efectivo'),
(2, 'Credito'),
(3, 'Debito'),
(4, 'Trasferencia'),
(5, 'Mercado Pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracion`
--

CREATE TABLE `valoracion` (
  `id_Cliente` int(11) NOT NULL,
  `id_Producto` int(11) NOT NULL,
  `fecha_valoracion` date NOT NULL,
  `cant_estrellas` int(11) DEFAULT NULL,
  `comentario` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `valoracion`
--

INSERT INTO `valoracion` (`id_Cliente`, `id_Producto`, `fecha_valoracion`, `cant_estrellas`, `comentario`) VALUES
(2, 1, '2023-03-11', 5, 'muy rico'),
(3, 1, '2023-03-05', 4, 'muy rico'),
(1, 2, '2023-03-11', 2, 'tenia pocas cerezas'),
(1, 3, '2023-03-14', 4, 'muy rico'),
(4, 2, '2023-03-22', 5, 'riquisimo'),
(4, 2, '2023-02-10', 5, 'muy bueno'),
(5, 3, '2023-01-05', 3, 'masa un poco dura'),
(5, 3, '2023-03-18', 4, 'muy bueno');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_administrador`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_Cliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_Compra`),
  ADD KEY `id_Proveedor` (`id_Proveedor`),
  ADD KEY `id_MateriaPrima` (`id_MateriaPrima`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_Estado`);

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD KEY `id_MateriaPrima` (`id_MateriaPrima`),
  ADD KEY `id_Producto` (`id_Producto`);

--
-- Indices de la tabla `materia_prima`
--
ALTER TABLE `materia_prima`
  ADD PRIMARY KEY (`id_MateriaPrima`),
  ADD KEY `id_TipoMP` (`id_TipoMP`);

--
-- Indices de la tabla `pasos_receta`
--
ALTER TABLE `pasos_receta`
  ADD KEY `id_Producto` (`id_Producto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_Pedido`),
  ADD KEY `id_Cliente` (`id_Cliente`),
  ADD KEY `id_Estado` (`id_Estado`),
  ADD KEY `id_TipoPago` (`id_TipoPago`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_Producto`);

--
-- Indices de la tabla `productosxpedido`
--
ALTER TABLE `productosxpedido`
  ADD KEY `id_Pedido` (`id_Pedido`),
  ADD KEY `id_Producto` (`id_Producto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_Proveedor`);

--
-- Indices de la tabla `tipo_materiaprima`
--
ALTER TABLE `tipo_materiaprima`
  ADD PRIMARY KEY (`id_TipoMP`);

--
-- Indices de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  ADD PRIMARY KEY (`id_TipoPago`);

--
-- Indices de la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD KEY `id_Cliente` (`id_Cliente`),
  ADD KEY `id_Producto` (`id_Producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_Proveedor`) REFERENCES `proveedor` (`id_Proveedor`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_MateriaPrima`) REFERENCES `materia_prima` (`id_MateriaPrima`);

--
-- Filtros para la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD CONSTRAINT `ingrediente_ibfk_1` FOREIGN KEY (`id_MateriaPrima`) REFERENCES `materia_prima` (`id_MateriaPrima`),
  ADD CONSTRAINT `ingrediente_ibfk_2` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`id_Producto`);

--
-- Filtros para la tabla `materia_prima`
--
ALTER TABLE `materia_prima`
  ADD CONSTRAINT `materia_prima_ibfk_1` FOREIGN KEY (`id_TipoMP`) REFERENCES `tipo_materiaprima` (`id_TipoMP`);

--
-- Filtros para la tabla `pasos_receta`
--
ALTER TABLE `pasos_receta`
  ADD CONSTRAINT `pasos_receta_ibfk_1` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`id_Producto`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id_Cliente`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_Estado`) REFERENCES `estado` (`id_Estado`),
  ADD CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`id_TipoPago`) REFERENCES `tipo_pago` (`id_TipoPago`);

--
-- Filtros para la tabla `productosxpedido`
--
ALTER TABLE `productosxpedido`
  ADD CONSTRAINT `productosxpedido_ibfk_1` FOREIGN KEY (`id_Pedido`) REFERENCES `pedido` (`id_Pedido`),
  ADD CONSTRAINT `productosxpedido_ibfk_2` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`id_Producto`);

--
-- Filtros para la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD CONSTRAINT `valoracion_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id_Cliente`),
  ADD CONSTRAINT `valoracion_ibfk_2` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`id_Producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
