package com.cubo.cubo_project.api.controller;

import com.cubo.cubo_project.api.model.HotelCaliforniaModel;
import com.cubo.cubo_project.api.service.HotelCaliforniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelCaliforniaController {
    @Autowired
    private HotelCaliforniaService hotelCaliforniaService;

    @GetMapping
    public List<HotelCaliforniaModel> listarHotéis() {
        return hotelCaliforniaService.listarHotéis();
    }

    @PostMapping
    public HotelCaliforniaModel salvarHotel(@RequestBody HotelCaliforniaModel hotel) {
        return hotelCaliforniaService.salvarHotel(hotel);
    }

    @PutMapping("/{id}")
    public HotelCaliforniaModel atualizarHotel(@PathVariable UUID id, @RequestBody HotelCaliforniaModel hotel) {
        return hotelCaliforniaService.atualizarHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public void deletarHotel(@PathVariable UUID id) {
        hotelCaliforniaService.deletarHotel(id);
    }
}

