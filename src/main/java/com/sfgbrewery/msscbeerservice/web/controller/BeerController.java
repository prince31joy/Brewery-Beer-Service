package com.sfgbrewery.msscbeerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import com.sfgbrewery.model.BeerDto;
import com.sfgbrewery.model.BeerPagedList;
import com.sfgbrewery.model.BeerStyleEnum;
import com.sfgbrewery.msscbeerservice.service.BeerService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/")
@RestController
@RequiredArgsConstructor
public class BeerController {

	private static final Integer DEFAULT_PAGE_NUMBER = 0;
	private static final Integer DEFAULT_PAGE_SIZE = 25;

	private final BeerService beerService;

	@GetMapping(produces = { "application/json" }, path = "beer")
	public ResponseEntity<BeerPagedList> listBeers(
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "beerName", required = false) String beerName,
			@RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle,
			@RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {

		if (showInventoryOnHand == null) {
			showInventoryOnHand = false;
		}

		if (pageNumber == null || pageNumber < 0) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}

		if (pageSize == null || pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}

		BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize),
				showInventoryOnHand);

		return new ResponseEntity<>(beerList, HttpStatus.OK);
	}

	@GetMapping("beer/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId,
			@RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {

		if (showInventoryOnHand == null) {
			showInventoryOnHand = false;
		}

		return new ResponseEntity<>(beerService.getById(beerId, showInventoryOnHand), HttpStatus.OK);
	}

	@GetMapping("beerUpc/{upc}")
	public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("upc") String upc) {
		return new ResponseEntity<>(beerService.getByUpc(upc), HttpStatus.OK);
	}

	@PostMapping(path = "beer")
	public ResponseEntity<BeerDto> saveNewBeer(@Validated @RequestBody BeerDto beerDto) {

		return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
	}

	@PutMapping("beer/{beerId}")
	public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId,
			@Validated @RequestBody BeerDto beerDto) {

		return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
	}
}
