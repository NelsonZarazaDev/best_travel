package com.nombre_empresa.best_travel.api.models.responses;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TourResponse {
    private Long id;
    private Set<UUID> ticketIds;
    private Set<UUID> reservationIds;
}
