package cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampakDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import cc.kertaskerja.manrisk.manajemenrisiko.exception.ResourceNotFoundException;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.SkalaDampakRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkalaDampakServiceImpl implements SkalaDampakService {

    private final SkalaDampakRepository skalaDampakRepository;

    private SkalaDampakDTO toDTO(SkalaDampak skalaDampak) {
        return new SkalaDampakDTO(
                skalaDampak.getId(),
                skalaDampak.getSkalaDampak(),
                skalaDampak.getKeteranganDampak()
        );
    }

    @Override
    public List<SkalaDampakDTO> findAll() {
        return skalaDampakRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SkalaDampakDTO findById(Long id) {
        SkalaDampak skalaDampak = skalaDampakRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with ID " + id + " not found"));
        return toDTO(skalaDampak);
    }

    @Override
    public SkalaDampakDTO findBySkalaDampak(String skalaDampak) {
        SkalaDampak result = skalaDampakRepository.findBySkalaDampak(skalaDampak)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with value " + skalaDampak + " not found"));
        return toDTO(result);
    }

    @Override
    @Transactional
    public SkalaDampakDTO save(SkalaDampak skalaDampak) {
        SkalaDampak saved = skalaDampakRepository.save(skalaDampak);
        return toDTO(saved);
    }

    @Override
    @Transactional
    public SkalaDampakDTO update(Long id, SkalaDampak skalaDampakRequest) {
        SkalaDampak existingSkalaDampak = skalaDampakRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with ID " + id + " not found"));

        if (skalaDampakRequest.getSkalaDampak() != null) {
            existingSkalaDampak.setSkalaDampak(skalaDampakRequest.getSkalaDampak());
        }
        if (skalaDampakRequest.getKeteranganDampak() != null) {
            existingSkalaDampak.setKeteranganDampak(skalaDampakRequest.getKeteranganDampak());
        }

        SkalaDampak updated = skalaDampakRepository.save(existingSkalaDampak);
        return toDTO(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        SkalaDampak skalaDampak = skalaDampakRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skala Dampak with ID " + id + " not found"));
        skalaDampakRepository.delete(skalaDampak);
    }
}
