package com.cubo.cubo_project.infraestructure.service;

import com.cubo.cubo_project.api.dto.HotelCaliforniaDto;
import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import com.cubo.cubo_project.infraestructure.repository.HotelCaliforniaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelCaliforniaService {

    @Autowired
    private HotelCaliforniaRepository hotelCaliforniaRepository;

    public List<HotelCaliforniaDto> listarHoteis() {
        return hotelCaliforniaRepository.findAll().stream()
                .map(HotelCaliforniaDto::toDto)
                .collect(Collectors.toList());
    }

    public Optional<HotelCaliforniaDto> listarHotelPorId(Long id) {
        return hotelCaliforniaRepository.findById(id)
                .map(HotelCaliforniaDto::toDto);
    }

    public Optional<HotelCaliforniaDto> findByCnpj(String cnpj) {
        return hotelCaliforniaRepository.findByCnpj(cnpj)
                .map(HotelCaliforniaDto::toDto);
    }

    @Transactional
    public HotelCaliforniaDto criarHotel(HotelCaliforniaDto hotelDto) {
        validarHotel(hotelDto);
        verificarDuplicidadeCnpj(hotelDto.getCnpj());
        HotelCaliforniaModel model = hotelDto.toModel();
        HotelCaliforniaModel savedModel = hotelCaliforniaRepository.save(model);
        return HotelCaliforniaDto.toDto(savedModel);
    }


    private void validarHotel(HotelCaliforniaDto hotelDto) {
        if (hotelDto == null) {
            throw new IllegalArgumentException("Os dados do hotel não podem ser nulos.");
        }
        if (hotelDto.getNome() == null || hotelDto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do hotel é obrigatório.");
        }
        if (hotelDto.getLocal() == null || hotelDto.getLocal().trim().isEmpty()) {
            throw new IllegalArgumentException("O local do hotel é obrigatório.");
        }
        if (hotelDto.getCapacidade() <= 0) {
            throw new IllegalArgumentException("A capacidade do hotel deve ser maior que zero.");
        }
        if (hotelDto.getCnpj() == null || hotelDto.getCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório.");
        }
    }

    private void verificarDuplicidadeCnpj(String cnpj) {
        if (hotelCaliforniaRepository.existsByCnpj(cnpj)) {
            throw new IllegalStateException("Já existe um hotel cadastrado com este CNPJ.");
        }
    }


    public HotelCaliforniaDto atualizarHotel(Long id, HotelCaliforniaDto novoHotelDto) {
        validarHotel(novoHotelDto);
        HotelCaliforniaModel hotelAtual = hotelCaliforniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));

        if (!hotelAtual.getCnpj().equals(novoHotelDto.getCnpj())) {
            verificarDuplicidadeCnpj(novoHotelDto.getCnpj());

        }

        if (novoHotelDto.getNome() != null) {
            hotelAtual.setNome(novoHotelDto.getNome());
        }
        if (novoHotelDto.getLocal() != null) {
            hotelAtual.setLocal(novoHotelDto.getLocal());
        }
        if (novoHotelDto.getCapacidade() > 0) {
            hotelAtual.setCapacidade(novoHotelDto.getCapacidade());
        }
        if (novoHotelDto.getCnpj() != null) {
            hotelAtual.setCnpj(novoHotelDto.getCnpj());
        }

        HotelCaliforniaModel hotelAtualizado = hotelCaliforniaRepository.save(hotelAtual);
        return HotelCaliforniaDto.toDto(hotelAtualizado);
    }

    public void deletarHotel(Long id) {
        if (!hotelCaliforniaRepository.existsById(id)) {
            throw new IllegalArgumentException("Hotel com ID " + id + " não encontrado.");
        }
        hotelCaliforniaRepository.deleteById(id);
    }
}

