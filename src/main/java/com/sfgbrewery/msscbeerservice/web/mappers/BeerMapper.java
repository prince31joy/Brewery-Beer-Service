package com.sfgbrewery.msscbeerservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import com.sfgbrewery.model.BeerDto;
import com.sfgbrewery.msscbeerservice.domain.Beer;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);

	BeerDto beerToBeerDtoWithInventory(Beer beer);
	
    Beer beerDtoToBeer(BeerDto dto);
}
