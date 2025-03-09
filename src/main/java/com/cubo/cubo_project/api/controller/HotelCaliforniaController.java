package com.cubo.cubo_project.api.controller;

import com.cubo.cubo_project.api.dto.HotelCaliforniaDto;
import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import com.cubo.cubo_project.infraestructure.service.HotelCaliforniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/hoteis")
public class HotelCaliforniaController {
    @Autowired
    private HotelCaliforniaService hotelCaliforniaService;


    @GetMapping
    public ResponseEntity<List<HotelCaliforniaDto>> listarHoteis() {
        return ResponseEntity.ok().body(hotelCaliforniaService.listarHoteis());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> listarHotelPorId(@PathVariable(value = "id") Long id) {
        Optional<HotelCaliforniaDto> hotelOptional = hotelCaliforniaService.listarHotelPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotelOptional.get());
    }


    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Object> findByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        Optional<HotelCaliforniaDto> hotelOptional = hotelCaliforniaService.findByCnpj(cnpj);
        return ResponseEntity.status(HttpStatus.OK).body(hotelOptional.get());
    }


    @PostMapping
    public ResponseEntity<HotelCaliforniaDto> criarHotel(@RequestBody HotelCaliforniaDto hotelDto) {
        HotelCaliforniaDto savedHotel = hotelCaliforniaService.criarHotel(hotelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }
    

    @PutMapping(value = "/id/{id}")
    public HotelCaliforniaDto atualizarHotel(@PathVariable Long id, @RequestBody HotelCaliforniaDto hotelDto) {
        return hotelCaliforniaService.atualizarHotel(id, hotelDto);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<Void> deletarHotel(@PathVariable Long id) {
        hotelCaliforniaService.deletarHotel(id);
        return ResponseEntity.noContent().build();
    }
}

