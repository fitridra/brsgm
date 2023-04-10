-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 10 Apr 2023 pada 00.50
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
-- Database: `brsgm`
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
(1, 'pena', 2, 'buah', 2000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_permintaan`
--

CREATE TABLE `tb_permintaan` (
  `id_permintaan` bigint NOT NULL,
  `id_barang` bigint NOT NULL,
  `tanggal` date NOT NULL,
  `ruangan` varchar(100) NOT NULL,
  `petugas` varchar(255) NOT NULL,
  `stok_ruangan` int NOT NULL,
  `jumlah_diminta` int NOT NULL,
  `jumlah_disetujui` int NOT NULL,
  `keterangan` text NOT NULL,
  `p_managerbd` tinyint NOT NULL,
  `p_direktur` tinyint NOT NULL,
  `p_spi` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_spb`
--

CREATE TABLE `tb_spb` (
  `id_spb` bigint NOT NULL,
  `id_permintaan` bigint NOT NULL,
  `id_barang` bigint NOT NULL,
  `petugas` varchar(255) NOT NULL,
  `p_managerk` tinyint NOT NULL,
  `p_spb` tinyint NOT NULL,
  `p_direkturrs` tinyint NOT NULL,
  `p_direkturpt` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(255) NOT NULL,
  `nama` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`username`, `nama`, `password`, `role`) VALUES
('aku', 'aku', 'aku', '1');

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
  ADD KEY `id_barang` (`id_barang`);

--
-- Indeks untuk tabel `tb_spb`
--
ALTER TABLE `tb_spb`
  ADD PRIMARY KEY (`id_spb`),
  ADD KEY `id_permintaan` (`id_permintaan`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `id_barang` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `tb_permintaan`
--
ALTER TABLE `tb_permintaan`
  MODIFY `id_permintaan` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_spb`
--
ALTER TABLE `tb_spb`
  MODIFY `id_spb` bigint NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
