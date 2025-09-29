package com.nombre_empresa.best_travel.infraestructure.abstract_services;

import com.nombre_empresa.best_travel.api.models.request.ReservationRequest;
import com.nombre_empresa.best_travel.api.models.responses.ReservationResponse;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public interface IReservationService extends CrudService<ReservationRequest, ReservationResponse, UUID> {
    BigDecimal findPrice(Long idHotel, Currency currency);
}
