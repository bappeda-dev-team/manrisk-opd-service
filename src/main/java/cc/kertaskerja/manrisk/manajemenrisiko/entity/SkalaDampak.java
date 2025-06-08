package cc.kertaskerja.manrisk.manajemenrisiko.entity;

import cc.kertaskerja.manrisk.manajemenrisiko.common.BaseAuditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "skala_dampak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class SkalaDampak extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Skala dampak wajib diisi!")
    @Column(name = "skala_dampak", nullable = false)
    private Integer skalaDampak;

    @NotNull(message = "Keterangan dampak wajib diisi!")
    @Column(name = "keterangan_dampak", columnDefinition = "TEXT")
    private String keteranganDampak;
}