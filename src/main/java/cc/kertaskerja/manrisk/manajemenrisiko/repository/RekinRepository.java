package cc.kertaskerja.manrisk.manajemenrisiko.repository;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RekinRepository extends JpaRepository<Rekin, Long> {

     @Query("SELECT r FROM Rekin r WHERE r.kodeOpd = :kodeOpd AND r.tahun = :tahun")
     List<Rekin> findAll(@Param("kodeOpd") String kodeOpd,
                         @Param("tahun") String tahun);

     @Query("SELECT r FROM Rekin r WHERE r.kodeOpd = :kodeOpd AND r.tahun = :tahun AND r.idRekin = :idRekin")
     Optional<Rekin> findByIdRekin(@Param("kodeOpd") String kodeOpd,
                                   @Param("tahun") String tahun,
                                   @Param("idRekin") String idRekin);

     @Query("SELECT r FROM Rekin r WHERE r.kodeOpd = :kodeOpd AND r.tahun = :tahun AND r.nip = :nip")
     List<Rekin> findByNip(@Param("kodeOpd") String kodeOpd,
                           @Param("tahun") String tahun,
                           @Param("nip") String nip);

     @Query("SELECT r FROM Rekin r WHERE r.kodeOpd = :kodeOpd AND r.tahun = :tahun AND r.nip = :nip AND r.idRekin = :idRekin")
     Optional<Rekin> findRekinForUpdate(@Param("kodeOpd") String kodeOpd,
                                        @Param("tahun") String tahun,
                                        @Param("nip") String nip,
                                        @Param("idRekin") String idRekin);
}
