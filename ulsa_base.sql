-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 18, 2023 at 11:04 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ulsa_base`
--

-- --------------------------------------------------------

--
-- Table structure for table `alumno`
--

CREATE TABLE `alumno` (
  `id_alumno` bigint(20) NOT NULL,
  `año` int(11) DEFAULT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `nombre_alumno` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `año`, `carrera`, `nombre_alumno`) VALUES
(1, 4, 'ICE', 'Tomas Enmanuel Palacios Gallo'),
(2, 5, 'ICE', 'Jean Manuel Ocampo Aragón');

-- --------------------------------------------------------

--
-- Table structure for table `asistencia`
--

CREATE TABLE `asistencia` (
  `id_asistencia` bigint(20) NOT NULL,
  `estado_asistencia` bit(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `id_alumno` bigint(20) DEFAULT NULL,
  `id_clase` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `asistencia`
--

INSERT INTO `asistencia` (`id_asistencia`, `estado_asistencia`, `fecha`, `hora_entrada`, `hora_salida`, `id_alumno`, `id_clase`) VALUES
(1, b'0', '2023-04-20', '11:06:03', '17:06:03', 2, 1),
(2, b'1', '2023-04-25', '10:00:00', '11:40:00', 2, 2),
(3, b'0', '2023-04-25', '10:00:00', '11:40:00', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `clases`
--

CREATE TABLE `clases` (
  `id_clase` bigint(20) NOT NULL,
  `aula` varchar(255) DEFAULT NULL,
  `año` int(11) DEFAULT NULL,
  `dias` varchar(255) DEFAULT NULL,
  `grupo` varchar(255) DEFAULT NULL,
  `nombre_clase` varchar(255) DEFAULT NULL,
  `id_profesor` bigint(20) DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `clases`
--

INSERT INTO `clases` (`id_clase`, `aula`, `año`, `dias`, `grupo`, `nombre_clase`, `id_profesor`, `hora_entrada`, `hora_salida`) VALUES
(1, 'B107', 4, 'Miercoles, Jueves', '1', 'Prolog', 1, '13:00:00', '13:50:00'),
(2, 'A102', 5, 'Viernes', '2', 'Legislación', 1, '13:00:00', '14:40:00'),
(3, 'D102', 5, 'Lunes, Martes', '1', 'Seguridad', 1, '08:00:00', '10:00:00'),
(4, 'E102', 5, 'Martes, Jueves', '4', 'Redes glob.', 1, '10:00:00', '11:40:00');

-- --------------------------------------------------------

--
-- Table structure for table `passwords`
--

CREATE TABLE `passwords` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `profesor_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `passwords`
--

INSERT INTO `passwords` (`id`, `password`, `username`, `profesor_id`) VALUES
(1, '123', 'skarleth_prof', 1);

-- --------------------------------------------------------

--
-- Table structure for table `profesores`
--

CREATE TABLE `profesores` (
  `id_profesor` bigint(20) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `nombre_profesor` varchar(255) DEFAULT NULL,
  `password_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `profesores`
--

INSERT INTO `profesores` (`id_profesor`, `correo`, `nombre_profesor`, `password_id`) VALUES
(1, 'skarlet.fletes@ac.ulsa.edu.ni', 'Skarleth Massiel Fletes Latino', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_alumno`);

--
-- Indexes for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id_asistencia`),
  ADD KEY `FKhoistiucdphdkhv4gcsan5o0d` (`id_alumno`),
  ADD KEY `FKorubh4gens1fvbyl6p2ty7tsm` (`id_clase`);

--
-- Indexes for table `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`id_clase`),
  ADD KEY `FKjuih704v7agr6ummyum4sfg6h` (`id_profesor`);

--
-- Indexes for table `passwords`
--
ALTER TABLE `passwords`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ctqal5l7ho5wff884xcu0we98` (`username`),
  ADD KEY `FKpi4gss88til4yeul9si2trulq` (`profesor_id`);

--
-- Indexes for table `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_profesor`),
  ADD UNIQUE KEY `UK_fiue7qbfu7qcms949clp2323o` (`nombre_profesor`),
  ADD KEY `FKe7qc9ocbrbl594yi0mmb7iy2r` (`password_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_alumno` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id_asistencia` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `clases`
--
ALTER TABLE `clases`
  MODIFY `id_clase` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `passwords`
--
ALTER TABLE `passwords`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `profesores`
--
ALTER TABLE `profesores`
  MODIFY `id_profesor` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `FKhoistiucdphdkhv4gcsan5o0d` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  ADD CONSTRAINT `FKorubh4gens1fvbyl6p2ty7tsm` FOREIGN KEY (`id_clase`) REFERENCES `clases` (`id_clase`);

--
-- Constraints for table `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `FKjuih704v7agr6ummyum4sfg6h` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`);

--
-- Constraints for table `passwords`
--
ALTER TABLE `passwords`
  ADD CONSTRAINT `FKpi4gss88til4yeul9si2trulq` FOREIGN KEY (`profesor_id`) REFERENCES `profesores` (`id_profesor`);

--
-- Constraints for table `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `FKe7qc9ocbrbl594yi0mmb7iy2r` FOREIGN KEY (`password_id`) REFERENCES `passwords` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
