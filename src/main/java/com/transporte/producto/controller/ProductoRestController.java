package com.transporte.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.producto.entities.ProductoEntity;
import com.transporte.producto.repository.ProductoRepository;

@RestController
@RequestMapping("/transporte")
public class ProductoRestController {

	@Autowired
	ProductoRepository productoRepository;

	@GetMapping("/producto")
	public List<ProductoEntity> obtenerProducto() {
		return productoRepository.findAll();
	}

	@GetMapping("/producto/{id}")
	public Optional<ProductoEntity> obtenerProductoId(@PathVariable long id) {
		return productoRepository.findById(id);
	}

	// Endpoint para crear un nuevo cliente
	@PostMapping("/producto")
	public ResponseEntity<String> crearProducto(@RequestBody ProductoEntity producto) {
		productoRepository.save(producto);
		return new ResponseEntity<>("producto creado correctamente", HttpStatus.CREATED);
	}

	@PutMapping("/producto/{id}")
	public ResponseEntity<String> modificarProducto(@PathVariable long id, @RequestBody ProductoEntity producto) {
		productoRepository.save(producto);
		return new ResponseEntity<>("producto modificado correctamente", HttpStatus.CREATED);
	}

	@DeleteMapping("/producto/{id}")
	public ResponseEntity<String> eliminarProducto(@PathVariable long id) {
		productoRepository.deleteById(id);
		return new ResponseEntity<>("producto eliminado correctamente", HttpStatus.ACCEPTED);

	}
}
