package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Pessoa;
import com.example.demo.Repositoy.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;


    private void validarPessoa(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getDataNascimento() == null) {
            throw new IllegalArgumentException("Nome e data de nascimento são campos obrigatórios.");
        }
    }

    private Pessoa criarPessoa(Pessoa pessoa){
        validarPessoa(pessoa);
        Pessoa newPessoa = pessoaRepository.save(pessoa);
        return newPessoa;
     
    }
}
