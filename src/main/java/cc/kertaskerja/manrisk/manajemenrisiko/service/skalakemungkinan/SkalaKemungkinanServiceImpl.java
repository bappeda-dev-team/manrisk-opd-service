package cc.kertaskerja.manrisk.manajemenrisiko.service.skalakemungkinan;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakUpdatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanCreateDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanSimpleDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanUpdateDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaKemungkinan;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.SkalaKemungkinanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkalaKemungkinanServiceImpl implements SkalaKemungkinanService {

    private final SkalaKemungkinanRepository skalaKemungkinanRepository;

    private SkalaKemungkinanSimpleDTO toSimpleDTO(SkalaKemungkinan skalaKemungkinan) {
        return new SkalaKemungkinanSimpleDTO(
                skalaKemungkinan.getId(),
                skalaKemungkinan.getSkalaKemungkinan(),
                skalaKemungkinan.getKeteranganKemungkinan()
        );
    }

    private SkalaKemungkinanCreateDTO toCreateDTO(SkalaKemungkinan skalaKemungkinan) {
        return new SkalaKemungkinanCreateDTO(
                skalaKemungkinan.getId(),
                skalaKemungkinan.getSkalaKemungkinan(),
                skalaKemungkinan.getKeteranganKemungkinan(),
                skalaKemungkinan.getCreatedDate()
        );
    }

    private SkalaKemungkinanUpdateDTO toUpdateDTO(SkalaKemungkinan skalaKemungkinan) {
        return new SkalaKemungkinanUpdateDTO(
                skalaKemungkinan.getId(),
                skalaKemungkinan.getSkalaKemungkinan(),
                skalaKemungkinan.getKeteranganKemungkinan(),
                skalaKemungkinan.getUpdatedDate()
        );
    }

    @Override
    public List<SkalaKemungkinanSimpleDTO> findAll() {
        return skalaKemungkinanRepository.findAll().stream()
                .map(this::toSimpleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SkalaKemungkinanSimpleDTO findById(Long id) {
        SkalaKemungkinan skalaKemungkinan = skalaKemungkinanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skala Kemungkinan with ID " + id + " not found"));
        return toSimpleDTO(skalaKemungkinan);
    }

    @Override
    @Transactional
    public SkalaKemungkinanCreateDTO save(SkalaKemungkinan skalaKemungkinan) {
        SkalaKemungkinan saved = skalaKemungkinanRepository.save(skalaKemungkinan);
        return toCreateDTO(saved);
    }

    @Override
    @Transactional
    public SkalaKemungkinanUpdateDTO update(Long id, SkalaKemungkinan skalaKemungkinanRequest) {
        SkalaKemungkinan existingSkalaKemungkinan = skalaKemungkinanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skala Kemungkinan with ID " + id + " not found"));

        if (skalaKemungkinanRequest.getSkalaKemungkinan() != null) {
            existingSkalaKemungkinan.setSkalaKemungkinan(skalaKemungkinanRequest.getSkalaKemungkinan());
        }
        if (skalaKemungkinanRequest.getKeteranganKemungkinan() != null) {
            existingSkalaKemungkinan.setKeteranganKemungkinan(skalaKemungkinanRequest.getKeteranganKemungkinan());
        }

        SkalaKemungkinan updated = skalaKemungkinanRepository.save(existingSkalaKemungkinan);
        return toUpdateDTO(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        SkalaKemungkinan skalaKemungkinan = skalaKemungkinanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skala Kemungkinan with ID " + id + " not found"));
        skalaKemungkinanRepository.delete(skalaKemungkinan);
    }
}
