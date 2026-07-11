-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 11, 2026 at 12:06 PM
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
  `jht_karyawan` decimal(8,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bpjs`
--

INSERT INTO `bpjs` (`id`, `jkk`, `jkm`, `jht_perusahaan`, `jht_karyawan`) VALUES
(1, '0.25', '0.30', '3.70', '2.00');

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
  `total` int UNSIGNED NOT NULL,
  `bulan` enum('Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahun` year NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `gaji_bersih`
--

INSERT INTO `gaji_bersih` (`id`, `karyawan_id`, `gaji_kotor_id`, `potongan_jabatan`, `potongan_absen`, `jumlah_absen`, `jht_karyawan`, `total`, `bulan`, `tahun`) VALUES
(3, 3, 3, 435932, 0, 0, '2.00', 8118702, 'Januari', 2026),
(6, 6, 6, 335397, 100000, 2, '2.00', 6145751, 'Januari', 2026),
(51, 5, 5, 471019, 100000, 2, '2.00', 8672158, 'Januari', 2026),
(555, 7, 7, 537742, 0, 0, '2.00', 10013290, 'Januari', 2026),
(1111, 4, 4, 506799, 100000, 2, '2.00', 9337586, 'Januari', 2026);

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
  `jkm` decimal(8,2) UNSIGNED NOT NULL,
  `jht_perusahaan` decimal(8,2) UNSIGNED NOT NULL,
  `total_2` bigint UNSIGNED NOT NULL,
  `golongan_ter` enum('A','B','C') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A',
  `tarif_ter` decimal(8,2) UNSIGNED NOT NULL,
  `total_ter` int UNSIGNED NOT NULL,
  `total` int UNSIGNED NOT NULL,
  `bulan` enum('Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahun` year NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `gaji_kotor`
--

INSERT INTO `gaji_kotor` (`id`, `karyawan_id`, `gaji_pokok`, `tunjangan_jabatan`, `tunjangan_transportasi`, `tunjangan_makan`, `jumlah_lembur`, `tunjangan_lembur`, `total_1`, `jkk`, `jkm`, `jht_perusahaan`, `total_2`, `golongan_ter`, `tarif_ter`, `total_ter`, `total`, `bulan`, `tahun`) VALUES
(3, 3, 6800000, 450000, 330000, 220000, 14, 400000, 8200000, '0.24', '0.30', '3.70', 8547680, 'C', '0.02', 170954, 8718634, 'Januari', 2026),
(4, 4, 8000000, 450000, 420000, 260000, 10, 450000, 9580000, '0.24', '0.30', '3.70', 9986192, 'B', '0.02', 149793, 10135985, 'Januari', 2026),
(5, 5, 7600000, 450000, 280000, 280000, 12, 250000, 8860000, '0.24', '0.30', '3.70', 9235664, 'C', '0.02', 184713, 9420377, 'Januari', 2026),
(6, 6, 5100000, 850000, 170000, 220000, 1, 0, 6340000, '0.24', '0.30', '3.70', 6608816, 'B', '0.02', 99132, 6707948, 'Januari', 2026),
(7, 7, 8900000, 0, 450000, 340000, 0, 500000, 10190000, '0.24', '0.30', '3.70', 10622056, 'A', '0.01', 132776, 10754832, 'Januari', 2026),
(14, 13, 15000000, 1000000, 1000000, 1000000, 20, 100000, 20000000, '0.25', '0.30', '3.70', 20510000, 'A', '0.02', 461475, 20971475, 'Juli', 2026);

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id` bigint UNSIGNED NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tunjangan` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id`, `nama`, `tunjangan`) VALUES
(1, 'Tidak Diketahui', 0),
(2, 'Penambang', 1000000),
(3, 'Pembantu Rumah Tangga', 700000),
(4, 'Notaris', 450000),
(5, 'Dokter', 850000),
(6, 'Pengacara', 300000),
(7, 'Kepala Sekolah', 2000000),
(9, 'Staf 2', 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id` bigint UNSIGNED NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gaji_pokok` int UNSIGNED NOT NULL,
  `npwp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tunjangan_transportasi` int UNSIGNED NOT NULL,
  `tunjangan_makan` int UNSIGNED NOT NULL,
  `tunjangan_lembur` int UNSIGNED NOT NULL,
  `potongan_absen` int UNSIGNED NOT NULL,
  `golongan_ter` enum('A','B','C') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A',
  `jabatan_id` bigint UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `gaji_pokok`, `npwp`, `tunjangan_transportasi`, `tunjangan_makan`, `tunjangan_lembur`, `potongan_absen`, `golongan_ter`, `jabatan_id`) VALUES
(2, 'Vicky Janet Melani S.I.Kom', 5800000, '12.847.738.9-723.553', 330000, 300000, 0, 40000, 'C', 4),
(3, 'Yani Halimah S.Ked', 6800000, '31.416.858.0-284.649', 330000, 220000, 400000, 0, 'C', 4),
(4, 'Teddy Megantara', 8000000, '83.586.453.5-883.202', 420000, 260000, 450000, 80000, 'B', 4),
(5, 'Citra Susanti S.Gz', 7600000, '14.336.191.7-791.044', 280000, 280000, 250000, 20000, 'C', 4),
(6, 'Juli Namaga S.Pt', 5100000, '08.340.576.2-181.115', 170000, 220000, 0, 80000, 'B', 5),
(7, 'Prayitna Prima Budiyanto', 8900000, '62.824.815.6-115.927', 450000, 340000, 500000, 40000, 'A', 1),
(12, 'budi', 2000, '3432', 3020, 22, 22, 22, 'A', 7),
(13, 'Dion 2', 15000000, 'w34645yh4w5y4y', 1000000, 1000000, 100000, 300000, 'A', 2);

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int UNSIGNED NOT NULL,
  `migration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
-- Table structure for table `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint UNSIGNED NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
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
  `golongan` enum('A','B','C') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ter`
--

INSERT INTO `ter` (`id`, `min`, `max`, `tarif`, `golongan`) VALUES
(1, 0, 5400000, '0.00', 'A'),
(2, 5400001, 5650000, '0.25', 'A'),
(3, 5650001, 5950000, '0.50', 'A'),
(4, 5950001, 6300000, '0.75', 'A'),
(5, 6300001, 6750000, '1.00', 'A'),
(6, 6750001, 7500000, '1.25', 'A'),
(7, 7500001, 11000000, '2.00', 'A'),
(8, 0, 6200000, '0.00', 'B'),
(9, 6200001, 6500000, '0.25', 'B'),
(10, 6500001, 6850000, '0.50', 'B'),
(11, 6850001, 7300000, '0.75', 'B'),
(12, 7300001, 9200000, '1.00', 'B'),
(13, 0, 6600000, '0.00', 'C'),
(14, 6600001, 6950000, '0.25', 'C'),
(15, 6950001, 7350000, '0.50', 'C'),
(16, 7350001, 7800000, '0.75', 'C'),
(17, 7800001, 8850000, '1.00', 'C'),
(19, 11000001, 50000000, '2.25', 'A');

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ter_golongan_tarif_unique` (`golongan`,`tarif`);

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
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1114;

--
-- AUTO_INCREMENT for table `gaji_kotor`
--
ALTER TABLE `gaji_kotor`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ter`
--
ALTER TABLE `ter`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

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
