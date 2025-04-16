package com.dharbor.sales.services;

import com.dharbor.sales.model.User;
import com.dharbor.sales.model.dto.NewSaleDto;
import com.dharbor.sales.model.rest.Character;
import com.dharbor.sales.model.rest.ProductReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewSalesService {

    private final UserFeignService userFeignService;

    private final StockFeignService stockFeignService;

    private final NotificationFeignService notificationFeignService;

    private final RickMortyApiFeignService rickMortyApiFeignService;

    //TODO: Apply circuit breaking and error handling for Wed 4/16/2025
    //@CircuitBreaker(name = "newSale", fallbackMethod = "newSaleFallback")
    public String newSale(NewSaleDto newSaleDto) {

        User user = this.userFeignService.findById(newSaleDto.getUserId());

        ProductReservationRequest reservationRequest = new ProductReservationRequest();
        reservationRequest.setQuantity(newSaleDto.getQuantity());
        reservationRequest.setProductId(newSaleDto.getProductId());
        String reservationId = this.stockFeignService.reserve(reservationRequest);

        String notification = this.notificationFeignService.sendNotification(newSaleDto.getUserId().toString());

        Character character = this.rickMortyApiFeignService.findById(2);

        System.out.println(character.getName() + " " + character.getSpecies() + " " + character.getStatus());

        return "New Sale for " + user.getName() + " with reservation id " + reservationId + " and user has been notified " + notification;
    }

    private String newSaleFallback(NewSaleDto newSaleDto, Throwable throwable) {
        return "Service is temporarily unavailable. Please try again later.";
    }

}
