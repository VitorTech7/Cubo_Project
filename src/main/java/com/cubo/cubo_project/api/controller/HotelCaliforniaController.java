package com.cubo.cubo_project.api.controller;

import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import com.cubo.cubo_project.infraestructure.repository.HotelCaliforniaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hoteis")
public class HotelCaliforniaController {

    @Autowired
    private HotelCaliforniaRepository hotelCaliforniaRepository;


    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable UUID id) {
        hotelCaliforniaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public HotelCaliforniaModel updateHotel(@PathVariable UUID id, @RequestBody HotelCaliforniaModel hotelNovo) {
        HotelCaliforniaModel hotelAtual = hotelCaliforniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));
        BeanUtils.copyProperties(hotelNovo, hotelAtual, "id");
        return hotelCaliforniaRepository.save(hotelAtual);
    }

}
