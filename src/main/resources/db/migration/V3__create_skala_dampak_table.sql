DROP TABLE IF EXISTS skala_dampak;

CREATE TABLE skala_dampak (
    id BIGSERIAL PRIMARY KEY,
    skala_dampak VARCHAR(50),
    keterangan_dampak TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP
);

-- Create indexes for better performance
CREATE INDEX idx_skala_dampak_skala ON skala_dampak(skala_dampak);