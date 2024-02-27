package com.transporte.enviopuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.bodega.entities.BodegaEntity;
import com.transporte.enviopuerto.entities.EnvioPuertoEntity;
import com.transporte.envioterrestre.entities.EnvioTerrestreEntity;
@Repository
public interface EnvioPuertoRepository extends JpaRepository<EnvioPuertoEntity, Long> {

}
