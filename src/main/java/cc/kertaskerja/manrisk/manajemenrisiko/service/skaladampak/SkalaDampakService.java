package cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakCreatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakSimpleDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakUpdatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;

import java.util.List;

public interface SkalaDampakService {
    List<SkalaDampakSimpleDTO> findAll();

    SkalaDampakSimpleDTO findById(Long id);

    SkalaDampakCreatedDTO save(SkalaDampak skalaDampak);

    SkalaDampakUpdatedDTO update(Long id, SkalaDampak skalaDampak);

    void deleteById(Long id);
}
