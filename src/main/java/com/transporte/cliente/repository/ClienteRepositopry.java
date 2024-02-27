package com.transporte.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.cliente.entities.ClienteEntity;
@Repository
public interface ClienteRepositopry extends JpaRepository<ClienteEntity, Long>{

}
