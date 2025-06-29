package com.desarrollo.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.backend.model.Color;
import com.desarrollo.backend.repository.ColorRepository;

@RestController
@RequestMapping("/api/colores")
@CrossOrigin
public class ColorController {
	@Autowired
	private ColorRepository colorRepository;
	
	@GetMapping
	public Iterable<Color> getColores(){
		return colorRepository.findAll();
	}
	
	@PostMapping
    public Color crearProducto(@RequestBody Color color) {
        return colorRepository.save(color);
    }
}
