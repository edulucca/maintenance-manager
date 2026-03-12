package com.lucca.vehicleservice.dto;

import com.lucca.vehicleservice.model.Vehicle;

import java.time.LocalDate;

public record VehicleResponseDTO (
         String id,

         String placa,

         String modelo,

         Integer anoModelo,

         Integer anoFabricacao,

         Integer quilometragem
){
    public static VehicleResponseDTO toResponseDTO(Vehicle vehicle){
        return new VehicleResponseDTO(vehicle.getId(), vehicle.getPlaca(), vehicle.getModelo(), vehicle.getAnoModelo(), vehicle.getAnoFabricacao(), vehicle.getQuilometragem());
    }
}
