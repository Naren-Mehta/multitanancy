package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MultiTanancyDemoAppApplication;

@RestController
public class RestartController {

	@PostMapping("/restart")
	public void restart() {
		MultiTanancyDemoAppApplication.restart();
	}

}
