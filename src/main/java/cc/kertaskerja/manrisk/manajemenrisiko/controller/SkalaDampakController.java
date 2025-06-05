package cc.kertaskerja.manrisk.manajemenrisiko.controller;

import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakCreatedDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakSimpleDTO;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.ApiResponse;
import cc.kertaskerja.manrisk.manajemenrisiko.dto.SkalaDampak.SkalaDampakUpdatedDTO;
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
@RequiredArgsConstructor
@Tag(name = "Skala Dampak", description = "API Skala Dampak untuk manajemen risiko")
public class SkalaDampakController {

    private final SkalaDampakService skalaDampakService;

    @GetMapping
    @Operation(summary = "Ambil semua data Skala Dampak")
    public ResponseEntity<ApiResponse<List<SkalaDampakSimpleDTO>>> getAllData() {
        List<SkalaDampakSimpleDTO> skalaDampakList = skalaDampakService.findAll();
        ApiResponse<List<SkalaDampakSimpleDTO>> response = ApiResponse.success(skalaDampakList,
                "Retrieved " + skalaDampakList.size() + " data successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ambil data Skala Dampak berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaDampakSimpleDTO>> getDataById(@PathVariable Long id) {
        SkalaDampakSimpleDTO skalaDampak = skalaDampakService.findById(id);
        ApiResponse<SkalaDampakSimpleDTO> response = ApiResponse.success(skalaDampak,
                "Retrieved Skala Dampak with ID " + id + " successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Buat data Skala Dampak baru")
    public ResponseEntity<ApiResponse<SkalaDampakCreatedDTO>> createData(@Valid @RequestBody SkalaDampakSimpleDTO skalaDampakRequestDto) {
        SkalaDampak skalaDampak = new SkalaDampak();
        skalaDampak.setSkalaDampak(skalaDampakRequestDto.getSkalaDampak());
        skalaDampak.setKeteranganDampak(skalaDampakRequestDto.getKeteranganDampak());

        SkalaDampakCreatedDTO createdDto = skalaDampakService.save(skalaDampak);
        ApiResponse<SkalaDampakCreatedDTO> response = ApiResponse.created(createdDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update data Skala Dampak berdasarkan ID")
    public ResponseEntity<ApiResponse<SkalaDampakUpdatedDTO>> updateData(@PathVariable Long id,
                                                                         @RequestBody SkalaDampakSimpleDTO skalaDampakRequestDto) {
        SkalaDampak skalaDampak = new SkalaDampak();
        skalaDampak.setSkalaDampak(skalaDampakRequestDto.getSkalaDampak());
        skalaDampak.setKeteranganDampak(skalaDampakRequestDto.getKeteranganDampak());

        SkalaDampakUpdatedDTO updatedDto = skalaDampakService.update(id, skalaDampak);
        ApiResponse<SkalaDampakUpdatedDTO> response = ApiResponse.updated(updatedDto);

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
