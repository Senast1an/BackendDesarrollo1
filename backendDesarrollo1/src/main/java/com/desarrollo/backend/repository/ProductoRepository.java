package com.desarrollo.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.desarrollo.backend.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, String> {

}
