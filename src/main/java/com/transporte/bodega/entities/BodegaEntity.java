package com.transporte.bodega.entities;

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
@Table(name = "bodegas")
public class BodegaEntity {
	
	public BodegaEntity() {
		super();
	}
	public BodegaEntity(long id_bodega, String nombre, String ubicacion, String detalle) {
		super();
		this.id_bodega = id_bodega;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.detalle = detalle;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_bodega")
	long id_bodega;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "ubicacion")
	String ubicacion;
	@Column(name = "detalle")
	String detalle;
	
	@OneToMany(mappedBy = "bodegas")
	private List<EnvioTerrestreEntity> envio_terrestre;
	
	public long getId_bodega() {
		return id_bodega;
	}
	public void setId_bodega(long id_bodega) {
		this.id_bodega = id_bodega;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	
	
}
