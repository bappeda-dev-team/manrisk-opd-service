package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.Rekin.RekinDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.Rekin;
import cc.kertaskerja.manrisk.manajemenrisiko.service.rekin.RekinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/manrisk")
@CrossOrigin(origins = "*")
@Tag(name = "Rekin", description = "API Rekin untuk manajemen risiko")
@RequiredArgsConstructor
public class RekinController {

    private final RekinService rekinService;

    @GetMapping("/{kodeOpd}/{tahun}")
    @Operation(summary = "Ambil semua data Rekin")
    public ResponseEntity<ApiResponse<List<RekinDTO>>> getAllData(@PathVariable String kodeOpd,
                                                                  @PathVariable String tahun) {
        List<RekinDTO> rekinList = rekinService.findAll(kodeOpd, tahun);
        ApiResponse<List<RekinDTO>> response = ApiResponse.success(rekinList,
                "Retrieved " + rekinList.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByIdRekin/{kodeOpd}/{tahun}/{idRekin}")
    @Operation(summary = "Ambil data Rekin berdasarkan ID Rekin")
    public ResponseEntity<ApiResponse<RekinDTO>> getDataByIdRekin(@PathVariable String kodeOpd,
                                                                  @PathVariable String tahun,
                                                                  @PathVariable String idRekin) {
        RekinDTO rekin = rekinService.findByIdRekin(kodeOpd, tahun, idRekin);
        ApiResponse<RekinDTO> response = ApiResponse.success(rekin,
                "Retrieved " + rekin.getIdRekin() + " data by Id Rekin successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByNip/{kodeOpd}/{tahun}/{nip}")
    @Operation(summary = "Ambil semua data Rekin berdasarkan Kode OPD, NIP, dan Tahun")
    public ResponseEntity<ApiResponse<List<RekinDTO>>> getDataByNIP(@PathVariable String kodeOpd,
                                                                    @PathVariable String tahun,
                                                                    @PathVariable String nip) {
        List<RekinDTO> rekins = rekinService.findByNip(kodeOpd, tahun, nip);
        ApiResponse<List<RekinDTO>> response = ApiResponse.success(rekins,
                "Retrieved " + rekins.size() + " data by NIP successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Buat data Rekin baru")
    public ResponseEntity<ApiResponse<RekinDTO>> createData(@Valid @RequestBody RekinDTO rekinRequestDTO) {
        Rekin rekin = new Rekin();
        BeanUtils.copyProperties(rekinRequestDTO, rekin);

        RekinDTO savedRekin = rekinService.save(rekin);
        ApiResponse<RekinDTO> response = ApiResponse.created(savedRekin);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{kodeOpd}/{tahun}/{nip}/{idRekin}")
    @Operation(summary = "Update data Rekin berdasarkan Kode OPD, Tahun, NIP, dan ID Rekin")
    public ResponseEntity<ApiResponse<RekinDTO>> updateData(@PathVariable String kodeOpd,
                                                            @PathVariable String tahun,
                                                            @PathVariable String nip,
                                                            @PathVariable String idRekin,
                                                            @RequestBody RekinDTO rekinRequestDTO) {
        Rekin rekin = new Rekin();
        BeanUtils.copyProperties(rekinRequestDTO, rekin);

        RekinDTO updatedRekin = rekinService.update(kodeOpd, tahun, nip, idRekin, rekinRequestDTO);
        ApiResponse<RekinDTO> response = ApiResponse.updated(updatedRekin);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{kodeOpd}/{tahun}/{idRekin}")
    @Operation(summary = "Hapus data Rekin berdasarkan Kode OPD, Tahun, dan ID Rekin")
    public ResponseEntity<ApiResponse<Void>> deleteData(@PathVariable String kodeOpd,
                                                        @PathVariable String tahun,
                                                        @PathVariable String idRekin) {
        rekinService.deleteByIdRekin(kodeOpd, tahun, idRekin);
        ApiResponse<Void> response = ApiResponse.deleted();

        return ResponseEntity.ok(response);
    }
}
