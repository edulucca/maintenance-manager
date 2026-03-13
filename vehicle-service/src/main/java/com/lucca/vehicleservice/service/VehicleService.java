package com.lucca.vehicleservice.service;

import com.lucca.vehicleservice.dto.VehicleRequestDTO;
import com.lucca.vehicleservice.dto.VehicleResponseDTO;
import com.lucca.vehicleservice.domain.model.Vehicle;
import com.lucca.vehicleservice.domain.repository.VehicleRepository;
import com.lucca.vehicleservice.mapper.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public VehicleResponseDTO inserir(VehicleRequestDTO vehicleRequest){
        if(repository.existsVehicleByPlaca(vehicleRequest.placa())){
            throw new IllegalArgumentException("Vehicle already inserted");
        }

        return mapper.toResponse(repository.save(mapper.toEntity(vehicleRequest)));
    }

    public VehicleResponseDTO alterar(String placa, VehicleRequestDTO vehicleRequest){
        Vehicle vehicleTarget = repository.findVehicleByPlacaIgnoreCase(placa);

        if(vehicleTarget == null){
            throw new IllegalArgumentException("no vehicle found");
        }

        mapper.updateEntityFromDto(vehicleRequest, vehicleTarget);

        return mapper.toResponse(repository.save(vehicleTarget));
    }

    public List<VehicleResponseDTO> listarTodos(){
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public VehicleResponseDTO localizarPorPlaca(String placa){
        return mapper.toResponse(repository.findVehicleByPlacaIgnoreCase(placa));
    }

    public void deletar(String placa){
        Vehicle vehicle = repository.findVehicleByPlacaIgnoreCase(placa);

        if(vehicle == null){
            throw new IllegalArgumentException("vehicle not found");
        }

        repository.deleteById(vehicle.getId());
    }

}
