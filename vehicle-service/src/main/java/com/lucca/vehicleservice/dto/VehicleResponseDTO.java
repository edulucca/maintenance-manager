package com.lucca.vehicleservice.dto;

import java.time.LocalDate;

public record VehicleResponseDTO (
         String id,

         String placa,

         String modelo,

         Integer anoModelo,

         Integer anoFabricacao,

         Integer quilometragem
){
}
