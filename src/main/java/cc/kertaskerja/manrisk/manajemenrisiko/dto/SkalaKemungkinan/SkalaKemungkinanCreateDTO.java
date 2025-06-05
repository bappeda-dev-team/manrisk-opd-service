package cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkalaKemungkinanCreateDTO {
    private Long id;
    private Integer skalaKemungkinan;
    private String keteranganKemungkinan;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createdDate;
}
