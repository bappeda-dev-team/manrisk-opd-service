package cc.kertaskerja.manrisk.manajemenrisiko.service.skalakemungkinan;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakUpdatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanCreateDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanSimpleDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanUpdateDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaKemungkinan;

import java.util.List;

public interface SkalaKemungkinanService {
    List<SkalaKemungkinanSimpleDTO> findAll();

    SkalaKemungkinanSimpleDTO findById(Long id);

    SkalaKemungkinanCreateDTO save(SkalaKemungkinan skalaKemungkinan);

    SkalaKemungkinanUpdateDTO update(Long id, SkalaKemungkinan skalaKemungkinan);

    void deleteById(Long id);
}
