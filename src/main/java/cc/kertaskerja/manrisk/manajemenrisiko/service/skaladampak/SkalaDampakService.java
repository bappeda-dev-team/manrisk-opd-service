package cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkalaDampakService {

    List<SkalaDampak> findAll();

    SkalaDampak findById(Long id);

    SkalaDampak findBySkalaDampak(String skalaDampak);

    SkalaDampak save(SkalaDampak skalaDampak);

    SkalaDampak update(Long id, SkalaDampak skalaDampak);

    void deleteById(Long id);
}