package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanCreateDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanSimpleDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaKemungkinan.SkalaKemungkinanUpdateDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.entity.SkalaKemungkinan;
import cc.kertaskerja.manrisk.manajemenrisiko.service.skalakemungkinan.SkalaKemungkinanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skala-kemungkinan")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Skala Kemungkinan", description = "API Skala Kemungkinan untuk manajemen risiko")
public class SkalaKemungkinanController {

    private final SkalaKemungkinanService skalaKemungkinanService;

    @GetMapping
    @Operation(summary = "Ambil semua data Skala Kemungkinan")
    public ResponseEntity<ApiResponse<List<SkalaKemungkinanSimpleDTO>>> getAllData() {
        List<SkalaKemungkinanSimpleDTO> skalaKemungkinanList = skalaKemungkinanService.findAll();
        ApiResponse<List<SkalaKemungkinanSimpleDTO>> response = ApiResponse.success(skalaKemungkinanList,
                "Retrieved " + skalaKemungkinanList.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ambil data Skala Kemungkinan berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaKemungkinanSimpleDTO>> getDataById(@PathVariable Long id) {
        SkalaKemungkinanSimpleDTO skalaKemungkinan = skalaKemungkinanService.findById(id);
        ApiResponse<SkalaKemungkinanSimpleDTO> response = ApiResponse.success(skalaKemungkinan,
                "Retrieved Skala Kemungkinan with ID " + id + " successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Buat data Skala Kemungkinan baru")
    public ResponseEntity<ApiResponse<SkalaKemungkinanCreateDTO>> createData(@Valid @RequestBody SkalaKemungkinanSimpleDTO skalaKemungkinanRequestDto) {
        SkalaKemungkinan skalaKemungkinan = new SkalaKemungkinan();
        skalaKemungkinan.setSkalaKemungkinan(skalaKemungkinanRequestDto.getSkalaKemungkinan());
        skalaKemungkinan.setKeteranganKemungkinan(skalaKemungkinanRequestDto.getKeteranganKemungkinan());

        SkalaKemungkinanCreateDTO createDTO = skalaKemungkinanService.save(skalaKemungkinan);
        ApiResponse<SkalaKemungkinanCreateDTO> response = ApiResponse.created(createDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update data Skala Kemungkinan berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaKemungkinanUpdateDTO>> updateData(@PathVariable Long id,
                                                                             @RequestBody SkalaKemungkinanSimpleDTO skalaKemungkinanRequestDto) {
        SkalaKemungkinan skalaKemungkinan = new SkalaKemungkinan();
        skalaKemungkinan.setSkalaKemungkinan(skalaKemungkinanRequestDto.getSkalaKemungkinan());
        skalaKemungkinan.setKeteranganKemungkinan(skalaKemungkinanRequestDto.getKeteranganKemungkinan());

        SkalaKemungkinanUpdateDTO updateDTO = skalaKemungkinanService.update(id, skalaKemungkinan);
        ApiResponse<SkalaKemungkinanUpdateDTO> response = ApiResponse.updated(updateDTO);

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
