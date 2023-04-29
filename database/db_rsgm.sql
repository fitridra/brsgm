-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 27 Apr 2023 pada 08.23
-- Versi server: 8.0.30
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rsgm`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_barang`
--

CREATE TABLE `tb_barang` (
  `id_barang` bigint NOT NULL,
  `nm_barang` varchar(255) NOT NULL,
  `stok_gudang` int NOT NULL,
  `satuan` varchar(10) NOT NULL,
  `harga` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tb_barang`
--

INSERT INTO `tb_barang` (`id_barang`, `nm_barang`, `stok_gudang`, `satuan`, `harga`) VALUES
(1, 'Pensil', 1, 'Buah', 5000),
(3, 'Pena', 15, 'Buah', 2000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_permintaan`
--

CREATE TABLE `tb_permintaan` (
  `id_permintaan` bigint NOT NULL,
  `id_petugas` int NOT NULL,
  `tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tb_permintaan`
--

INSERT INTO `tb_permintaan` (`id_permintaan`, `id_petugas`, `tanggal`) VALUES
(1, 6, '2023-04-18 11:05:24'),
(2, 6, '2023-04-18 11:05:42');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_permintaan_detail`
--

CREATE TABLE `tb_permintaan_detail` (
  `id_permintaan_detail` bigint NOT NULL,
  `id_barang` bigint NOT NULL,
  `id_permintaan` int NOT NULL,
  `stok_ruangan` int NOT NULL,
  `jumlah_diminta` int NOT NULL,
  `jumlah_disetujui` int DEFAULT NULL,
  `keterangan` text NOT NULL,
  `p_manager` varchar(10) DEFAULT NULL,
  `p_direktur` varchar(10) DEFAULT NULL,
  `p_spi` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tb_permintaan_detail`
--

INSERT INTO `tb_permintaan_detail` (`id_permintaan_detail`, `id_barang`, `id_permintaan`, `stok_ruangan`, `jumlah_diminta`, `jumlah_disetujui`, `keterangan`, `p_manager`, `p_direktur`, `p_spi`) VALUES
(1, 1, 1, 0, 1, 5, '-', 'Setuju', 'Setuju', NULL),
(2, 3, 1, 0, 1, 2, '-', 'Setuju', 'Setuju', NULL),
(3, 1, 2, 0, 1, NULL, '-', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_petugas`
--

CREATE TABLE `tb_petugas` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `ruangan` varchar(100) NOT NULL,
  `role` enum('Petugas','Admin','Manager','Direktur RS','Direktur PT') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_petugas`
--

INSERT INTO `tb_petugas` (`id`, `nama`, `username`, `password`, `ruangan`, `role`) VALUES
(6, 'fitri', 'fitri', '$2a$10$4YANpX5fAki13yt6x.rcbO39Ua/uB8SRFC8u2FBzbdqw8Lcj4gJ1q', 'sekretariat', 'Admin'),
(8, 'aku', 'aku', '$2a$10$ibdqbcZVHACzZ8ZK.jzLHuktP2k2d672cVjckdRNwiR/4zNG4YkeO', 'sekretariat', 'Petugas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_spb`
--

CREATE TABLE `tb_spb` (
  `id_spb` int NOT NULL,
  `id_petugas` int NOT NULL,
  `tanggal` datetime NOT NULL,
  `total` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tb_spb`
--

INSERT INTO `tb_spb` (`id_spb`, `id_petugas`, `tanggal`, `total`) VALUES
(2, 6, '2023-04-27 14:28:24', 29000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_spb_detail`
--

CREATE TABLE `tb_spb_detail` (
  `id_spb_detail` int NOT NULL,
  `id_permintaan_detail` int NOT NULL,
  `id_spb` int NOT NULL,
  `jumlah_harga` int NOT NULL,
  `p_managerk` varchar(10) DEFAULT NULL,
  `p_direkturrs` varchar(10) DEFAULT NULL,
  `p_direkturpt` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tb_spb_detail`
--

INSERT INTO `tb_spb_detail` (`id_spb_detail`, `id_permintaan_detail`, `id_spb`, `jumlah_harga`, `p_managerk`, `p_direkturrs`, `p_direkturpt`) VALUES
(1, 1, 2, 25000, NULL, NULL, NULL),
(2, 2, 2, 4000, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `tb_permintaan`
--
ALTER TABLE `tb_permintaan`
  ADD PRIMARY KEY (`id_permintaan`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indeks untuk tabel `tb_permintaan_detail`
--
ALTER TABLE `tb_permintaan_detail`
  ADD PRIMARY KEY (`id_permintaan_detail`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_permintaan` (`id_permintaan`);

--
-- Indeks untuk tabel `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_spb`
--
ALTER TABLE `tb_spb`
  ADD PRIMARY KEY (`id_spb`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indeks untuk tabel `tb_spb_detail`
--
ALTER TABLE `tb_spb_detail`
  ADD PRIMARY KEY (`id_spb_detail`),
  ADD KEY `id_permintaan_detail` (`id_permintaan_detail`,`id_spb`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `id_barang` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_permintaan`
--
ALTER TABLE `tb_permintaan`
  MODIFY `id_permintaan` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_permintaan_detail`
--
ALTER TABLE `tb_permintaan_detail`
  MODIFY `id_permintaan_detail` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tb_petugas`
--
ALTER TABLE `tb_petugas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `tb_spb`
--
ALTER TABLE `tb_spb`
  MODIFY `id_spb` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tb_spb_detail`
--
ALTER TABLE `tb_spb_detail`
  MODIFY `id_spb_detail` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
