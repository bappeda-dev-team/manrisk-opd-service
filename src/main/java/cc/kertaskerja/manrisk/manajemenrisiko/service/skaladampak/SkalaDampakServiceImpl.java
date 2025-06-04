package cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import cc.kertaskerja.manrisk.manajemenrisiko.exception.ResourceNotFoundException;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.SkalaDampakRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkalaDampakServiceImpl implements SkalaDampakService {

    private final SkalaDampakRepository skalaDampakRepository;

    @Override
    public List<SkalaDampak> findAll() {
        return skalaDampakRepository.findAll();
    }

    @Override
    public SkalaDampak findById(Long id) {
        Optional<SkalaDampak> result = skalaDampakRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("Skala Dampak with ID " + id + " not found");
        }
    }

    @Override
    public SkalaDampak findBySkalaDampak(String skalaDampak) {
        Optional<SkalaDampak> result = skalaDampakRepository.findBySkalaDampak(skalaDampak);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("Skala Dampak with value " + skalaDampak + " not found");
        }
    }

    @Override
    @Transactional
    public SkalaDampak save(SkalaDampak skalaDampak) {
        return skalaDampakRepository.save(skalaDampak);
    }

    @Override
    @Transactional
    public SkalaDampak update(Long id, SkalaDampak skalaDampakRequest) {
        Optional<SkalaDampak> existingSkalaDampakOpt = skalaDampakRepository.findById(id);

        if (existingSkalaDampakOpt.isEmpty()) {
            throw new ResourceNotFoundException("Skala Dampak with ID " + id + " not found");
        }

        SkalaDampak existingSkalaDampak = existingSkalaDampakOpt.get();

        if (skalaDampakRequest.getSkalaDampak() != null) {
            existingSkalaDampak.setSkalaDampak(skalaDampakRequest.getSkalaDampak());
        }
        if (skalaDampakRequest.getKeteranganDampak() != null) {
            existingSkalaDampak.setKeteranganDampak(skalaDampakRequest.getKeteranganDampak());
        }

        return skalaDampakRepository.save(existingSkalaDampak);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<SkalaDampak> skalaDampakOpt = skalaDampakRepository.findById(id);

        if (skalaDampakOpt.isEmpty()) {
            throw new ResourceNotFoundException("Skala Dampak with ID " + id + " not found");
        }

        skalaDampakRepository.delete(skalaDampakOpt.get());
    }
}