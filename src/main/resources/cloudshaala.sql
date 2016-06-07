-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2016 at 11:10 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cloudshaala`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `lecture_id` varchar(20) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `biomatric_attendance_mapping`
--

CREATE TABLE IF NOT EXISTS `biomatric_attendance_mapping` (
  `institution_id` varchar(20) DEFAULT NULL,
  `excel_column_int` int(11) NOT NULL,
  `cloushaala_table` varchar(20) NOT NULL,
  `cloudshaala_column_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `class_id` varchar(20) NOT NULL,
  `class_title` varchar(50) NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `class_teacher_id` varchar(20) DEFAULT NULL,
  `acadmic_session` varchar(10) DEFAULT NULL,
  `course_id` varchar(20) DEFAULT NULL,
  `section` int(11) DEFAULT NULL,
  `institution_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class_feedback_by_student`
--

CREATE TABLE IF NOT EXISTS `class_feedback_by_student` (
  `class_id` int(11) DEFAULT NULL,
  `student_id` varchar(20) DEFAULT NULL,
  `feedback_text` varchar(500) NOT NULL,
  `feedback_datetime` datetime NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class_subject_teaching`
--

CREATE TABLE IF NOT EXISTS `class_subject_teaching` (
  `teaching_id` varchar(20) NOT NULL,
  `class_id` varchar(20) NOT NULL,
  `subject_id` varchar(20) DEFAULT NULL,
  `start_datetime` datetime DEFAULT NULL,
  `end_datetime` datetime DEFAULT NULL,
  `class_start_timing` varchar(5) DEFAULT NULL,
  `class_end_timing` varchar(5) DEFAULT NULL,
  `subject_teacher_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class_teacher_history`
--

CREATE TABLE IF NOT EXISTS `class_teacher_history` (
  `class_id` int(11) NOT NULL,
  `teacher_id` varchar(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class_test`
--

CREATE TABLE IF NOT EXISTS `class_test` (
`test_id` int(11) NOT NULL,
  `class_subject_teaching_id` varchar(20) DEFAULT NULL,
  `title` varchar(20) NOT NULL,
  `datetime` datetime NOT NULL,
  `duration` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  `min` int(11) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `class_test_result`
--

CREATE TABLE IF NOT EXISTS `class_test_result` (
  `test_id` int(11) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `marks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `country_state_district`
--

CREATE TABLE IF NOT EXISTS `country_state_district` (
  `country_code` varchar(5) NOT NULL,
  `country_name` varchar(50) NOT NULL,
  `state_code` varchar(5) NOT NULL,
  `state_name` varchar(50) NOT NULL,
  `district_code` varchar(5) NOT NULL,
  `district_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country_state_district`
--

INSERT INTO `country_state_district` (`country_code`, `country_name`, `state_code`, `state_name`, `district_code`, `district_name`) VALUES
('in', 'india', 'mp', 'madhya pradesh', 'ind', 'indore'),
('in', 'india', 'mp', 'madhya pradesh', 'ujj', 'ujjain'),
('in', 'india', 'up', 'utter  pradesh', 'agr', 'agra'),
('in', 'india', 'up', 'utter  pradesh', 'luk', 'lucknow'),
('in', 'india', 'bh', 'bihar', 'pat', 'patna');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
`id` int(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `createdOn` datetime NOT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `institution` varchar(20) DEFAULT NULL,
  `syllabus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `title`, `createdOn`, `created_by`, `institution`, `syllabus`) VALUES
(1, 'Inter', '2016-05-22 09:52:13', '2', '1', 'Science'),
(2, 'Inter', '2016-05-22 09:54:41', '2', '1', 'Scienceqwq'),
(3, 'Inter', '2016-05-22 09:55:08', '2', '1', 'Science'),
(4, 'Inter', '2016-05-22 09:56:39', '2', '1', 'Scienceqwq'),
(5, 'Inter', '2016-05-22 10:52:54', '2', '1', 'Scienceqwq'),
(7, '10th', '2016-05-22 11:00:09', NULL, NULL, NULL),
(8, 'Class1', '2016-05-22 13:50:28', NULL, NULL, NULL),
(9, 'BSC', '2016-05-22 13:50:46', NULL, NULL, NULL),
(10, 'BCS', '2016-05-22 13:51:00', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
`doc_id` int(11) NOT NULL,
  `sender_id` varchar(20) DEFAULT NULL,
  `doc_type` int(11) DEFAULT NULL,
  `doc_title` varchar(50) NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `send_on` datetime DEFAULT NULL,
  `is_draft` tinyint(1) DEFAULT NULL,
  `extension` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `document_receiver_log`
--

CREATE TABLE IF NOT EXISTS `document_receiver_log` (
  `doc_id` int(11) DEFAULT NULL,
  `receiver_id` varchar(20) DEFAULT NULL,
  `seen_datetime_time` datetime DEFAULT NULL,
  `seen_platform` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `document_type`
--

CREATE TABLE IF NOT EXISTS `document_type` (
`doc_type_id` int(11) NOT NULL,
  `doc_type_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `entity_table`
--

CREATE TABLE IF NOT EXISTS `entity_table` (
`entity_id` int(11) NOT NULL,
  `entity_table` varchar(50) DEFAULT NULL,
  `entity_title` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `feedback_complain`
--

CREATE TABLE IF NOT EXISTS `feedback_complain` (
  `complain_reg_by` varchar(20) DEFAULT NULL,
  `complain_datetime` datetime NOT NULL,
  `content_text` varchar(500) NOT NULL,
  `institution_id` varchar(20) DEFAULT NULL,
  `refer_to` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `language_table`
--

CREATE TABLE IF NOT EXISTS `language_table` (
  `lang_iso_code` varchar(10) NOT NULL,
  `lang_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `language_table`
--

INSERT INTO `language_table` (`lang_iso_code`, `lang_name`) VALUES
('eng', 'english'),
('hin', 'hindi');

-- --------------------------------------------------------

--
-- Table structure for table `lecture`
--

CREATE TABLE IF NOT EXISTS `lecture` (
`lecture_id` int(11) NOT NULL,
  `class_subject_teaching_id` varchar(20) DEFAULT NULL,
  `topic` varchar(50) NOT NULL,
  `datetime_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
`msg_id` int(11) NOT NULL,
  `sender_id` varchar(20) DEFAULT NULL,
  `msg_type` varchar(10) NOT NULL,
  `msg_title` varchar(50) NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `send_on` datetime DEFAULT NULL,
  `is_draft` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `message_image`
--

CREATE TABLE IF NOT EXISTS `message_image` (
  `msg_id` int(11) DEFAULT NULL,
  `msg_path` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `message_receiver_log`
--

CREATE TABLE IF NOT EXISTS `message_receiver_log` (
  `msg_id` int(11) NOT NULL,
  `receiver_id` varchar(20) DEFAULT NULL,
  `seen_datetime_time` datetime DEFAULT NULL,
  `seen_platform` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `message_text`
--

CREATE TABLE IF NOT EXISTS `message_text` (
  `msg_id` int(11) DEFAULT NULL,
  `msg_txt` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `page_label_data`
--

CREATE TABLE IF NOT EXISTS `page_label_data` (
`page_id` int(11) NOT NULL,
  `page_url` varchar(100) NOT NULL,
  `page_title` varchar(50) NOT NULL,
  `page_platform` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `page_label_language_data`
--

CREATE TABLE IF NOT EXISTS `page_label_language_data` (
`label_id` int(11) NOT NULL,
  `label_title` varchar(50) NOT NULL,
  `lang_id` varchar(20) DEFAULT NULL,
  `page_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE IF NOT EXISTS `parent` (
  `parent_id` varchar(20) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`parent_id`, `is_active`, `created_by`, `user_id`, `created_on`) VALUES
('', 1, NULL, '1457578394399', '2016-03-10 08:23:07');

-- --------------------------------------------------------

--
-- Table structure for table `postdateed_notifications`
--

CREATE TABLE IF NOT EXISTS `postdateed_notifications` (
  `msg_id` int(11) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` tinyint(2) NOT NULL,
  `role_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'teacher'),
(2, 'student'),
(3, 'parent'),
(4, 'institution'),
(5, 'institution sub admin');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` varchar(20) NOT NULL,
  `created_on` datetime NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `updatetime_remark` varchar(50) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_classes`
--

CREATE TABLE IF NOT EXISTS `student_classes` (
  `class_id` int(11) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `join_datetime` datetime NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_parent`
--

CREATE TABLE IF NOT EXISTS `student_parent` (
  `student_id` varchar(20) NOT NULL,
  `parent_id` varchar(20) NOT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `subject_id` varchar(20) NOT NULL,
  `subject_title` varchar(50) NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `course_id` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject_teacher`
--

CREATE TABLE IF NOT EXISTS `subject_teacher` (
`subject_teacher_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `teacher_id` varchar(20) DEFAULT NULL,
  `subject_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` varchar(20) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `created_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `university_board_course`
--

CREATE TABLE IF NOT EXISTS `university_board_course` (
  `ubm_id` varchar(20) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `course_duration_type` varchar(10) DEFAULT NULL,
  `duration_month` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `university_board_master`
--

CREATE TABLE IF NOT EXISTS `university_board_master` (
  `ubm_id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `country_code` varchar(5) NOT NULL,
  `state_code` varchar(5) NOT NULL,
  `district_code` varchar(5) NOT NULL,
  `city_village` varchar(50) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `university_board_master`
--

INSERT INTO `university_board_master` (`ubm_id`, `name`, `country_code`, `state_code`, `district_code`, `city_village`, `contact`, `type`) VALUES
('ub1', 'Vikram', 'in', 'mp', 'ind', 'indore', '9856987485', 'college'),
('ub2', 'SSI', 'in', 'mp', 'ind', 'indore', '8886987485', 'school');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL,
  `password` varchar(12) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `country_code` varchar(5) DEFAULT NULL,
  `state_code` varchar(5) DEFAULT NULL,
  `district_code` varchar(5) DEFAULT NULL,
  `city_village` varchar(50) DEFAULT NULL,
  `street_address` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `landline` varchar(15) DEFAULT NULL,
  `mobile` varchar(15) NOT NULL,
  `loc_latitude` varchar(12) DEFAULT NULL,
  `loc_longitude` varchar(12) DEFAULT NULL,
  `registered_by_user` varchar(30) DEFAULT NULL,
  `registration_platform` varchar(15) NOT NULL,
  `community_login_by` varchar(10) DEFAULT NULL,
  `community_id` varchar(50) DEFAULT NULL,
  `profile_pic` varchar(100) DEFAULT NULL,
  `secondary_lang_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `firstname`, `lastname`, `gender`, `country_code`, `state_code`, `district_code`, `city_village`, `street_address`, `email`, `landline`, `mobile`, `loc_latitude`, `loc_longitude`, `registered_by_user`, `registration_platform`, `community_login_by`, `community_id`, `profile_pic`, `secondary_lang_code`) VALUES
('1457491850872', '852598', 'sourabbh', 'panchaal', NULL, NULL, NULL, NULL, NULL, NULL, 'sourcabhp@gmail.com', NULL, '7889232356', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('1457577885590', '880470', 'somanshu', 'vijay', NULL, NULL, NULL, NULL, NULL, NULL, 'somanshu@gmail.com', NULL, '222211122', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('1457578157570', '152299', 's1', 'v1', NULL, NULL, NULL, NULL, NULL, NULL, 's1@gmail.com', NULL, '12341234', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('1457578394399', '387108', 's2', 'v2', NULL, NULL, NULL, NULL, NULL, NULL, 's2@gmail.com', NULL, '12341235', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('1460041466348', '467151', 'hello123', '222', NULL, NULL, NULL, NULL, NULL, NULL, 'hello123@gmail.com', NULL, '888686', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('1460475039135', '47833', 's5', 'v5', NULL, NULL, NULL, NULL, NULL, NULL, 's3@gmail.com', NULL, '1234541235', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('1463892029840', '20511', 'nishant', 'vaidya', NULL, NULL, NULL, NULL, NULL, NULL, 'nishant@abc.com', NULL, '99999999', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('cuid123456', '112233', 'aman', 'jha', 'm', NULL, NULL, NULL, NULL, NULL, 'amanajha@gmail.com', NULL, '9922331212', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('cuid1457490482341496935432', '82341', 'aniket', 'gupta', NULL, NULL, NULL, NULL, NULL, NULL, 'aniket@gmail.com', NULL, '99342334', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL),
('cuid223344', '112233', 'mohit', 'sharma', 'm', NULL, NULL, NULL, NULL, NULL, 'mohits@gmail.com', NULL, '8899889981', NULL, NULL, NULL, 'android', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` varchar(20) NOT NULL,
  `role_id` tinyint(2) NOT NULL,
  `role_join_date` datetime DEFAULT NULL,
  `role_added_by` varchar(20) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`, `role_join_date`, `role_added_by`, `is_active`) VALUES
('1457577885590', 2, '2016-03-10 08:14:40', NULL, 0),
('1457578157570', 2, '2016-03-10 08:19:12', NULL, 0),
('1457578394399', 2, '2016-03-10 08:23:07', NULL, 0),
('1460041466348', 2, '2016-04-07 20:34:27', NULL, 0),
('1460475039135', 2, '2016-04-12 21:00:48', NULL, 0),
('1463892029840', 2, '2016-05-22 10:10:20', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
 ADD PRIMARY KEY (`lecture_id`,`student_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
 ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `class_teacher_history`
--
ALTER TABLE `class_teacher_history`
 ADD PRIMARY KEY (`class_id`,`teacher_id`);

--
-- Indexes for table `class_test`
--
ALTER TABLE `class_test`
 ADD PRIMARY KEY (`test_id`);

--
-- Indexes for table `class_test_result`
--
ALTER TABLE `class_test_result`
 ADD PRIMARY KEY (`test_id`,`student_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `document`
--
ALTER TABLE `document`
 ADD PRIMARY KEY (`doc_id`);

--
-- Indexes for table `document_type`
--
ALTER TABLE `document_type`
 ADD PRIMARY KEY (`doc_type_id`);

--
-- Indexes for table `entity_table`
--
ALTER TABLE `entity_table`
 ADD PRIMARY KEY (`entity_id`);

--
-- Indexes for table `language_table`
--
ALTER TABLE `language_table`
 ADD PRIMARY KEY (`lang_iso_code`);

--
-- Indexes for table `lecture`
--
ALTER TABLE `lecture`
 ADD PRIMARY KEY (`lecture_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
 ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `page_label_data`
--
ALTER TABLE `page_label_data`
 ADD PRIMARY KEY (`page_id`);

--
-- Indexes for table `page_label_language_data`
--
ALTER TABLE `page_label_language_data`
 ADD PRIMARY KEY (`label_id`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
 ADD PRIMARY KEY (`parent_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
 ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `student_classes`
--
ALTER TABLE `student_classes`
 ADD PRIMARY KEY (`class_id`,`student_id`);

--
-- Indexes for table `student_parent`
--
ALTER TABLE `student_parent`
 ADD PRIMARY KEY (`student_id`,`parent_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
 ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `subject_teacher`
--
ALTER TABLE `subject_teacher`
 ADD PRIMARY KEY (`subject_teacher_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
 ADD PRIMARY KEY (`teacher_id`);

--
-- Indexes for table `university_board_course`
--
ALTER TABLE `university_board_course`
 ADD PRIMARY KEY (`ubm_id`,`course_id`);

--
-- Indexes for table `university_board_master`
--
ALTER TABLE `university_board_master`
 ADD PRIMARY KEY (`ubm_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`user_id`), ADD UNIQUE KEY `mobile` (`mobile`), ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
 ADD PRIMARY KEY (`user_id`,`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class_test`
--
ALTER TABLE `class_test`
MODIFY `test_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
MODIFY `doc_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `document_type`
--
ALTER TABLE `document_type`
MODIFY `doc_type_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `entity_table`
--
ALTER TABLE `entity_table`
MODIFY `entity_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lecture`
--
ALTER TABLE `lecture`
MODIFY `lecture_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
MODIFY `msg_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `page_label_data`
--
ALTER TABLE `page_label_data`
MODIFY `page_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `page_label_language_data`
--
ALTER TABLE `page_label_language_data`
MODIFY `label_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subject_teacher`
--
ALTER TABLE `subject_teacher`
MODIFY `subject_teacher_id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `class` 
CHANGE COLUMN `created_on` `created_on` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP ;
ALTER TABLE `teacher` 
CHANGE COLUMN `teacher_id` `id` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `is_active` `active` TINYINT(1) NOT NULL ,
CHANGE COLUMN `created_on` `created_on` TIMESTAMP NOT NULL ;
ALTER TABLE `class` 
CHANGE COLUMN `class_title` `title` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `is_active` `active` TINYINT(1) NOT NULL ;

ALTER TABLE  `class` 
CHANGE COLUMN `class_id` `id` VARCHAR(20) NOT NULL ;
ALTER TABLE  `user` 
CHANGE COLUMN `firstname` `first_name` VARCHAR(30) NOT NULL ,
CHANGE COLUMN `lastname` `last_name` VARCHAR(30) NULL DEFAULT NULL ;
ALTER TABLE `teacher` 
CHANGE COLUMN `id` `id` INT(20) NOT NULL AUTO_INCREMENT ;
ALTER TABLE `class` 
CHANGE COLUMN `id` `id` INT(20) NOT NULL AUTO_INCREMENT ;
ALTER TABLE  `subject` 
CHANGE COLUMN `subject_id` `id` INT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `subject_title` `title` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `created_on` `created_on` TIMESTAMP NOT NULL ;
ALTER TABLE  `subject` 
ADD COLUMN `active` TINYINT(1) NULL AFTER `description`;
ALTER TABLE  `subject_teacher` 
CHANGE COLUMN `subject_teacher_id` `subject_teacher_id` INT(20) NOT NULL ,
CHANGE COLUMN `class_id` `class_id` INT(20) NULL DEFAULT NULL ,
CHANGE COLUMN `teacher_id` `teacher_id` INT(20) NULL DEFAULT NULL ,
CHANGE COLUMN `subject_id` `subject_id` INT(20) NULL ;
ALTER TABLE `subject_teacher` 
CHANGE COLUMN `subject_teacher_id` `subject_teacher_id` INT(20) NOT NULL;
ALTER TABLE  `student_classes` 
CHANGE COLUMN `class_id` `class_id` INT(20) NOT NULL ,
CHANGE COLUMN `student_id` `student_id` INT(20) NOT NULL ,
CHANGE COLUMN `is_active` `active` TINYINT(1) NOT NULL ,
ADD COLUMN `id` INT(20) NULL AFTER `active`,
ADD COLUMN `student_classescol` VARCHAR(45) NULL AFTER `id`;
ALTER TABLE `subject_teacher` 
CHANGE COLUMN `subject_teacher_id` `id` INT(20) NOT NULL AUTO_INCREMENT ;
ALTER TABLE `student` 
CHANGE COLUMN `created_on` `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ;
ALTER TABLE `student` 
CHANGE COLUMN `is_active` `active` TINYINT(1) NOT NULL ;
ALTER TABLE `student` 
CHANGE COLUMN `student_id` `student_id` INT(20) NOT NULL AUTO_INCREMENT ;
ALTER TABLE `student_classes` 
CHANGE COLUMN `join_datetime` `join_datetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `active` `active` TINYINT(1) NOT NULL DEFAULT 1 ;







/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
