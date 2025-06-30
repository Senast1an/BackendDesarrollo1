package com.desarrollo.backend.model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name="ID", length = 7)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    private Color color;

    @Column(name="GROSOR")
    private Integer grosor;

    @Column(name="PRECIO")
    private double precio;

    @Column(name="STOCK")
    private int stock;
    
    @Column(name="ACTIVO")
    private boolean activo = true;

    private void generarId() {
    	String codigoColor = this.color.getCodigo().toUpperCase();
    	String grosor = String.format("%03d", this.grosor);
    	this.id = codigoColor + "-" + grosor;
    }
    
    @PrePersist
    public void prePersis() {
    	if (this.id == null) generarId();
    }
}
