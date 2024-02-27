package com.transporte.enviopuerto.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.transporte.bodega.entities.BodegaEntity;
import com.transporte.cliente.entities.ClienteEntity;
import com.transporte.producto.entities.ProductoEntity;
import com.transporte.puerto.entities.PuertoEntity;



@Entity
@Table(name = "envio_maritimo")
public class EnvioPuertoEntity {

	public EnvioPuertoEntity() {
		super();
	}
	public EnvioPuertoEntity(long id_envio, @NotBlank(message = "El campo envio no puede estar vacío") String envio,
			@NotBlank(message = "El campo tipo_producto no puede estar vacío") String tipo_producto,
			@Min(value = 0, message = "La cantidad_producto debe ser un número positivo") int cantidad_producto,
			@NotBlank(message = "El campo fecha_registro no puede estar vacío") LocalDate fecha_registro,
			@NotBlank(message = "El campo bodega_entrega no puede estar vacío") String puerto_entrega,
			double precio_envio, double desc_precio_envio, String numero_flota, String numero_guía, String detalles,
			ClienteEntity clienteLogist, PuertoEntity puerto, ProductoEntity produtlogis) {
		super();
		this.id_envio = id_envio;
		this.envio = envio;
		this.tipo_producto = tipo_producto;
		this.cantidad_producto = cantidad_producto;
		this.fecha_registro = fecha_registro;
		this.puerto_entrega = puerto_entrega;
		this.precio_envio = precio_envio;
		this.desc_precio_envio = desc_precio_envio;
		this.numero_flota = numero_flota;
		this.numero_guía = numero_guía;
		this.detalles = detalles;
		this.clienteLogist = clienteLogist;
		this.puerto = puerto;
		this.produtlogis = produtlogis;
	}

	
	

	public long getId_envio() {
		return id_envio;
	}
	public void setId_envio(long id_envio) {
		this.id_envio = id_envio;
	}
	public String getEnvio() {
		return envio;
	}
	public void setEnvio(String envio) {
		this.envio = envio;
	}
	public String getTipo_producto() {
		return tipo_producto;
	}
	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public LocalDate getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(LocalDate fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getPuerto_entrega() {
		return puerto_entrega;
	}
	public void setPuerto_entrega(String puerto_entrega) {
		this.puerto_entrega = puerto_entrega;
	}
	public double getPrecio_envio() {
		return precio_envio;
	}
	public void setPrecio_envio(double precio_envio) {
		this.precio_envio = precio_envio;
	}
	public double getDesc_precio_envio() {
		return desc_precio_envio;
	}
	public void setDesc_precio_envio(double desc_precio_envio) {
		this.desc_precio_envio = desc_precio_envio;
	}
	public String getNumero_flota() {
		return numero_flota;
	}
	public void setNumero_flota(String numero_flota) {
		this.numero_flota = numero_flota;
	}
	public String getNumero_guía() {
		return numero_guía;
	}
	public void setNumero_guía(String numero_guía) {
		this.numero_guía = numero_guía;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public ClienteEntity getClienteLogist() {
		return clienteLogist;
	}
	public void setClienteLogist(ClienteEntity clienteLogist) {
		this.clienteLogist = clienteLogist;
	}
	public PuertoEntity getPuerto() {
		return puerto;
	}
	public void setPuerto(PuertoEntity puerto) {
		this.puerto = puerto;
	}
	public ProductoEntity getProdutlogis() {
		return produtlogis;
	}
	public void setProdutlogis(ProductoEntity produtlogis) {
		this.produtlogis = produtlogis;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_envio")
	long id_envio;
	
	@Column(name = "envio")
	@NotBlank(message = "El campo envio no puede estar vacío")
	String envio;
	@NotBlank(message = "El campo tipo_producto no puede estar vacío")
	@Column(name = "tipo_producto")
	String tipo_producto;
	 @Min(value = 0, message = "La cantidad_producto debe ser un número positivo")
	@Column(name = "cantidad_producto")
	int cantidad_producto;
	@NotBlank(message = "El campo fecha_registro no puede estar vacío")
	@Column(name = "fecha_registro")
	LocalDate fecha_registro;
	@NotBlank(message = "El campo bodega_entrega no puede estar vacío")
	@Column(name = "puerto_entrega")
	String puerto_entrega;
	@Column(name = "precio_envio")
	double precio_envio;
	@Column(name = "desc_precio_envio")
	double desc_precio_envio;
	@Column(name = "numero_flota")
	String numero_flota; // (El formato debe corresponder a 3 letras iniciales y 3 números finales)
	@Column(name = "numero_guía")
	String numero_guía; // (Numero único alfanumérico de 10 dígitos)
	@Column(name = "detalles")
	String detalles;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	ClienteEntity clienteLogist;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "id_puerto")
	PuertoEntity puerto;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "id_producto")
	ProductoEntity produtlogis;

	
	
}
