package com.sfgbrewery.msscbeerservice.service;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;

import com.sfgbrewery.model.BeerDto;
import com.sfgbrewery.model.BeerPagedList;
import com.sfgbrewery.model.BeerStyleEnum;

public interface BeerService {

	BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest,
			Boolean showInventoryOnHand);

	BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

	BeerDto getByUpc(String upc);

}
