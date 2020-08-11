package com.sfgbrewery.model.events;

import java.io.Serializable;

import com.sfgbrewery.model.BeerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

	static final long serialVersionUID = -5781515597148163111L;

	private BeerDto beerDto;

}
