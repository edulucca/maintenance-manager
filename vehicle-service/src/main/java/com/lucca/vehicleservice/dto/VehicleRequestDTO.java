package com.lucca.vehicleservice.dto;

import com.lucca.vehicleservice.model.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record VehicleRequestDTO (
        @NotBlank(message = "O campo placa não pode ser nulo")
        @Size(min = 7, max = 7, message = "O campo placa não possui o a quantidade caracteres correta")
        String placa,

        @NotBlank(message = "O campo modelo não pode ser nulo")
        String modelo,

        @NotBlank(message = "O campo anoModelo não pode ser nulo")
        Integer anoModelo,

        @NotBlank(message = "O campo anoFabricacao não pode ser nulo")
        Integer anoFabricacao,

        @NotBlank(message = "O campo quilometragem não pode ser nulo")
        Integer quilometragem
) {
    public Vehicle toVehicleByDTO(){
        return Vehicle.builder().placa(this.placa).modelo(this.modelo).anoModelo(this.anoModelo).anoFabricacao(this.anoFabricacao).quilometragem(this.quilometragem).build();
    }
}
