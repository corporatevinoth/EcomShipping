package com.ecommerce.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shipping.model.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,Long> {

	
 }
