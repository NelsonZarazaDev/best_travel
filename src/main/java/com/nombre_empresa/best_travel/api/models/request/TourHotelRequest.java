package com.nombre_empresa.best_travel.api.models.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TourHotelRequest {
    public Long id;
    private Integer totalDays;
}
