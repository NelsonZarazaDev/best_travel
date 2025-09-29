package com.nombre_empresa.best_travel.api.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nombre_empresa.best_travel.domain.entities.CustomerEntity;
import com.nombre_empresa.best_travel.domain.entities.FlyEntity;
import com.nombre_empresa.best_travel.domain.entities.TourEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketResponse implements Serializable {
    private UUID id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime arrivalDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
    private BigDecimal price;
    private FlyResponse fly;
}
