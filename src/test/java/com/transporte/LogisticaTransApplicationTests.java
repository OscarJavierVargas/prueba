package com.transporte;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.transporte.bodega.controller.BodegaRestController;
import com.transporte.bodega.entities.BodegaEntity;

@SpringBootTest
class LogisticaTransApplicationTests {
	@Autowired
	BodegaRestController bodegaRestController;

	@Test
	void contextLoads() {
		
		  // Crear un objeto BodegaEntity para la prueba
	    BodegaEntity expectedBodega = new BodegaEntity(1, "zona f", "avenida mis- av siempre", "solo productos quimicos");

	   
	    // Obtener el Optional de la BodegaEntity obtenida del controlador
	    Optional<BodegaEntity> actualOptional = bodegaRestController.obtenerBodegaId(1);

	    // Obtener el valor de la BodegaEntity en el Optional (si está presente)
	    BodegaEntity actualBodega = actualOptional.orElse(null);

	    // Comparar los valores directamente

	    assertEquals(expectedBodega.getId_bodega(), actualBodega.getId_bodega());
	    assertEquals(expectedBodega.getDetalle(), actualBodega.getDetalle());
	    assertEquals(expectedBodega.getUbicacion(), actualBodega.getUbicacion());
	    assertEquals(expectedBodega.getUbicacion(), actualBodega.getUbicacion());
	    
//	assertTrue(condition);
//	assertFalse(condition);
//		
		
		
	}

}
