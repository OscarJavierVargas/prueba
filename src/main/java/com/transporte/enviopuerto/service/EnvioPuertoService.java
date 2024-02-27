package com.transporte.enviopuerto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.transporte.enviopuerto.entities.EnvioPuertoEntity;
import com.transporte.enviopuerto.repository.EnvioPuertoRepository;

@Service
public class EnvioPuertoService {
	@Autowired
	EnvioPuertoRepository envioPuertoRepository;

	public List<EnvioPuertoEntity> obtenerEnvioP() {
		return envioPuertoRepository.findAll();
	}

	public Optional<EnvioPuertoEntity> obtenerEnvioPId(long id) {
		return envioPuertoRepository.findById(id);
	}

	public EnvioPuertoEntity crearEnvioP(EnvioPuertoEntity EnvioT) {

		int cantida = EnvioT.getCantidad_producto();
		if (cantida >= 10) {
			EnvioT.setDesc_precio_envio(EnvioT.getPrecio_envio() * 0.97);

		} else {
			EnvioT.setDesc_precio_envio(EnvioT.getPrecio_envio());
			envioPuertoRepository.save(EnvioT);
		}

		EnvioPuertoEntity saved = envioPuertoRepository.save(EnvioT);
		return saved;

	}

	public EnvioPuertoEntity modificarEnvioP(EnvioPuertoEntity EnvioT) {

		return envioPuertoRepository.save(EnvioT);

	}

	@DeleteMapping("/terrestre/{id}")
	public void eliminarEnvioP(long id) {
		envioPuertoRepository.deleteById(id);

	}
}
