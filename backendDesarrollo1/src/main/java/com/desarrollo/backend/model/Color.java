package com.desarrollo.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "COLORES")
public class Color {
	
	@Id
	@Column(name = "CODIGO", length = 3)
	private String codigo;
	
	@Column(name = "NOMBRE", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "HEX", nullable = false, length = 6)
	private String hex;
}
