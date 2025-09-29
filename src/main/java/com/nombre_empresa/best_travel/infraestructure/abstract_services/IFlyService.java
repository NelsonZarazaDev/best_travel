package com.nombre_empresa.best_travel.infraestructure.abstract_services;

import com.nombre_empresa.best_travel.api.models.responses.FlyResponse;

import java.util.Set;

public interface IFlyService extends CatalogoService<FlyResponse> {
    Set<FlyResponse> readByOriginDestiny(String origin, String destiny);
}
