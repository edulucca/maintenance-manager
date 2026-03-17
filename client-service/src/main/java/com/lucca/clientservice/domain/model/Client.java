package com.lucca.clientservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "client")
public class Client {
    @Id
    private String id;

    private String cpf;

    private String nome;

    private String telefone;

    private String email;

    @Builder.Default
    private List<String> vehicles = new ArrayList<>();
}
