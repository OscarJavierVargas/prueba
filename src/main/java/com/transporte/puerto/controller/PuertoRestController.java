package com.transporte.puerto.controller;

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
import com.transporte.puerto.entities.PuertoEntity;
import com.transporte.puerto.repository.PuertoRepository;

@RestController
@RequestMapping(value = "/transporte")
public class PuertoRestController {
	@Autowired
	PuertoRepository puertoRepository;

	@GetMapping("/puerto")
	public List<PuertoEntity> obtenerBodega() {
		return puertoRepository.findAll();
	}

	@GetMapping("/puerto/{id}")
	public Optional<PuertoEntity> obtenerPuertoId(@PathVariable long id) {
		return puertoRepository.findById(id);
	}

	// Endpoint para crear un nuevo cliente
	@PostMapping("/puerto")
	public ResponseEntity<String> crearPuerto(@RequestBody PuertoEntity producto) {
		puertoRepository.save(producto);
		return new ResponseEntity<>("puerto creado correctamente", HttpStatus.CREATED);
	}

	@PutMapping("/puerto/{id}")
	public ResponseEntity<String> modificarPuerto(@PathVariable long id, @RequestBody PuertoEntity producto) {
		puertoRepository.save(producto);
		return new ResponseEntity<>("puerto modificado correctamente", HttpStatus.CREATED);
	}

	@DeleteMapping("/puerto/{id}")
	public ResponseEntity<String> eliminarPuerto(@PathVariable long id) {
		puertoRepository.deleteById(id);
		return new ResponseEntity<>("puerto eliminado correctamente", HttpStatus.ACCEPTED);

	}

}
