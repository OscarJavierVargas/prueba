package com.transporte.cliente.entities;

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
@Table(name="clienteLogist")
public class ClienteEntity {
	
	
	
	
	public ClienteEntity() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cliente")
	long id_cliente;
	@Column(name="nombre")
	String nombre;
	@Column(name="apellido")
	String apellido;
	@Column(name="documento")
	String documento;
	@Column(name="tipo_transporte")
	String tipo_transporte; //maritimo o terrestre
	@Column(name="detalles")
	String detalles;
	
	@OneToMany(mappedBy = "clienteLogist")
	private List<EnvioTerrestreEntity> envio_terrestre;
	
	
	
	
	public ClienteEntity(long id_cliente, String nombre, String apellido, String documento, String tipo_transporte,
			String detalles) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.tipo_transporte = tipo_transporte;
		this.detalles = detalles;
	}
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipo_transporte() {
		return tipo_transporte;
	}
	public void setTipo_transporte(String tipo_transporte) {
		this.tipo_transporte = tipo_transporte;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	

}
