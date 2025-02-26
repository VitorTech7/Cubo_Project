package com.cubo.cubo_project.infraestructure.repository;

import com.cubo.cubo_project.infraestructure.model.HotelCaliforniaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelCaliforniaRepository extends JpaRepository<HotelCaliforniaModel, Long> {

    boolean existsByCnpj(String cnpj);
}
