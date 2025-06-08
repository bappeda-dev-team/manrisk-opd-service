
-- Insert sample data for rekin table
INSERT INTO rekin (
    id_rekin, nip, kode_opd, tahun,
    penyebab_permasalahan, permasalahan, pernyataan_risiko,
    skala_kemungkinan, dampak, skala_dampak,
    pihak_yang_terkena, keterangan, status, status_manrisk, version,
    created_date, updated_date
) VALUES
-- Record 1: Bappeda - Risk Management Documentation
(
    'REK-2025-001',
    '199001011990011001',
    '1.29.01.01001',
    '2025',
    'Jumlah SDM Bappeda yang terbatas dan kurangnya koordinasi antar bidang',
    'Keterlambatan dalam penyusunan dokumen RAT Tahun N+1',
    'Jika dokumen RAT tidak tersusun tepat waktu maka tidak ada panduan dalam penanggulangan kemiskinan pada tahun berikutnya',
    'Jarang',
    'Intervensi program penanggulangan kemiskinan tidak tepat sasaran dan alokasi anggaran tidak optimal',
    'Tinggi',
    'Pemerintah Kota Madiun, Masyarakat Miskin, dan Stakeholder Terkait',
    'Perlu dilakukan pengendalian dengan penambahan SDM dan perbaikan koordinasi',
    'UNCHECKED',
    'MenungguVerifikasiAtasan',
    1,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),

-- Record 2: DINAS KESEHATAN - Medical Equipment Risk
(
    'REK-2025-002',
    '198505152010012002',
    '1.29.02.02002',
    '2025',
    'Anggaran pemeliharaan alat kesehatan yang tidak mencukupi dan kurangnya teknisi terlatih',
    'Kerusakan alat kesehatan di puskesmas yang tidak dapat segera diperbaiki',
    'Jika alat kesehatan rusak dan tidak diperbaiki maka pelayanan kesehatan masyarakat akan terganggu',
    'Sering',
    'Menurunnya kualitas pelayanan kesehatan dan kepercayaan masyarakat terhadap fasilitas kesehatan',
    'Sedang',
    'Masyarakat pengguna layanan kesehatan dan tenaga medis',
    'Diperlukan peningkatan anggaran pemeliharaan dan pelatihan teknisi',
    'UNCHECKED',
    'MenungguVerifikasiAtasan',
    1,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),

-- Record 3: DINAS PENDIDIKAN - Educational Infrastructure
(
    'REK-2025-003',
    '197712121999031003',
    '1.29.03.03003',
    '2025',
    'Usia bangunan sekolah yang sudah tua dan minimnya dana rehabilitasi',
    'Kerusakan infrastruktur sekolah yang membahayakan keselamatan siswa',
    'Jika infrastruktur sekolah rusak maka proses belajar mengajar akan terganggu dan membahayakan keselamatan',
    'Kadang-kadang',
    'Gangguan proses pembelajaran dan potensi kecelakaan yang mengancam keselamatan siswa',
    'Tinggi',
    'Siswa, guru, dan komunitas sekolah',
    'Perlu segera dilakukan rehabilitasi dan perawatan rutin infrastruktur sekolah',
    'UNCHECKED',
    'MenungguVerifikasiAtasan',
    1,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),

-- Record 4: DINAS PEKERJAAN UMUM - Road Infrastructure
(
    'REK-2025-004',
    '198203201005011004',
    '1.29.04.04004',
    '2025',
    'Intensitas hujan tinggi dan drainase yang tidak memadai',
    'Banjir dan kerusakan jalan akibat sistem drainase yang buruk',
    'Jika sistem drainase tidak diperbaiki maka akan terjadi banjir berulang dan kerusakan infrastruktur',
    'Sering',
    'Gangguan mobilitas masyarakat, kerugian ekonomi, dan kerusakan properti',
    'Tinggi',
    'Masyarakat pengguna jalan dan pelaku usaha',
    'Diperlukan perbaikan sistem drainase dan pemeliharaan jalan secara berkala',
    'UNCHECKED',
    'MenungguVerifikasiAtasan',
    1,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),

-- Record 5: DINAS SOSIAL - Social Aid Distribution
(
    'REK-2025-005',
    '199208081015022005',
    '1.29.05.05005',
    '2025',
    'Sistem database penerima bantuan yang belum terintegrasi dan verifikasi manual',
    'Kesalahan targeting dalam pemberian bantuan sosial kepada masyarakat',
    'Jika targeting bantuan salah maka bantuan tidak tepat sasaran dan terjadi ketidakadilan sosial',
    'Kadang-kadang',
    'Ketidakpuasan masyarakat dan bantuan sosial tidak efektif mengurangi kemiskinan',
    'Sedang',
    'Masyarakat penerima bantuan dan masyarakat yang berhak tetapi tidak menerima',
    'Perlu pengembangan sistem database terintegrasi dan perbaikan mekanisme verifikasi',
    'UNCHECKED',
    'MenungguVerifikasiAtasan',
    1,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);