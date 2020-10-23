package com.example.pocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocapi.model.Formulario;

public interface TransferenciaRepository extends JpaRepository<Formulario, Long> {

}
