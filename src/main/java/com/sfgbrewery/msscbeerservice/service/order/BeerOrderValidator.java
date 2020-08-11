package com.sfgbrewery.msscbeerservice.service.order;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.sfgbrewery.model.events.BeerOrderDto;
import com.sfgbrewery.msscbeerservice.repository.BeerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderValidator {
	
	private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrder){

        AtomicInteger beersNotFound = new AtomicInteger();

        beerOrder.getBeerOrderLines().forEach(orderline -> {
            if(beerRepository.findByUpc(orderline.getUpc()) == null){
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }

}
