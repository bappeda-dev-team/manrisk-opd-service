package cc.kertaskerja.manrisk.manajemenrisiko.service.skalakemungkinan;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaKemungkinan;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.SkalaKemungkinanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkalaKemungkinanServiceImpl implements SkalaKemungkinanService {

    private final SkalaKemungkinanRepository skalaKemungkinanRepository;

    @Override
    public List<SkalaKemungkinan> findAll() {
        return skalaKemungkinanRepository.findAll();
    }

    @Override
    public SkalaKemungkinan findById(Long id) {
        Optional<SkalaKemungkinan> result = skalaKemungkinanRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Skala Kemungkinan with ID " + id + " not found");
        }
    }

    @Override
    public SkalaKemungkinan save(SkalaKemungkinan skalaKemungkinan) {
        return skalaKemungkinanRepository.save(skalaKemungkinan);
    }

    @Override
    @Transactional
    public SkalaKemungkinan update(Long id, SkalaKemungkinan skalaKemungkinan) {
        Optional<SkalaKemungkinan> existingSkalaKemungkinanOpt = skalaKemungkinanRepository.findById(id);

        if (existingSkalaKemungkinanOpt.isEmpty()) {
            throw new RuntimeException("Skala Kemungkinan with ID " + id + " not found");
        }

        SkalaKemungkinan existingSkalaKemungkinan = existingSkalaKemungkinanOpt.get();

        if (skalaKemungkinan.getSkalaKemungkinan() != null) {
            existingSkalaKemungkinan.setSkalaKemungkinan(skalaKemungkinan.getSkalaKemungkinan());
        }
        if (skalaKemungkinan.getKeteranganKemungkinan() != null) {
            existingSkalaKemungkinan.setKeteranganKemungkinan(skalaKemungkinan.getKeteranganKemungkinan());
        }

        return skalaKemungkinanRepository.save(existingSkalaKemungkinan);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<SkalaKemungkinan> skalaKemungkinanOpt = skalaKemungkinanRepository.findById(id);

        if (skalaKemungkinanOpt.isEmpty()) {
            throw new RuntimeException("Skala Kemungkinan with ID " + id + " not found");
        }

        skalaKemungkinanRepository.delete(skalaKemungkinanOpt.get());
    }
}
