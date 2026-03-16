package com.lucca.clientservice.controller;

import com.lucca.clientservice.dto.ClientRequestDTO;
import com.lucca.clientservice.dto.ClientResponseDTO;
import com.lucca.clientservice.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> inserir (@Valid @RequestBody ClientRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.inserir(request));
    }

    @PostMapping("/{cpf}/vehicles/{placa}")
    public ResponseEntity<ClientResponseDTO> associarPlaca(@PathVariable String cpf, @PathVariable String placa){
        return ResponseEntity.ok(service.associarPlaca(cpf, placa));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> alterar (@PathVariable String cpf, @Valid @RequestBody ClientRequestDTO request){
        return ResponseEntity.ok(service.alterar(cpf, request));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> buscarPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf){
        service.deletar(cpf);

        return ResponseEntity.noContent().build();
    }
}
