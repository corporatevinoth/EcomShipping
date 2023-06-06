package com.ecommerce.shipping.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shipping.model.Shipping;
import com.ecommerce.shipping.repository.ShippingRepository;

@Service
public class ShippingService {
	 @Autowired
	    private ShippingRepository shippingingRepository;
	 
	    // Save operation
	    
	    public Shipping saveShipping(Shipping shipping)
	    {
	        return shippingingRepository.save(shipping);
	    }
	 
	    // Read operation
	     public List<Shipping> fetchShippingList()
	    {
	        return (List<Shipping>)
	            shippingingRepository.findAll();
	    }
	 
	    // Update operation
	    public Shipping
	    updateShipping(Shipping shipping,
	                     Long shippingId)
	    {
	 
	        Shipping depDB
	            = shippingingRepository.findById(shippingId)
	                  .get();
	 
	        if (Objects.nonNull(shipping.getReceiverName())
	            && !"".equalsIgnoreCase(
	                shipping.getReceiverName())) {
	            depDB.setReceiverName(
	                shipping.getReceiverName());
	        }
	 
	        if (Objects.nonNull(
	                shipping.getShippingAddress())
	            && !"".equalsIgnoreCase(
	                shipping.getShippingAddress())) {
	            depDB.setShippingAddress(
	                shipping.getShippingAddress());
	        }
	 
	        if (Objects.nonNull(shipping.getDeliveryDate())) {
	            depDB.setDeliveryDate(
	                shipping.getDeliveryDate());
	        }
	 
	        return shippingingRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteShippingById(Long shippingId)
	    {
	        shippingingRepository.deleteById(shippingId);
	    }
}
