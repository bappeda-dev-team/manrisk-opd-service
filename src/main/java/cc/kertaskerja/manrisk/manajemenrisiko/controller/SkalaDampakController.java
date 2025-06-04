package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaDampak;
import cc.kertaskerja.manrisk.manajemenrisiko.service.skaladampak.SkalaDampakService;
import io.micrometer.core.annotation.Timed;
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
    @Timed(value = "skala.dampak.get.all", description = "Time taken to return all skala dampak")
    public ResponseEntity<ApiResponse<List<SkalaDampak>>> getAllData() {
        List<SkalaDampak> skalaDampakList = skalaDampakService.findAll();
        ApiResponse<List<SkalaDampak>> response = ApiResponse.success(skalaDampakList,
                "Retrieved " + skalaDampakList.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ambil data Skala Dampak berdasarkan ID")
    @Timed(value = "skala.dampak.get.by.id", description = "Time taken to return skala dampak by ID")
    public ResponseEntity<ApiResponse<SkalaDampak>> getDataById(@PathVariable Long id) {
        SkalaDampak skalaDampak = skalaDampakService.findById(id);

        ApiResponse<SkalaDampak> response = ApiResponse.success(skalaDampak,
                "Retrieved Skala Dampak with ID " + id + " successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-skala/{skalaDampak}")
    @Operation(summary = "Ambil data Skala Dampak berdasarkan nilai skala dampak")
    public ResponseEntity<ApiResponse<SkalaDampak>> getDataBySkalaDampak(@PathVariable String skalaDampak) {
        SkalaDampak result = skalaDampakService.findBySkalaDampak(skalaDampak);

        ApiResponse<SkalaDampak> response = ApiResponse.success(result,
                "Retrieved Skala Dampak with value " + skalaDampak + " successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Buat data Skala Dampak baru")
    @Timed(value = "skala.dampak.create", description = "Time taken to create new skala dampak")
    public ResponseEntity<ApiResponse<SkalaDampak>> createData(@Valid @RequestBody SkalaDampak skalaDampakRequest) {
        SkalaDampak skalaDampak = skalaDampakService.save(skalaDampakRequest);

        ApiResponse<SkalaDampak> response = ApiResponse.created(skalaDampak);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update data Skala Dampak berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaDampak>> updateData(@PathVariable Long id,
                                                      @RequestBody SkalaDampak skalaDampakRequest) {
        SkalaDampak updatedSkalaDampak = skalaDampakService.update(id, skalaDampakRequest);

        ApiResponse<SkalaDampak> response = ApiResponse.updated(updatedSkalaDampak);

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
