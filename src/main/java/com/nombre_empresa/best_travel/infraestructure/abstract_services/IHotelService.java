package com.nombre_empresa.best_travel.infraestructure.abstract_services;

import com.nombre_empresa.best_travel.api.models.responses.HotelResponse;

import java.util.Set;

public interface IHotelService extends CatalogoService<HotelResponse>{
    Set<HotelResponse> readGreaterThan(Integer rating);
}
