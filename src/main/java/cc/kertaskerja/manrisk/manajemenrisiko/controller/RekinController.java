package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import cc.kertaskerja.manrisk.manajemenrisiko.service.rekin.RekinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Tag(name = "Rekin", description = "API Rekin untuk manajemen risiko")
public class RekinController {

    private final RekinService rekinService;

    public RekinController(RekinService rekinService) {
        this.rekinService = rekinService;
    }

    @GetMapping("/manrisk/{kodeOpd}/{tahun}")
    @Operation(summary = "Ambil semua data Rekin berdasarkan Kode OPD dan Tahun")
    public ResponseEntity<ApiResponse<List<Rekin>>> getAllData(@PathVariable String kodeOpd,
                                                               @PathVariable String tahun) {
        List<Rekin> rekins = rekinService.findAll(kodeOpd, tahun);
        ApiResponse<List<Rekin>> response = ApiResponse.success(rekins,
                "Retrieved " + rekins.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/manrisk/getByIdRekin/{kodeOpd}/{tahun}/{idRekin}")
    @Operation(summary = "Ambil data Rekin berdasarkan ID Rekin")
    public ResponseEntity<ApiResponse<Rekin>> getDataByIdRekin(@PathVariable String kodeOpd,
                                                               @PathVariable String tahun,
                                                               @PathVariable String idRekin) {
        Rekin rekin = rekinService.findByIdRekin(kodeOpd, tahun, idRekin);

        ApiResponse<Rekin> response = ApiResponse.success(rekin,
                "Retrieved " + rekin.getIdRekin() + " data by Id Rekin successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/manrisk/getByNip/{kodeOpd}/{tahun}/{nip}")
    @Operation(summary = "Ambil semua data Rekin berdasarkan Kode OPD, NIP, dan Tahun")
    public ResponseEntity<ApiResponse<List<Rekin>>> getDataByNIP(@PathVariable String kodeOpd,
                                                                 @PathVariable String tahun,
                                                                 @PathVariable String nip) {
        List<Rekin> rekins = rekinService.findByNip(kodeOpd, tahun, nip);

        ApiResponse<List<Rekin>> response = ApiResponse.success(rekins,
                "Retrieved " + rekins.size() + " data by NIP successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/manrisk")
    @Operation(summary = "Buat data Rekin baru")
    public ResponseEntity<ApiResponse<Rekin>> createData(@Valid @RequestBody Rekin rekinRequest) {
        Rekin rekin = new Rekin(
                rekinRequest.getIdRekin(),
                rekinRequest.getNipAsn(),
                rekinRequest.getKodeOpd(),
                rekinRequest.getTahun(),
                rekinRequest.getPenyebabPermasalahan(),
                rekinRequest.getPermasalahan(),
                rekinRequest.getPernyataanRisiko(),
                rekinRequest.getSkalaKemungkinan(),
                rekinRequest.getDampak(),
                rekinRequest.getSkalaDampak(),
                rekinRequest.getPihakYangTerkena(),
                rekinRequest.getKeterangan(),
                rekinRequest.getStatus() != null ? rekinRequest.getStatus() : "UNCHECKED",
                rekinRequest.getStatusManrisk() != null ? rekinRequest.getStatusManrisk() : "MenungguVerifikasiAtasan",
                rekinRequest.getVersion(),
                LocalDateTime.now(),     // createdDate
                LocalDateTime.now()      // updatedDate
        );
        rekinService.save(rekin);

        ApiResponse<Rekin> response = ApiResponse.success(rekin,
                "Created data successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}