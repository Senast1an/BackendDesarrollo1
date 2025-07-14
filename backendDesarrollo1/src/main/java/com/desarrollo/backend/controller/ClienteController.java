package com.desarrollo.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.backend.model.Cliente;
import com.desarrollo.backend.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
		Cliente clienteNuevo = clienteRepository.save(cliente);
		return ResponseEntity.ok(clienteNuevo);
	}
	
	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();		
	}
	
	@GetMapping("/{ruc}")
	public ResponseEntity<Cliente> obtenerPorRuc(@PathVariable String ruc) {
		Optional<Cliente> clienteTmp = clienteRepository.findById(ruc);
		if (clienteTmp.isPresent()) {
			return ResponseEntity.ok(clienteTmp.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
