package com.nombre_empresa.best_travel.api.models.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TourRequest {
    @Size(min = 18, max = 20, message = "El tamño tiene que tener entre 10 y 20 caracteres")
    @NotBlank(message = "El id del cliente es obligatorio")
    public String customerId;
    @Min(value = 1, message = "Se debe tener un vuelo minimo por cada tur")
    private Set<TourFlyRequest> flights;
    @Min(value = 1, message = "Se debe tener un vuelo minimo por cada tur")
    private Set<TourHotelRequest> hotels;
}
