package com.nombre_empresa.best_travel.api.models.responses;

import com.nombre_empresa.best_travel.domain.entities.ReservationEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HotelResponse implements Serializable {
    private Long id;
    private String name;
    private String address;
    private Integer rating;
    private BigDecimal price;
}
