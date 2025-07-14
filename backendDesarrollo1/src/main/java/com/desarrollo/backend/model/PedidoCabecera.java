package com.desarrollo.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PEDIDOS_CABECERA")
public class PedidoCabecera {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "ID_PEDIDO")
	private String idPedido;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE")
	private Cliente cliente;
	
	@Column(name = "FECHA_PEDIDO")
	private Date fechaPedido;
	
	@Column(name = "FECHA_ENTREGA")
	private Date fechaEntrega;
	

    @Column(name="CANCELADO")
    private boolean cancelado = false;
    
    @Column(name="ENTREGADO")
    private boolean entregado = false;
	
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDetalle> detalles = new ArrayList<>();
}
