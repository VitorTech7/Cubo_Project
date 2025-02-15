package com.cubo.cubo_project.api.repository;

import com.cubo.cubo_project.api.model.HotelCaliforniaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelCaliforniaRepository extends JpaRepository<HotelCaliforniaModel, UUID> {
}
