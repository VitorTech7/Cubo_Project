package com.cubo.cubo_project.api.service;

import com.cubo.cubo_project.api.model.HotelCaliforniaModel;
import com.cubo.cubo_project.api.repository.HotelCaliforniaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelCaliforniaService {

    @Autowired
    private HotelCaliforniaRepository hotelCaliforniaRepository;

    public List<HotelCaliforniaModel> listarHotéis() {
        return hotelCaliforniaRepository.findAll();
    }

    public HotelCaliforniaModel salvarHotel(HotelCaliforniaModel hotel) {
        return hotelCaliforniaRepository.save(hotel);
    }

    public HotelCaliforniaModel atualizarHotel(UUID id, HotelCaliforniaModel hotel) {
        HotelCaliforniaModel existingHotel = hotelCaliforniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));

        BeanUtils.copyProperties(hotel, existingHotel, "id");
        return hotelCaliforniaRepository.save(existingHotel);
    }

    public void deletarHotel(UUID id) {
        hotelCaliforniaRepository.deleteById(id);
    }
}

