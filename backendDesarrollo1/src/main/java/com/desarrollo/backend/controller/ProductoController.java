package com.desarrollo.backend.controller;

import com.desarrollo.backend.model.Producto;
import com.desarrollo.backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping
	public Iterable<Producto> getProductos(){
		return productoRepository.findAll();
	}
	
	@PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}
