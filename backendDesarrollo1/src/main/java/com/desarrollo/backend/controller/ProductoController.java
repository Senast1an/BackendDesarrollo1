package com.desarrollo.backend.controller;

import com.desarrollo.backend.model.Producto;
import com.desarrollo.backend.repository.ProductoRepository;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
	
	@GetMapping("/{id}")
	public Producto getProductoId(@PathVariable String id) {
		Optional<Producto> productoTmp = productoRepository.findById(id);
		if (productoTmp.isPresent()) return productoTmp.get();
		
		return null;
	}
	
	@PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }	
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> toggleActivoProducto(@PathVariable String id, @RequestBody Map<String, Object> updates) {
	    return productoRepository.findById(id)
	        .map(producto -> {
	            if (updates.containsKey("activo")) {
	                producto.setActivo((Boolean) updates.get("activo"));
	                productoRepository.save(producto);
	                return ResponseEntity.ok().build();
	            }
	            return ResponseEntity.badRequest().build();
	        })
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarProducto(@PathVariable String id, @RequestBody Producto productoActualizado) {
		Optional<Producto> productoTmp = productoRepository.findById(id);
		return productoRepository.findById(id)
	            .map(producto -> {
	                producto.setColor(productoActualizado.getColor());
	                producto.setGrosor(productoActualizado.getGrosor());
	                producto.setPrecio(productoActualizado.getPrecio());
	                producto.setStock(productoActualizado.getStock());
	                productoRepository.save(producto);
	                return ResponseEntity.ok().build();
	            })
	            .orElse(ResponseEntity.notFound().build());
	}
}
