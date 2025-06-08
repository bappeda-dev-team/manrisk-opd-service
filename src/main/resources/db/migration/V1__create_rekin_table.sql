DROP TABLE IF EXISTS rekin;

CREATE TABLE rekin (
                       id BIGSERIAL PRIMARY KEY,
                       id_rekin VARCHAR(50) NOT NULL,
                       nip VARCHAR(20) NOT NULL,
                       kode_opd VARCHAR(50) NOT NULL,
                       tahun VARCHAR(4) NOT NULL,
                       penyebab_permasalahan TEXT,
                       permasalahan TEXT,
                       pernyataan_risiko TEXT,
                       skala_kemungkinan VARCHAR(50),
                       dampak TEXT,
                       skala_dampak VARCHAR(50),
                       pihak_yang_terkena TEXT,
                       keterangan TEXT,
                       status VARCHAR(50) DEFAULT 'UNCHECKED',
                       status_manrisk VARCHAR(100) DEFAULT 'MenungguVerifikasiAtasan',
                       version INTEGER,
                       created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_date TIMESTAMP
);

-- Create indexes for better performance
CREATE INDEX idx_rekin_kode_opd_tahun ON rekin(kode_opd, tahun);
CREATE INDEX idx_rekin_nip ON rekin(nip);
CREATE INDEX idx_rekin_id_rekin ON rekin(id_rekin);
CREATE INDEX idx_rekin_status ON rekin(status);