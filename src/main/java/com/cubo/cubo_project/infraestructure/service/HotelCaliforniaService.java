package com.cubo.cubo_project.infraestructure.service;

import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import com.cubo.cubo_project.infraestructure.repository.HotelCaliforniaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelCaliforniaService {

    @Autowired
    private HotelCaliforniaRepository hotelCaliforniaRepository;

    public List<HotelCaliforniaModel> listarHoteis() {
        return hotelCaliforniaRepository.findAll();
    }

    public HotelCaliforniaModel listarHotelPorId(Long id){
        return hotelCaliforniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel com ID " + id + " não encontrado!"));
    }


    @Transactional
    public HotelCaliforniaModel criarHotel(HotelCaliforniaModel hotel) {
        validarHotel(hotel);
        verificarDuplicidadeCnpj(hotel.getCnpj());
        return hotelCaliforniaRepository.save(hotel);
    }

    private void validarHotel(HotelCaliforniaModel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Os dados do hotel não podem ser nulos.");
        }
        if (hotel.getNome() == null || hotel.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do hotel é obrigatório.");
        }
        if (hotel.getLocal() == null || hotel.getLocal().trim().isEmpty()) {
            throw new IllegalArgumentException("O local do hotel é obrigatório.");
        }
        if (hotel.getCapacidade() <= 0) {
            throw new IllegalArgumentException("A capacidade do hotel deve ser maior que zero.");
        }
        if (hotel.getCnpj() == null || hotel.getCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório.");
        }
    }

    private void verificarDuplicidadeCnpj(String cnpj) {
        if (hotelCaliforniaRepository.existsByCnpj(cnpj)) {
            throw new IllegalStateException("Já existe um hotel cadastrado com este CNPJ.");
        }
    }


    public HotelCaliforniaModel atualizarHotel(Long id, HotelCaliforniaModel novoHotel) {
        HotelCaliforniaModel hotelAtual = hotelCaliforniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));

        if (novoHotel.getNome() != null) {
            hotelAtual.setNome(novoHotel.getNome());
        }
        if (novoHotel.getLocal() != null) {
            hotelAtual.setLocal(novoHotel.getLocal());
        }
        if (novoHotel.getCapacidade() > 0) {
            hotelAtual.setCapacidade(novoHotel.getCapacidade());
        }
        if (novoHotel.getCnpj() != null) {
            hotelAtual.setCnpj(novoHotel.getCnpj());
        }

        return hotelCaliforniaRepository.save(hotelAtual);
    }

    public void deletarHotel(Long id) {
        if (!hotelCaliforniaRepository.existsById(id)) {
            throw new IllegalArgumentException("Hotel com ID " + id + " não encontrado.");
        }
        hotelCaliforniaRepository.deleteById(id);
    }
}

