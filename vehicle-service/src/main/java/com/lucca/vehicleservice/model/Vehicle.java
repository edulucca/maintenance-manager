package com.lucca.vehicleservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "vehicle")
public class Vehicle {
    @Id
    private String id;

    private String placa;

    private String modelo;

    private Integer anoModelo;

    private Integer anoFabricacao;

    private Integer quilometragem;
}
