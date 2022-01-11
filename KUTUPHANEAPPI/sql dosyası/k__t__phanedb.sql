-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 07 Oca 2022, 00:06:34
-- Sunucu sürümü: 10.4.22-MariaDB
-- PHP Sürümü: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kütüphanedb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `adminler`
--

CREATE TABLE `adminler` (
  `kullaniciadi` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `parola` text COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `adminler`
--

INSERT INTO `adminler` (`kullaniciadi`, `parola`) VALUES
('engin', 'engin'),
('ahmet', 'ahmet');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaplar`
--

CREATE TABLE `kitaplar` (
  `id` int(11) NOT NULL,
  `kitapadi` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `yazaradi` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `basımyili` int(11) NOT NULL,
  `turu` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitaplar`
--

INSERT INTO `kitaplar` (`id`, `kitapadi`, `yazaradi`, `basımyili`, `turu`) VALUES
(1, 'Sefiller', 'Victor Hugo', 1862, 'Roman'),
(2, 'Yeraltından Notlar', 'Fyodor Dostoevsky', 1864, 'Roman'),
(3, 'Değişen Beynim', 'Sinan Canan', 2018, 'Bilim-Teknoloji'),
(4, 'Yeni Başlayanlar İçin Java 10', 'Sezer Tanrıverdioğlu', 2010, 'Teknik'),
(5, 'Yapmamak', 'Steven D\'Souza', 2018, 'Kişisel Gelişim'),
(6, 'Yaratıcı Tür', 'David Eagleman', 2019, 'Bilim-Teknoloji'),
(7, 'Şeker Portakalı', 'José Mauro de Vasconcelos', 1968, 'Roman'),
(8, 'Simyacı', 'Paulo Coelho', 1988, 'Roman'),
(9, 'Düşün ve Zengin Ol', 'Napoleon Hill', 1937, 'Kişisel Gelişim'),
(10, 'Zengin Baba Fakir Baba', 'Robert Kiyosaki', 1997, 'Kişisel Gelişim'),
(11, 'Karatay Mutfağı', 'Canan Karatay', 2012, 'Teknik'),
(12, 'Fitmühendisce Tarifler', 'Canan Hastürk', 2018, 'Teknik'),
(14, 'Olasılıksız', 'Adam FEVER', 1985, 'Roman');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyeler`
--

CREATE TABLE `uyeler` (
  `id` int(11) NOT NULL,
  `ad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `soyad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `uyeliktipi` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `uyeler`
--

INSERT INTO `uyeler` (`id`, `ad`, `soyad`, `uyeliktipi`) VALUES
(5, 'Süphan', 'YAKUT', 'Platin Üye'),
(9, 'Doğukan', 'ALIŞ', 'Normal Üye'),
(10, 'Özcan', 'TUNCER', 'Platin Üye'),
(13, 'Levent', 'KIRCA', 'Platin Üye'),
(14, 'Mehmet', 'YÜKSEL', 'Normal Üye');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kitaplar`
--
ALTER TABLE `kitaplar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `uyeler`
--
ALTER TABLE `uyeler`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kitaplar`
--
ALTER TABLE `kitaplar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `uyeler`
--
ALTER TABLE `uyeler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
