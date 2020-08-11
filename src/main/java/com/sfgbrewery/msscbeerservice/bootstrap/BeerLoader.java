package com.sfgbrewery.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sfgbrewery.model.BeerStyleEnum;
import com.sfgbrewery.msscbeerservice.domain.Beer;
import com.sfgbrewery.msscbeerservice.repository.BeerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

	public static final String BEER_1_UPC = "0631234200036";
	public static final String BEER_2_UPC = "0631234300019";
	public static final String BEER_3_UPC = "0083783375213";

	private final BeerRepository beerRepository;

	@Override
	public void run(String... args) throws Exception {

			loadBeerObjects();
	}

	private void loadBeerObjects() {
		if (beerRepository.count() == 0) {

			beerRepository.save(Beer.builder().beerName("Mango Bobs").beerStyle(BeerStyleEnum.IPA.name()).minOnHand(12)
					.quantityToBrew(200).price(new BigDecimal("12.95")).upc(BEER_1_UPC).build());

			beerRepository.save(Beer.builder().beerName("Galaxy Cats").beerStyle(BeerStyleEnum.PALE_ALE.name())
					.minOnHand(12).quantityToBrew(200).price(new BigDecimal("11.95")).upc(BEER_2_UPC).build());

			beerRepository.save(Beer.builder().beerName("Pinball Porter").beerStyle(BeerStyleEnum.PALE_ALE.name())
					.minOnHand(12).quantityToBrew(200).price(new BigDecimal("11.95")).upc(BEER_3_UPC).build());
		}

	}

}
