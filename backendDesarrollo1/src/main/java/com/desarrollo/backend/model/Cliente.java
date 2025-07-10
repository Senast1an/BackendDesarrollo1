package com.desarrollo.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="CLIENTES")
public class Cliente {

	@Id
	@Column(name = "RUC", length = 11)
	private String ruc;
	
	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "LINEA_CREDITO", precision = 10, scale = 2)
	private BigDecimal  lineaCredito;
	
	@Column(name = "CUOTA_MENSUAL", precision = 10, scale = 2)
	private BigDecimal  cuotaMensual; 
	
	
}
