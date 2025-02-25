package com.cubo.cubo_project.api.controller;

import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import com.cubo.cubo_project.infraestructure.service.HotelCaliforniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/hoteis")
public class HotelCaliforniaController {
    @Autowired
    private HotelCaliforniaService hotelCaliforniaService;

    @GetMapping
    public ResponseEntity<List<HotelCaliforniaModel>> listarHoteis(){
        return ResponseEntity.ok().body(hotelCaliforniaService.listarHoteis());
    }

    //Listar por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<HotelCaliforniaModel> listarHotelPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(hotelCaliforniaService.listarHotelPorId(id));
    }

    @PostMapping
    public ResponseEntity<HotelCaliforniaModel>criarHotel(@RequestBody HotelCaliforniaModel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelCaliforniaService.criarHotel(hotel));
    }

    @PutMapping(value = "/{id}")
    public HotelCaliforniaModel atualizarHotel(@PathVariable Long id, @RequestBody HotelCaliforniaModel hotel) {
        return hotelCaliforniaService.atualizarHotel(id, hotel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarHotel(@PathVariable Long id) {
        hotelCaliforniaService.deletarHotel(id);
        return ResponseEntity.noContent().build();
    }
}

