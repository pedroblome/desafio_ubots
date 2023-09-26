package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    // retorna apenas os dados de pessoa
    public PessoaDTO consultarPessoa(Integer id) {
        Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
        if (findPessoa == null) {
            throw new IllegalArgumentException("Id de pessoa nao achado no sistema.");
        }
        Pessoa pessoa = findPessoa.get();
        PessoaDTO findPessoaDto = new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento());
        return findPessoaDto;
    }

    // retorna pessoa com dados de enderecos
    public Optional<Pessoa> consultarPessoaComEndereco(Integer id) {
        Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
        if (findPessoa == null) {
            throw new IllegalArgumentException("Id de pessoa nao achado no sistema.");
        }
        return findPessoa;
    }

    // retorna apenas os dados de pessoa
    public List<PessoaDTO> consultarPessoas() {
        List<Pessoa> findPessoas = pessoaRepository.findAll();
        List<PessoaDTO> pessoasDTOs = findPessoas.stream()
                .map(pessoa -> new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento()))
                .collect(Collectors.toList());
        return pessoasDTOs;
    }

    // retorna pessoa com dados de enderecos
    public List<Pessoa> consultarPessoasComEndereco() {
        List<Pessoa> findPessoas = pessoaRepository.findAll();
        return findPessoas;

    }

}
