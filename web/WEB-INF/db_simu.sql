-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 19, 2018 at 03:06 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_simu`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_accesorios`
--

CREATE TABLE `tbl_accesorios` (
  `id_accesorio` int(11) NOT NULL COMMENT 'identificacion accesorio',
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL COMMENT 'nombre del accesorio',
  `producto` int(11) NOT NULL,
  `tipo_accesorio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_accesorios`
--

INSERT INTO `tbl_accesorios` (`id_accesorio`, `nombre`, `producto`, `tipo_accesorio`) VALUES
(13, 'casco', 9, 1),
(14, 'guante', 10, 3),
(15, 'maletero', 11, 4),
(16, 'slider', 12, 2),
(17, 'casco', 13, 1),
(18, 'maletero', 14, 4),
(19, 'casco', 22, 2),
(20, 'guante', 23, 3),
(21, 'maletero', 24, 4),
(22, 'slider', 25, 1),
(23, 'casco', 26, 2),
(24, 'guante', 27, 1),
(25, 'slider', 28, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_ciudades`
--

CREATE TABLE `tbl_ciudades` (
  `id_ciudad` int(11) NOT NULL COMMENT 'identificacion ciudad',
  `ciudad` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'nombre de la ciudad',
  `departamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_ciudades`
--

INSERT INTO `tbl_ciudades` (`id_ciudad`, `ciudad`, `departamento`) VALUES
(1, 'Leticia', 1),
(2, 'Puerto Nariño', 1),
(3, 'Abejorral', 2),
(4, 'Abriaquí', 2),
(5, 'Alejandria', 2),
(6, 'Amagá', 2),
(7, 'Amalfi', 2),
(8, 'Andes', 2),
(9, 'Angelópolis', 2),
(10, 'Angostura', 2),
(11, 'Anorí', 2),
(12, 'Anzá', 2),
(13, 'Apartadó', 2),
(14, 'Arboletes', 2),
(15, 'Argelia', 2),
(16, 'Armenia', 2),
(17, 'Barbosa', 2),
(18, 'Bello', 2),
(19, 'Belmira', 2),
(20, 'Betania', 2),
(21, 'Betulia', 2),
(22, 'Bolívar', 2),
(23, 'Briceño', 2),
(24, 'Burítica', 2),
(25, 'Caicedo', 2),
(26, 'Caldas', 2),
(27, 'Campamento', 2),
(28, 'Caracolí', 2),
(29, 'Caramanta', 2),
(30, 'Carepa', 2),
(31, 'Carmen de Viboral', 2),
(32, 'Carolina', 2),
(33, 'Caucasia', 2),
(34, 'Cañasgordas', 2),
(35, 'Chigorodó', 2),
(36, 'Cisneros', 2),
(37, 'Cocorná', 2),
(38, 'Concepción', 2),
(39, 'Concordia', 2),
(40, 'Copacabana', 2),
(41, 'Cáceres', 2),
(42, 'Dabeiba', 2),
(43, 'Don Matías', 2),
(44, 'Ebéjico', 2),
(45, 'El Bagre', 2),
(46, 'Entrerríos', 2),
(47, 'Envigado', 2),
(48, 'Fredonia', 2),
(49, 'Frontino', 2),
(50, 'Giraldo', 2),
(51, 'Girardota', 2),
(52, 'Granada', 2),
(53, 'Guadalupe', 2),
(54, 'Guarne', 2),
(55, 'Guatapé', 2),
(56, 'Gómez Plata', 2),
(57, 'Heliconia', 2),
(58, 'Hispania', 2),
(59, 'Itagüí', 2),
(60, 'Ituango', 2),
(61, 'Jardín', 2),
(62, 'Jericó', 2),
(63, 'La Ceja', 2),
(64, 'La Estrella', 2),
(65, 'La Pintada', 2),
(66, 'La Unión', 2),
(67, 'Liborina', 2),
(68, 'Maceo', 2),
(69, 'Marinilla', 2),
(70, 'Medellín', 2),
(71, 'Montebello', 2),
(72, 'Murindó', 2),
(73, 'Mutatá', 2),
(74, 'Nariño', 2),
(75, 'Nechí', 2),
(76, 'Necoclí', 2),
(77, 'Olaya', 2),
(78, 'Peque', 2),
(79, 'Peñol', 2),
(80, 'Pueblorrico', 2),
(81, 'Puerto Berrío', 2),
(82, 'Puerto Nare', 2),
(83, 'Puerto Triunfo', 2),
(84, 'Remedios', 2),
(85, 'Retiro', 2),
(86, 'Ríonegro', 2),
(87, 'Sabanalarga', 2),
(88, 'Sabaneta', 2),
(89, 'Salgar', 2),
(90, 'San Andrés de Cuerquía', 2),
(91, 'San Carlos', 2),
(92, 'San Francisco', 2),
(93, 'San Jerónimo', 2),
(94, 'San José de Montaña', 2),
(95, 'San Juan de Urabá', 2),
(96, 'San Luís', 2),
(97, 'San Pedro', 2),
(98, 'San Pedro de Urabá', 2),
(99, 'San Rafael', 2),
(100, 'San Roque', 2),
(101, 'San Vicente', 2),
(102, 'Santa Bárbara', 2),
(103, 'Santa Fé de Antioquia', 2),
(104, 'Santa Rosa de Osos', 2),
(105, 'Santo Domingo', 2),
(106, 'Santuario', 2),
(107, 'Segovia', 2),
(108, 'Sonsón', 2),
(109, 'Sopetrán', 2),
(110, 'Tarazá', 2),
(111, 'Tarso', 2),
(112, 'Titiribí', 2),
(113, 'Toledo', 2),
(114, 'Turbo', 2),
(115, 'Támesis', 2),
(116, 'Uramita', 2),
(117, 'Urrao', 2),
(118, 'Valdivia', 2),
(119, 'Valparaiso', 2),
(120, 'Vegachí', 2),
(121, 'Venecia', 2),
(122, 'Vigía del Fuerte', 2),
(123, 'Yalí', 2),
(124, 'Yarumal', 2),
(125, 'Yolombó', 2),
(126, 'Yondó (Casabe)', 2),
(127, 'Zaragoza', 2),
(128, 'Arauca', 3),
(129, 'Arauquita', 3),
(130, 'Cravo Norte', 3),
(131, 'Fortúl', 3),
(132, 'Puerto Rondón', 3),
(133, 'Saravena', 3),
(134, 'Tame', 3),
(135, 'Baranoa', 4),
(136, 'Barranquilla', 4),
(137, 'Campo de la Cruz', 4),
(138, 'Candelaria', 4),
(139, 'Galapa', 4),
(140, 'Juan de Acosta', 4),
(141, 'Luruaco', 4),
(142, 'Malambo', 4),
(143, 'Manatí', 4),
(144, 'Palmar de Varela', 4),
(145, 'Piojo', 4),
(146, 'Polonuevo', 4),
(147, 'Ponedera', 4),
(148, 'Puerto Colombia', 4),
(149, 'Repelón', 4),
(150, 'Sabanagrande', 4),
(151, 'Sabanalarga', 4),
(152, 'Santa Lucía', 4),
(153, 'Santo Tomás', 4),
(154, 'Soledad', 4),
(155, 'Suan', 4),
(156, 'Tubará', 4),
(157, 'Usiacuri', 4),
(158, 'Achí', 5),
(159, 'Altos del Rosario', 5),
(160, 'Arenal', 5),
(161, 'Arjona', 5),
(162, 'Arroyohondo', 5),
(163, 'Barranco de Loba', 5),
(164, 'Calamar', 5),
(165, 'Cantagallo', 5),
(166, 'Cartagena', 5),
(167, 'Cicuco', 5),
(168, 'Clemencia', 5),
(169, 'Córdoba', 5),
(170, 'El Carmen de Bolívar', 5),
(171, 'El Guamo', 5),
(172, 'El Peñon', 5),
(173, 'Hatillo de Loba', 5),
(174, 'Magangué', 5),
(175, 'Mahates', 5),
(176, 'Margarita', 5),
(177, 'María la Baja', 5),
(178, 'Mompós', 5),
(179, 'Montecristo', 5),
(180, 'Morales', 5),
(181, 'Norosí', 5),
(182, 'Pinillos', 5),
(183, 'Regidor', 5),
(184, 'Río Viejo', 5),
(185, 'San Cristobal', 5),
(186, 'San Estanislao', 5),
(187, 'San Fernando', 5),
(188, 'San Jacinto', 5),
(189, 'San Jacinto del Cauca', 5),
(190, 'San Juan de Nepomuceno', 5),
(191, 'San Martín de Loba', 5),
(192, 'San Pablo', 5),
(193, 'Santa Catalina', 5),
(194, 'Santa Rosa ', 5),
(195, 'Santa Rosa del Sur', 5),
(196, 'Simití', 5),
(197, 'Soplaviento', 5),
(198, 'Talaigua Nuevo', 5),
(199, 'Tiquisio (Puerto Rico)', 5),
(200, 'Turbaco', 5),
(201, 'Turbaná', 5),
(202, 'Villanueva', 5),
(203, 'Zambrano', 5),
(204, 'Almeida', 6),
(205, 'Aquitania', 6),
(206, 'Arcabuco', 6),
(207, 'Belén', 6),
(208, 'Berbeo', 6),
(209, 'Beteitiva', 6),
(210, 'Boavita', 6),
(211, 'Boyacá', 6),
(212, 'Briceño', 6),
(213, 'Buenavista', 6),
(214, 'Busbanza', 6),
(215, 'Caldas', 6),
(216, 'Campohermoso', 6),
(217, 'Cerinza', 6),
(218, 'Chinavita', 6),
(219, 'Chiquinquirá', 6),
(220, 'Chiscas', 6),
(221, 'Chita', 6),
(222, 'Chitaraque', 6),
(223, 'Chivatá', 6),
(224, 'Chíquiza', 6),
(225, 'Chívor', 6),
(226, 'Ciénaga', 6),
(227, 'Coper', 6),
(228, 'Corrales', 6),
(229, 'Covarachía', 6),
(230, 'Cubará', 6),
(231, 'Cucaita', 6),
(232, 'Cuitiva', 6),
(233, 'Cómbita', 6),
(234, 'Duitama', 6),
(235, 'El Cocuy', 6),
(236, 'El Espino', 6),
(237, 'Firavitoba', 6),
(238, 'Floresta', 6),
(239, 'Gachantivá', 6),
(240, 'Garagoa', 6),
(241, 'Guacamayas', 6),
(242, 'Guateque', 6),
(243, 'Guayatá', 6),
(244, 'Guicán', 6),
(245, 'Gámeza', 6),
(246, 'Izá', 6),
(247, 'Jenesano', 6),
(248, 'Jericó', 6),
(249, 'La Capilla', 6),
(250, 'La Uvita', 6),
(251, 'La Victoria', 6),
(252, 'Labranzagrande', 6),
(253, 'Macanal', 6),
(254, 'Maripí', 6),
(255, 'Miraflores', 6),
(256, 'Mongua', 6),
(257, 'Monguí', 6),
(258, 'Moniquirá', 6),
(259, 'Motavita', 6),
(260, 'Muzo', 6),
(261, 'Nobsa', 6),
(262, 'Nuevo Colón', 6),
(263, 'Oicatá', 6),
(264, 'Otanche', 6),
(265, 'Pachavita', 6),
(266, 'Paipa', 6),
(267, 'Pajarito', 6),
(268, 'Panqueba', 6),
(269, 'Pauna', 6),
(270, 'Paya', 6),
(271, 'Paz de Río', 6),
(272, 'Pesca', 6),
(273, 'Pisva', 6),
(274, 'Puerto Boyacá', 6),
(275, 'Páez', 6),
(276, 'Quipama', 6),
(277, 'Ramiriquí', 6),
(278, 'Rondón', 6),
(279, 'Ráquira', 6),
(280, 'Saboyá', 6),
(281, 'Samacá', 6),
(282, 'San Eduardo', 6),
(283, 'San José de Pare', 6),
(284, 'San Luís de Gaceno', 6),
(285, 'San Mateo', 6),
(286, 'San Miguel de Sema', 6),
(287, 'San Pablo de Borbur', 6),
(288, 'Santa María', 6),
(289, 'Santa Rosa de Viterbo', 6),
(290, 'Santa Sofía', 6),
(291, 'Santana', 6),
(292, 'Sativanorte', 6),
(293, 'Sativasur', 6),
(294, 'Siachoque', 6),
(295, 'Soatá', 6),
(296, 'Socha', 6),
(297, 'Socotá', 6),
(298, 'Sogamoso', 6),
(299, 'Somondoco', 6),
(300, 'Sora', 6),
(301, 'Soracá', 6),
(302, 'Sotaquirá', 6),
(303, 'Susacón', 6),
(304, 'Sutamarchán', 6),
(305, 'Sutatenza', 6),
(306, 'Sáchica', 6),
(307, 'Tasco', 6),
(308, 'Tenza', 6),
(309, 'Tibaná', 6),
(310, 'Tibasosa', 6),
(311, 'Tinjacá', 6),
(312, 'Tipacoque', 6),
(313, 'Toca', 6),
(314, 'Toguí', 6),
(315, 'Topagá', 6),
(316, 'Tota', 6),
(317, 'Tunja', 6),
(318, 'Tunungua', 6),
(319, 'Turmequé', 6),
(320, 'Tuta', 6),
(321, 'Tutasá', 6),
(322, 'Ventaquemada', 6),
(323, 'Villa de Leiva', 6),
(324, 'Viracachá', 6),
(325, 'Zetaquirá', 6),
(326, 'Úmbita', 6),
(327, 'Aguadas', 7),
(328, 'Anserma', 7),
(329, 'Aranzazu', 7),
(330, 'Belalcázar', 7),
(331, 'Chinchiná', 7),
(332, 'Filadelfia', 7),
(333, 'La Dorada', 7),
(334, 'La Merced', 7),
(335, 'La Victoria', 7),
(336, 'Manizales', 7),
(337, 'Manzanares', 7),
(338, 'Marmato', 7),
(339, 'Marquetalia', 7),
(340, 'Marulanda', 7),
(341, 'Neira', 7),
(342, 'Norcasia', 7),
(343, 'Palestina', 7),
(344, 'Pensilvania', 7),
(345, 'Pácora', 7),
(346, 'Risaralda', 7),
(347, 'Río Sucio', 7),
(348, 'Salamina', 7),
(349, 'Samaná', 7),
(350, 'San José', 7),
(351, 'Supía', 7),
(352, 'Villamaría', 7),
(353, 'Viterbo', 7),
(354, 'Albania', 8),
(355, 'Belén de los Andaquíes', 8),
(356, 'Cartagena del Chairá', 8),
(357, 'Curillo', 8),
(358, 'El Doncello', 8),
(359, 'El Paujil', 8),
(360, 'Florencia', 8),
(361, 'La Montañita', 8),
(362, 'Milán', 8),
(363, 'Morelia', 8),
(364, 'Puerto Rico', 8),
(365, 'San José del Fragua', 8),
(366, 'San Vicente del Caguán', 8),
(367, 'Solano', 8),
(368, 'Solita', 8),
(369, 'Valparaiso', 8),
(370, 'Aguazul', 9),
(371, 'Chámeza', 9),
(372, 'Hato Corozal', 9),
(373, 'La Salina', 9),
(374, 'Maní', 9),
(375, 'Monterrey', 9),
(376, 'Nunchía', 9),
(377, 'Orocué', 9),
(378, 'Paz de Ariporo', 9),
(379, 'Pore', 9),
(380, 'Recetor', 9),
(381, 'Sabanalarga', 9),
(382, 'San Luís de Palenque', 9),
(383, 'Sácama', 9),
(384, 'Tauramena', 9),
(385, 'Trinidad', 9),
(386, 'Támara', 9),
(387, 'Villanueva', 9),
(388, 'Yopal', 9),
(389, 'Almaguer', 10),
(390, 'Argelia', 10),
(391, 'Balboa', 10),
(392, 'Bolívar', 10),
(393, 'Buenos Aires', 10),
(394, 'Cajibío', 10),
(395, 'Caldono', 10),
(396, 'Caloto', 10),
(397, 'Corinto', 10),
(398, 'El Tambo', 10),
(399, 'Florencia', 10),
(400, 'Guachené', 10),
(401, 'Guapí', 10),
(402, 'Inzá', 10),
(403, 'Jambaló', 10),
(404, 'La Sierra', 10),
(405, 'La Vega', 10),
(406, 'López (Micay)', 10),
(407, 'Mercaderes', 10),
(408, 'Miranda', 10),
(409, 'Morales', 10),
(410, 'Padilla', 10),
(411, 'Patía (El Bordo)', 10),
(412, 'Piamonte', 10),
(413, 'Piendamó', 10),
(414, 'Popayán', 10),
(415, 'Puerto Tejada', 10),
(416, 'Puracé (Coconuco)', 10),
(417, 'Páez (Belalcazar)', 10),
(418, 'Rosas', 10),
(419, 'San Sebastián', 10),
(420, 'Santa Rosa', 10),
(421, 'Santander de Quilichao', 10),
(422, 'Silvia', 10),
(423, 'Sotara (Paispamba)', 10),
(424, 'Sucre', 10),
(425, 'Suárez', 10),
(426, 'Timbiquí', 10),
(427, 'Timbío', 10),
(428, 'Toribío', 10),
(429, 'Totoró', 10),
(430, 'Villa Rica', 10),
(431, 'Aguachica', 11),
(432, 'Agustín Codazzi', 11),
(433, 'Astrea', 11),
(434, 'Becerríl', 11),
(435, 'Bosconia', 11),
(436, 'Chimichagua', 11),
(437, 'Chiriguaná', 11),
(438, 'Curumaní', 11),
(439, 'El Copey', 11),
(440, 'El Paso', 11),
(441, 'Gamarra', 11),
(442, 'Gonzalez', 11),
(443, 'La Gloria', 11),
(444, 'La Jagua de Ibirico', 11),
(445, 'La Paz (Robles)', 11),
(446, 'Manaure Balcón del Cesar', 11),
(447, 'Pailitas', 11),
(448, 'Pelaya', 11),
(449, 'Pueblo Bello', 11),
(450, 'Río de oro', 11),
(451, 'San Alberto', 11),
(452, 'San Diego', 11),
(453, 'San Martín', 11),
(454, 'Tamalameque', 11),
(455, 'Valledupar', 11),
(456, 'Acandí', 12),
(457, 'Alto Baudó (Pie de Pato)', 12),
(458, 'Atrato (Yuto)', 12),
(459, 'Bagadó', 12),
(460, 'Bahía Solano (Mútis)', 12),
(461, 'Bajo Baudó (Pizarro)', 12),
(462, 'Belén de Bajirá', 12),
(463, 'Bojayá (Bellavista)', 12),
(464, 'Cantón de San Pablo', 12),
(465, 'Carmen del Darién (CURBARADÓ)', 12),
(466, 'Condoto', 12),
(467, 'Cértegui', 12),
(468, 'El Carmen de Atrato', 12),
(469, 'Istmina', 12),
(470, 'Juradó', 12),
(471, 'Lloró', 12),
(472, 'Medio Atrato', 12),
(473, 'Medio Baudó', 12),
(474, 'Medio San Juan (ANDAGOYA)', 12),
(475, 'Novita', 12),
(476, 'Nuquí', 12),
(477, 'Quibdó', 12),
(478, 'Río Iró', 12),
(479, 'Río Quito', 12),
(480, 'Ríosucio', 12),
(481, 'San José del Palmar', 12),
(482, 'Santa Genoveva de Docorodó', 12),
(483, 'Sipí', 12),
(484, 'Tadó', 12),
(485, 'Unguía', 12),
(486, 'Unión Panamericana (ÁNIMAS)', 12),
(487, 'Ayapel', 13),
(488, 'Buenavista', 13),
(489, 'Canalete', 13),
(490, 'Cereté', 13),
(491, 'Chimá', 13),
(492, 'Chinú', 13),
(493, 'Ciénaga de Oro', 13),
(494, 'Cotorra', 13),
(495, 'La Apartada y La Frontera', 13),
(496, 'Lorica', 13),
(497, 'Los Córdobas', 13),
(498, 'Momil', 13),
(499, 'Montelíbano', 13),
(500, 'Monteria', 13),
(501, 'Moñitos', 13),
(502, 'Planeta Rica', 13),
(503, 'Pueblo Nuevo', 13),
(504, 'Puerto Escondido', 13),
(505, 'Puerto Libertador', 13),
(506, 'Purísima', 13),
(507, 'Sahagún', 13),
(508, 'San Andrés Sotavento', 13),
(509, 'San Antero', 13),
(510, 'San Bernardo del Viento', 13),
(511, 'San Carlos', 13),
(512, 'San José de Uré', 13),
(513, 'San Pelayo', 13),
(514, 'Tierralta', 13),
(515, 'Tuchín', 13),
(516, 'Valencia', 13),
(517, 'Agua de Dios', 14),
(518, 'Albán', 14),
(519, 'Anapoima', 14),
(520, 'Anolaima', 14),
(521, 'Apulo', 14),
(522, 'Arbeláez', 14),
(523, 'Beltrán', 14),
(524, 'Bituima', 14),
(525, 'Bogotá D.C.', 15),
(526, 'Bojacá', 14),
(527, 'Cabrera', 14),
(528, 'Cachipay', 14),
(529, 'Cajicá', 14),
(530, 'Caparrapí', 14),
(531, 'Carmen de Carupa', 14),
(532, 'Chaguaní', 14),
(533, 'Chipaque', 14),
(534, 'Choachí', 14),
(535, 'Chocontá', 14),
(536, 'Chía', 14),
(537, 'Cogua', 14),
(538, 'Cota', 14),
(539, 'Cucunubá', 14),
(540, 'Cáqueza', 14),
(541, 'El Colegio', 14),
(542, 'El Peñón', 14),
(543, 'El Rosal', 14),
(544, 'Facatativá', 14),
(545, 'Fosca', 14),
(546, 'Funza', 14),
(547, 'Fusagasugá', 14),
(548, 'Fómeque', 14),
(549, 'Fúquene', 14),
(550, 'Gachalá', 14),
(551, 'Gachancipá', 14),
(552, 'Gachetá', 14),
(553, 'Gama', 14),
(554, 'Girardot', 14),
(555, 'Granada', 14),
(556, 'Guachetá', 14),
(557, 'Guaduas', 14),
(558, 'Guasca', 14),
(559, 'Guataquí', 14),
(560, 'Guatavita', 14),
(561, 'Guayabal de Siquima', 14),
(562, 'Guayabetal', 14),
(563, 'Gutiérrez', 14),
(564, 'Jerusalén', 14),
(565, 'Junín', 14),
(566, 'La Calera', 14),
(567, 'La Mesa', 14),
(568, 'La Palma', 14),
(569, 'La Peña', 14),
(570, 'La Vega', 14),
(571, 'Lenguazaque', 14),
(572, 'Machetá', 14),
(573, 'Madrid', 14),
(574, 'Manta', 14),
(575, 'Medina', 14),
(576, 'Mosquera', 14),
(577, 'Nariño', 14),
(578, 'Nemocón', 14),
(579, 'Nilo', 14),
(580, 'Nimaima', 14),
(581, 'Nocaima', 14),
(582, 'Pacho', 14),
(583, 'Paime', 14),
(584, 'Pandi', 14),
(585, 'Paratebueno', 14),
(586, 'Pasca', 14),
(587, 'Puerto Salgar', 14),
(588, 'Pulí', 14),
(589, 'Quebradanegra', 14),
(590, 'Quetame', 14),
(591, 'Quipile', 14),
(592, 'Ricaurte', 14),
(593, 'San Antonio de Tequendama', 14),
(594, 'San Bernardo', 14),
(595, 'San Cayetano', 14),
(596, 'San Francisco', 14),
(597, 'San Juan de Río Seco', 14),
(598, 'Sasaima', 14),
(599, 'Sesquilé', 14),
(600, 'Sibaté', 14),
(601, 'Silvania', 14),
(602, 'Simijaca', 14),
(603, 'Soacha', 14),
(604, 'Sopó', 14),
(605, 'Subachoque', 14),
(606, 'Suesca', 14),
(607, 'Supatá', 14),
(608, 'Susa', 14),
(609, 'Sutatausa', 14),
(610, 'Tabio', 14),
(611, 'Tausa', 14),
(612, 'Tena', 14),
(613, 'Tenjo', 14),
(614, 'Tibacuy', 14),
(615, 'Tibirita', 14),
(616, 'Tocaima', 14),
(617, 'Tocancipá', 14),
(618, 'Topaipí', 14),
(619, 'Ubalá', 14),
(620, 'Ubaque', 14),
(621, 'Ubaté', 14),
(622, 'Une', 14),
(623, 'Venecia (Ospina Pérez)', 14),
(624, 'Vergara', 14),
(625, 'Viani', 14),
(626, 'Villagómez', 14),
(627, 'Villapinzón', 14),
(628, 'Villeta', 14),
(629, 'Viotá', 14),
(630, 'Yacopí', 14),
(631, 'Zipacón', 14),
(632, 'Zipaquirá', 14),
(633, 'Útica', 14),
(634, 'Inírida', 16),
(635, 'Calamar', 17),
(636, 'El Retorno', 17),
(637, 'Miraflores', 17),
(638, 'San José del Guaviare', 17),
(639, 'Acevedo', 18),
(640, 'Agrado', 18),
(641, 'Aipe', 18),
(642, 'Algeciras', 18),
(643, 'Altamira', 18),
(644, 'Baraya', 18),
(645, 'Campoalegre', 18),
(646, 'Colombia', 18),
(647, 'Elías', 18),
(648, 'Garzón', 18),
(649, 'Gigante', 18),
(650, 'Guadalupe', 18),
(651, 'Hobo', 18),
(652, 'Isnos', 18),
(653, 'La Argentina', 18),
(654, 'La Plata', 18),
(655, 'Neiva', 18),
(656, 'Nátaga', 18),
(657, 'Oporapa', 18),
(658, 'Paicol', 18),
(659, 'Palermo', 18),
(660, 'Palestina', 18),
(661, 'Pital', 18),
(662, 'Pitalito', 18),
(663, 'Rivera', 18),
(664, 'Saladoblanco', 18),
(665, 'San Agustín', 18),
(666, 'Santa María', 18),
(667, 'Suaza', 18),
(668, 'Tarqui', 18),
(669, 'Tello', 18),
(670, 'Teruel', 18),
(671, 'Tesalia', 18),
(672, 'Timaná', 18),
(673, 'Villavieja', 18),
(674, 'Yaguará', 18),
(675, 'Íquira', 18),
(676, 'Albania', 19),
(677, 'Barrancas', 19),
(678, 'Dibulla', 19),
(679, 'Distracción', 19),
(680, 'El Molino', 19),
(681, 'Fonseca', 19),
(682, 'Hatonuevo', 19),
(683, 'La Jagua del Pilar', 19),
(684, 'Maicao', 19),
(685, 'Manaure', 19),
(686, 'Riohacha', 19),
(687, 'San Juan del Cesar', 19),
(688, 'Uribia', 19),
(689, 'Urumita', 19),
(690, 'Villanueva', 19),
(691, 'Algarrobo', 20),
(692, 'Aracataca', 20),
(693, 'Ariguaní (El Difícil)', 20),
(694, 'Cerro San Antonio', 20),
(695, 'Chivolo', 20),
(696, 'Ciénaga', 20),
(697, 'Concordia', 20),
(698, 'El Banco', 20),
(699, 'El Piñon', 20),
(700, 'El Retén', 20),
(701, 'Fundación', 20),
(702, 'Guamal', 20),
(703, 'Nueva Granada', 20),
(704, 'Pedraza', 20),
(705, 'Pijiño', 20),
(706, 'Pivijay', 20),
(707, 'Plato', 20),
(708, 'Puebloviejo', 20),
(709, 'Remolino', 20),
(710, 'Sabanas de San Angel (SAN ANGE', 20),
(711, 'Salamina', 20),
(712, 'San Sebastián de Buenavista', 20),
(713, 'San Zenón', 20),
(714, 'Santa Ana', 20),
(715, 'Santa Bárbara de Pinto', 20),
(716, 'Santa Marta', 20),
(717, 'Sitionuevo', 20),
(718, 'Tenerife', 20),
(719, 'Zapayán (PUNTA DE PIEDRAS)', 20),
(720, 'Zona Bananera (PRADO - SEVILLA', 20),
(721, 'Acacías', 21),
(722, 'Barranca de Upía', 21),
(723, 'Cabuyaro', 21),
(724, 'Castilla la Nueva', 21),
(725, 'Cubarral', 21),
(726, 'Cumaral', 21),
(727, 'El Calvario', 21),
(728, 'El Castillo', 21),
(729, 'El Dorado', 21),
(730, 'Fuente de Oro', 21),
(731, 'Granada', 21),
(732, 'Guamal', 21),
(733, 'La Macarena', 21),
(734, 'Lejanías', 21),
(735, 'Mapiripan', 21),
(736, 'Mesetas', 21),
(737, 'Puerto Concordia', 21),
(738, 'Puerto Gaitán', 21),
(739, 'Puerto Lleras', 21),
(740, 'Puerto López', 21),
(741, 'Puerto Rico', 21),
(742, 'Restrepo', 21),
(743, 'San Carlos de Guaroa', 21),
(744, 'San Juan de Arama', 21),
(745, 'San Juanito', 21),
(746, 'San Martín', 21),
(747, 'Uribe', 21),
(748, 'Villavicencio', 21),
(749, 'Vista Hermosa', 21),
(750, 'Albán (San José)', 22),
(751, 'Aldana', 22),
(752, 'Ancuya', 22),
(753, 'Arboleda (Berruecos)', 22),
(754, 'Barbacoas', 22),
(755, 'Belén', 22),
(756, 'Buesaco', 22),
(757, 'Chachaguí', 22),
(758, 'Colón (Génova)', 22),
(759, 'Consaca', 22),
(760, 'Contadero', 22),
(761, 'Cuaspud (Carlosama)', 22),
(762, 'Cumbal', 22),
(763, 'Cumbitara', 22),
(764, 'Córdoba', 22),
(765, 'El Charco', 22),
(766, 'El Peñol', 22),
(767, 'El Rosario', 22),
(768, 'El Tablón de Gómez', 22),
(769, 'El Tambo', 22),
(770, 'Francisco Pizarro', 22),
(771, 'Funes', 22),
(772, 'Guachavés', 22),
(773, 'Guachucal', 22),
(774, 'Guaitarilla', 22),
(775, 'Gualmatán', 22),
(776, 'Iles', 22),
(777, 'Imúes', 22),
(778, 'Ipiales', 22),
(779, 'La Cruz', 22),
(780, 'La Florida', 22),
(781, 'La Llanada', 22),
(782, 'La Tola', 22),
(783, 'La Unión', 22),
(784, 'Leiva', 22),
(785, 'Linares', 22),
(786, 'Magüi (Payán)', 22),
(787, 'Mallama (Piedrancha)', 22),
(788, 'Mosquera', 22),
(789, 'Nariño', 22),
(790, 'Olaya Herrera', 22),
(791, 'Ospina', 22),
(792, 'Policarpa', 22),
(793, 'Potosí', 22),
(794, 'Providencia', 22),
(795, 'Puerres', 22),
(796, 'Pupiales', 22),
(797, 'Ricaurte', 22),
(798, 'Roberto Payán (San José)', 22),
(799, 'Samaniego', 22),
(800, 'San Bernardo', 22),
(801, 'San Juan de Pasto', 22),
(802, 'San Lorenzo', 22),
(803, 'San Pablo', 22),
(804, 'San Pedro de Cartago', 22),
(805, 'Sandoná', 22),
(806, 'Santa Bárbara (Iscuandé)', 22),
(807, 'Sapuyes', 22),
(808, 'Sotomayor (Los Andes)', 22),
(809, 'Taminango', 22),
(810, 'Tangua', 22),
(811, 'Tumaco', 22),
(812, 'Túquerres', 22),
(813, 'Yacuanquer', 22),
(814, 'Arboledas', 23),
(815, 'Bochalema', 23),
(816, 'Bucarasica', 23),
(817, 'Chinácota', 23),
(818, 'Chitagá', 23),
(819, 'Convención', 23),
(820, 'Cucutilla', 23),
(821, 'Cáchira', 23),
(822, 'Cácota', 23),
(823, 'Cúcuta', 23),
(824, 'Durania', 23),
(825, 'El Carmen', 23),
(826, 'El Tarra', 23),
(827, 'El Zulia', 23),
(828, 'Gramalote', 23),
(829, 'Hacarí', 23),
(830, 'Herrán', 23),
(831, 'La Esperanza', 23),
(832, 'La Playa', 23),
(833, 'Labateca', 23),
(834, 'Los Patios', 23),
(835, 'Lourdes', 23),
(836, 'Mutiscua', 23),
(837, 'Ocaña', 23),
(838, 'Pamplona', 23),
(839, 'Pamplonita', 23),
(840, 'Puerto Santander', 23),
(841, 'Ragonvalia', 23),
(842, 'Salazar', 23),
(843, 'San Calixto', 23),
(844, 'San Cayetano', 23),
(845, 'Santiago', 23),
(846, 'Sardinata', 23),
(847, 'Silos', 23),
(848, 'Teorama', 23),
(849, 'Tibú', 23),
(850, 'Toledo', 23),
(851, 'Villa Caro', 23),
(852, 'Villa del Rosario', 23),
(853, 'Ábrego', 23),
(854, 'Colón', 24),
(855, 'Mocoa', 24),
(856, 'Orito', 24),
(857, 'Puerto Asís', 24),
(858, 'Puerto Caicedo', 24),
(859, 'Puerto Guzmán', 24),
(860, 'Puerto Leguízamo', 24),
(861, 'San Francisco', 24),
(862, 'San Miguel', 24),
(863, 'Santiago', 24),
(864, 'Sibundoy', 24),
(865, 'Valle del Guamuez', 24),
(866, 'Villagarzón', 24),
(867, 'Armenia', 25),
(868, 'Buenavista', 25),
(869, 'Calarcá', 25),
(870, 'Circasia', 25),
(871, 'Cordobá', 25),
(872, 'Filandia', 25),
(873, 'Génova', 25),
(874, 'La Tebaida', 25),
(875, 'Montenegro', 25),
(876, 'Pijao', 25),
(877, 'Quimbaya', 25),
(878, 'Salento', 25),
(879, 'Apía', 26),
(880, 'Balboa', 26),
(881, 'Belén de Umbría', 26),
(882, 'Dos Quebradas', 26),
(883, 'Guática', 26),
(884, 'La Celia', 26),
(885, 'La Virginia', 26),
(886, 'Marsella', 26),
(887, 'Mistrató', 26),
(888, 'Pereira', 26),
(889, 'Pueblo Rico', 26),
(890, 'Quinchía', 26),
(891, 'Santa Rosa de Cabal', 26),
(892, 'Santuario', 26),
(893, 'Providencia', 27),
(894, 'Aguada', 28),
(895, 'Albania', 28),
(896, 'Aratoca', 28),
(897, 'Barbosa', 28),
(898, 'Barichara', 28),
(899, 'Barrancabermeja', 28),
(900, 'Betulia', 28),
(901, 'Bolívar', 28),
(902, 'Bucaramanga', 28),
(903, 'Cabrera', 28),
(904, 'California', 28),
(905, 'Capitanejo', 28),
(906, 'Carcasí', 28),
(907, 'Cepita', 28),
(908, 'Cerrito', 28),
(909, 'Charalá', 28),
(910, 'Charta', 28),
(911, 'Chima', 28),
(912, 'Chipatá', 28),
(913, 'Cimitarra', 28),
(914, 'Concepción', 28),
(915, 'Confines', 28),
(916, 'Contratación', 28),
(917, 'Coromoro', 28),
(918, 'Curití', 28),
(919, 'El Carmen', 28),
(920, 'El Guacamayo', 28),
(921, 'El Peñon', 28),
(922, 'El Playón', 28),
(923, 'Encino', 28),
(924, 'Enciso', 28),
(925, 'Floridablanca', 28),
(926, 'Florián', 28),
(927, 'Galán', 28),
(928, 'Girón', 28),
(929, 'Guaca', 28),
(930, 'Guadalupe', 28),
(931, 'Guapota', 28),
(932, 'Guavatá', 28),
(933, 'Guepsa', 28),
(934, 'Gámbita', 28),
(935, 'Hato', 28),
(936, 'Jesús María', 28),
(937, 'Jordán', 28),
(938, 'La Belleza', 28),
(939, 'La Paz', 28),
(940, 'Landázuri', 28),
(941, 'Lebrija', 28),
(942, 'Los Santos', 28),
(943, 'Macaravita', 28),
(944, 'Matanza', 28),
(945, 'Mogotes', 28),
(946, 'Molagavita', 28),
(947, 'Málaga', 28),
(948, 'Ocamonte', 28),
(949, 'Oiba', 28),
(950, 'Onzaga', 28),
(951, 'Palmar', 28),
(952, 'Palmas del Socorro', 28),
(953, 'Pie de Cuesta', 28),
(954, 'Pinchote', 28),
(955, 'Puente Nacional', 28),
(956, 'Puerto Parra', 28),
(957, 'Puerto Wilches', 28),
(958, 'Páramo', 28),
(959, 'Rio Negro', 28),
(960, 'Sabana de Torres', 28),
(961, 'San Andrés', 28),
(962, 'San Benito', 28),
(963, 'San Gíl', 28),
(964, 'San Joaquín', 28),
(965, 'San José de Miranda', 28),
(966, 'San Miguel', 28),
(967, 'San Vicente del Chucurí', 28),
(968, 'Santa Bárbara', 28),
(969, 'Santa Helena del Opón', 28),
(970, 'Simacota', 28),
(971, 'Socorro', 28),
(972, 'Suaita', 28),
(973, 'Sucre', 28),
(974, 'Suratá', 28),
(975, 'Tona', 28),
(976, 'Valle de San José', 28),
(977, 'Vetas', 28),
(978, 'Villanueva', 28),
(979, 'Vélez', 28),
(980, 'Zapatoca', 28),
(981, 'Buenavista', 29),
(982, 'Caimito', 29),
(983, 'Chalán', 29),
(984, 'Colosó (Ricaurte)', 29),
(985, 'Corozal', 29),
(986, 'Coveñas', 29),
(987, 'El Roble', 29),
(988, 'Galeras (Nueva Granada)', 29),
(989, 'Guaranda', 29),
(990, 'La Unión', 29),
(991, 'Los Palmitos', 29),
(992, 'Majagual', 29),
(993, 'Morroa', 29),
(994, 'Ovejas', 29),
(995, 'Palmito', 29),
(996, 'Sampués', 29),
(997, 'San Benito Abad', 29),
(998, 'San Juan de Betulia', 29),
(999, 'San Marcos', 29),
(1000, 'San Onofre', 29),
(1001, 'San Pedro', 29),
(1002, 'Sincelejo', 29),
(1003, 'Sincé', 29),
(1004, 'Sucre', 29),
(1005, 'Tolú', 29),
(1006, 'Tolú Viejo', 29),
(1007, 'Alpujarra', 30),
(1008, 'Alvarado', 30),
(1009, 'Ambalema', 30),
(1010, 'Anzoátegui', 30),
(1011, 'Armero (Guayabal)', 30),
(1012, 'Ataco', 30),
(1013, 'Cajamarca', 30),
(1014, 'Carmen de Apicalá', 30),
(1015, 'Casabianca', 30),
(1016, 'Chaparral', 30),
(1017, 'Coello', 30),
(1018, 'Coyaima', 30),
(1019, 'Cunday', 30),
(1020, 'Dolores', 30),
(1021, 'Espinal', 30),
(1022, 'Falan', 30),
(1023, 'Flandes', 30),
(1024, 'Fresno', 30),
(1025, 'Guamo', 30),
(1026, 'Herveo', 30),
(1027, 'Honda', 30),
(1028, 'Ibagué', 30),
(1029, 'Icononzo', 30),
(1030, 'Lérida', 30),
(1031, 'Líbano', 30),
(1032, 'Mariquita', 30),
(1033, 'Melgar', 30),
(1034, 'Murillo', 30),
(1035, 'Natagaima', 30),
(1036, 'Ortega', 30),
(1037, 'Palocabildo', 30),
(1038, 'Piedras', 30),
(1039, 'Planadas', 30),
(1040, 'Prado', 30),
(1041, 'Purificación', 30),
(1042, 'Rioblanco', 30),
(1043, 'Roncesvalles', 30),
(1044, 'Rovira', 30),
(1045, 'Saldaña', 30),
(1046, 'San Antonio', 30),
(1047, 'San Luis', 30),
(1048, 'Santa Isabel', 30),
(1049, 'Suárez', 30),
(1050, 'Valle de San Juan', 30),
(1051, 'Venadillo', 30),
(1052, 'Villahermosa', 30),
(1053, 'Villarrica', 30),
(1054, 'Alcalá', 31),
(1055, 'Andalucía', 31),
(1056, 'Ansermanuevo', 31),
(1057, 'Argelia', 31),
(1058, 'Bolívar', 31),
(1059, 'Buenaventura', 31),
(1060, 'Buga', 31),
(1061, 'Bugalagrande', 31),
(1062, 'Caicedonia', 31),
(1063, 'Calima (Darién)', 31),
(1064, 'Calí', 31),
(1065, 'Candelaria', 31),
(1066, 'Cartago', 31),
(1067, 'Dagua', 31),
(1068, 'El Cairo', 31),
(1069, 'El Cerrito', 31),
(1070, 'El Dovio', 31),
(1071, 'El Águila', 31),
(1072, 'Florida', 31),
(1073, 'Ginebra', 31),
(1074, 'Guacarí', 31),
(1075, 'Jamundí', 31),
(1076, 'La Cumbre', 31),
(1077, 'La Unión', 31),
(1078, 'La Victoria', 31),
(1079, 'Obando', 31),
(1080, 'Palmira', 31),
(1081, 'Pradera', 31),
(1082, 'Restrepo', 31),
(1083, 'Riofrío', 31),
(1084, 'Roldanillo', 31),
(1085, 'San Pedro', 31),
(1086, 'Sevilla', 31),
(1087, 'Toro', 31),
(1088, 'Trujillo', 31),
(1089, 'Tulúa', 31),
(1090, 'Ulloa', 31),
(1091, 'Versalles', 31),
(1092, 'Vijes', 31),
(1093, 'Yotoco', 31),
(1094, 'Yumbo', 31),
(1095, 'Zarzal', 31),
(1096, 'Carurú', 32),
(1097, 'Mitú', 32),
(1098, 'Taraira', 32),
(1099, 'Cumaribo', 33),
(1100, 'La Primavera', 33),
(1101, 'Puerto Carreño', 33),
(1102, 'Santa Rosalía', 33);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_departamentos`
--

CREATE TABLE `tbl_departamentos` (
  `id_departamento` int(11) NOT NULL COMMENT 'identificacion departamento',
  `departamento` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'nombre departamento'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_departamentos`
--

INSERT INTO `tbl_departamentos` (`id_departamento`, `departamento`) VALUES
(1, 'Amazonas'),
(2, 'Antioquia'),
(3, 'Arauca'),
(4, 'Atlántico'),
(5, 'Bolívar'),
(6, 'Boyacá'),
(7, 'Caldas'),
(8, 'Caquetá'),
(9, 'Casanare'),
(10, 'Cauca'),
(11, 'Cesar'),
(12, 'Chocó'),
(13, 'Córdoba'),
(14, 'Cundinamarca'),
(15, 'Bogotá D.C.'),
(16, 'Guainia'),
(17, 'Guaviare'),
(18, 'Huila'),
(19, 'La Guajira'),
(20, 'Magdalena'),
(21, 'Meta'),
(22, 'Nariño'),
(23, 'Norte de Santander'),
(24, 'Putumayo'),
(25, 'Quindio'),
(26, 'Risaralda'),
(27, 'San Andrés y Providencia'),
(28, 'Santander'),
(29, 'Sucre'),
(30, 'Tolima'),
(31, 'Valle del Cauca'),
(32, 'Vaupés'),
(33, 'Vichada');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detalles_transaccion`
--

CREATE TABLE `tbl_detalles_transaccion` (
  `id_detalle_transaccion` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_final` double DEFAULT NULL,
  `producto` int(11) NOT NULL,
  `transaccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_estados_moto`
--

CREATE TABLE `tbl_estados_moto` (
  `id_estado_moto` int(11) NOT NULL,
  `nombre_estado` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_estados_moto`
--

INSERT INTO `tbl_estados_moto` (`id_estado_moto`, `nombre_estado`) VALUES
(1, 'Ofrecida'),
(2, 'Descartada'),
(3, 'Disponible'),
(4, 'Vendida'),
(5, 'En reparación');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_marcas`
--

CREATE TABLE `tbl_marcas` (
  `id_marca` int(11) NOT NULL,
  `marca` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_marcas`
--

INSERT INTO `tbl_marcas` (`id_marca`, `marca`, `tipo_producto`) VALUES
(1, 'Yamaha', 1),
(2, 'Honda', 1),
(3, 'Bajaj', 1),
(4, 'Pulsar', 1),
(5, 'Ducati', 1),
(6, 'Piaggio', 1),
(7, 'BMW', 1),
(8, 'Kymco', 1),
(9, 'AKT', 1),
(10, 'KTM', 1),
(11, 'Suzuki', 1),
(12, 'Kawasaki', 1),
(13, 'Harley-Davidson', 1),
(14, 'Patito', 2),
(15, 'Mecanics', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_motos`
--

CREATE TABLE `tbl_motos` (
  `id_moto` int(11) NOT NULL,
  `placa` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `cilindraje` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `color` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `kilometraje` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `estado_moto` int(11) NOT NULL,
  `producto` int(11) NOT NULL,
  `cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_motos`
--

INSERT INTO `tbl_motos` (`id_moto`, `placa`, `cilindraje`, `color`, `modelo`, `kilometraje`, `estado_moto`, `producto`, `cliente`) VALUES
(1, 'xx44xx', '', '', '2018', '', 3, 17, NULL),
(2, 'xx45xx', '', '', '2018', '', 3, 18, NULL),
(3, 'xx46xx', '', '', '2018', '', 3, 19, NULL),
(4, 'xx47xx', '', '', '2018', '', 3, 20, NULL),
(5, 'xx48xx', '', '', '2018', '', 3, 21, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_permisos`
--

CREATE TABLE `tbl_permisos` (
  `id_permiso` int(11) NOT NULL COMMENT 'identificacion permiso',
  `permiso` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'nombre permiso',
  `icono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `url` text COLLATE utf8_spanish_ci,
  `permiso_padre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_permisos`
--

INSERT INTO `tbl_permisos` (`id_permiso`, `permiso`, `icono`, `url`, `permiso_padre`) VALUES
(3, 'Reparaciones', 'fa fa-wrench', 'index.xhtml', NULL),
(4, 'Editar perfil', 'fa fa-pencil', 'editar-perfil.xhtml', NULL),
(5, 'Inicio', 'fa fa-home', 'index.xhtml', NULL),
(6, 'Motos', 'fa fa-motorcycle', 'listarMotos.xhtml', NULL),
(7, 'Accesorios', 'fa fa-wrench', 'listarAccesorios.xhtml', NULL),
(8, 'Clientes', 'fa fa-user', 'listarClientes.xhtml', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_productos`
--

CREATE TABLE `tbl_productos` (
  `id_producto` int(11) NOT NULL COMMENT 'identificacion producto',
  `referencia` varchar(10) COLLATE utf8_spanish_ci NOT NULL COMMENT 'referencia producto',
  `precio` double NOT NULL COMMENT 'precio producto',
  `porcentaje_descuento` double DEFAULT NULL,
  `url_foto` text COLLATE utf8_spanish_ci NOT NULL,
  `alt_foto` text COLLATE utf8_spanish_ci NOT NULL,
  `marca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_productos`
--

INSERT INTO `tbl_productos` (`id_producto`, `referencia`, `precio`, `porcentaje_descuento`, `url_foto`, `alt_foto`, `marca`) VALUES
(9, 'xx79xx', 45000, 0, 'Casco.png', 'casco', 15),
(10, 'xx80xx', 50000, NULL, 'guantes.png', 'guantes', 15),
(11, 'xx81xx', 55000, NULL, 'maletero.png', 'maletero', 14),
(12, 'xx82xx', 60000, NULL, 'slider.png', 'slider', 15),
(13, 'xx83xx', 65000, NULL, 'Casco1.png', 'casco', 14),
(14, 'xx84xx', 70000, NULL, 'maletero1.png', 'maletero', 15),
(15, 'xx85xx', 75000, NULL, 'guantes1.png', 'guantes', 15),
(16, 'xx86xx', 80000, NULL, 'nose.png', 'nose', 14),
(17, 'xx87xx', 16000000, NULL, 'moto-fondo.jpg', 'Ducati xx87xx', 5),
(18, 'xx88xx', 17000000, NULL, 'yamaha-ejemplo.jpg', 'Yamaha xx88xx', 1),
(19, 'xx89xx', 18000000, NULL, 'honda-ejemplo.jpg', 'Honda xx89xx', 2),
(20, 'xx90xx', 19000000, NULL, 'bajaj-ejemplo.jpg', 'Bajaj xx89xx', 3),
(21, 'xx91xx', 20000000, NULL, 'scooter-1245844_1920.jpg', 'Pulsar xx90xx', 4),
(22, 'xx92xx', 10000, NULL, 'Casco3.png', 'casco', 15),
(23, 'xx93xx', 11000, NULL, 'guantes3.png', 'guante', 14),
(24, 'xx94xx', 12000, NULL, 'maletero3.png', 'maletero', 15),
(25, 'xx95xx', 13000, NULL, 'slider3.png', 'slider', 14),
(26, 'xx96xx', 14000, NULL, 'Casco1.png', 'casco', 15),
(27, 'xx97xx', 15000, NULL, 'guantes.png', 'guante', 14),
(28, 'xx98xx', 16000, NULL, 'slider.png', 'slider', 15);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_reparaciones`
--

CREATE TABLE `tbl_reparaciones` (
  `id_reparacion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `descripcion` text COLLATE utf8_spanish_ci,
  `calificacion` int(1) DEFAULT NULL,
  `moto` int(11) NOT NULL,
  `mecanico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_reparaciones_has_tbl_tipos_reparacion`
--

CREATE TABLE `tbl_reparaciones_has_tbl_tipos_reparacion` (
  `reparacion` int(11) NOT NULL,
  `tipo_reparacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_roles`
--

CREATE TABLE `tbl_roles` (
  `id_rol` int(11) NOT NULL COMMENT 'identificacion rol',
  `rol` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'nombre rol'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_roles`
--

INSERT INTO `tbl_roles` (`id_rol`, `rol`) VALUES
(1, 'Cliente'),
(2, 'Mecánico'),
(3, 'Administrador'),
(4, 'Administrador superior');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_roles_has_tbl_permisos`
--

CREATE TABLE `tbl_roles_has_tbl_permisos` (
  `rol` int(11) NOT NULL,
  `permiso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_roles_has_tbl_permisos`
--

INSERT INTO `tbl_roles_has_tbl_permisos` (`rol`, `permiso`) VALUES
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(3, 7),
(3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tipos_accesorio`
--

CREATE TABLE `tbl_tipos_accesorio` (
  `id_tipo_accesorio` int(11) NOT NULL,
  `tipo_accesorio` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_tipos_accesorio`
--

INSERT INTO `tbl_tipos_accesorio` (`id_tipo_accesorio`, `tipo_accesorio`) VALUES
(1, 'Casco'),
(2, 'Slider'),
(3, 'Guante'),
(4, 'Maletero'),
(5, 'Chaqueta');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tipos_documento`
--

CREATE TABLE `tbl_tipos_documento` (
  `id_tipo_documento` int(11) NOT NULL,
  `sigla` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_documento` varchar(25) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_tipos_documento`
--

INSERT INTO `tbl_tipos_documento` (`id_tipo_documento`, `sigla`, `tipo_documento`) VALUES
(1, 'CC', 'Cédula de ciudadanía'),
(2, 'CE', 'Cédula de extranjería'),
(3, 'P', 'Pasaporte');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tipos_producto`
--

CREATE TABLE `tbl_tipos_producto` (
  `id_tipo_producto` int(11) NOT NULL,
  `tipo_producto` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_tipos_producto`
--

INSERT INTO `tbl_tipos_producto` (`id_tipo_producto`, `tipo_producto`) VALUES
(1, 'Moto'),
(2, 'Accesorio');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tipos_reparacion`
--

CREATE TABLE `tbl_tipos_reparacion` (
  `id_tipo_reparacion` int(11) NOT NULL COMMENT 'identificacion servicio\n1 - Revision (cuando se va a vender, depende de como implementemos esa parte)\n2 - Reparacion\n3 - Mantenimiento (el - mec)\n4 - Modificacion',
  `servicio` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'nombre servicio'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_tipos_reparacion`
--

INSERT INTO `tbl_tipos_reparacion` (`id_tipo_reparacion`, `servicio`) VALUES
(1, 'Reparación'),
(2, 'Mantenimiento eléctrico'),
(3, 'Mantenimiento mecánico'),
(4, 'Modificación');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tipos_transaccion`
--

CREATE TABLE `tbl_tipos_transaccion` (
  `id_tipo_transaccion` int(11) NOT NULL COMMENT 'Identifica el tipo de producto',
  `tipo_transaccion` varchar(15) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Si el tipo de producto en el stock es moto o accesorio'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_tipos_transaccion`
--

INSERT INTO `tbl_tipos_transaccion` (`id_tipo_transaccion`, `tipo_transaccion`) VALUES
(1, 'Compra'),
(2, 'Venta');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transacciones`
--

CREATE TABLE `tbl_transacciones` (
  `id_transaccion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cliente` int(11) NOT NULL,
  `tipo_transaccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numero_documento` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `rol` int(11) NOT NULL,
  `tipo_documento` int(11) DEFAULT NULL,
  `ciudad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`id_usuario`, `nombre`, `apellido`, `email`, `contrasena`, `direccion`, `telefono`, `numero_documento`, `fecha_registro`, `rol`, `tipo_documento`, `ciudad`) VALUES
(1, 'Daniel', 'Ramírez', 'dansan@hotmail.es', 'aa47f8215c6f30a0dcdb2a36a9f4168e', 'Carrera 23 # 34 - 45', '3124567890', '1234567890', '2018-09-10', 1, 1, 317),
(2, 'David', 'Rivas', 'd.rivas95@hotmail.com', '172522ec1028ab781d9dfd17eaca4427', NULL, '3015835266', NULL, '2018-09-10', 2, 1, NULL),
(3, 'Nicolas', 'Murillo', 'nicolas@simu.com.co', 'deb97a759ee7b8ba42e02dddf2b412fe', NULL, '3249589600', NULL, '2018-09-10', 3, 3, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_accesorios`
--
ALTER TABLE `tbl_accesorios`
  ADD PRIMARY KEY (`id_accesorio`),
  ADD KEY `producto` (`producto`),
  ADD KEY `tipo_accesorio` (`tipo_accesorio`);

--
-- Indexes for table `tbl_ciudades`
--
ALTER TABLE `tbl_ciudades`
  ADD PRIMARY KEY (`id_ciudad`),
  ADD KEY `departamento` (`departamento`);

--
-- Indexes for table `tbl_departamentos`
--
ALTER TABLE `tbl_departamentos`
  ADD PRIMARY KEY (`id_departamento`);

--
-- Indexes for table `tbl_detalles_transaccion`
--
ALTER TABLE `tbl_detalles_transaccion`
  ADD PRIMARY KEY (`id_detalle_transaccion`),
  ADD KEY `producto` (`producto`),
  ADD KEY `transaccion` (`transaccion`);

--
-- Indexes for table `tbl_estados_moto`
--
ALTER TABLE `tbl_estados_moto`
  ADD PRIMARY KEY (`id_estado_moto`);

--
-- Indexes for table `tbl_marcas`
--
ALTER TABLE `tbl_marcas`
  ADD PRIMARY KEY (`id_marca`),
  ADD KEY `tipo_producto` (`tipo_producto`);

--
-- Indexes for table `tbl_motos`
--
ALTER TABLE `tbl_motos`
  ADD PRIMARY KEY (`id_moto`),
  ADD KEY `cliente` (`cliente`),
  ADD KEY `estado_moto` (`estado_moto`),
  ADD KEY `tbl_motos_ibfk_1` (`producto`);

--
-- Indexes for table `tbl_permisos`
--
ALTER TABLE `tbl_permisos`
  ADD PRIMARY KEY (`id_permiso`),
  ADD KEY `permiso_padre` (`permiso_padre`);

--
-- Indexes for table `tbl_productos`
--
ALTER TABLE `tbl_productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `marca` (`marca`);

--
-- Indexes for table `tbl_reparaciones`
--
ALTER TABLE `tbl_reparaciones`
  ADD PRIMARY KEY (`id_reparacion`),
  ADD KEY `moto` (`moto`),
  ADD KEY `mecanico` (`mecanico`);

--
-- Indexes for table `tbl_reparaciones_has_tbl_tipos_reparacion`
--
ALTER TABLE `tbl_reparaciones_has_tbl_tipos_reparacion`
  ADD PRIMARY KEY (`reparacion`,`tipo_reparacion`),
  ADD KEY `tipo_reparacion` (`tipo_reparacion`);

--
-- Indexes for table `tbl_roles`
--
ALTER TABLE `tbl_roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indexes for table `tbl_roles_has_tbl_permisos`
--
ALTER TABLE `tbl_roles_has_tbl_permisos`
  ADD PRIMARY KEY (`rol`,`permiso`),
  ADD KEY `permiso` (`permiso`);

--
-- Indexes for table `tbl_tipos_accesorio`
--
ALTER TABLE `tbl_tipos_accesorio`
  ADD PRIMARY KEY (`id_tipo_accesorio`);

--
-- Indexes for table `tbl_tipos_documento`
--
ALTER TABLE `tbl_tipos_documento`
  ADD PRIMARY KEY (`id_tipo_documento`);

--
-- Indexes for table `tbl_tipos_producto`
--
ALTER TABLE `tbl_tipos_producto`
  ADD PRIMARY KEY (`id_tipo_producto`);

--
-- Indexes for table `tbl_tipos_reparacion`
--
ALTER TABLE `tbl_tipos_reparacion`
  ADD PRIMARY KEY (`id_tipo_reparacion`);

--
-- Indexes for table `tbl_tipos_transaccion`
--
ALTER TABLE `tbl_tipos_transaccion`
  ADD PRIMARY KEY (`id_tipo_transaccion`);

--
-- Indexes for table `tbl_transacciones`
--
ALTER TABLE `tbl_transacciones`
  ADD PRIMARY KEY (`id_transaccion`),
  ADD KEY `tipo_transaccion` (`tipo_transaccion`),
  ADD KEY `cliente` (`cliente`);

--
-- Indexes for table `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `rol` (`rol`),
  ADD KEY `tipo_documento` (`tipo_documento`),
  ADD KEY `ciudad` (`ciudad`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_accesorios`
--
ALTER TABLE `tbl_accesorios`
  MODIFY `id_accesorio` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion accesorio', AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `tbl_ciudades`
--
ALTER TABLE `tbl_ciudades`
  MODIFY `id_ciudad` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion ciudad', AUTO_INCREMENT=1103;

--
-- AUTO_INCREMENT for table `tbl_departamentos`
--
ALTER TABLE `tbl_departamentos`
  MODIFY `id_departamento` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion departamento', AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `tbl_detalles_transaccion`
--
ALTER TABLE `tbl_detalles_transaccion`
  MODIFY `id_detalle_transaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_estados_moto`
--
ALTER TABLE `tbl_estados_moto`
  MODIFY `id_estado_moto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_marcas`
--
ALTER TABLE `tbl_marcas`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_motos`
--
ALTER TABLE `tbl_motos`
  MODIFY `id_moto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_permisos`
--
ALTER TABLE `tbl_permisos`
  MODIFY `id_permiso` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion permiso', AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_productos`
--
ALTER TABLE `tbl_productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion producto', AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `tbl_reparaciones`
--
ALTER TABLE `tbl_reparaciones`
  MODIFY `id_reparacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_roles`
--
ALTER TABLE `tbl_roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion rol', AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_tipos_accesorio`
--
ALTER TABLE `tbl_tipos_accesorio`
  MODIFY `id_tipo_accesorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_tipos_documento`
--
ALTER TABLE `tbl_tipos_documento`
  MODIFY `id_tipo_documento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_tipos_producto`
--
ALTER TABLE `tbl_tipos_producto`
  MODIFY `id_tipo_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_tipos_reparacion`
--
ALTER TABLE `tbl_tipos_reparacion`
  MODIFY `id_tipo_reparacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificacion servicio\n1 - Revision (cuando se va a vender, depende de como implementemos esa parte)\n2 - Reparacion\n3 - Mantenimiento (el - mec)\n4 - Modificacion', AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_tipos_transaccion`
--
ALTER TABLE `tbl_tipos_transaccion`
  MODIFY `id_tipo_transaccion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifica el tipo de producto', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_transacciones`
--
ALTER TABLE `tbl_transacciones`
  MODIFY `id_transaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_accesorios`
--
ALTER TABLE `tbl_accesorios`
  ADD CONSTRAINT `tbl_accesorios_ibfk_1` FOREIGN KEY (`producto`) REFERENCES `tbl_productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_accesorios_ibfk_2` FOREIGN KEY (`tipo_accesorio`) REFERENCES `tbl_tipos_accesorio` (`id_tipo_accesorio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_ciudades`
--
ALTER TABLE `tbl_ciudades`
  ADD CONSTRAINT `tbl_ciudades_ibfk_1` FOREIGN KEY (`departamento`) REFERENCES `tbl_departamentos` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_detalles_transaccion`
--
ALTER TABLE `tbl_detalles_transaccion`
  ADD CONSTRAINT `tbl_detalles_transaccion_ibfk_1` FOREIGN KEY (`producto`) REFERENCES `tbl_productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_detalles_transaccion_ibfk_2` FOREIGN KEY (`transaccion`) REFERENCES `tbl_transacciones` (`id_transaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_marcas`
--
ALTER TABLE `tbl_marcas`
  ADD CONSTRAINT `tbl_marcas_ibfk_1` FOREIGN KEY (`tipo_producto`) REFERENCES `tbl_tipos_producto` (`id_tipo_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_motos`
--
ALTER TABLE `tbl_motos`
  ADD CONSTRAINT `tbl_motos_ibfk_1` FOREIGN KEY (`producto`) REFERENCES `tbl_productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_motos_ibfk_2` FOREIGN KEY (`cliente`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_motos_ibfk_3` FOREIGN KEY (`estado_moto`) REFERENCES `tbl_estados_moto` (`id_estado_moto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_permisos`
--
ALTER TABLE `tbl_permisos`
  ADD CONSTRAINT `tbl_permisos_ibfk_1` FOREIGN KEY (`permiso_padre`) REFERENCES `tbl_permisos` (`id_permiso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_productos`
--
ALTER TABLE `tbl_productos`
  ADD CONSTRAINT `tbl_productos_ibfk_1` FOREIGN KEY (`marca`) REFERENCES `tbl_marcas` (`id_marca`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_reparaciones`
--
ALTER TABLE `tbl_reparaciones`
  ADD CONSTRAINT `tbl_reparaciones_ibfk_1` FOREIGN KEY (`moto`) REFERENCES `tbl_motos` (`id_moto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_reparaciones_ibfk_2` FOREIGN KEY (`mecanico`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_reparaciones_has_tbl_tipos_reparacion`
--
ALTER TABLE `tbl_reparaciones_has_tbl_tipos_reparacion`
  ADD CONSTRAINT `tbl_reparaciones_has_tbl_tipos_reparacion_ibfk_1` FOREIGN KEY (`reparacion`) REFERENCES `tbl_reparaciones` (`id_reparacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_reparaciones_has_tbl_tipos_reparacion_ibfk_2` FOREIGN KEY (`tipo_reparacion`) REFERENCES `tbl_tipos_reparacion` (`id_tipo_reparacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_roles_has_tbl_permisos`
--
ALTER TABLE `tbl_roles_has_tbl_permisos`
  ADD CONSTRAINT `tbl_roles_has_tbl_permisos_ibfk_1` FOREIGN KEY (`permiso`) REFERENCES `tbl_permisos` (`id_permiso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_roles_has_tbl_permisos_ibfk_2` FOREIGN KEY (`rol`) REFERENCES `tbl_roles` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_transacciones`
--
ALTER TABLE `tbl_transacciones`
  ADD CONSTRAINT `tbl_transacciones_ibfk_2` FOREIGN KEY (`tipo_transaccion`) REFERENCES `tbl_tipos_transaccion` (`id_tipo_transaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_transacciones_ibfk_3` FOREIGN KEY (`cliente`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD CONSTRAINT `tbl_usuarios_ibfk_1` FOREIGN KEY (`rol`) REFERENCES `tbl_roles` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_usuarios_ibfk_2` FOREIGN KEY (`tipo_documento`) REFERENCES `tbl_tipos_documento` (`id_tipo_documento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_usuarios_ibfk_3` FOREIGN KEY (`ciudad`) REFERENCES `tbl_ciudades` (`id_ciudad`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
