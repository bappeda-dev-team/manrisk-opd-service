package cc.kertaskerja.manrisk.manajemenrisiko.entity;

import cc.kertaskerja.manrisk.manajemenrisiko.common.BaseAuditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "skala_kemungkinan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class SkalaKemungkinan extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Skala kemungkinan wajib diisi!")
    @Column(name = "skala_kemungkinan", nullable = false)
    private Integer skalaKemungkinan;

    @NotNull(message = "Keterangan kemungkinan wajib diisi!")
    @Column(name = "keterangan_kemungkinan", columnDefinition = "TEXT")
    private String keteranganKemungkinan;
}
