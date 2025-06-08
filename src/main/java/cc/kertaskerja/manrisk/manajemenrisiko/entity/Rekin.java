package cc.kertaskerja.manrisk.manajemenrisiko.entity;

import cc.kertaskerja.manrisk.manajemenrisiko.common.BaseAuditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "rekin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Rekin extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "ID Rekin wajib diisi!")
    @Size(max = 50, message = "ID Rekin tidak boleh lebih dari 50 karakter!")
    @Column(name = "id_rekin", nullable = false, length = 50)
    private String idRekin;

    @NotNull(message = "NIP wajib diisi!")
    @Size(max = 20, message = "NIP tidak boleh lebih dari 20 karakter!")
    @Column(name = "nip", nullable = false, length = 20)
    private String nip;

    @NotNull(message = "Kode OPD wajib diisi!")
    @Size(max = 50, message = "Kode OPD tidak boleh lebih dari 50 karakter!")
    @Column(name = "kode_opd", nullable = false, length = 50)
    private String kodeOpd;

    @NotNull(message = "Tahun wajib diisi!")
    @Pattern(regexp = "\\d{4}", message = "Tahun harus berformat 4 digit!")
    @Column(name = "tahun", nullable = false, length = 4)
    private String tahun;

    @Size(max = 5000, message = "Penyebab permasalahan tidak boleh lebih dari 5000 karakter!")
    @Column(name = "penyebab_permasalahan", columnDefinition = "TEXT")
    private String penyebabPermasalahan;

    @Size(max = 5000, message = "Permasalahan tidak boleh lebih dari 5000 karakter!")
    @Column(name = "permasalahan", columnDefinition = "TEXT")
    private String permasalahan;

    @Size(max = 5000, message = "Pernyataan risiko tidak boleh lebih dari 5000 karakter!")
    @Column(name = "pernyataan_risiko", columnDefinition = "TEXT")
    private String pernyataanRisiko;

    @NotNull(message = "Skala Kemungkinan wajib diisi!")
    @Size(max = 50, message = "Skala kemungkinan tidak boleh lebih dari 50 karakter!")
    @Column(name = "skala_kemungkinan", length = 50)
    private String skalaKemungkinan;

    @Size(max = 5000, message = "Dampak tidak boleh lebih dari 5000 karakter!")
    @Column(name = "dampak", columnDefinition = "TEXT")
    private String dampak;

    @NotNull(message = "Skala Dampak wajib diisi!")
    @Size(max = 50, message = "Skala dampak tidak boleh lebih dari 50 karakter!")
    @Column(name = "skala_dampak", length = 50)
    private String skalaDampak;

    @Size(max = 5000, message = "Pihak yang terkena tidak boleh lebih dari 5000 karakter!")
    @Column(name = "pihak_yang_terkena", columnDefinition = "TEXT")
    private String pihakYangTerkena;

    @Size(max = 5000, message = "Keterangan tidak boleh lebih dari 5000 karakter!")
    @Column(name = "keterangan", columnDefinition = "TEXT")
    private String keterangan;

    @Size(max = 50, message = "Status tidak boleh lebih dari 50 karakter!")
    @Column(name = "status", length = 50)
    @Builder.Default
    private String status = "UNCHECKED";

    @Size(max = 100, message = "Status manrisk tidak boleh lebih dari 100 karakter!")
    @Column(name = "status_manrisk", length = 100)
    @Builder.Default
    private String statusManrisk = "MenungguVerifikasiAtasan";

    @Version
    @Column(name = "version")
    private Integer version;
}
