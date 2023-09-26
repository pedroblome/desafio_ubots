package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Endereco;
import com.example.demo.Model.Pessoa;
import com.example.demo.Repositoy.EnderecoRepository;
import com.example.demo.Repositoy.PessoaRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    private void validarEndereco(Endereco endereco) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(endereco.getPessoa().getId());

        if (pessoa == null) {
            throw new IllegalArgumentException("Campo id_pessoa nao pertence a nenhuma pessoa no sistema.");
        }

        else if (endereco.getCep() == null || endereco.getCidade() == null || endereco.getLogadouro() == null
                || endereco.getNumero() == null) {
            throw new IllegalArgumentException("Cep, Cidade, Logradouro e Numero são obrigatorios.");
        }
    }

    private Endereco criarEndereco(Endereco endereco) {
        validarEndereco(endereco);
        Endereco newEndereco = enderecoRepository.save(endereco);
        return newEndereco;

    }

}
