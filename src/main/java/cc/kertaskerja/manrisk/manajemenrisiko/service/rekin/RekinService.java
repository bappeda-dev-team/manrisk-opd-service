package cc.kertaskerja.manrisk.manajemenrisiko.service.rekin;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RekinService {

    List<Rekin> findAll(String kodeOpd, String tahun);

    Rekin findByIdRekin(String kodeOpd, String tahun, String idRekin);

    List<Rekin> findByNip(String kodeOpd, String tahun, String nip);

    void save(Rekin rekin);
}
