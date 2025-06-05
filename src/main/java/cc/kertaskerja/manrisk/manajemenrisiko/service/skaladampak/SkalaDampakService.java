package cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampakDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;

import java.util.List;

public interface SkalaDampakService {
    List<SkalaDampakDTO> findAll();

    SkalaDampakDTO findById(Long id);

    SkalaDampakDTO save(SkalaDampak skalaDampak);

    SkalaDampakDTO update(Long id, SkalaDampak skalaDampak);

    void deleteById(Long id);
}
