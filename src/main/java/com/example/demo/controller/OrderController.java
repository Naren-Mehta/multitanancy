package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.config.TenantContext;
import com.example.demo.dao.OrderRepository;
import com.example.demo.entity.Order;

@Controller
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping(path = "/orders", method = RequestMethod.POST)
	public ResponseEntity<?> createSampleOrder(@RequestHeader("X-TenantID") String tenantName) {
		TenantContext.setCurrentTenant(tenantName);

		Order newOrder = new Order(new Date(System.currentTimeMillis()));
		orderRepository.save(newOrder);

		return ResponseEntity.ok(newOrder);
	}
}
