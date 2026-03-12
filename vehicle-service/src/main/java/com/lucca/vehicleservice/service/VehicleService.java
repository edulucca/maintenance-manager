package com.lucca.vehicleservice.service;

import com.lucca.vehicleservice.dto.VehicleRequestDTO;
import com.lucca.vehicleservice.dto.VehicleResponseDTO;
import com.lucca.vehicleservice.model.Vehicle;
import com.lucca.vehicleservice.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleResponseDTO inserir(VehicleRequestDTO vehicleRequest){
        if(vehicleRepository.existsVehicleByPlaca(vehicleRequest.placa())){
            throw new IllegalArgumentException("Vehicle already inserted");
        }

        return VehicleResponseDTO.toResponseDTO(vehicleRepository.save(vehicleRequest.toVehicleByDTO()));
    }

    public VehicleResponseDTO alterar(String placa, VehicleRequestDTO vehicleRequest){
        Vehicle vehicleCurrent = vehicleRepository.findVehicleByPlacaIgnoreCase(placa);

        if(vehicleCurrent == null){
            throw new IllegalArgumentException("no vehicle found");
        }

        Vehicle vehicleNew = new Vehicle(vehicleRequest.toVehicleByDTO());

        return VehicleResponseDTO.toResponseDTO(vehicleRepository.save(vehicleNew));
    }

    public List<VehicleResponseDTO> listarTodos(){
        return vehicleRepository.findAll().stream().map(VehicleResponseDTO::toResponseDTO).collect(Collectors.toList());
    }

    public VehicleResponseDTO localizarPorPlaca(String placa){
        return VehicleResponseDTO.toResponseDTO(vehicleRepository.findVehicleByPlacaIgnoreCase(placa));
    }

    public void deletar(String placa){
        Vehicle vehicle = vehicleRepository.findVehicleByPlacaIgnoreCase(placa);

        if(vehicle == null){
            throw new IllegalArgumentException("vehicle not found");
        }

        vehicleRepository.deleteById(vehicle.getId());
    }

}
