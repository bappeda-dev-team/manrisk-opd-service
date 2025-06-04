package cc.kertaskerja.manrisk.manajemenrisiko.service.skalakemungkinan;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaKemungkinan;

import java.util.List;

public interface SkalaKemungkinanService {

    List<SkalaKemungkinan> findAll();

    SkalaKemungkinan findById(Long id);

    SkalaKemungkinan save(SkalaKemungkinan skalaKemungkinan);

    SkalaKemungkinan update(Long id, SkalaKemungkinan skalaKemungkinan);

    void deleteById(Long id);
}
