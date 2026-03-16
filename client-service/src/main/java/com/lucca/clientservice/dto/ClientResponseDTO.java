package com.lucca.clientservice.dto;

import java.util.List;

public record ClientResponseDTO (
     String id,

     String cpf,

     String nome,

     String telefone,

     String email,

     List<String> vehicles
) {}
