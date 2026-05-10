-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 10, 2026 at 11:57 AM
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
(1, '0.24', '0.30', '3.70', '2.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08');

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `id` bigint UNSIGNED NOT NULL,
  `karyawan_id` bigint UNSIGNED NOT NULL,
  `gaji_pokok` int UNSIGNED NOT NULL,
  `tunjangan_transportasi` int UNSIGNED NOT NULL,
  `tunjangan_makan` int UNSIGNED NOT NULL,
  `tunjangan_lembur` int UNSIGNED NOT NULL,
  `jumlah_lembur` int UNSIGNED NOT NULL,
  `potongan_absen` int UNSIGNED NOT NULL,
  `jumlah_absen` int UNSIGNED NOT NULL,
  `nama_jabatan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tunjangan_jabatan` int UNSIGNED NOT NULL,
  `jkk` decimal(8,2) UNSIGNED NOT NULL,
  `jkm` decimal(8,2) UNSIGNED NOT NULL,
  `jht_perusahaan` decimal(8,2) UNSIGNED NOT NULL,
  `jht_karyawan` decimal(8,2) UNSIGNED NOT NULL,
  `bulan` enum('Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahun` year NOT NULL,
  `tarif_ter` decimal(8,2) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id`, `karyawan_id`, `gaji_pokok`, `tunjangan_transportasi`, `tunjangan_makan`, `tunjangan_lembur`, `jumlah_lembur`, `potongan_absen`, `jumlah_absen`, `nama_jabatan`, `tunjangan_jabatan`, `jkk`, `jkm`, `jht_perusahaan`, `jht_karyawan`, `bulan`, `tahun`, `tarif_ter`, `created_at`, `updated_at`) VALUES
(1, 1, 7200000, 180000, 260000, 400000, 3, 20000, 4, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.50', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(2, 2, 4900000, 100000, 360000, 500000, 5, 80000, 0, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(3, 3, 6200000, 220000, 340000, 0, 5, 20000, 2, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(4, 4, 4900000, 370000, 400000, 50000, 5, 60000, 0, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(5, 5, 8700000, 190000, 200000, 200000, 2, 80000, 1, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '1.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(6, 6, 7200000, 180000, 260000, 400000, 3, 20000, 1, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.50', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(7, 7, 4900000, 370000, 400000, 50000, 3, 60000, 1, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(8, 8, 8700000, 190000, 200000, 200000, 0, 80000, 2, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '1.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(9, 9, 4900000, 370000, 400000, 50000, 3, 60000, 3, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '0.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(10, 10, 8700000, 190000, 200000, 200000, 5, 80000, 2, 'Tidak Diketahui', 0, '0.24', '0.30', '3.70', '2.00', 'Januari', 2026, '1.00', '2026-05-10 03:36:08', '2026-05-10 03:36:08');

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
(1, 'Tidak Diketahui', 0, '2026-05-10 03:36:07', '2026-05-10 03:36:07'),
(2, 'Desainer', 750000, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(3, 'Montir', 850000, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(4, 'Penerjemah', 650000, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(5, 'Perawat', 300000, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(6, 'Konstruksi', 400000, '2026-05-10 03:36:08', '2026-05-10 03:36:08');

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
  `tunjangan_absen` int UNSIGNED NOT NULL,
  `golongan_ter` enum('A','B','C') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A',
  `jabatan_id` bigint UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `gaji_pokok`, `npwp`, `tunjangan_transportasi`, `tunjangan_makan`, `tunjangan_lembur`, `tunjangan_absen`, `golongan_ter`, `jabatan_id`, `created_at`, `updated_at`) VALUES
(1, 'Usyi Dina Pertiwi M.Farm', 6600000, '44.522.534.3-610.865', 280000, 220000, 400000, 60000, 'A', 5, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(2, 'Natalia Lestari', 8700000, '41.436.723.0-290.804', 190000, 200000, 200000, 80000, 'B', 1, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(3, 'Alika Wahyuni', 6200000, '72.555.933.7-033.575', 220000, 340000, 0, 20000, 'C', 1, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(4, 'Darman Respati Kuswoyo S.IP', 5100000, '08.089.665.5-747.868', 290000, 310000, 0, 100000, 'B', 2, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(5, 'Ghani Waluyo', 7200000, '67.105.009.4-153.191', 180000, 260000, 400000, 20000, 'C', 1, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(6, 'Okta Pradipta', 8600000, '91.292.909.2-036.744', 100000, 370000, 200000, 0, 'B', 5, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(7, 'Cawisadi Budiman', 7600000, '16.505.335.6-389.135', 280000, 340000, 100000, 100000, 'C', 6, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(8, 'Radika Suryono', 4900000, '11.675.557.1-325.480', 100000, 360000, 500000, 80000, 'A', 1, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(9, 'Mitra Kuswoyo', 4900000, '90.389.714.0-763.776', 370000, 400000, 50000, 60000, 'B', 1, '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(10, 'Putri Pudjiastuti', 9000000, '83.554.643.2-143.873', 350000, 350000, 200000, 0, 'B', 6, '2026-05-10 03:36:08', '2026-05-10 03:36:08');

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
(6, '2036_04_20_164051_create_gaji_table', 1);

-- --------------------------------------------------------

--
-- Table structure for table `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text COLLATE utf8mb4_unicode_ci,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
(1, 0, 5400000, '0.00', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(2, 5400001, 5650000, '0.25', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(3, 5650001, 5950000, '0.50', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(4, 5950001, 6300000, '0.75', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(5, 6300001, 6750000, '1.00', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(6, 6750001, 7500000, '1.25', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(7, 7500001, 8550000, '1.50', 'A', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(8, 0, 6200000, '0.00', 'B', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(9, 6200001, 6500000, '0.25', 'B', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(10, 6500001, 6850000, '0.50', 'B', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(11, 6850001, 7300000, '0.75', 'B', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(12, 7300001, 9200000, '1.00', 'B', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(13, 0, 6600000, '0.00', 'C', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(14, 6600001, 6950000, '0.25', 'C', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(15, 6950001, 7350000, '0.50', 'C', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(16, 7350001, 7800000, '0.75', 'C', '2026-05-10 03:36:08', '2026-05-10 03:36:08'),
(17, 7800001, 8850000, '1.00', 'C', '2026-05-10 03:36:08', '2026-05-10 03:36:08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bpjs`
--
ALTER TABLE `bpjs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
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
-- Indexes for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Indexes for table `ter`
--
ALTER TABLE `ter`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bpjs`
--
ALTER TABLE `bpjs`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gaji`
--
ALTER TABLE `gaji`
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
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ter`
--
ALTER TABLE `ter`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gaji`
--
ALTER TABLE `gaji`
  ADD CONSTRAINT `gaji_karyawan_id_foreign` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_jabatan_id_foreign` FOREIGN KEY (`jabatan_id`) REFERENCES `jabatan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
