package com.nombre_empresa.best_travel.api.models.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsResponse extends BaseErrorResponse {
    private List<String> errors;
}
