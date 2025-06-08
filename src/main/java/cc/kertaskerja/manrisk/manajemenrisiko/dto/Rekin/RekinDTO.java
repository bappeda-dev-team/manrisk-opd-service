package cc.kertaskerja.manrisk.manajemenrisiko.dto.Rekin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RekinDTO {
    private Long id;
    private String idRekin;
    private String nip;
    private String kodeOpd;
    private String tahun;
    private String penyebabPermasalahan;
    private String permasalahan;
    private String pernyataanRisiko;
    private String skalaKemungkinan;
    private String dampak;
    private String skalaDampak;
    private String pihakYangTerkena;
    private String keterangan;
    private String status;
    private String statusManrisk;
    private Integer version;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private java.time.LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private java.time.LocalDateTime updatedDate;
}


