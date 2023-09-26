package com.example.demo.Repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Endereco;
import com.example.demo.Model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
    List<Endereco> findByPessoa(Pessoa pessoa);
}
