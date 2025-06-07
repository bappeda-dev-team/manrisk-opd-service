package cc.kertaskerja.manrisk.manajemenrisiko.service.rekin;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.Rekin.RekinDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RekinService {

//    List<Rekin> findAll(String kodeOpd, String tahun);
//
//    Rekin findByIdRekin(String kodeOpd, String tahun, String idRekin);
//
//    List<Rekin> findByNip(String kodeOpd, String tahun, String nip);
//
//    Rekin save(Rekin rekin);
//
//    Rekin update(String kodeOpd, String tahun, String nip, String idRekin, Rekin rekinRequest);
//
//    void deleteByIdRekin(String kodeOpd, String tahun, String idRekin);

    List<RekinDTO> findAll(String kodeOpd, String tahun);

    RekinDTO findByIdRekin(String kodeOpd, String tahun, String idRekin);

    List<RekinDTO> findByNip(String kodeOpd, String tahun, String nip);

    RekinDTO save(Rekin rekin);

    RekinDTO update(String kodeOpd, String tahun, String nip, String idRekin, RekinDTO rekinRequest);

    void deleteByIdRekin(String kodeOpd, String tahnun, String idRekin);
}
