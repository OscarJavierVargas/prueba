package com.transporte.envioterrestre.entities;

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



@Entity
@Table(name = "envio_terrestre")
public class EnvioTerrestreEntity {

	public EnvioTerrestreEntity() {
		super();
	}

	public EnvioTerrestreEntity(long id_envio, String envio, String tipo_producto, int cantidad_producto,
			LocalDate fecha_registro, String bodega_entrega, double precio_envio, double desc_precio_envio,
			String placa_vehículo, String numero_guía, String detalles, ClienteEntity clienteLogist,
			BodegaEntity bodegas, ProductoEntity produtlogis) {
		super();
		this.id_envio = id_envio;
		this.envio = envio;
		this.tipo_producto = tipo_producto;
		this.cantidad_producto = cantidad_producto;
		this.fecha_registro = fecha_registro;
		this.bodega_entrega = bodega_entrega;
		this.precio_envio = precio_envio;
		this.placa_vehículo = placa_vehículo;
		this.numero_guía = numero_guía;
		this.detalles = detalles;
		this.clienteLogist = clienteLogist;
		this.bodegas = bodegas;
		this.produtlogis = produtlogis;
		this.desc_precio_envio = desc_precio_envio;
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
	@Column(name = "bodega_entrega")
	String bodega_entrega;
	@Column(name = "precio_envio")
	double precio_envio;
	@Column(name = "desc_precio_envio")
	double desc_precio_envio;
	@Column(name = "placa_vehículo")
	String placa_vehículo; // (El formato debe corresponder a 3 letras iniciales y 3 números finales)
	@Column(name = "numero_guía")
	String numero_guía; // (Numero único alfanumérico de 10 dígitos)
	@Column(name = "detalles")
	String detalles;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	ClienteEntity clienteLogist;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "id_bodega")
	BodegaEntity bodegas;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "id_producto")
	ProductoEntity produtlogis;

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

	public String getBodega_entrega() {
		return bodega_entrega;
	}

	public void setBodega_entrega(String bodega_entrega) {
		this.bodega_entrega = bodega_entrega;
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

	public String getPlaca_vehículo() {
		return placa_vehículo;
	}

	public void setPlaca_vehículo(String placa_vehículo) {
		this.placa_vehículo = placa_vehículo;
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

	public BodegaEntity getBodegas() {
		return bodegas;
	}

	public void setBodegas(BodegaEntity bodegas) {
		this.bodegas = bodegas;
	}

	public ProductoEntity getProdutlogis() {
		return produtlogis;
	}

	public void setProdutlogis(ProductoEntity produtlogis) {
		this.produtlogis = produtlogis;
	}

}
