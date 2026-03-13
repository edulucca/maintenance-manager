package com.lucca.vehicleservice.dto;

public record VehicleResponseDTO (
         String id,

         String placa,

         String modelo,

         Integer anoModelo,

         Integer anoFabricacao,

         Integer quilometragem
){
}
