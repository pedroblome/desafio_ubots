package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {

}
