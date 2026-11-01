
package com.ejemplo.apividrios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "vidrios")
public class Vidrio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referencia;
    private String tipo;
    private Integer espesor;
    private Double precio;
    private Integer stock;

    public Vidrio() {
    }

    public Vidrio(String referencia, String tipo,
                  Integer espesor, Double precio, Integer stock) {
        this.referencia = referencia;
        this.tipo = tipo;
        this.espesor = espesor;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getEspesor() {
        return espesor;
    }

    public void setEspesor(Integer espesor) {
        this.espesor = espesor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
