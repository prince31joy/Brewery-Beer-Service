package com.sfgbrewery.msscbeerservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import com.sfgbrewery.model.BeerDto;
import com.sfgbrewery.msscbeerservice.domain.Beer;
import com.sfgbrewery.msscbeerservice.service.inventory.BeerInventoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BeerMapperDecorator implements BeerMapper {

	private BeerInventoryService beerInventoryService;
	private BeerMapper mapper;

	@Autowired
	public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
		this.beerInventoryService = beerInventoryService;
	}

	@Autowired
	public void setMapper(BeerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public BeerDto beerToBeerDto(Beer beer) {
		return mapper.beerToBeerDto(beer);
	}

	@Override
	public BeerDto beerToBeerDtoWithInventory(Beer beer) {
		BeerDto dto = mapper.beerToBeerDto(beer);
		log.info("setting inventoryOnHand");
		dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
		return dto;
	}

	@Override
	public Beer beerDtoToBeer(BeerDto beerDto) {
		return mapper.beerDtoToBeer(beerDto);
	}

}
