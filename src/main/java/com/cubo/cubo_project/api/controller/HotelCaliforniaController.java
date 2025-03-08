package com.cubo.cubo_project.api.controller;

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
    public ResponseEntity<List<HotelCaliforniaModel>> listarHoteis(){
        return ResponseEntity.ok().body(hotelCaliforniaService.listarHoteis());
    }

    //Listar por id
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<HotelCaliforniaModel> listarHotelPorId(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(hotelCaliforniaService.listarHotelPorId(id));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Object> findByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        Optional<HotelCaliforniaModel> hotelOptional = hotelCaliforniaService.findByCnpj(cnpj);
        return ResponseEntity.status(HttpStatus.OK).body(hotelOptional.get());
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

