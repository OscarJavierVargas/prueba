package com.transporte.envioterrestre.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.transporte.envioterrestre.entities.EnvioTerrestreEntity;
import com.transporte.envioterrestre.repository.EnvioTerrestreRepository;


@Service
public class EnvioTerrestreService {
	@Autowired
	EnvioTerrestreRepository envioTerrestreRepository;


	public List<EnvioTerrestreEntity> obtenerEnvioT() {
		return envioTerrestreRepository.findAll();
	}


	public Optional<EnvioTerrestreEntity> obtenerEnvioTId( long id) {
		return envioTerrestreRepository.findById(id);
	}

	
	
	public EnvioTerrestreEntity crearEnvioT( EnvioTerrestreEntity EnvioT) {
		
        	int cantida=EnvioT.getCantidad_producto();				
    		if (cantida>=10) {
    			EnvioT.setDesc_precio_envio(EnvioT.getPrecio_envio()*0.95);
    			
    		}else {
    			EnvioT.setDesc_precio_envio(EnvioT.getPrecio_envio());
    			envioTerrestreRepository.save(EnvioT);
    		}
    		
    		EnvioTerrestreEntity saved =envioTerrestreRepository.save(EnvioT);
    		return saved;
           
        } 

	public EnvioTerrestreEntity modificarEnvioT(   EnvioTerrestreEntity EnvioT) {
			
	
		return envioTerrestreRepository.save(EnvioT);
	
	}


	@DeleteMapping("/terrestre/{id}")
	public void eliminarEnvioT(@PathVariable long id) {
		envioTerrestreRepository.deleteById(id);
		
	}

	}
