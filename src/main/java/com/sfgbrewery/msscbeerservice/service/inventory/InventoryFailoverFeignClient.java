package com.sfgbrewery.msscbeerservice.service.inventory;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sfgbrewery.msscbeerservice.service.inventory.model.BeerInventoryDto;

@FeignClient(name = "inventory-failover")
public interface InventoryFailoverFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/inventory-failover")
	ResponseEntity<List<BeerInventoryDto>> getOnhandInventory();

}
