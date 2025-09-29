package com.nombre_empresa.best_travel.api.controllers;

import com.nombre_empresa.best_travel.api.models.responses.FlyResponse;
import com.nombre_empresa.best_travel.config.CacheConstants;
import com.nombre_empresa.best_travel.infraestructure.abstract_services.IFlyService;
import com.nombre_empresa.best_travel.util.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(path = "fly")
@AllArgsConstructor
public class FlyController {
    private IFlyService flyService;

    @GetMapping
    @Cacheable(value = CacheConstants.FLY_CACHE_NAME)
    public ResponseEntity<Page<FlyResponse>> getAll(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType)) sortType = SortType.NONE;
        var response = this.flyService.realAll(page, size, sortType);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping(path = "less_price")
    @Cacheable(value = CacheConstants.FLY_CACHE_NAME)
    public ResponseEntity<Set<FlyResponse>> getLessPrice(@RequestParam BigDecimal price) {
        var response = this.flyService.readLessPrice(price);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping(path = "between_price")
    @Cacheable(value = CacheConstants.FLY_CACHE_NAME)
    public ResponseEntity<Set<FlyResponse>> getBetweenPrice(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        var response = this.flyService.readBetweenPrice(min, max);
        return ResponseEntity.ok(response);

    }

    @GetMapping(path = "origin_destiny")
    @Cacheable(value = CacheConstants.FLY_CACHE_NAME)
    public ResponseEntity<Set<FlyResponse>> getOriginDestiny(@RequestParam String origin, @RequestParam String destiny){
        var response = this.flyService.readByOriginDestiny(origin, destiny);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

}
