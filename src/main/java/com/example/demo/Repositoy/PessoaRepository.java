package com.example.demo.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
