package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaKemungkinan;
import cc.kertaskerja.manrisk.manajemenrisiko.service.skalakemungkinan.SkalaKemungkinanService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skala-kemungkinan")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SkalaKemungkinanController {

    private final SkalaKemungkinanService skalaKemungkinanService;

    @GetMapping
    @Operation(summary = "Ambil semua data Skala Kemungkinan")
    public ResponseEntity<ApiResponse<List<SkalaKemungkinan>>> getAllData() {
        List<SkalaKemungkinan> skalaKemungkinanList = skalaKemungkinanService.findAll();
        ApiResponse<List<SkalaKemungkinan>> response = ApiResponse.success(skalaKemungkinanList,
                "Retrieved " + skalaKemungkinanList.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ambil data Skala Kemungkinan berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaKemungkinan>> getDataById(@PathVariable Long id) {
        SkalaKemungkinan skalaKemungkinan = skalaKemungkinanService.findById(id);

        ApiResponse<SkalaKemungkinan> response = ApiResponse.success(skalaKemungkinan,
                "Retrieved Skala Kemungkinan with ID " + id + " successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Buat data Skala Kemungkinan baru")
    public ResponseEntity<ApiResponse<SkalaKemungkinan>> createData(@RequestBody SkalaKemungkinan skalaKemungkinanRequest) {
        SkalaKemungkinan skalaKemungkinan = skalaKemungkinanService.save(skalaKemungkinanRequest);

        ApiResponse<SkalaKemungkinan> response = ApiResponse.created(skalaKemungkinan);

        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update data Skala Kemungkinan berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaKemungkinan>> updateData(@PathVariable Long id,
                                                                   @RequestBody SkalaKemungkinan skalaKemungkinanRequest) {
        SkalaKemungkinan updatedSkalaKemungkinan = skalaKemungkinanService.update(id, skalaKemungkinanRequest);

        ApiResponse<SkalaKemungkinan> response = ApiResponse.updated(updatedSkalaKemungkinan);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Hapus data Skala Kemungkinan berdasarkan ID")
    public ResponseEntity<ApiResponse<Void>> deleteData(@PathVariable Long id) {
        skalaKemungkinanService.deleteById(id);

        ApiResponse<Void> response = ApiResponse.deleted();

        return ResponseEntity.ok(response);
    }
}
