package com.transporte.enviopuerto.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.enviopuerto.entities.EnvioPuertoEntity;
import com.transporte.enviopuerto.service.EnvioPuertoService;
import com.transporte.envioterrestre.entities.EnvioTerrestreEntity;
import com.transporte.envioterrestre.service.EnvioTerrestreService;

@RestController
@RequestMapping(value = "/transporte")
public class EnvioPuertoRestController {

	@Autowired
	EnvioPuertoService envioPuertoService;

	@GetMapping("/EvioPuerto")
	public ResponseEntity<List<EnvioPuertoEntity>> obtenerEnvioT() {
		if (envioPuertoService.obtenerEnvioP().isEmpty()) {
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.ok(envioPuertoService.obtenerEnvioP());
		}
	}

	// Endpoint para buscar cliente por id
	@GetMapping("/EvioPuerto/{id}")
	public ResponseEntity<EnvioPuertoEntity> obtenerEnvioTId(@PathVariable long id) {
		return envioPuertoService.obtenerEnvioPId(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	// Endpoint para crear un nuevo cliente
	@PostMapping("/EvioPuerto")
	public ResponseEntity<String> crearEnvioT(@Valid @RequestBody EnvioPuertoEntity EnvioT,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// Si hay errores de validación, retorna una respuesta con los errores
			List<FieldError> errors = bindingResult.getFieldErrors();
			StringBuilder errorMessage = new StringBuilder("Error en los datos del envío: ");
			for (FieldError error : errors) {
				errorMessage.append(error.getDefaultMessage()).append("; ");
			}
			return ResponseEntity.badRequest().body(errorMessage.toString());
		}
		String patron = "[a-zA-Z0-9]{10}";

		// Compilar el patrón
		Pattern pattern = Pattern.compile(patron);
		// Crear un objeto Matcher
		Matcher matcher = pattern.matcher(EnvioT.getNumero_guía());
		// Verificar si el número cumple con el patrón
		if (matcher.matches()) {

			envioPuertoService.crearEnvioP(EnvioT);
		} else {

			return new ResponseEntity<>(
					"EnvioT no cumple con la validacion de datos numero de guia Numero (único alfanumérico de 10 dígitos)",
					HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>("envio terrestre creado correctamente)", HttpStatus.CREATED);

	}

	@PutMapping("/EvioPuerto/{id}")
	public ResponseEntity<String> modificarEnvioT(@PathVariable long id, @RequestBody EnvioPuertoEntity EnvioT,
			BindingResult bindingResult) {
		List<EnvioPuertoEntity> updateen = envioPuertoService.obtenerEnvioP();
		for (int i = 0; i < updateen.size(); i++) {
			if (updateen.get(i).getId_envio() == id) {
				
				if (bindingResult.hasErrors()) {
					// Si hay errores de validación, retorna una respuesta con los errores
					List<FieldError> errors = bindingResult.getFieldErrors();
					StringBuilder errorMessage = new StringBuilder("Error en los datos del envío: ");
					for (FieldError error : errors) {
						errorMessage.append(error.getDefaultMessage()).append("; ");
					}
					return ResponseEntity.badRequest().body(errorMessage.toString());
				}
				String patron = "[a-zA-Z0-9]{10}";

				// Compilar el patrón
				Pattern pattern = Pattern.compile(patron);
				// Crear un objeto Matcher
				Matcher matcher = pattern.matcher(EnvioT.getNumero_guía());
				// Verificar si el número cumple con el patrón
				if (matcher.matches()) {

					envioPuertoService.crearEnvioP(EnvioT);
				} else {

					return new ResponseEntity<>(
							"EnvioT no cumple con la validacion de datos numero de guia Numero (único alfanumérico de 10 dígitos)",
							HttpStatus.BAD_REQUEST);

				}
				return new ResponseEntity<>("envio terrestre creado correctamente)", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("id no encontrado", HttpStatus.BAD_REQUEST);
		}
		return null;
	}


	@DeleteMapping("/EvioPuerto/{id}")
	public ResponseEntity<String> eliminarEnvioT(@PathVariable long id) {
		List<EnvioPuertoEntity> all = envioPuertoService.obtenerEnvioP();
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).getId_envio() == id) {
			return new ResponseEntity<>("eliminado correctamente", HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>("id de envio no existe", HttpStatus.NO_CONTENT);
		}
		}
		return null;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		String errorMessage = result.getFieldErrors().get(0).getDefaultMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}

}
