package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private void validaEnderecoPrincipal(Endereco endereco) {
        List<Endereco> findEndereco = enderecoRepository.findByPessoa(endereco.getPessoa());
        System.out.println(findEndereco);
        if (findEndereco.isEmpty()) {
            // sera o primeiro endereco para essa pessoa, logo sera o endereco principal.
            endereco.setEndPrincipal(true);
        } else {
            endereco.setEndPrincipal(false);
        }

    }

    private void negaEnderecoPrincipalByPessoa(Pessoa pessoa) {
        List<Endereco> listEnderecos = enderecoRepository.findByPessoa(pessoa);
        for (Endereco endereo : listEnderecos) {
            endereo.setEndPrincipal(false);
        }

    }

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

    public Endereco criarEndereco(Endereco endereco) {
        validarEndereco(endereco);
        validaEnderecoPrincipal(endereco);
        Endereco newEndereco = enderecoRepository.save(endereco);
        return newEndereco;

    }

    public Optional<Endereco> consultaEnderecoById(Integer id) {
        Optional<Endereco> findEndereco = enderecoRepository.findById(id);
        if (findEndereco == null) {
            throw new IllegalArgumentException("Nao ha endereço com este id de endereço");
        }
        return findEndereco;
    }

    public List<Endereco> consultarEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        if (enderecos == null) {
            throw new IllegalArgumentException("Nao ha endereços cadastrados");
        }
        return enderecos;
    }

    public List<Endereco> consultarEnderecosByPessoa(Integer id_pessoa) {
        Pessoa pessoa = new Pessoa(id_pessoa, null, null);
        List<Endereco> enderecosPessoa = enderecoRepository.findByPessoa(pessoa);
        if (enderecosPessoa == null) {
            throw new IllegalArgumentException("Nao ha endereços para este id de pessoa");
        }
        return enderecosPessoa;
    }

    public Optional<Endereco> setEnderecoPrincipal(Integer id) {
        Optional<Endereco> findEndereco = enderecoRepository.findById(id);
        Pessoa findPessoa = findEndereco.get().getPessoa();
        negaEnderecoPrincipalByPessoa(findPessoa);
        findEndereco.get().setEndPrincipal(true);
        // setar falso para outro end principal que contenha o mesmo idPessoa
        return findEndereco;

    }
}
