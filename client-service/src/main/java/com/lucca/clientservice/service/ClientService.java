package com.lucca.clientservice.service;

import com.lucca.clientservice.client.VehicleClient;
import com.lucca.clientservice.domain.model.Client;
import com.lucca.clientservice.domain.repository.ClientRepository;
import com.lucca.clientservice.dto.ClientRequestDTO;
import com.lucca.clientservice.dto.ClientResponseDTO;
import com.lucca.clientservice.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final VehicleClient vehicleClient;

    public ClientResponseDTO inserir(ClientRequestDTO request){
        if(repository.existsClientsByCpf(request.cpf())){
            throw new IllegalArgumentException("client already inserted");
        }

        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public ClientResponseDTO alterar(String cpf, ClientRequestDTO request){
        Client clientTarget = repository.findClientByCpf(cpf);

        if(clientTarget == null){
            throw new IllegalArgumentException("client not found");
        }

        mapper.updateEntityFromDto(request, clientTarget);

        return mapper.toResponse(repository.save(clientTarget));
    }

    public List<ClientResponseDTO> listarTodos(){
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public ClientResponseDTO buscarPorCpf(String cpf){
        return mapper.toResponse(repository.findClientByCpf(cpf));
    }

    public void deletar(String cpf){
        if(!repository.existsClientsByCpf(cpf)){
            throw new IllegalArgumentException("Client not found");
        }

        repository.deleteClientByCpf(cpf);
    }

    public ClientResponseDTO associarPlaca(String cpf, String placa) {
        VehicleClient.VehicleDTO vehicle = vehicleClient.buscarPorPlaca(placa);

        if(vehicle == null){
            throw new IllegalArgumentException("vehicle not found");
        }

        Client clientTarget = repository.findClientByCpf(cpf);

        if (clientTarget == null){
            throw new IllegalArgumentException("client not found");
        }

        if(!clientTarget.getVehicles().contains(placa)){
            clientTarget.getVehicles().add(placa);
        }

        return mapper.toResponse(repository.save(clientTarget));
    }
}
