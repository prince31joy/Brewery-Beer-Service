package com.sfgbrewery.model.events;

import com.sfgbrewery.model.BeerDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
	
	public NewInventoryEvent(BeerDto beerDto) {
		super(beerDto);
	}

}
