package com.lucca.vehicleservice.repository;

import com.lucca.vehicleservice.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleRepositoy extends MongoRepository<Vehicle, String> {
    List<Vehicle> findVehicleByModeloContainingIgnoreCase(String modelo);

    Vehicle findVehicleByPlacaIgnoreCase(String placa);

    boolean existsVehicleByPlaca(String placa);
}
