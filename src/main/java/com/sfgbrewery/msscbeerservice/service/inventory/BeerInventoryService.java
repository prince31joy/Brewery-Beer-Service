package com.sfgbrewery.msscbeerservice.service.inventory;

import java.util.UUID;

public interface BeerInventoryService {
	
	Integer getOnhandInventory(UUID beerId);
}
