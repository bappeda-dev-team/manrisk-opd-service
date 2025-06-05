package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampakDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak.SkalaDampakService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skala-dampak")
@CrossOrigin(origins = "*")
@Tag(name = "Skala Dampak", description = "API Skala Dampak untuk manajemen risiko")
@RequiredArgsConstructor
public class SkalaDampakController {

    private final SkalaDampakService skalaDampakService;

    @GetMapping
    @Operation(summary = "Ambil semua data Skala Dampak")
    public ResponseEntity<ApiResponse<List<SkalaDampakDTO>>> getAllData() {
        List<SkalaDampakDTO> skalaDampakList = skalaDampakService.findAll();
        ApiResponse<List<SkalaDampakDTO>> response = ApiResponse.success(skalaDampakList,
                "Retrieved " + skalaDampakList.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ambil data Skala Dampak berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaDampakDTO>> getDataById(@PathVariable Long id) {
        SkalaDampakDTO skalaDampak = skalaDampakService.findById(id);

        ApiResponse<SkalaDampakDTO> response = ApiResponse.success(skalaDampak,
                "Retrieved Skala Dampak with ID " + id + " successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Buat data Skala Dampak baru")
    public ResponseEntity<ApiResponse<SkalaDampakDTO>> createData(@Valid @RequestBody SkalaDampakDTO skalaDampakRequestDto) {
        // Convert DTO to Entity before saving
        SkalaDampak skalaDampak = new SkalaDampak();
        skalaDampak.setSkalaDampak(skalaDampakRequestDto.getSkalaDampak());
        skalaDampak.setKeteranganDampak(skalaDampakRequestDto.getKeteranganDampak());

        SkalaDampakDTO savedDto = skalaDampakService.save(skalaDampak);

        ApiResponse<SkalaDampakDTO> response = ApiResponse.created(savedDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update data Skala Dampak berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaDampakDTO>> updateData(@PathVariable Long id,
                                                                  @RequestBody SkalaDampakDTO skalaDampakRequestDto) {
        SkalaDampak skalaDampak = new SkalaDampak();
        skalaDampak.setSkalaDampak(skalaDampakRequestDto.getSkalaDampak());
        skalaDampak.setKeteranganDampak(skalaDampakRequestDto.getKeteranganDampak());

        SkalaDampakDTO updatedDto = skalaDampakService.update(id, skalaDampak);

        ApiResponse<SkalaDampakDTO> response = ApiResponse.updated(updatedDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Hapus data Skala Dampak berdasarkan ID")
    public ResponseEntity<ApiResponse<Void>> deleteData(@PathVariable Long id) {
        skalaDampakService.deleteById(id);

        ApiResponse<Void> response = ApiResponse.deleted();

        return ResponseEntity.ok(response);
    }
}
