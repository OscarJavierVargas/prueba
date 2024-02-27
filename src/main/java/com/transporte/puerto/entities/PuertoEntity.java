package com.transporte.puerto.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transporte.enviopuerto.entities.EnvioPuertoEntity;
import com.transporte.envioterrestre.entities.EnvioTerrestreEntity;

@Entity
@Table(name = "puerto")
public class PuertoEntity {
	
	public PuertoEntity() {
		super();
	}
	public PuertoEntity(long id_puerto, String nombre, String ubicacion, String detalle) {
		super();
		this.id_puerto = id_puerto;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.detalle = detalle;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_puerto")
	long id_puerto;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "ubicacion")
	String ubicacion;
	@Column(name = "detalle")
	String detalle;
	
	@OneToMany(mappedBy = "puerto")
	private List<EnvioPuertoEntity> envio_maritimo;
	
	public long getId_puerto() {
		return id_puerto;
	}
	public void setId_puerto(long id_puerto) {
		this.id_puerto = id_puerto;
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
