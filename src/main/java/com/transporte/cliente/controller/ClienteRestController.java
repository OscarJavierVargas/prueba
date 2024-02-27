package com.transporte.cliente.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.transporte.cliente.entities.ClienteEntity;
import com.transporte.cliente.repository.ClienteRepositopry;
import com.transporte.producto.entities.ProductoEntity;
import com.transporte.producto.repository.ProductoRepository;
@RestController
@RequestMapping(value="/transporte")
public class ClienteRestController {
	@Autowired
	ClienteRepositopry clienteRepositopry;

	@GetMapping("/cliente")
	public ResponseEntity<List<ClienteEntity>> obtenerClientes() {
		
		if(clienteRepositopry.findAll().isEmpty()){
		return	ResponseEntity.noContent().build();
			
		} else{
			
		return ResponseEntity.ok(clienteRepositopry.findAll());
	}
	}
	@GetMapping("/cliente/{id}")
	public Optional<ClienteEntity> obtenerClientesId(@PathVariable long id) {
		return clienteRepositopry.findById(id);
	}

	// Endpoint para crear un nuevo cliente
	@PostMapping("/cliente")
	public ResponseEntity<String> crearCliente(@RequestBody ClienteEntity cliente) {
		clienteRepositopry.save(cliente);
	//	return new ResponseEntity<>("cliente creado correctamente", HttpStatus.CREATED);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/cliente/{id}")
	public ResponseEntity<String> modificarCliente(@PathVariable long id, @RequestBody ClienteEntity producto) {
		clienteRepositopry.save(producto);
		return new ResponseEntity<>("cliente modificado correctamente", HttpStatus.CREATED);
	}

	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<String> eliminarCliente(@PathVariable long id) {
		clienteRepositopry.deleteById(id);
		return new ResponseEntity<>("cliente eliminado correctamente", HttpStatus.ACCEPTED);

	}
}
