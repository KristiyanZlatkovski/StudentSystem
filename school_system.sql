-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Време на генериране: 17 ное 2021 в 01:35
-- Версия на сървъра: 8.0.21
-- Версия на PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данни: `school_system`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `enlisted_students_per_subject`
-- (See below for the actual view)
--
CREATE TABLE `enlisted_students_per_subject` (
`enlisted_students` bigint
,`subject_name` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура на таблица `student`
--

CREATE TABLE `student` (
  `id` bigint NOT NULL,
  `course` tinyint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `student`
--

INSERT INTO `student` (`id`, `course`, `name`) VALUES
(1, 1, 'Sheri Stevens'),
(2, 2, 'Kathryn Meyer'),
(3, 4, 'Angelo Mullins'),
(4, 1, 'Alma Stokes'),
(5, 3, 'Lola Swanson'),
(6, 3, 'Bert Boyd'),
(7, 1, 'Ignacio Baker'),
(8, 3, 'Travis Bowen'),
(9, 4, 'Jean Elliott'),
(10, 3, 'David Hayes');

-- --------------------------------------------------------

--
-- Stand-in structure for view `students_and_credits`
-- (See below for the actual view)
--
CREATE TABLE `students_and_credits` (
`name` varchar(255)
,`total_credits` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `student_and_course`
-- (See below for the actual view)
--
CREATE TABLE `student_and_course` (
`name` varchar(255)
,`year_in_college` tinyint
);

-- --------------------------------------------------------

--
-- Структура на таблица `subjects`
--

CREATE TABLE `subjects` (
  `id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `credits` int NOT NULL,
  `teacher_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `subjects`
--

INSERT INTO `subjects` (`id`, `name`, `credits`, `teacher_id`) VALUES
(1, 'Mathematics', 3, 1),
(2, 'Data management', 7, 4),
(3, 'Software Engineering II', 5, 1),
(4, ' Analysis of Algorithms', 2, 2),
(5, 'Database Systems', 5, 3),
(6, 'Artificial Intelligence', 2, 4),
(7, 'Computer Simulations', 3, 5),
(8, ' Data Structures', 2, 6),
(9, 'Software Engineering I ', 1, 7);

-- --------------------------------------------------------

--
-- Структура на таблица `subjects_students`
--

CREATE TABLE `subjects_students` (
  `subjects_id` bigint NOT NULL,
  `students_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `subjects_students`
--

INSERT INTO `subjects_students` (`subjects_id`, `students_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(6, 1),
(7, 1),
(2, 2),
(3, 2),
(6, 2),
(1, 3),
(2, 3),
(3, 3),
(1, 4),
(2, 4),
(5, 4),
(2, 5),
(4, 5),
(8, 5),
(4, 6),
(6, 6),
(8, 6),
(7, 7),
(8, 7),
(9, 7),
(2, 8),
(3, 8),
(4, 8),
(6, 8),
(8, 8),
(1, 9),
(3, 9),
(5, 9),
(9, 9),
(1, 10),
(4, 10),
(7, 10),
(8, 10);

-- --------------------------------------------------------

--
-- Структура на таблица `teacher`
--

CREATE TABLE `teacher` (
  `id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `title`) VALUES
(1, 'Beth Williams', 'Professor'),
(2, 'Douglas White', 'Professor'),
(3, 'Lana Norris', 'Associate Professor'),
(4, 'Alexandra Sandoval', 'Associate Professor'),
(5, 'Sabrina Blair', 'Chief Assistant'),
(6, 'Elaine Freeman', 'Assistant'),
(7, 'Desiree Fernandez', 'Assistant');

-- --------------------------------------------------------

--
-- Stand-in structure for view `teachers_ranking_by_students_count`
-- (See below for the actual view)
--
CREATE TABLE `teachers_ranking_by_students_count` (
`name` varchar(255)
,`total_students` bigint
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `teacher_subjects_count`
-- (See below for the actual view)
--
CREATE TABLE `teacher_subjects_count` (
`name` varchar(255)
,`subjects_count` bigint
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `teacher_subject_enlisted_count`
-- (See below for the actual view)
--
CREATE TABLE `teacher_subject_enlisted_count` (
`enlisted_students_count` bigint
,`subject_name` varchar(255)
,`teacher_name` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура на изгледа `enlisted_students_per_subject`
--
DROP TABLE IF EXISTS `enlisted_students_per_subject`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `enlisted_students_per_subject`  AS SELECT `subjects`.`name` AS `subject_name`, count(`subjects_students`.`subjects_id`) AS `enlisted_students` FROM (`subjects` join `subjects_students` on((`subjects_students`.`subjects_id` = `subjects`.`id`))) GROUP BY `subjects`.`name` ORDER BY `enlisted_students` DESC LIMIT 0, 3 ;

-- --------------------------------------------------------

--
-- Структура на изгледа `students_and_credits`
--
DROP TABLE IF EXISTS `students_and_credits`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `students_and_credits`  AS SELECT `student`.`name` AS `name`, sum(`subjects`.`credits`) AS `total_credits` FROM ((`subjects_students` join `subjects` on((`subjects`.`id` = `subjects_students`.`subjects_id`))) join `student` on((`student`.`id` = `subjects_students`.`students_id`))) GROUP BY `subjects_students`.`students_id` ORDER BY `student`.`name` ASC ;

-- --------------------------------------------------------

--
-- Структура на изгледа `student_and_course`
--
DROP TABLE IF EXISTS `student_and_course`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_and_course`  AS SELECT `student`.`name` AS `name`, `student`.`course` AS `year_in_college` FROM `student` ORDER BY `student`.`name` ASC ;

-- --------------------------------------------------------

--
-- Структура на изгледа `teachers_ranking_by_students_count`
--
DROP TABLE IF EXISTS `teachers_ranking_by_students_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teachers_ranking_by_students_count`  AS SELECT `teacher`.`name` AS `name`, count(`subjects_students`.`subjects_id`) AS `total_students` FROM ((`subjects` join `teacher` on((`teacher`.`id` = `subjects`.`teacher_id`))) join `subjects_students` on((`subjects_students`.`subjects_id` = `subjects`.`id`))) GROUP BY `teacher`.`name` ORDER BY `total_students` DESC LIMIT 0, 3 ;

-- --------------------------------------------------------

--
-- Структура на изгледа `teacher_subjects_count`
--
DROP TABLE IF EXISTS `teacher_subjects_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_subjects_count`  AS SELECT `teacher`.`name` AS `name`, count(`subjects`.`teacher_id`) AS `subjects_count` FROM (`teacher` join `subjects` on((`teacher`.`id` = `subjects`.`teacher_id`))) GROUP BY `teacher`.`name` ORDER BY `teacher`.`name` ASC ;

-- --------------------------------------------------------

--
-- Структура на изгледа `teacher_subject_enlisted_count`
--
DROP TABLE IF EXISTS `teacher_subject_enlisted_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_subject_enlisted_count`  AS SELECT `teacher`.`name` AS `teacher_name`, `subjects`.`name` AS `subject_name`, count(`subjects_students`.`subjects_id`) AS `enlisted_students_count` FROM ((`subjects` join `teacher` on((`teacher`.`id` = `subjects`.`teacher_id`))) join `subjects_students` on((`subjects`.`id` = `subjects_students`.`subjects_id`))) GROUP BY `subjects`.`name` ORDER BY `teacher_name` ASC ;

--
-- Indexes for dumped tables
--

--
-- Индекси за таблица `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Индекси за таблица `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3csfetmomyye6tk45s4vb1e7v` (`teacher_id`);

--
-- Индекси за таблица `subjects_students`
--
ALTER TABLE `subjects_students`
  ADD PRIMARY KEY (`subjects_id`,`students_id`),
  ADD KEY `FKjehm7br3b13p5wq58wu0162b5` (`students_id`);

--
-- Индекси за таблица `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ограничения за дъмпнати таблици
--

--
-- Ограничения за таблица `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `FK3csfetmomyye6tk45s4vb1e7v` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);

--
-- Ограничения за таблица `subjects_students`
--
ALTER TABLE `subjects_students`
  ADD CONSTRAINT `FKjehm7br3b13p5wq58wu0162b5` FOREIGN KEY (`students_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `FKo6o92edk4tc3j4y16kb61lljg` FOREIGN KEY (`subjects_id`) REFERENCES `subjects` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
