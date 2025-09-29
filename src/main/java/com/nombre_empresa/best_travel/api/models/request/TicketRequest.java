package com.nombre_empresa.best_travel.api.models.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketRequest implements Serializable {
    private String idClient;
    private Long idFly;
}
