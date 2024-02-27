package com.transporte.producto.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transporte.envioterrestre.entities.EnvioTerrestreEntity;



@Entity
@Table(name="produtlogis")
public class ProductoEntity {

	public ProductoEntity() {
		super();
	}
	
	public long getId_producto() {
		return id_producto;
	}

	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public ProductoEntity(long id_producto, String nombre, String descripción, String tipo, String otros) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripción = descripción;
		this.tipo = tipo;
		this.otros = otros;
	}


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_producto")
	long id_producto;
	@Column(name="nombre")
	String nombre;
	@Column(name="descripción")
	String descripción;
	@Column(name="tipo")
	String tipo; //(terrestre/marítimo)
	@Column(name="otros")
	String otros; //detalles relevantes
	
	@OneToMany(mappedBy = "produtlogis")
	private List<EnvioTerrestreEntity> envio_terrestre;
	
	 
}
