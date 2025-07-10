package com.desarrollo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.backend.model.PedidoDetalle;
import com.desarrollo.backend.model.PedidoDetalle.DetallePedidoId;

public interface PedidoDetRepository extends JpaRepository<PedidoDetalle, DetallePedidoId>{

}
