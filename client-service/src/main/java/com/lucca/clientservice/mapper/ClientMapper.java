package com.lucca.clientservice.mapper;

import com.lucca.clientservice.domain.model.Client;
import com.lucca.clientservice.dto.ClientRequestDTO;
import com.lucca.clientservice.dto.ClientResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientRequestDTO clientRequest);

    ClientResponseDTO toResponse(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ClientRequestDTO clientRequestDTO, @MappingTarget Client client);
}
