package com.desarrollo.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PEDIDOS_DETALLE")
public class PedidoDetalle {
	
	@EmbeddedId
	private DetallePedidoId id;
	
	@ManyToOne
    @MapsId("pedidoId") // Vincula con el pedidoId del ID compuesto
    @JoinColumn(name = "pedido_id")
    private PedidoCabecera pedido;
	
	@ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

	@Column(name = "CANTIDAD")
    private int cantidad;


	@Embeddable
	@Data
	public static class DetallePedidoId implements Serializable {

	    private String pedidoId;
	    private int posicion;

	    public DetallePedidoId() {}

	    public DetallePedidoId(String pedidoId, int posicion) {
	        this.pedidoId = pedidoId;
	        this.posicion = posicion;
	    }
	}
}
