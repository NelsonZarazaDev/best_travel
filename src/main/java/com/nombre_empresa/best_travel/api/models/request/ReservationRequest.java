package com.nombre_empresa.best_travel.api.models.request;

import jakarta.validation.constraints.*;
import lombok.*;
import org.aspectj.bridge.IMessage;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationRequest implements Serializable {
    @Size(min = 18, max = 20, message = "El tamño tiene que tener entre 10 y 20 caracteres")
    @NotBlank(message = "El id del cliente es obligatorio")
    private String idClient;
    @Positive
    @NotNull(message = "El id del hotel es obligatorio")
    private Long idHotel;
    @Min(value = 1, message = "Se debe hospedar minimo 1 dia")
    @Max(value = 30, message = "Se debe hospedar maximo 30 dias")
    @NotNull(message = "El total de dias es obligatorio")
    private Integer totalDays;
    //@Pattern(regexp = "^(.+)@(.+)$")
    @Email(message = "Correo invalido")
    private String email;
}
