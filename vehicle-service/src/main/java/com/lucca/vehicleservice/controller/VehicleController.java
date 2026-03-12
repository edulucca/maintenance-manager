package com.lucca.vehicleservice.controller;

import com.lucca.vehicleservice.dto.VehicleRequestDTO;
import com.lucca.vehicleservice.dto.VehicleResponseDTO;
import com.lucca.vehicleservice.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> inserir(@Valid @RequestBody VehicleRequestDTO vehicleRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.inserir(vehicleRequestDTO));
    }

    @PutMapping("/{placa}")
    public ResponseEntity<VehicleResponseDTO> alterar(@PathVariable String placa, @Valid @RequestBody VehicleRequestDTO vehicleRequestDTO){
        return ResponseEntity.ok(vehicleService.alterar(placa, vehicleRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> buscarTodos(){
        return ResponseEntity.ok(vehicleService.listarTodos());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VehicleResponseDTO> buscarPorPlaca(@PathVariable String placa){
        return ResponseEntity.ok(vehicleService.localizarPorPlaca(placa));
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletar(@PathVariable String placa){
        vehicleService.deletar(placa);

        return ResponseEntity.noContent().build();
    }
}
