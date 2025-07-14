package com.desarrollo.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.backend.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public void descontarStock(String idProducto, int consumo) {
		productoRepository.findById(idProducto)
        .ifPresent(producto -> {
            int stockActual = producto.getStock();
            producto.setStock(stockActual - consumo);
            productoRepository.save(producto);
        });
	}
}
