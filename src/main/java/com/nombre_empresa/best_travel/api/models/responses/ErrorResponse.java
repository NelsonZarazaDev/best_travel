package com.nombre_empresa.best_travel.api.models.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder //La clase va a ser heredada no implementada
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends BaseErrorResponse {
    private String message;
}
