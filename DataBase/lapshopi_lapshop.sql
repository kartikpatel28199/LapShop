-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 25, 2018 at 07:46 AM
-- Server version: 5.6.40-84.0-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lapshopi_lapshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `credit_debit_card`
--

CREATE TABLE `credit_debit_card` (
  `cdid` int(11) NOT NULL,
  `cemail` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `card_number` int(11) NOT NULL,
  `expiry_date` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `card_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `card_label` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `credit_debit_card`
--

INSERT INTO `credit_debit_card` (`cdid`, `cemail`, `card_number`, `expiry_date`, `card_name`, `card_label`) VALUES
(8, 'niku76@gmail.com', 1234567890, '07 2018', '1234567890', 'Bob'),
(9, 'nikunjramani76@gmail.com', 1234567890, '07 2023', '1234567890', 'asdfghjk'),
(10, '', 0, '', '', ''),
(11, 'kartikpatel281@gmail.com', 2147483647, '06 2024', '673636363636263 ', 'bob'),
(12, 'nikunjramani7624@gmail.com', 2147483647, '07 2023', '4444444444446', 'bob');

-- --------------------------------------------------------

--
-- Table structure for table `customer_singup`
--

CREATE TABLE `customer_singup` (
  `cid` int(11) NOT NULL,
  `firstname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `mobileno` decimal(10,0) NOT NULL,
  `datetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer_singup`
--

INSERT INTO `customer_singup` (`cid`, `firstname`, `lastname`, `gender`, `email`, `password`, `mobileno`, `datetime`) VALUES
(29, 'kartik', 'patel', 'Male', 'kartikpatel281@gmail.com', 'kartik@123', '9409312098', '2018-04-16 11:26:59'),
(31, 'Nikunj', 'Ramani', 'Male', 'nikunjramani7624@gmail.com', 'nikunj@7624', '7984356582', '2018-04-16 11:52:57');

-- --------------------------------------------------------

--
-- Table structure for table `forgot_password`
--

CREATE TABLE `forgot_password` (
  `fid` int(11) NOT NULL,
  `mobileno` varchar(150) NOT NULL,
  `otp` int(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forgot_password`
--

INSERT INTO `forgot_password` (`fid`, `mobileno`, `otp`) VALUES
(1, '0', 0),
(2, '', 0),
(3, '7624069124', 843848),
(4, '7624069124', 268314),
(5, '0', 943492),
(6, '0', 188710),
(7, '0', 586089),
(8, '0', 685720),
(9, '0', 768359),
(10, '0', 651444),
(11, '7624069124', 688400),
(12, '7624069124', 418313),
(13, '7624069124', 761594),
(14, '7016096843', 716681),
(15, '7016096843', 161230),
(16, '7984356582', 986986),
(17, '7984356582', 264608),
(18, '7984356582', 406334),
(19, '7984356582', 530555),
(20, '7984356582', 434352),
(21, '7016096843', 868800),
(22, '7984356582', 775901),
(23, '7984356582', 492229),
(24, '7984356582', 517668),
(25, '7984356582', 0),
(26, '7984356582', 921408),
(27, '7984356582', 340665),
(28, '7984356582', 745821),
(29, '7984356582', 327143),
(30, '7984356582', 709507),
(31, '7984356582', 890893);

-- --------------------------------------------------------

--
-- Table structure for table `giftcard`
--

CREATE TABLE `giftcard` (
  `gcid` int(11) NOT NULL,
  `cemail` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gift_card_number` int(11) NOT NULL,
  `gift_card_pincode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `giftcard`
--

INSERT INTO `giftcard` (`gcid`, `cemail`, `gift_card_number`, `gift_card_pincode`) VALUES
(1, '', 0, 0),
(2, 'ss', 0, 0),
(3, '', 54545, 42),
(4, '', 0, 0),
(5, 'nik@gmail.com', 0, 0),
(6, 'nik@gmail.com', 0, 0),
(7, 'nik@gmail.com', 0, 0),
(8, 'nik@gmail.com', 0, 0),
(9, 'nik@gmail.com', 0, 0),
(10, 'nik@gmail.com', 0, 0),
(11, 'nik@gmail.com', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `lapshop_specification`
--

CREATE TABLE `lapshop_specification` (
  `sid` int(11) NOT NULL,
  `seller_email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `datetime` datetime NOT NULL,
  `laptop_type` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_title` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_brand` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_modelname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_modelno` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_shortdesc` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_price` int(250) NOT NULL,
  `laptop_color` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `battary_backup` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `processor_brand` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `processor_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `processor_generation` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ssd` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ram` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ram_type` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `hdd_capacity` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `processor_variant` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `clock_speed` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `cache` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `graphics_processor` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `operating_system` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mic_in` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `touch_screen` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `screen_size` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `screen_resolution` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `screen_type` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `speakers` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `internal_mic` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `sound_properties` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `wireless_lan` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `bluetooth` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ethernet` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `disk_drive` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `web_camera` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `read_write_speed` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `keybord` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `pointer_device` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `battery` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `battery_type` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `warranty_summary` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `warranty_service_type` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `covered_in_warranty` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `not_covered_in_warranty` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `domestic_warranty` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `image_1` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `image_2` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `image_3` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `image_4` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `image_5` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lapshop_specification`
--

INSERT INTO `lapshop_specification` (`sid`, `seller_email`, `datetime`, `laptop_type`, `laptop_title`, `laptop_brand`, `laptop_modelname`, `laptop_modelno`, `laptop_shortdesc`, `laptop_price`, `laptop_color`, `battary_backup`, `processor_brand`, `processor_name`, `processor_generation`, `ssd`, `ram`, `ram_type`, `hdd_capacity`, `processor_variant`, `clock_speed`, `cache`, `graphics_processor`, `operating_system`, `mic_in`, `touch_screen`, `screen_size`, `screen_resolution`, `screen_type`, `speakers`, `internal_mic`, `sound_properties`, `wireless_lan`, `bluetooth`, `ethernet`, `disk_drive`, `web_camera`, `read_write_speed`, `keybord`, `pointer_device`, `battery`, `battery_type`, `warranty_summary`, `warranty_service_type`, `covered_in_warranty`, `not_covered_in_warranty`, `domestic_warranty`, `image_1`, `image_2`, `image_3`, `image_4`, `image_5`) VALUES
(92, 'nikunj76@gmail.com', '0000-00-00 00:00:00', 'notebook', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'Acer', 'aspire', 'e15', '8Gb Ram,1Tb Harddisk', 50000, 'black', '5 hour', 'intel', 'core i5', '7th', '100gb', '8gb', 'ddr4', '1tb', 'intel', '2gh', '2mb', 'AMD', 'Windows 10', 'on', 'yes', '15.7 inch', '1440 x 2560', 'touch', 'yes', 'yes', 'Dolby', 'yes', 'yes', 'yes', 'yes', 'yes', '4mbps', 'on', 'on', '35000mh', 'simple', '1 year', '', '', '', '', 'http://lapshop.in.net/seller/add_laptop/image/92_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/92_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/92_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/92_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/92_5.jpeg'),
(93, 'nikunj76@gmail.com', '0000-00-00 00:00:00', 'notebook', 'dell CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'Dell', 'aspire', 'e15', '8Gb Ram,1Tb Harddisk', 50000, 'black', '5 hour', 'intel', 'core i5', '7th', '100gb', '8gb', 'ddr4', '1tb', 'intel', '2gh', '2mb', 'AMD', 'Windows 10', 'on', 'yes', '15.7 inch', '1440 x 2560', 'touch', 'yes', 'yes', 'Dolby', 'yes', 'yes', 'yes', 'yes', 'yes', '4mbps', 'on', 'on', '35000mh', 'simple', '1 year', '', '', '', '', 'http://lapshop.in.net/seller/add_laptop/image/93_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/93_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/93_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/93_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/93_5.jpg'),
(94, 'nikunj76@gmail.com', '0000-00-00 00:00:00', 'notebook', 'HP CORE I7 7TH GEN 16GB RAM 2TB HARDDISK,4GB GRAPHICS', 'Hp', 'hp', 'e15', '16Gb Ram,2Tb Harddisk', 70000, 'black', '5 hour', 'intel', 'core i5', '7th', '100gb', '16gb', 'ddr4', '2tb', 'intel', '2gh', '2mb', 'AMD', 'Windows 10', 'on', 'yes', '15.7 inch', '1440 x 2560', 'touch', 'yes', 'yes', 'Dolby', 'yes', 'yes', 'yes', 'yes', 'yes', '4mbps', 'on', 'on', '35000mh', 'simple', '1 year', '', '', '', '', 'http://lapshop.in.net/seller/add_laptop/image/94_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/94_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/94_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/94_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/94_5.jpeg'),
(95, 'nikunj76@gmail.com', '0000-00-00 00:00:00', 'notebook', 'LENOVO CORE I7 7TH GEN 16GB RAM 2TB HARDDISK,4GB GRAPHICS', 'Lenovo', 'hp', 'e15', '16Gb Ram,2Tb Harddisk', 80000, 'black', '5 hour', 'intel', 'core i5', '7th', '100gb', '16gb', 'ddr4', '2tb', 'intel', '2gh', '2mb', 'AMD', 'Windows 10', 'on', 'yes', '15.7 inch', '1440 x 2560', 'touch', 'yes', 'yes', 'Dolby', 'yes', 'yes', 'yes', 'yes', 'yes', '4mbps', 'on', 'on', '35000mh', 'simple', '1 year', '', '', '', '', 'http://lapshop.in.net/seller/add_laptop/image/95_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/95_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/95_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/95_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/95_5.jpeg'),
(103, 'nikunj76@gmail.com', '2018-04-14 07:16:44', 'Gaming', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Laptop  (18.4 inch, Black, 5.5 kg)', 'MSI', 'MSI', ' GT83 8RG-007IN', '18.4 inch, Black, 5.5 kg', 350000, 'Black', '10 Hour', 'Intel', 'Core i9', '8th', '512GB', '32GB', 'DDR4', '1TB', ' 8850H', '2.6 GHz with Turbo Boost Upto ', '10mb', 'AMD', 'Window 10', 'yes', 'Yes', '18.4 inch', '2160 x 3840', 'Full HD LED Backlit ', ' Built-in Quad Speak', 'Built-in Microphone', '4 x 3 W Speakers, So', 'IEEE 802.11ac', ' v5.0', ' Killer LAN', 'CD/DVD writer', 'Full HD Webcam', ' 8x', 'yes', 'on', 'Lion', 'Internal', ' 2 Years Carry In Warranty', 'Carry In', 'Manufacturing Defects, Part Failure', ' Physical Damage, Burn, Liquid Spill', '2 Year', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/96_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/96_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/96_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/96_5.jpeg'),
(104, 'nikunj76@gmail.com', '2018-04-14 07:17:50', 'Gaming Laptop', 'Acer Nitro 5 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home/2 GB Graphics) AN515-51 Gaming Laptop  (15.6 inch, Black, 2.7 kg)', 'Acer', ' Nitro 5', ' AN515-51', '8 GB RAM, 1 TB Hard Disk', 57000, ' Black', ' Upto 7 hours', ' Intel', ' Core i5', ' 7th Gen', ' No', ' 8 GB', ' DDR4', ' 1 TB', ' 7300HQ', '2.5 GHz with Turbo Boost Upto ', ' 6 MB', '', 'Windows 10 Home', 'on', 'No', '15.6 inch', '1080 x 1920', 'Full HD LED Backlit ', 'Built-in Dual Speake', 'Built-in Dual Digita', 'Stereo Speakers, Ace', 'IEEE 802.11a/b/g/n/ac', 'v4.0', '10/100/1000 Mbps', 'Not Available', 'HD Webcam', ' 8x', 'on', 'on', '3220 mAh ', 'Li-ion Battery', '1 Year International Travelers Warranty (ITW)', 'Onsite', 'Manufacturing Defects', 'Physical Damage', ' 1 Year', 'http://lapshop.in.net/seller/add_laptop/image/104_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/104_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/104_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/104_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/104_5.jpeg'),
(105, 'nikunj76@gmail.com', '2018-04-14 07:35:18', 'Laptop', 'Acer Core i5 7th Gen - (8 GB/1 TB HDD/Linux) E5 - 575 Laptop  (15.6 inch, Black)', 'Acer', 'Aspire', 'E5 - 575', '8 GB/1 TB HDD', 35990, 'Black', 'Upto 5 hours', 'Upto 5 hours', 'Core i5', '7th Gen', 'No', ' 8 GB', 'DDR4', '1 TB', '7200U', '2.5 GHz with Turbo Boost Upto ', '3 MB', ' Intel Integrated HD', 'Linux', 'on', 'No', '15.6 inch', '768 x 1366', 'HD LED Backlit Displ', 'Yes', 'Yes', ' Acer Harmony Sound', 'IEEE 802.11ac', ' v4.1', '10/100/1000 Mbps', 'CD/DVD writer', 'Acer Crystal Eye Web', '8x', 'on', 'on', '3400 mah', 'Li-ion Battery', '1 Year Onsite Warranty', 'Onsite', 'Manufacturing Defects', 'Warranty does not cover any physical damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/105_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/105_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/105_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/105_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/105_5.jpeg'),
(106, 'nikunj76@gmail.com', '2018-04-14 07:45:36', 'Laptop', 'Acer Swift 3 Ryzen 5 Quad Core - (8 GB/1 TB HDD/Linux) SF315-41 Laptop  (15.6 inch, STeel Grey, 2.1 kg)', 'Acer', 'Swift 3', 'SF315-41', '8 GB/1 TB HDD', 48490, 'STeel Grey', ' Upto 8 hours', 'AMD', 'Ryzen 5 Quad Core', '', 'No', '8 GB', 'DDR4', '1 TB', ' 2500U', '2 GHz with Turbo Boost Upto 3.', ' 4 MB', ' AMD Radeon Vega 8', 'Linux', 'on', 'No', '15.6 inch', '1080 x 1920', 'Full HD LED Backlit ', ' Built-in Dual Speak', 'Built-in Dual Microp', ' Stereo Speakers, Ac', ' IEEE 802.11a/b/g/n/ac', ' v4.1', '', 'Not Available', ' HD Webcam', '4x', 'on', 'on', '3220 mAh', 'Li-ion Battery', '1 Year International Travelers Warranty (ITW)', 'Onsite', 'Manufacturing Defects', 'Physical Damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/106_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/106_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/106_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/106_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/106_5.jpeg'),
(107, 'nikunj76@gmail.com', '2018-04-14 07:55:13', ' Gaming Laptop', 'Acer Predator Helios 300 Core i7 7th Gen - (16 GB/2 TB HDD/256 GB SSD/Windows 10 Home/6 GB Graphics) G3-572 Gaming Laptop  (15.6 inch, Black, 2.7 kg)', 'Acer', 'Predator Helios 300', ' G3-572', '16 GB/2 TB HDD', 120990, 'Black', ' Upto 6 hours', 'Intel', 'Core i7', '7th Gen', 'Yes', '16 GB', 'DDR4', ' 2 TB', '7700HQ', '2.8 GHz with Turbo Boost Upto ', '6 MB', 'NVIDIA Geforce GTX 1060', ' Windows 10 Home', 'on', 'No', '15.6 inch', '1080 x 1920', ' Full HD LED Backlit', ' Built-in Dual Speak', 'Built-in Dual Digita', 'Stereo Speakers, Ace', ' IEEE 802.11a/b/g/n/ac', 'v4.0', 'Gigabit Ethernet, Wake-on-LAN ', 'Not Available', 'HD Webcam', '8x', 'on', 'on', '3500 mah', '4 cell', ' 1 Year Manufacturer Warranty', 'Onsite', ' Manufacturing Defects', ' Physical Damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/107_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/107_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/107_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/107_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/107_5.jpeg'),
(109, 'nikunj76@gmail.com', '2018-04-15 15:53:52', 'Laptop', 'Dell Inspiron Core i3 6th Gen - (4 GB/1 TB HDD/Linux) 3467 Laptop  (14 inch, Black, 1.956 kg)', 'Dell', 'Inspiron', ' Inspiron 3467', '4 GB/1 TB HDD', 25990, 'Black', 'Upto 5 hours', 'Intel', ' Core i3', '6th Gen', 'No', '4 GB', 'DDR4', '1 TB', '6006U', ' 2 GHz', ' 3 MB', 'Intel Integrated HD 520', 'Linux', 'yes', 'No', '14 inch', '768 x 1366', 'HD LED Backlit Anti-', 'Dual Speakers', ' Single Digital Micr', '2 x Tuned Speakers w', 'IEEE 802.11ac', 'v4.1', '10/100 Mbps', 'CD/DVD writer', 'Integrated HD Webcam', '8x', 'yes', 'on', '3220 mAh', 'Simple', '1 Year Onsite Warranty', 'Onsite', ' Manufacturing Defects', 'Warranty does not cover any physical damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/109_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/109_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/109_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/109_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/109_5.jpeg'),
(110, 'nikunj76@gmail.com', '2018-04-15 16:09:31', 'Laptop', 'HP 15 Core i5 8th Gen - (8 GB/1 TB HDD/DOS) 15-BS145TU Laptop  (15.6 inch, SParkling Black, 2.1 kg)', 'HP', '15', '15-BS145TU', '8 GB/1 TB HDD', 38990, 'SParkling Black', 'Upto 5 hours', 'Intel', 'Core i5', ' 8th Gen', 'No', '8 GB', 'DDR4', '1 TB', '8250U', '1.6 GHz with Turbo Boost Upto ', ' 6 MB', ' Intel Integrated 620', 'DOS', 'yes', 'No', '15.6 inch', '1080 x 1920', 'Full HD LED Widescre', 'Built-in Dual Speake', 'Yes', 'Dolby', 'IEEE 802.11b/g/n', 'v4.0', '10/100/1000 Mbps', 'CD/DVD writer', 'HD Webcam', '8x', 'yes', 'on', '3500 mah', 'Li-ion Battery', '1 Year Onsite Warranty', 'Onsite', 'Manufacturing Defects', 'Physical Damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/110_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/110_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/110_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/110_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/110_5.jpeg'),
(111, 'nikunj76@gmail.com', '2018-04-15 16:31:34', 'Laptop', 'Lenovo Ideapad Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home/2 GB Graphics) IP 320 Laptop  (15.6 inch, Black, 2.2 kg)', 'Lenovo', 'IP 320', 'IP 320', '8 GB/1 TB HDD', 44990, 'Black', 'Upto 5 hours', 'Intel', 'Core i5', '7th Gen', 'No', '8 GB', 'DDR4', '1 TB', '7200U', '2.5 GHz with Turbo Boost Upto ', '3 MB', 'NVIDIA Geforce 940MX', 'Windows 10 Home', 'yes', 'No', '15.6 inch', '768 x 1366', 'HD LED Backlit Anti-', 'Built-in Dual Speake', 'Built-in Microphone', ' 2 x 1.5 W Speakers ', 'WIFI 1x1 AC', 'v4.1', '10/100 Mbps', 'CD/DVD writer', 'HD Webcam', '8x', 'yes', 'on', '3300 mah', 'Simple', '1 Year Onsite Warranty', 'Onsite', 'Manufacturing Defects', 'Physical Damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/111_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/111_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/111_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/111_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/111_5.jpeg'),
(112, 'nikunj76@gmail.com', '2018-04-15 16:51:25', 'Laptop', 'Lenovo Ideapad Core i3 6th Gen - (4 GB/1 TB HDD/DOS) IP 320E Laptop  (15.6 inch, Black, 2.2 kg)', 'Lenovo', 'IP 320', 'IP 320E', '4 GB/1 TB HDD', 25990, 'Black', 'Upto 5 hours', 'Intel', 'Core i3', '6th Gen', 'No', '4 GB', 'DDR4', '1 TB', '6006U', '2 GHz', '3 MB', 'Intel Integrated HD 520', 'DOS', 'yes', 'No', '15.6 inch', '768 x 1366', 'HD LED Backlit Anti-', 'Built-in Dual Speake', 'Built-in Microphone', '2 x 1.5 W Speakers w', 'WIFI 1x1 AC', 'v4.1', '100/1000 Mbps', 'CD/DVD writer', 'HD Webcam', '8x', 'yes', 'on', '3600 mah', 'Simple', '1 Year Onsite Warranty', 'Onsite', 'Manufacturing Defects', 'Physical Damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/112_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/112_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/112_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/112_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/112_5.jpeg'),
(113, 'nikunj76@gmail.com', '2018-04-16 04:34:44', 'Laptop', 'Dell Vostro 3000 Core i5 7th Gen - (8 GB/1 TB HDD/Ubuntu/2 GB Graphics) 3568 Laptop  (15.6 inch, Black)', 'Dell', 'Vostro 3000', '3568', '8 GB/1 TB HDD', 40990, 'Black', 'Upto 4 hours', 'Intel', 'Core i5', '7th Gen', 'No', '8 GB', 'DDR4', '1 TB', '8850H', '8x', '3 MB', '', 'Ubuntu', 'yes', 'No', '15.6 inch', '768 x 1366', 'HD LED Backlit Anti-', 'Built-in Dual Speake', 'Built-in Microphone', 'Dolby', 'IEEE 802.11ac', 'v4.1', 'Gigabit Ethernet', 'CD/DVD writer', 'HD Webcam', '8x', 'yes', 'on', '3300 mah', 'Simple', '1 Year Onsite Warranty', 'Onsite', 'Manufacturing Defects', 'Physical Damage', '1 Year', 'http://lapshop.in.net/seller/add_laptop/image/113_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/113_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/113_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/113_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/113_5.jpeg'),
(114, 'nikunj76@gmail.com', '2018-04-16 04:42:07', 'Thin and Light ', 'Asus VivoBook S14 Core i5 8th Gen - (8 GB/1 TB HDD/128 GB SSD/Windows 10 Home) S410UA-EB267T Thin and Light Laptop  (14 inch, Metal Grey, 1.43 kg)', 'Asus', 'VivoBook S14', 'S410UA-EB267T', '8 GB/1 TB HDD', 59990, 'Metal Grey', 'Upto 5 hours', 'Intel', 'Core i5', '8th Gen', 'No', '8 GB', 'DDR4', '1 TB', '8250U', '1.6 GHz with Turbo Boost Upto ', '6 MB', 'Intel Integrated UHD 620', 'Windows 10 Home', 'yes', 'No', '14 inch', '1080 x 1920', 'Full HD LED Backlit ', 'Built-in Speakers', 'Built-in Microphone', 'Sonic Master', 'IEEE 802.11ac', 'v4.1', '10/100 Mbps', 'Not Available', 'VGA Webcam', '8x', 'yes', 'on', '3500 mah', 'Simple', '2 Years Global Onsite Warranty', 'Onsite', 'Manufacturing Defects', 'Physical Damage', '2 Year', 'http://lapshop.in.net/seller/add_laptop/image/114_1.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/114_2.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/114_3.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/114_4.jpeg', 'http://lapshop.in.net/seller/add_laptop/image/114_5.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `laptop`
--

CREATE TABLE `laptop` (
  `id` int(11) NOT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `brand` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `shortdesc` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `rating` double NOT NULL,
  `price` float NOT NULL,
  `image` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `laptop`
--

INSERT INTO `laptop` (`id`, `title`, `brand`, `shortdesc`, `rating`, `price`, `image`) VALUES
(11, 'acer e15', 'acer', 'best laptop', 5, 37500, 'http://nikunjramani.000webhostapp.com/images/1.jpg'),
(22, 'Nikunj Ramani', 'keshaval', 'fatel note', 6, 9464, 'http://nikunjramani.000webhostapp.com/images/12.jpg'),
(23, 'nikunj', '', '', 0, 0, 'http://nikunjramani.000webhostapp.com/images/23.jpg'),
(25, 'nsns', 'nk', 'nk', 44, 44, 'http://nikunjramani.000webhostapp.com/images/25.jpg'),
(26, '', '', '', 0, 0, 'http://nikunjramani.000webhostapp.com/images/26.jpeg'),
(27, 'ghd', 'jdj', 'jcj', 9, 669, 'http://nikunjramani.000webhostapp.com/images/27.jpg'),
(28, '', '', '', 0, 0, 'http://nikunjramani.000webhostapp.com/images/28.jpeg'),
(29, '', '', '', 0, 0, 'http://nikunjramani.000webhostapp.com/images/29.jpg'),
(30, '', '', '', 0, 0, 'http://nikunjramani.000webhostapp.com/images/30.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `laptop_mycart`
--

CREATE TABLE `laptop_mycart` (
  `id` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `email` varchar(52) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_brand` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `screen_size` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_price` int(100) NOT NULL,
  `image_1` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `laptop_mycart`
--

INSERT INTO `laptop_mycart` (`id`, `sid`, `email`, `laptop_title`, `laptop_brand`, `screen_size`, `laptop_price`, `image_1`) VALUES
(121, 104, 'nikunjramani76@gmail.com', 'Acer Nitro 5 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home/2 GB Graphics) AN515-51 Gaming Laptop ', 'acer', '15.6 inch', 57000, 'http://lapshop.in.net/seller/add_laptop/image/104_1.jpeg'),
(127, 103, 'nikunjramani7624@gmail.com', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Ga', 'MSI', '18.4 inch', 350000, 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(128, 107, 'nikunjramani7624@gmail.com', 'Acer Predator Helios 300 Core i7 7th Gen - (16 GB/2 TB HDD/256 GB SSD/Windows 10 Home/6 GB Graphics)', 'Acer', '15.6 inch', 120990, 'http://lapshop.in.net/seller/add_laptop/image/107_1.jpeg'),
(129, 103, 'nikunjramani7624@gmail.com', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Ga', 'MSI', '18.4 inch', 350000, 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(130, 103, 'nikunjramani7624@gmail.com', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Ga', 'MSI', '18.4 inch', 350000, 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `laptop_wishlist`
--

CREATE TABLE `laptop_wishlist` (
  `id` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_brand` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `screen_size` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `laptop_price` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `image_1` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `laptop_wishlist`
--

INSERT INTO `laptop_wishlist` (`id`, `sid`, `email`, `laptop_title`, `laptop_brand`, `screen_size`, `color`, `laptop_price`, `image_1`) VALUES
(40, 1, 'nikunj@gmail.com', 'acer aspire e15', 'acer', '15.6 inch', 'black', '37500', 'https://nikunjramani.000webhostapp.com/Lapshop/show_image/show_image_1.php?sid=1'),
(41, 27, 'nikunj@gmail.com', 'Dell Inspiron 15 7000 Core i7 7th Gen - (16 GB/1 TB HDD/256 GB SSD/Windows 10 Home/6 GB Graphics) 7577 Laptop  (15.6 inch, Matte Black, 2.65 kg)', 'dell', '15.6 inch', 'black', '124000', 'https://nikunjramani.000webhostapp.com/Lapshop/show_image/show_image_1.php?sid=27'),
(55, 0, '', '', '', '', '', '', ''),
(57, 92, 'nik@gmail.com', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'acer', '15.7 inch', 'black', '5000', 'http://lapshop.in.net/Lapshop/add_laptop/image/92_1.jpeg'),
(61, 92, 'niku76@gmail.com', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'acer', '15.7 inch', 'black', '5000', 'http://lapshop.in.net/Lapshop/add_laptop/image/92_1.jpeg'),
(62, 103, 'nikunjramani76@gmail.com', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Laptop  (18.4 inch, Black, 5.5 kg)', 'MSI', '18.4 inch', 'Black', '350000', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(63, 104, 'nikunjramani76@gmail.com', 'Acer Nitro 5 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home/2 GB Graphics) AN515-51 Gaming Laptop  (15.6 inch, Black, 2.7 kg)', 'acer', '15.6 inch', ' Black', '57000', 'http://lapshop.in.net/seller/add_laptop/image/104_1.jpeg'),
(66, 92, 'kartikpatel281@gmail.com', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'Acer', '15.7 inch', 'black', '50000', 'http://lapshop.in.net/seller/add_laptop/image/92_1.jpeg'),
(67, 103, 'nikunjramani7624@gmail.com', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Laptop  (18.4 inch, Black, 5.5 kg)', 'MSI', '18.4 inch', 'Black', '350000', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `manage_address`
--

CREATE TABLE `manage_address` (
  `maid` int(11) NOT NULL,
  `cemail` varchar(110) COLLATE utf8_unicode_ci NOT NULL,
  `customer_city` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_locality` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_flatno` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_pincode` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_state` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_landmark` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `customer_mobileno` int(10) NOT NULL,
  `customer_alternativemobileno` int(10) NOT NULL,
  `customer_addresstype` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `manage_address`
--

INSERT INTO `manage_address` (`maid`, `cemail`, `customer_city`, `customer_locality`, `customer_flatno`, `customer_pincode`, `customer_state`, `customer_landmark`, `customer_name`, `customer_mobileno`, `customer_alternativemobileno`, `customer_addresstype`) VALUES
(26, 'nik@gmail.com', 'keshavala', 'keshavala', 'keshavala', '666666', '', 'keshavala', 'nikunj', 2147483647, 2147483647, 'home'),
(30, 'nik@gmail.', 'xx', 'aa', 'ss', 'ssss', 'zz', 'zz', 'zz', 22, 22, 'work'),
(31, 'nikunjramani76@gmail.com', 'keshavala', 'keshavala', 'keshaval', '364465', 'gujarat', 'hello', 'Nikunj Ramani', 2147483647, 2147483647, 'home'),
(32, 'niku76@gmail.com', 'Gandhinagar', 'Sctor 26', '67/2,KishanNagar', '382026', 'Gujarat', 'home', 'Nikunj Ramani', 2147483647, 2147483647, 'home'),
(35, 'kartikpatel281@gmail.com', 'gadhinagar', 'sector 26', '67/2', '364465', 'gujarat', 'gandhinagar', 'Nikunj', 2147483647, 2147483647, 'home'),
(36, 'nikunjramani7624@gmail.com', 'gandhinagar', 'sector 26', '67/2', '364465', 'gujarat', 'kh6', 'nikunj', 2147483647, 2147483647, 'home');

-- --------------------------------------------------------

--
-- Table structure for table `order_now`
--

CREATE TABLE `order_now` (
  `oid` int(11) NOT NULL,
  `c_email` varchar(300) NOT NULL,
  `sid` int(150) NOT NULL,
  `price` int(100) NOT NULL,
  `datetime` datetime NOT NULL,
  `cdid` int(150) NOT NULL,
  `maid` int(150) NOT NULL,
  `tracking` varchar(400) NOT NULL,
  `payment_method` varchar(200) NOT NULL,
  `title` varchar(110) NOT NULL,
  `image_1` varchar(1100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_now`
--

INSERT INTO `order_now` (`oid`, `c_email`, `sid`, `price`, `datetime`, `cdid`, `maid`, `tracking`, `payment_method`, `title`, `image_1`) VALUES
(15, 'nikunjramani76@gmail.com', 92, 5000, '2018-04-15 23:33:19', 0, 31, 'Book', 'cash On Delivery', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'http://lapshop.in.net/seller/add_laptop/image/92_1.jpeg'),
(16, 'kartikpatel281@gmail.com', 93, 50000, '2018-04-16 06:10:01', 11, 35, 'Book', 'creditDebit', 'dell CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'http://lapshop.in.net/seller/add_laptop/image/93_1.jpeg'),
(14, 'nikunjramani76@gmail.com', 93, 50000, '2018-04-15 23:06:19', 9, 31, 'Book', 'creditDebit', 'dell CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'http://lapshop.in.net/seller/add_laptop/image/93_1.jpeg'),
(17, 'nikunjramani7624@gmail.com', 103, 350000, '2018-04-16 06:32:16', 12, 36, 'Book', 'creditDebit', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Lapto', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(18, 'nikunjramani7624@gmail.com', 103, 350000, '2018-04-17 04:50:52', 0, 36, 'Book', 'cash On Delivery', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Lapto', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(19, 'nikunjramani7624@gmail.com', 103, 350000, '2018-04-17 05:25:17', 12, 36, 'Book', 'creditDebit', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Lapto', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(20, 'kartikpatel281@gmail.com', 92, 50000, '2018-04-17 05:33:55', 11, 35, 'Book', 'creditDebit', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'http://lapshop.in.net/seller/add_laptop/image/92_1.jpeg'),
(21, 'nikunjramani7624@gmail.com', 92, 50000, '2018-05-16 05:46:24', 12, 36, 'Book', 'creditDebit', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'http://lapshop.in.net/seller/add_laptop/image/92_1.jpeg'),
(22, 'nikunjramani7624@gmail.com', 103, 350000, '2018-05-16 07:30:55', 0, 36, 'Book', 'cash On Delivery', 'MSI GT Core i7 8th Gen - (32 GB/1 TB HDD/512 GB SSD/Windows 10 Home/8 GB Graphics) GT83 8RG-007IN Gaming Lapto', 'http://lapshop.in.net/seller/add_laptop/image/96_1.jpeg'),
(23, 'nikunjramani7624@gmail.com', 92, 50000, '2018-05-16 07:32:53', 12, 36, 'Book', 'creditDebit', 'Acer CORE I5 7TH GEN 8GB RAM 1TB HARDDISK,4GB GRAPHICS', 'http://lapshop.in.net/seller/add_laptop/image/92_1.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `order_now_otp`
--

CREATE TABLE `order_now_otp` (
  `onoid` int(11) NOT NULL,
  `mobileno` varchar(100) NOT NULL,
  `otp` int(6) NOT NULL,
  `time` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_now_otp`
--

INSERT INTO `order_now_otp` (`onoid`, `mobileno`, `otp`, `time`) VALUES
(1, '0', 0, '00:00:00'),
(2, '0', 0, '00:00:00'),
(3, '2147483647', 673155, '11:16:56'),
(4, '7984356582', 817786, '11:19:01'),
(5, '7984356582', 407908, '11:21:04'),
(6, '7984356582', 0, '00:00:00'),
(7, '7984356582', 307639, '05:45:56'),
(8, '7984356582', 380081, '07:32:37');

-- --------------------------------------------------------

--
-- Table structure for table `seller_singup`
--

CREATE TABLE `seller_singup` (
  `cid` int(11) NOT NULL,
  `firstname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `mobileno` decimal(10,0) NOT NULL,
  `datetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `seller_singup`
--

INSERT INTO `seller_singup` (`cid`, `firstname`, `lastname`, `email`, `password`, `mobileno`, `datetime`) VALUES
(28, 'nik', 'nik', 'nikunj76@gmail.com', 'nikunj@76', '1234567899', '2018-04-09 12:37:48');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `token` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `token`) VALUES
(1, 'nikunj', 'nikunj@gmail.com', ''),
(2, 'nikunj', 'nikunj12@gmail.com', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `credit_debit_card`
--
ALTER TABLE `credit_debit_card`
  ADD PRIMARY KEY (`cdid`);

--
-- Indexes for table `customer_singup`
--
ALTER TABLE `customer_singup`
  ADD PRIMARY KEY (`cid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `forgot_password`
--
ALTER TABLE `forgot_password`
  ADD UNIQUE KEY `fid` (`fid`);

--
-- Indexes for table `giftcard`
--
ALTER TABLE `giftcard`
  ADD PRIMARY KEY (`gcid`);

--
-- Indexes for table `lapshop_specification`
--
ALTER TABLE `lapshop_specification`
  ADD PRIMARY KEY (`sid`),
  ADD UNIQUE KEY `laptop_price` (`sid`);

--
-- Indexes for table `laptop`
--
ALTER TABLE `laptop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `laptop_mycart`
--
ALTER TABLE `laptop_mycart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `laptop_wishlist`
--
ALTER TABLE `laptop_wishlist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manage_address`
--
ALTER TABLE `manage_address`
  ADD PRIMARY KEY (`maid`);

--
-- Indexes for table `order_now`
--
ALTER TABLE `order_now`
  ADD PRIMARY KEY (`oid`);

--
-- Indexes for table `order_now_otp`
--
ALTER TABLE `order_now_otp`
  ADD PRIMARY KEY (`onoid`);

--
-- Indexes for table `seller_singup`
--
ALTER TABLE `seller_singup`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credit_debit_card`
--
ALTER TABLE `credit_debit_card`
  MODIFY `cdid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `customer_singup`
--
ALTER TABLE `customer_singup`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `forgot_password`
--
ALTER TABLE `forgot_password`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `giftcard`
--
ALTER TABLE `giftcard`
  MODIFY `gcid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `lapshop_specification`
--
ALTER TABLE `lapshop_specification`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;
--
-- AUTO_INCREMENT for table `laptop`
--
ALTER TABLE `laptop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `laptop_mycart`
--
ALTER TABLE `laptop_mycart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;
--
-- AUTO_INCREMENT for table `laptop_wishlist`
--
ALTER TABLE `laptop_wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT for table `manage_address`
--
ALTER TABLE `manage_address`
  MODIFY `maid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `order_now`
--
ALTER TABLE `order_now`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `order_now_otp`
--
ALTER TABLE `order_now_otp`
  MODIFY `onoid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `seller_singup`
--
ALTER TABLE `seller_singup`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
