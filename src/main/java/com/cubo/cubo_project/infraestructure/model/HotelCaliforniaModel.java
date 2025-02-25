package com.cubo.cubo_project.infraestructure.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotel_california")
public class HotelCaliforniaModel implements Serializable {

    public HotelCaliforniaModel(){

    }
    public HotelCaliforniaModel(String nome, String local, int capacidade, String cnpj) {
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
        this.cnpj = cnpj;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "local")
    private String local;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "cnpj")
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
