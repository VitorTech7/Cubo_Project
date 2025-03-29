package com.cubo.cubo_project.api.dto;

import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;


public class HotelCaliforniaDto implements Serializable {

    private Long id;

    @NotNull(message = "Nome do Hotel é obrigatório.")
    @Size(min = 1, max = 100, message = "Nome do hotel deve ter entre 1 e 100 caracteres.")
    private String nome;

    @NotNull(message = "Local do Hotel é obrigatório.")
    private String local;

    @NotNull(message = "Capacidade do Hotel é obrigatório.")
    private int capacidade;

    @NotNull(message = "CNPJ do Hotel é obrigatório.")
    @Size(min = 14, max = 14, message = "CNPJ do hotel deve ter 14 caracteres")
    private String cnpj;

    public HotelCaliforniaDto() {
    }

    public HotelCaliforniaDto(Long id, String nome, String local, int capacidade, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
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


    public int getCapacidade(){
        return capacidade;
    }

    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static HotelCaliforniaDto toDto(HotelCaliforniaModel model) {
        return new HotelCaliforniaDto(
                model.getId(),
                model.getNome(),
                model.getLocal(),
                model.getCapacidade(),
                model.getCnpj()
        );
    }

    public HotelCaliforniaModel toModel() {
        HotelCaliforniaModel model = new HotelCaliforniaModel();
        model.setNome(this.nome);
        model.setLocal(this.local);
        model.setCapacidade(this.capacidade);
        model.setCnpj(this.cnpj);
        return model;
    }
}
