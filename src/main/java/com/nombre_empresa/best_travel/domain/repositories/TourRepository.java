package com.nombre_empresa.best_travel.domain.repositories;

import com.nombre_empresa.best_travel.domain.entities.FlyEntity;
import com.nombre_empresa.best_travel.domain.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<TourEntity,Long> {

}
