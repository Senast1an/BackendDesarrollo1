package com.desarrollo.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desarrollo.backend.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, String> {
	List<Producto> findByActivo(Boolean activo);
}
