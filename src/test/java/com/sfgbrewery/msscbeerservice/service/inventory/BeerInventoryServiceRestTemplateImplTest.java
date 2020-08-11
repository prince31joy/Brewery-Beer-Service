package com.sfgbrewery.msscbeerservice.service.inventory;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {
	


	@Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {

    }

	@Test
	void getOnhandInventory() {
		Integer qoh = beerInventoryService.getOnhandInventory(UUID.fromString("2616a9ee-4906-482e-b1e4-a78376201e48"));

        System.out.println(qoh);
		
	}

}
