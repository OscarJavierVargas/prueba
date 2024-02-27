package com.transporte.bodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.bodega.entities.BodegaEntity;
@Repository
public interface BodegaRepository extends JpaRepository<BodegaEntity, Long> {

}
