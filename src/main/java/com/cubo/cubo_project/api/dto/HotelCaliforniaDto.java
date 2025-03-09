package com.cubo.cubo_project.api.dto;

import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;

import java.io.Serializable;


public class HotelCaliforniaDto implements Serializable {

    private Long id;

    private String nome;

    private String local;

    private int capacidade;

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
