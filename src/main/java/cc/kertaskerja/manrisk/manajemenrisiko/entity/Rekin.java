package cc.kertaskerja.manrisk.manajemenrisiko.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "rekin")
@EntityListeners(AuditingEntityListener.class)
public class Rekin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull(message = "ID Rekin wajib diisi!")
    @Size(max = 50, message = "ID Rekin tidak boleh lebih dari 50 karakter!")
    @Column(name = "id_rekin", nullable = false, length = 50)
    private String idRekin;

    @NotNull(message = "NIP ASN wajib diisi!")
    @Size(max = 20, message = "NIP ASN tidak boleh lebih dari 20 karakter!")
    @Column(name = "nip_asn", nullable = false, length = 20)
    private String nipAsn;

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
    private String status = "UNCHECKED";

    @Size(max = 100, message = "Status manrisk tidak boleh lebih dari 100 karakter!")
    @Column(name = "status_manrisk", length = 100)
    private String statusManrisk = "MenungguVerifikasiAtasan";

    @NotNull(message = "Version wajib diisi!")
    @Column(name = "version")
    private Integer version;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public Rekin() {}

    public Rekin(String idRekin, String nipAsn, String kodeOpd, String tahun, String penyebabPermasalahan, String permasalahan, String pernyataanRisiko, String skalaKemungkinan, String dampak, String skalaDampak, String pihakYangTerkena, String keterangan, String status, String statusManrisk, Integer version, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.idRekin = idRekin;
        this.nipAsn = nipAsn;
        this.kodeOpd = kodeOpd;
        this.tahun = tahun;
        this.penyebabPermasalahan = penyebabPermasalahan;
        this.permasalahan = permasalahan;
        this.pernyataanRisiko = pernyataanRisiko;
        this.skalaKemungkinan = skalaKemungkinan;
        this.dampak = dampak;
        this.skalaDampak = skalaDampak;
        this.pihakYangTerkena = pihakYangTerkena;
        this.keterangan = keterangan;
        this.status = status;
        this.statusManrisk = statusManrisk;
        this.version = version;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdRekin() {
        return idRekin;
    }

    public void setIdRekin(String idRekin) {
        this.idRekin = idRekin;
    }

    public String getNipAsn() {
        return nipAsn;
    }

    public void setNipAsn(String nipAsn) {
        this.nipAsn = nipAsn;
    }

    public String getKodeOpd() {
        return kodeOpd;
    }

    public void setKodeOpd(String kodeOpd) {
        this.kodeOpd = kodeOpd;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getPenyebabPermasalahan() {
        return penyebabPermasalahan;
    }

    public void setPenyebabPermasalahan(String penyebabPermasalahan) {
        this.penyebabPermasalahan = penyebabPermasalahan;
    }

    public String getPermasalahan() {
        return permasalahan;
    }

    public void setPermasalahan(String permasalahan) {
        this.permasalahan = permasalahan;
    }

    public String getPernyataanRisiko() {
        return pernyataanRisiko;
    }

    public void setPernyataanRisiko(String pernyataanRisiko) {
        this.pernyataanRisiko = pernyataanRisiko;
    }

    public String getSkalaKemungkinan() {
        return skalaKemungkinan;
    }

    public void setSkalaKemungkinan(String skalaKemungkinan) {
        this.skalaKemungkinan = skalaKemungkinan;
    }

    public String getDampak() {
        return dampak;
    }

    public void setDampak(String dampak) {
        this.dampak = dampak;
    }

    public String getSkalaDampak() {
        return skalaDampak;
    }

    public void setSkalaDampak(String skalaDampak) {
        this.skalaDampak = skalaDampak;
    }

    public String getPihakYangTerkena() {
        return pihakYangTerkena;
    }

    public void setPihakYangTerkena(String pihakYangTerkena) {
        this.pihakYangTerkena = pihakYangTerkena;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusManrisk() {
        return statusManrisk;
    }

    public void setStatusManrisk(String statusManrisk) {
        this.statusManrisk = statusManrisk;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Rekin{" +
                "id=" + id +
                ", idRekin='" + idRekin + '\'' +
                ", nipAsn='" + nipAsn + '\'' +
                ", kodeOpd='" + kodeOpd + '\'' +
                ", tahun='" + tahun + '\'' +
                ", penyebabPermasalahan='" + penyebabPermasalahan + '\'' +
                ", permasalahan='" + permasalahan + '\'' +
                ", pernyataanRisiko='" + pernyataanRisiko + '\'' +
                ", skalaKemungkinan='" + skalaKemungkinan + '\'' +
                ", dampak='" + dampak + '\'' +
                ", skalaDampak='" + skalaDampak + '\'' +
                ", pihakYangTerkena='" + pihakYangTerkena + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", status='" + status + '\'' +
                ", statusManrisk='" + statusManrisk + '\'' +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
