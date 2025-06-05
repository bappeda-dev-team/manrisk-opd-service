package cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakCreatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakSimpleDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakUpdatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import cc.kertaskerja.manrisk.manajemenrisiko.exception.ResourceNotFoundException;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.SkalaDampakRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkalaDampakServiceImpl implements SkalaDampakService {

    private final SkalaDampakRepository skalaDampakRepository;

    private SkalaDampakSimpleDTO toSimpleDTO(SkalaDampak skalaDampak) {
        return new SkalaDampakSimpleDTO(
                skalaDampak.getId(),
                skalaDampak.getSkalaDampak(),
                skalaDampak.getKeteranganDampak()
        );
    }

    private SkalaDampakCreatedDTO toCreatedDTO(SkalaDampak skalaDampak) {
        return new SkalaDampakCreatedDTO(
                skalaDampak.getId(),
                skalaDampak.getSkalaDampak(),
                skalaDampak.getKeteranganDampak(),
                skalaDampak.getCreatedDate()
        );
    }

    private SkalaDampakUpdatedDTO toUpdatedDTO(SkalaDampak skalaDampak) {
        return new SkalaDampakUpdatedDTO(
                skalaDampak.getId(),
                skalaDampak.getSkalaDampak(),
                skalaDampak.getKeteranganDampak(),
                skalaDampak.getUpdatedDate()
        );
    }

    @Override
    public List<SkalaDampakSimpleDTO> findAll() {
        return skalaDampakRepository.findAll().stream()
                .map(this::toSimpleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SkalaDampakSimpleDTO findById(Long id) {
        SkalaDampak skalaDampak = skalaDampakRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with ID " + id + " not found"));
        return toSimpleDTO(skalaDampak);
    }

    @Override
    @Transactional
    public SkalaDampakCreatedDTO save(SkalaDampak skalaDampak) {
        SkalaDampak saved = skalaDampakRepository.save(skalaDampak);
        return toCreatedDTO(saved);
    }

    @Override
    @Transactional
    public SkalaDampakUpdatedDTO update(Long id, SkalaDampak skalaDampakRequest) {
        SkalaDampak existingSkalaDampak = skalaDampakRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with ID " + id + " not found"));

        if (skalaDampakRequest.getSkalaDampak() != null) {
            existingSkalaDampak.setSkalaDampak(skalaDampakRequest.getSkalaDampak());
        }
        if (skalaDampakRequest.getKeteranganDampak() != null) {
            existingSkalaDampak.setKeteranganDampak(skalaDampakRequest.getKeteranganDampak());
        }

        SkalaDampak updated = skalaDampakRepository.save(existingSkalaDampak);
        return toUpdatedDTO(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        SkalaDampak skalaDampak = skalaDampakRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with ID " + id + " not found"));
        skalaDampakRepository.delete(skalaDampak);
    }
}
