package cc.kertaskerja.manrisk.manajemenrisiko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkalaDampakDTO {
    private Long id;
    private Integer skalaDampak;
    private String keteranganDampak;
}
