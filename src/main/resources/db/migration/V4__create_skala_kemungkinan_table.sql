DROP TABLE IF EXISTS skala_kemungkinan;

CREATE TABLE skala_kemungkinan (
    id BIGSERIAL PRIMARY KEY,
    skala_kemungkinan VARCHAR(50),
    keterangan_kemungkinan TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP
);

-- Create indexes for better performance
CREATE INDEX idx_skala_kemungkinan_skala ON skala_kemungkinan(skala_kemungkinan);