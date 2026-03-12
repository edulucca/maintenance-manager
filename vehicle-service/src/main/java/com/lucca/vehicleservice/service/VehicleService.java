package com.lucca.vehicleservice.service;

import com.lucca.vehicleservice.dto.VehicleRequestDTO;
import com.lucca.vehicleservice.dto.VehicleResponseDTO;
import com.lucca.vehicleservice.model.Vehicle;
import com.lucca.vehicleservice.repository.VehicleRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepositoy vehicleRepositoy;

    public VehicleResponseDTO inserir(VehicleRequestDTO vehicleRequest){
        if(vehicleRepositoy.existsVehicleByPlaca(vehicleRequest.placa())){
            throw new IllegalArgumentException("Vehicle already inserted");
        }

        return toResponseDTO(vehicleRepositoy.save(vehicleRequest.toVehicleByDTO()));
    }

    private VehicleResponseDTO toResponseDTO(Vehicle vehicle) {
        return new VehicleResponseDTO(vehicle.getId(), vehicle.getPlaca(), vehicle.getModelo(), vehicle.getAnoModelo(), vehicle.getAnoFabricacao(), vehicle.getQuilometragem());
    }
}
