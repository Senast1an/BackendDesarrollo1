package com.desarrollo.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.backend.model.Cliente;
import com.desarrollo.backend.model.PedidoCabecera;
import com.desarrollo.backend.model.PedidoDetalle;
import com.desarrollo.backend.repository.ClienteRepository;
import com.desarrollo.backend.repository.PedidoCabRepository;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin
public class PedidoController {
	
	@Autowired
    private final ClienteRepository clienteRepository;
	@Autowired
	private PedidoCabRepository pedidoCabRepository;

    PedidoController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
	
	@PostMapping
	public ResponseEntity<?> crearPedido(@RequestBody PedidoCabecera pedido) {
	    // Generar ID automáticamente
	    pedido.setIdPedido(null);
	    // Asignar el ID de pedido a los detalles
	    int i = 1;
	    for (PedidoDetalle detalle : pedido.getDetalles()) {
	        detalle.setPedido(pedido); // Asigna el objeto Pedido
	        detalle.setId(new PedidoDetalle.DetallePedidoId()); // Asegúrate de crear el ID compuesto
	        detalle.getId().setPedidoId(null); // Será asignado luego
	        detalle.getId().setPosicion(i++);
	    }
	    Optional<Cliente> clienteOpt = clienteRepository.findById(pedido.getCliente().getRuc());

	    if (clienteOpt.isPresent()) {
	        pedido.setCliente(clienteOpt.get());
	    } else {
	        // Error: cliente no existe
	        return ResponseEntity.badRequest().body("Cliente no encontrado");
	    }
	    pedidoCabRepository.save(pedido);
	    return ResponseEntity.ok().build();
	}

    @GetMapping
    public List<PedidoCabecera> listarPedidos() {
        return pedidoCabRepository.findAll();
    }
}
