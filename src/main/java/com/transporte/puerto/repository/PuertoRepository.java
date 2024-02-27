package com.transporte.puerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.bodega.entities.BodegaEntity;
import com.transporte.puerto.entities.PuertoEntity;
@Repository
public interface PuertoRepository extends JpaRepository<PuertoEntity, Long> {

}
