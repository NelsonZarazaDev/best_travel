package com.nombre_empresa.best_travel.domain.entities;

import com.nombre_empresa.best_travel.util.enums.AeroLine;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "fly")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    private BigDecimal price;
    @Column(length = 20)
    private String destinyName;
    @Column(length = 20)
    private String originName;
    @Enumerated(EnumType.STRING)
    private AeroLine aeroLine;
    @OneToMany(
            cascade = CascadeType.ALL,
            //Permite hacer un join, otras funciones hacen otras cosas
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "fly")
    private Set<TicketEntity> ticket;
}
