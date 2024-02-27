package com.transporte.bodega.controller;

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

import com.transporte.bodega.entities.BodegaEntity;
import com.transporte.bodega.repository.BodegaRepository;

@RestController
@RequestMapping(value = "/transporte")
public class BodegaRestController {
	@Autowired
	BodegaRepository bodegaRepository;

	@GetMapping("/bodega")
	public List<BodegaEntity> obtenerBodega() {
		return bodegaRepository.findAll();
	}

	@GetMapping("/bodega/{id}")
	public Optional<BodegaEntity> obtenerBodegaId(@PathVariable long id) {
		return bodegaRepository.findById(id);
	}

	// Endpoint para crear un nuevo cliente
	@PostMapping("/bodega")
	public ResponseEntity<String> crearBodega(@RequestBody BodegaEntity producto) {
		bodegaRepository.save(producto);
		return new ResponseEntity<>("Bodega creado correctamente", HttpStatus.CREATED);
	}

	@PutMapping("/bodega/{id}")
	public ResponseEntity<String> modificarBodega(@PathVariable long id, @RequestBody BodegaEntity producto) {
		bodegaRepository.save(producto);
		return new ResponseEntity<>("Bodega modificado correctamente", HttpStatus.CREATED);
	}

	@DeleteMapping("/bodega/{id}")
	public ResponseEntity<String> eliminarBodega(@PathVariable long id) {
		bodegaRepository.deleteById(id);
		return new ResponseEntity<>("Bodega eliminado correctamente", HttpStatus.ACCEPTED);

	}

}
