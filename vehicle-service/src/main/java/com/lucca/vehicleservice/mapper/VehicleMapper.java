package com.lucca.vehicleservice.mapper;

import com.lucca.vehicleservice.domain.model.Vehicle;
import com.lucca.vehicleservice.dto.VehicleRequestDTO;
import com.lucca.vehicleservice.dto.VehicleResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toEntity(VehicleRequestDTO request);

    VehicleResponseDTO toResponse(Vehicle entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(VehicleRequestDTO dto, @MappingTarget Vehicle entity);
}
