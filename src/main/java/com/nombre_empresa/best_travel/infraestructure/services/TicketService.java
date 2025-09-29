package com.nombre_empresa.best_travel.infraestructure.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.nombre_empresa.best_travel.api.models.request.TicketRequest;
import com.nombre_empresa.best_travel.api.models.responses.FlyResponse;
import com.nombre_empresa.best_travel.api.models.responses.TicketResponse;
import com.nombre_empresa.best_travel.domain.entities.TicketEntity;
import com.nombre_empresa.best_travel.domain.repositories.CustomerRepository;
import com.nombre_empresa.best_travel.domain.repositories.FlyRepository;
import com.nombre_empresa.best_travel.domain.repositories.TicketRepository;
import com.nombre_empresa.best_travel.infraestructure.abstract_services.ITicketService;
import com.nombre_empresa.best_travel.infraestructure.helpers.BlackListHelper;
import com.nombre_empresa.best_travel.infraestructure.helpers.CustomerHelper;
import com.nombre_empresa.best_travel.util.BestTravelUtil;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class TicketService implements ITicketService {

    private FlyRepository flyRepository;
    private CustomerRepository customerRepository;
    private TicketRepository ticketRepository;
    private CustomerHelper customerHelper;
    private BlackListHelper blackListHelper;

    @Override
    public TicketResponse create(TicketRequest request) {
        blackListHelper.isInBlackListCustomer(request.getIdClient());
        var fly = flyRepository.findById(request.getIdFly()).orElseThrow();
        var customer = customerRepository.findById(request.getIdClient()).orElseThrow();
        var ticketToPersist = TicketEntity.builder()
                .id(UUID.randomUUID())
                .fly(fly)
                .customer(customer)
                .price(fly.getPrice().multiply(charger_price_percentage))
                .purchaseDate(LocalDate.now())
                .arrivalDate(BestTravelUtil.getRandomSoon())
                .departureDate(BestTravelUtil.getRandomLatter())
                .build();

        var ticketPersisted = this.ticketRepository.save(ticketToPersist);
        log.info("Ticket saved with id {}", ticketPersisted.getId());
        this.customerHelper.increase(customer.getDni(), TicketService.class);
        return this.entityToResponse(ticketPersisted);
    }

    @Override
    public TicketResponse read(UUID id) {
        var ticketFromDb = this.ticketRepository.findById(id).orElseThrow();
        return this.entityToResponse(ticketFromDb);
    }

    @Override
    public TicketResponse update(TicketRequest request, UUID id) {
        var ticketToUpdate = ticketRepository.findById(id).orElseThrow();
        var fly = flyRepository.findById(request.getIdFly()).orElseThrow();

        ticketToUpdate.setFly(fly);
        ticketToUpdate.setPrice(fly.getPrice().add((fly.getPrice().multiply(charger_price_percentage))));
        ticketToUpdate.setArrivalDate(BestTravelUtil.getRandomSoon());
        ticketToUpdate.setDepartureDate(BestTravelUtil.getRandomLatter());

        var ticketUpdated = this.ticketRepository.save(ticketToUpdate);
        log.info("ticket updated with id {}", ticketUpdated.getId());
        return this.entityToResponse(ticketToUpdate);
    }

    @Override
    public void delete(UUID id) {
        var ticketToDelete = this.ticketRepository.findById(id).orElseThrow();
        this.ticketRepository.delete(ticketToDelete);
    }

    @Override
    public BigDecimal findPrice(Long flyId) {
        var fly = this.flyRepository.findById(flyId).orElseThrow();
        return fly.getPrice().add(fly.getPrice().multiply(charger_price_percentage));
    }

    private TicketResponse entityToResponse(TicketEntity entity) {
        var response = new TicketResponse();
        BeanUtils.copyProperties(entity, response);
        var flyResponse = new FlyResponse();
        BeanUtils.copyProperties(entity.getFly(), flyResponse);
        response.setFly(flyResponse);
        return response;
    }

    public static final BigDecimal charger_price_percentage = BigDecimal.valueOf(0.25);
}
