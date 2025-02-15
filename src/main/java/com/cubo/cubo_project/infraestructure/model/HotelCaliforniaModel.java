package com.cubo.cubo_project.infraestructure.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "hotel_california")
public class HotelCaliforniaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome")
    private String name;

    @Column(name = "local")
    private String local;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "cnpj")
    private String cnpj;
}
