package com.nombre_empresa.best_travel.api.controllers;

import com.nombre_empresa.best_travel.api.models.request.ReservationRequest;
import com.nombre_empresa.best_travel.api.models.request.TicketRequest;
import com.nombre_empresa.best_travel.api.models.responses.ReservationResponse;
import com.nombre_empresa.best_travel.api.models.responses.TicketResponse;
import com.nombre_empresa.best_travel.domain.entities.ReservationEntity;
import com.nombre_empresa.best_travel.infraestructure.abstract_services.IReservationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(path = "reservation")
@AllArgsConstructor
public class ReservationController {

    private IReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> post(@Valid @RequestBody ReservationRequest request) {
        return ResponseEntity.ok(reservationService.create(request));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ReservationResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(reservationService.read(id));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ReservationResponse> put(@Valid @PathVariable UUID id, @RequestBody ReservationRequest request) {
        return ResponseEntity.ok(this.reservationService.update(request, id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<Map<String, BigDecimal>> getfindPrice(@RequestParam Long idHotel, @RequestHeader(required = false) Currency currency) {
        if (Objects.isNull(currency)) currency = Currency.getInstance("USD");
        log.info(String.valueOf(idHotel));
        return ResponseEntity.ok(Collections.singletonMap("findPrice", this.reservationService.findPrice(idHotel,currency)));
    }
}
