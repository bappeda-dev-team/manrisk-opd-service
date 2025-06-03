package cc.kertaskerja.manrisk.manajemenrisiko.service.rekin;

import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import cc.kertaskerja.manrisk.manajemenrisiko.exception.ResourceNotFoundException;
import cc.kertaskerja.manrisk.manajemenrisiko.repository.RekinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RekinServiceImpl implements RekinService {

    private RekinRepository rekinRepository;

    @Autowired
    public RekinServiceImpl(RekinRepository theRekinRepository) {
        rekinRepository = theRekinRepository;
    }

    @Override
    public List<Rekin> findAll(String kodeOpd, String tahun) {
        return rekinRepository.findAll(kodeOpd, tahun);
    }

    @Override
    public Rekin findByIdRekin(String kodeOpd, String tahun, String idRekin) {
        Optional<Rekin> result = rekinRepository.findByIdRekin(kodeOpd, tahun, idRekin);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("Data is not found");
        }
    }

    @Override
    public List<Rekin> findByNip(String kodeOpd, String tahun, String nip) {
        List<Rekin> result = rekinRepository.findByNip(kodeOpd, tahun, nip);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Data is not found");
        } else {
            return result;
        }
    }

    @Override
    @Transactional
    public void save(Rekin rekin) {
        rekinRepository.save(rekin);
    }
}
