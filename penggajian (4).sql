-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 11, 2026 at 12:57 PM
-- Server version: 8.0.30
-- PHP Version: 8.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penggajian`
--

-- --------------------------------------------------------

--
-- Table structure for table `bpjs`
--

CREATE TABLE `bpjs` (
  `id` bigint UNSIGNED NOT NULL,
  `jkk` decimal(8,2) UNSIGNED NOT NULL,
  `jkm` decimal(8,2) UNSIGNED NOT NULL,
  `jht_perusahaan` decimal(8,2) UNSIGNED NOT NULL,
  `jht_karyawan` decimal(8,2) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bpjs`
--

INSERT INTO `bpjs` (`id`, `jkk`, `jkm`, `jht_perusahaan`, `jht_karyawan`, `created_at`, `updated_at`) VALUES
(1, '0.24', '0.30', '3.70', '2.00', '2026-06-07 05:40:31', '2026-06-07 05:40:31');

-- --------------------------------------------------------

--
-- Table structure for table `gaji_bersih`
--

CREATE TABLE `gaji_bersih` (
  `id` bigint UNSIGNED NOT NULL,
  `karyawan_id` bigint UNSIGNED NOT NULL,
  `gaji_kotor_id` bigint UNSIGNED NOT NULL,
  `potongan_jabatan` int UNSIGNED NOT NULL,
  `potongan_absen` int UNSIGNED NOT NULL,
  `jumlah_absen` int UNSIGNED NOT NULL,
  `jht_karyawan` decimal(8,2) UNSIGNED NOT NULL,
  `total_jht_karyawan` int UNSIGNED NOT NULL,
  `total` int UNSIGNED NOT NULL,
  `bulan` enum('Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahun` year NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `gaji_bersih`
--

INSERT INTO `gaji_bersih` (`id`, `karyawan_id`, `gaji_kotor_id`, `potongan_jabatan`, `potongan_absen`, `jumlah_absen`, `jht_karyawan`, `total_jht_karyawan`, `total`, `bulan`, `tahun`, `created_at`, `updated_at`) VALUES
(2, 2, 2, 477582, 0, 0, '2.00', 181000, 8893060, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(3, 3, 3, 368345, 50000, 1, '2.00', 139600, 6808956, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(4, 4, 4, 379306, 50000, 1, '2.00', 143400, 7013412, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(5, 5, 5, 393402, 0, 0, '2.00', 148000, 7326633, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(6, 6, 6, 519397, 100000, 2, '2.00', 195400, 9573136, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(7, 7, 7, 521910, 0, 0, '2.00', 197800, 9718493, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(8, 8, 8, 517688, 50000, 1, '2.00', 196200, 9589880, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(9, 9, 9, 375205, 0, 0, '2.00', 142200, 6986702, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(10, 10, 10, 500802, 100000, 2, '2.00', 189800, 9225429, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31');

-- --------------------------------------------------------

--
-- Table structure for table `gaji_kotor`
--

CREATE TABLE `gaji_kotor` (
  `id` bigint UNSIGNED NOT NULL,
  `karyawan_id` bigint UNSIGNED NOT NULL,
  `gaji_pokok` int UNSIGNED NOT NULL,
  `tunjangan_jabatan` int UNSIGNED NOT NULL,
  `tunjangan_transportasi` int UNSIGNED NOT NULL,
  `tunjangan_makan` int UNSIGNED NOT NULL,
  `jumlah_lembur` int UNSIGNED NOT NULL,
  `tunjangan_lembur` int UNSIGNED NOT NULL,
  `total_1` bigint UNSIGNED NOT NULL,
  `jkk` decimal(8,2) UNSIGNED NOT NULL,
  `total_jkk` int UNSIGNED NOT NULL,
  `jkm` decimal(8,2) UNSIGNED NOT NULL,
  `total_jkm` int UNSIGNED NOT NULL,
  `jht_perusahaan` decimal(8,2) UNSIGNED NOT NULL,
  `total_jht_perusahaan` int UNSIGNED NOT NULL,
  `total_2` bigint UNSIGNED NOT NULL,
  `golongan_ter` enum('A','B','C') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A',
  `tarif_ter` decimal(8,2) UNSIGNED NOT NULL,
  `total_ter` int UNSIGNED NOT NULL,
  `total` int UNSIGNED NOT NULL,
  `bulan` enum('Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahun` year NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `gaji_kotor`
--

INSERT INTO `gaji_kotor` (`id`, `karyawan_id`, `gaji_pokok`, `tunjangan_jabatan`, `tunjangan_transportasi`, `tunjangan_makan`, `jumlah_lembur`, `tunjangan_lembur`, `total_1`, `jkk`, `total_jkk`, `jkm`, `total_jkm`, `jht_perusahaan`, `total_jht_perusahaan`, `total_2`, `golongan_ter`, `tarif_ter`, `total_ter`, `total`, `bulan`, `tahun`, `created_at`, `updated_at`) VALUES
(2, 2, 7900000, 250000, 400000, 400000, 19, 100000, 9050000, '0.24', 21720, '0.30', 27150, '3.70', 334850, 9433720, 'A', '0.01', 117922, 9551642, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(3, 3, 6000000, 250000, 310000, 370000, 20, 50000, 6980000, '0.24', 16752, '0.30', 20940, '3.70', 258260, 7275952, 'A', '0.01', 90949, 7366901, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(4, 4, 6100000, 0, 270000, 350000, 5, 450000, 7170000, '0.24', 17208, '0.30', 21510, '3.70', 265290, 7474008, 'B', '0.02', 112110, 7586118, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(5, 5, 6000000, 750000, 320000, 230000, 1, 100000, 7400000, '0.24', 17760, '0.30', 22200, '3.70', 273800, 7713760, 'C', '0.02', 154275, 7868035, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(6, 6, 9100000, 0, 410000, 260000, 12, 0, 9770000, '0.24', 23448, '0.30', 29310, '3.70', 361490, 10184248, 'C', '0.02', 203685, 10387933, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(7, 7, 8700000, 650000, 140000, 250000, 13, 150000, 9890000, '0.24', 23736, '0.30', 29670, '3.70', 365930, 10309336, 'A', '0.01', 128867, 10438203, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(8, 8, 8200000, 650000, 470000, 340000, 2, 150000, 9810000, '0.24', 23544, '0.30', 29430, '3.70', 362970, 10225944, 'A', '0.01', 127824, 10353768, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(9, 9, 5800000, 250000, 160000, 400000, 17, 500000, 7110000, '0.24', 17064, '0.30', 21330, '3.70', 263070, 7411464, 'A', '0.01', 92643, 7504107, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(10, 10, 8000000, 750000, 240000, 350000, 7, 150000, 9490000, '0.24', 22776, '0.30', 28470, '3.70', 351130, 9892376, 'A', '0.01', 123655, 10016031, 'Januari', 2026, '2026-06-07 05:40:31', '2026-06-07 05:40:31');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id` bigint UNSIGNED NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tunjangan` int UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id`, `nama`, `tunjangan`, `created_at`, `updated_at`) VALUES
(1, 'Tidak Diketahui', 0, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(2, 'Tukang Sol Sepatu', 750000, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(3, 'Pelaut', 300000, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(4, 'Atlet', 550000, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(5, 'Biarawati', 250000, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(6, 'Nelayan / Perikanan', 650000, '2026-06-07 05:40:31', '2026-06-07 05:40:31');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id` bigint UNSIGNED NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gaji_pokok` int UNSIGNED NOT NULL,
  `npwp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tunjangan_transportasi` int UNSIGNED NOT NULL,
  `tunjangan_makan` int UNSIGNED NOT NULL,
  `tunjangan_lembur` int UNSIGNED NOT NULL,
  `potongan_absen` int UNSIGNED NOT NULL,
  `golongan_ter` enum('A','B','C') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A',
  `jabatan_id` bigint UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `gaji_pokok`, `npwp`, `tunjangan_transportasi`, `tunjangan_makan`, `tunjangan_lembur`, `potongan_absen`, `golongan_ter`, `jabatan_id`, `created_at`, `updated_at`) VALUES
(1, 'Septi Padmi Sudiati', 6300000, '06.451.264.1-262.919', 410000, 320000, 450000, 100000, 'C', 2, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(2, 'Hardi Iswahyudi', 7900000, '81.905.952.1-644.409', 400000, 400000, 100000, 100000, 'A', 5, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(3, 'Nadine Rahmi Pudjiastuti S.Ked', 6000000, '87.730.463.6-967.348', 310000, 370000, 50000, 40000, 'A', 5, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(4, 'Cinthia Prastuti S.E.I', 6100000, '96.411.988.3-605.582', 270000, 350000, 450000, 60000, 'B', 1, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(5, 'Yulia Fujiati', 6000000, '98.862.512.9-866.737', 320000, 230000, 100000, 100000, 'C', 2, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(6, 'Wardi Prasetya S.Kom', 9100000, '87.231.654.0-397.143', 410000, 260000, 0, 100000, 'C', 1, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(7, 'Vera Lestari', 8700000, '35.568.685.3-100.614', 140000, 250000, 150000, 20000, 'A', 6, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(8, 'Juli Kania Maryati M.Farm', 8200000, '49.693.026.6-738.684', 470000, 340000, 150000, 20000, 'A', 6, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(9, 'Najib Kuswoyo', 5800000, '56.324.881.5-531.816', 160000, 400000, 500000, 100000, 'A', 5, '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(10, 'Parman Prabowo', 8000000, '05.261.447.4-144.778', 240000, 350000, 150000, 60000, 'A', 2, '2026-06-07 05:40:31', '2026-06-07 05:40:31');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2019_12_14_000001_create_personal_access_tokens_table', 1),
(2, '2026_04_20_160155_create_jabatan_table', 1),
(3, '2026_04_20_161851_create_bpjs_table', 1),
(4, '2026_04_20_163520_create_ter_table', 1),
(5, '2034_10_12_000000_create_karyawan_table', 1),
(6, '2036_04_20_164051_create_gaji_kotor_table', 1),
(7, '2036_04_20_164052_create_gaji_bersih_table', 1),
(8, '2036_04_20_164053_create_gaji_table', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ter`
--

CREATE TABLE `ter` (
  `id` bigint UNSIGNED NOT NULL,
  `min` bigint UNSIGNED NOT NULL,
  `max` bigint UNSIGNED NOT NULL,
  `tarif` decimal(8,2) UNSIGNED NOT NULL,
  `golongan` enum('A','B','C') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ter`
--

INSERT INTO `ter` (`id`, `min`, `max`, `tarif`, `golongan`, `created_at`, `updated_at`) VALUES
(1, 0, 5400000, '0.00', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(2, 5400001, 5650000, '0.25', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(3, 5650001, 5950000, '0.50', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(4, 5950001, 6300000, '0.75', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(5, 6300001, 6750000, '1.00', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(6, 6750001, 7500000, '1.25', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(7, 7500001, 8550000, '1.50', 'A', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(8, 0, 6200000, '0.00', 'B', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(9, 6200001, 6500000, '0.25', 'B', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(10, 6500001, 6850000, '0.50', 'B', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(11, 6850001, 7300000, '0.75', 'B', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(12, 7300001, 9200000, '1.00', 'B', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(13, 0, 6600000, '0.00', 'C', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(14, 6600001, 6950000, '0.25', 'C', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(15, 6950001, 7350000, '0.50', 'C', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(16, 7350001, 7800000, '0.75', 'C', '2026-06-07 05:40:31', '2026-06-07 05:40:31'),
(17, 7800001, 8850000, '1.00', 'C', '2026-06-07 05:40:31', '2026-06-07 05:40:31');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bpjs`
--
ALTER TABLE `bpjs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gaji_bersih`
--
ALTER TABLE `gaji_bersih`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_gaji_periode` (`karyawan_id`,`bulan`,`tahun`),
  ADD KEY `gaji_bersih_gaji_kotor_id_foreign` (`gaji_kotor_id`);

--
-- Indexes for table `gaji_kotor`
--
ALTER TABLE `gaji_kotor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_gaji_periode` (`karyawan_id`,`bulan`,`tahun`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `jabatan_nama_unique` (`nama`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `karyawan_jabatan_id_foreign` (`jabatan_id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ter`
--
ALTER TABLE `ter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ter_golongan_tarif_unique` (`golongan`,`tarif`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`nama`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bpjs`
--
ALTER TABLE `bpjs`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gaji_bersih`
--
ALTER TABLE `gaji_bersih`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `gaji_kotor`
--
ALTER TABLE `gaji_kotor`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ter`
--
ALTER TABLE `ter`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gaji_bersih`
--
ALTER TABLE `gaji_bersih`
  ADD CONSTRAINT `gaji_bersih_gaji_kotor_id_foreign` FOREIGN KEY (`gaji_kotor_id`) REFERENCES `gaji_kotor` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `gaji_bersih_karyawan_id_foreign` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `gaji_kotor`
--
ALTER TABLE `gaji_kotor`
  ADD CONSTRAINT `gaji_kotor_karyawan_id_foreign` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_jabatan_id_foreign` FOREIGN KEY (`jabatan_id`) REFERENCES `jabatan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
