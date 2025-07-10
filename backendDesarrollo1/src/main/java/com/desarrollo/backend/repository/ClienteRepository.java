package com.desarrollo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
}
