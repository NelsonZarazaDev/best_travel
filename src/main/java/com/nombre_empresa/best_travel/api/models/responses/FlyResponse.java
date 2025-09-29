package com.nombre_empresa.best_travel.api.models.responses;

import com.nombre_empresa.best_travel.util.enums.AeroLine;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlyResponse implements Serializable {
    private Long id;
    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    private BigDecimal price;
    private String destinyName;
    private String originName;
    private AeroLine aeroLine;
}
