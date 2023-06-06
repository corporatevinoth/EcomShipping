package com.ecommerce.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shipping.model.Shipping;
import com.ecommerce.shipping.service.ShippingService;

import jakarta.validation.Valid;

@RestController
public class ShippingController {

	@Autowired
	private ShippingService shippingService;

	// Save operation
	@PostMapping("/shipping")
	public Shipping saveShipping(@Valid @RequestBody Shipping shipping) {
		return shippingService.saveShipping(shipping);
	}

	// Read operation
	@GetMapping("/shipping")
	public List<Shipping> fetchShippingList() {
		return shippingService.fetchShippingList();
	}

	// Update operation
	@PutMapping("/shipping/{id}")
	public Shipping updateShipping(@RequestBody Shipping shipping, @PathVariable("id") Long shippingId) {
		return shippingService.updateShipping(shipping, shippingId);
	}

	// Delete operation
	@DeleteMapping("/shipping/{id}")
	public String deleteShippingById(@PathVariable("id") Long shippingId) {
		shippingService.deleteShippingById(shippingId);
		return "Deleted Successfully";
	}
}
