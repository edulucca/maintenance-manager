package com.lucca.vehicleservice.domain.repository;

import com.lucca.vehicleservice.domain.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    Vehicle findVehicleByPlacaIgnoreCase(String placa);

    boolean existsVehicleByPlaca(String placa);
}
