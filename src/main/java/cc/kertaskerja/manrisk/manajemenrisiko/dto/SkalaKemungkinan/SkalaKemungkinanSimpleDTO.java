package cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkalaKemungkinanSimpleDTO {
    private Long id;
    private Integer skalaKemungkinan;
    private String keteranganKemungkinan;
}
