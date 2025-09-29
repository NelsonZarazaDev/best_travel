package com.nombre_empresa.best_travel.infraestructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Map;

@Getter
@Setter
public class CurrencyDTO {

    @JsonProperty(value = "date") //Se usa para que se mape el valor de fecha de la api con este
    private LocalDate exchangeDate;

    //Objetos dinamicos
    private Map<Currency, BigDecimal> rates;
}
