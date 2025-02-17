package com.cubo.cubo_project.api.service;

import com.cubo.cubo_project.api.model.HotelCaliforniaModel;
import com.cubo.cubo_project.api.repository.HotelCaliforniaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelCaliforniaService {

    @Autowired
    private HotelCaliforniaRepository hotelCaliforniaRepository;

    public List<HotelCaliforniaModel> listarHoteis() {
        return hotelCaliforniaRepository.findAll();
    }

    public HotelCaliforniaModel listarHotelPorId(Long id){
        Optional<HotelCaliforniaModel> hotel = hotelCaliforniaRepository.findById(id);
        return hotel.get();
    }

    @Transactional
    public HotelCaliforniaModel criarHotel(HotelCaliforniaModel hotel) {
        return hotelCaliforniaRepository.save(hotel);
    }

    public HotelCaliforniaModel atualizarHotel(Long id, HotelCaliforniaModel novoHotel) {
        HotelCaliforniaModel hotelAtual = hotelCaliforniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));

        BeanUtils.copyProperties(novoHotel, hotelAtual, "id");
        return hotelCaliforniaRepository.save(hotelAtual);
    }

    public void deletarHotel(Long id) {
        hotelCaliforniaRepository.deleteById(id);
    }
}

