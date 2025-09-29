package com.nombre_empresa.best_travel.infraestructure.services;

import com.nombre_empresa.best_travel.api.models.responses.HotelResponse;
import com.nombre_empresa.best_travel.config.CacheConstants;
import com.nombre_empresa.best_travel.domain.entities.HotelEntity;
import com.nombre_empresa.best_travel.domain.repositories.HotelRepository;
import com.nombre_empresa.best_travel.infraestructure.abstract_services.IHotelService;
import com.nombre_empresa.best_travel.util.enums.SortType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
public class HotelService implements IHotelService {

    private HotelRepository hotelRepository;

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Set<HotelResponse> readGreaterThan(Integer rating) {
        var response = this.hotelRepository.findByRatingGreaterThan(rating);
        return response.stream().map(this::entityToResponse).collect(Collectors.toSet());
    }

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Page<HotelResponse> realAll(Integer page, Integer size, SortType sortType) {
        PageRequest pageRequest = null;
        switch (sortType) {
            case NONE -> pageRequest = PageRequest.of(page, size);
            case LOWER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case UPPER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.hotelRepository.findAll(pageRequest).map(this::entityToResponse);
    }

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Set<HotelResponse> readLessPrice(BigDecimal price) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var response = this.hotelRepository.findByPriceLessThan(price);
        return response.stream().map(this::entityToResponse).collect(Collectors.toSet());
    }

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Set<HotelResponse> readBetweenPrice(BigDecimal min, BigDecimal max) {
        var response = this.hotelRepository.findByPriceIsBetween(min, max);
        return response.stream().map(this::entityToResponse).collect(Collectors.toSet());
    }

    public HotelResponse entityToResponse(HotelEntity entity) {
        HotelResponse response = new HotelResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
