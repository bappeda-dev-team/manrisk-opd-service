package cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkalaDampakSimpleDTO {
    private Long id;
    private Integer skalaDampak;
    private String keteranganDampak;
}