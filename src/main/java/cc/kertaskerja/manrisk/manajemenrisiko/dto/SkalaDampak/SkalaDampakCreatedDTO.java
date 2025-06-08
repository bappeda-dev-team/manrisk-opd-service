package cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkalaDampakCreatedDTO {
    private Long id;
    private Integer skalaDampak;
    private String keteranganDampak;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createdDate;
}

