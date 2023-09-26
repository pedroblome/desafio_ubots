package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Pessoa;
import com.example.demo.Model.PessoaDTO;
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

    public Pessoa criarPessoa(Pessoa pessoa) {
        validarPessoa(pessoa);
        Pessoa newPessoa = pessoaRepository.save(pessoa);
        return newPessoa;

    }

    public Pessoa editarPessoa(Pessoa pessoa) {
        validarPessoa(pessoa);
        Pessoa updatePessoa = pessoaRepository.save(pessoa);
        return updatePessoa;
    }

    public Pessoa consultarPessoa(Integer id) {
        Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
        if (findPessoa == null) {
            throw new IllegalArgumentException("Id de pessoa nao achado no sistema.");
        }
        Pessoa pessoa = findPessoa.get();
        return pessoa;
    }


    public List<Pessoa> consultarPessoas() {
        List<Pessoa> findPessoas = pessoaRepository.findAll();
        if(findPessoas.isEmpty()){
            throw new IllegalArgumentException("Nao ha pessoas cadastradas no sistema.");

        }
        return findPessoas;
    }


}
