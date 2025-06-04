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
    public Rekin save(Rekin rekin) {
        if (rekin.getStatus() == null) {
            rekin.setStatus("UNCHECKED");
        }
        if (rekin.getStatusManrisk() == null) {
            rekin.setStatusManrisk("MenungguVerifikasiAtasan");
        }

        return rekinRepository.save(rekin);
    }

    @Override
    @Transactional
    public Rekin update(String kodeOpd, String tahun, String nip, String idRekin, Rekin rekinRequest) {
        Optional<Rekin> existingRekinOpt = rekinRepository.findRekinForUpdate(kodeOpd, tahun, nip, idRekin);

        if (existingRekinOpt.isEmpty()) {
            throw new ResourceNotFoundException("Rekin with ID " + idRekin + " not found for NIP " + nip);
        }

        Rekin existingRekin = existingRekinOpt.get();

        if (rekinRequest.getPenyebabPermasalahan() != null) {
            existingRekin.setPenyebabPermasalahan(rekinRequest.getPenyebabPermasalahan());
        }
        if (rekinRequest.getPermasalahan() != null) {
            existingRekin.setPermasalahan(rekinRequest.getPermasalahan());
        }
        if (rekinRequest.getPernyataanRisiko() != null) {
            existingRekin.setPernyataanRisiko(rekinRequest.getPernyataanRisiko());
        }
        if (rekinRequest.getSkalaKemungkinan() != null) {
            existingRekin.setSkalaKemungkinan(rekinRequest.getSkalaKemungkinan());
        }
        if (rekinRequest.getDampak() != null) {
            existingRekin.setDampak(rekinRequest.getDampak());
        }
        if (rekinRequest.getSkalaDampak() != null) {
            existingRekin.setSkalaDampak(rekinRequest.getSkalaDampak());
        }
        if (rekinRequest.getPihakYangTerkena() != null) {
            existingRekin.setPihakYangTerkena(rekinRequest.getPihakYangTerkena());
        }
        if (rekinRequest.getKeterangan() != null) {
            existingRekin.setKeterangan(rekinRequest.getKeterangan());
        }
        if (rekinRequest.getVersion() != null) {
            existingRekin.setVersion(rekinRequest.getVersion());
        }
        if (rekinRequest.getNipAsn() != null) {
            existingRekin.setNipAsn(rekinRequest.getNipAsn());
        }
        if (rekinRequest.getKodeOpd() != null) {
            existingRekin.setKodeOpd(rekinRequest.getKodeOpd());
        }
        if (rekinRequest.getTahun() != null) {
            existingRekin.setTahun(rekinRequest.getTahun());
        }
        if (rekinRequest.getIdRekin() != null) {
            existingRekin.setIdRekin(rekinRequest.getIdRekin());
        }

        // Reset status as per SPEC requirement
        existingRekin.setStatus("UNCHECKED");
        existingRekin.setStatusManrisk("MenungguVerifikasiAtasan");

        return rekinRepository.save(existingRekin);
    }

    @Override
    @Transactional
    public void deleteByIdRekin(String kodeOpd, String tahun, String idRekin) {
        Optional<Rekin> rekinOpt = rekinRepository.findByIdRekin(kodeOpd, tahun, idRekin);

        if (rekinOpt.isEmpty()) {
            throw new ResourceNotFoundException("Rekin with ID " + idRekin + " not found");
        }

        rekinRepository.delete(rekinOpt.get());
    }
}
