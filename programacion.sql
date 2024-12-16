-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generacion: 12-10-2018 a las 22:04:42
-- Version del servidor: 5.5.32
-- Version de PHP: 5.4.19
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
--
-- Base de datos: `programacion`
--
CREATE DATABASE IF NOT EXISTS `programacion` DEFAULT CHARACTER SET latin1 
COLLATE latin1_swedish_ci;
USE `programacion`;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `palabras`
--
CREATE TABLE IF NOT EXISTS `palabras` (
 `original` varchar(20) NOT NULL,
 `traduccion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Volcado de datos para la tabla `palabras`
--
INSERT INTO `palabras` (`original`, `traduccion`) VALUES
('odd', 'es_impar'),
('do', 'hacer'),
('while', 'mientras'),
('const', 'constante'),
('procedure', 'procedimiento'),
('var', 'variable'),
('begin', 'inicio'),
('end', 'fin'),
('if', 'si'),
('then', 'entonces'),
('call', 'invocar'),
('writeln', 'escribir_con_salto'),
('write', 'escribir'),
('readln', 'leer_con_salto');
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;