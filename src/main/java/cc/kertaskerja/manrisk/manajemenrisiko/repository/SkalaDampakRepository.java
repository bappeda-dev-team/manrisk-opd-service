package cc.kertaskerja.manrisk.manajemenrisiko.repository;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SkalaDampakRepository extends JpaRepository<SkalaDampak, Long> {

}