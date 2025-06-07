package cc.kertaskerja.manrisk.manajemenrisiko.service.rekin;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.Rekin.RekinDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import cc.kertaskerja.manrisk.manajemenrisiko.exception.ResourceNotFoundException;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.RekinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RekinServiceImpl implements RekinService {

    private final RekinRepository rekinRepository;

    private RekinDTO toDTO(Rekin rekin) {
        return new RekinDTO(
                rekin.getId(),
                rekin.getIdRekin(),
                rekin.getNip(),
                rekin.getKodeOpd(),
                rekin.getTahun(),
                rekin.getPenyebabPermasalahan(),
                rekin.getPermasalahan(),
                rekin.getPernyataanRisiko(),
                rekin.getSkalaKemungkinan(),
                rekin.getDampak(),
                rekin.getSkalaDampak(),
                rekin.getPihakYangTerkena(),
                rekin.getKeterangan(),
                rekin.getStatus(),
                rekin.getStatusManrisk(),
                rekin.getVersion(),
                rekin.getCreatedDate(),
                rekin.getUpdatedDate()
        );
    }


    @Override
    public List<RekinDTO> findAll(String kodeOpd, String tahun) {
        return rekinRepository.findAll(kodeOpd, tahun).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RekinDTO findByIdRekin(String kodeOpd, String tahun, String idRekin) {
        Rekin rekin = rekinRepository.findByIdRekin(kodeOpd, tahun, idRekin)
                .orElseThrow(() -> new ResourceNotFoundException("Rekin with ID " + idRekin + " not found"));

        return toDTO(rekin);
    }

    @Override
    public List<RekinDTO> findByNip(String kodeOpd, String tahun, String nip) {
        return rekinRepository.findByNip(kodeOpd, tahun, nip).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RekinDTO save(Rekin rekin) {
        if (rekin.getStatus() == null) {
            rekin.setStatus("UNCHECKED");
        }
        if (rekin.getStatusManrisk() == null) {
            rekin.setStatusManrisk("MenungguVerifikasiAtasan");
        }

        Rekin saved = rekinRepository.save(rekin);

        return toDTO(saved);
    }

    @Override
    @Transactional
    public RekinDTO update(String kodeOpd, String tahun, String nip, String idRekin, RekinDTO rekinRequest) {
        Rekin existingRekin = rekinRepository.findByIdRekin(kodeOpd, tahun, idRekin)
                .orElseThrow(() -> new ResourceNotFoundException("Rekin with ID " + idRekin + " not found for NIP " + nip));

        if (existingRekin.getPenyebabPermasalahan() != null) {
            existingRekin.setPenyebabPermasalahan(existingRekin.getPenyebabPermasalahan());
        }
        if (existingRekin.getPermasalahan() != null) {
            existingRekin.setPermasalahan(existingRekin.getPermasalahan());
        }
        if (existingRekin.getPernyataanRisiko() != null) {
            existingRekin.setPernyataanRisiko(existingRekin.getPernyataanRisiko());
        }
        if (existingRekin.getSkalaKemungkinan() != null) {
            existingRekin.setSkalaKemungkinan(existingRekin.getSkalaKemungkinan());
        }
        if (existingRekin.getDampak() != null) {
            existingRekin.setDampak(existingRekin.getDampak());
        }
        if (existingRekin.getSkalaDampak() != null) {
            existingRekin.setSkalaDampak(existingRekin.getSkalaDampak());
        }
        if (existingRekin.getPihakYangTerkena() != null) {
            existingRekin.setPihakYangTerkena(existingRekin.getPihakYangTerkena());
        }
        if (existingRekin.getKeterangan() != null) {
            existingRekin.setKeterangan(existingRekin.getKeterangan());
        }
        if (existingRekin.getVersion() != null) {
            existingRekin.setVersion(existingRekin.getVersion());
        }
        if (existingRekin.getNip() != null) {
            existingRekin.setNip(existingRekin.getNip());
        }
        if (existingRekin.getKodeOpd() != null) {
            existingRekin.setKodeOpd(existingRekin.getKodeOpd());
        }
        if (existingRekin.getTahun() != null) {
            existingRekin.setTahun(existingRekin.getTahun());
        }
        if (existingRekin.getIdRekin() != null) {
            existingRekin.setIdRekin(existingRekin.getIdRekin());
        }

        Rekin updated = rekinRepository.save(existingRekin);

        return toDTO(updated);
    }

    @Override
    @Transactional
    public void deleteByIdRekin(String kodeOpd, String tahnun, String idRekin) {
        Rekin rekin = rekinRepository.findByIdRekin(kodeOpd, tahnun, idRekin)
                .orElseThrow(() -> new ResourceNotFoundException("Rekin with ID " + idRekin + " not found"));
        rekinRepository.delete(rekin);
    }
}
