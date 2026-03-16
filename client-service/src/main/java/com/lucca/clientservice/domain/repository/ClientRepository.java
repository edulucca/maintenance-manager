package com.lucca.clientservice.domain.repository;

import com.lucca.clientservice.domain.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
    Client findClientByCpf(String cpf);

    boolean existsClientsByCpf(String cpf);

    Client deleteClientByCpf(String cpf);
}
