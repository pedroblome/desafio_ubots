package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Pessoa;
import com.example.demo.Model.PessoaDTO;
import com.example.demo.Service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.ok().body(newPessoa);

    }
    //consulta por id somente PessoaDTO
    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultarbyId(@PathVariable Integer id) {
        PessoaDTO findPessoa = pessoaService.consultarPessoa(id);
        return ResponseEntity.ok().body(findPessoa);
    }

    //consulta por id Pessoa
    @GetMapping("/consultarAll/{id}")
    public ResponseEntity<?> consultarAllbyId(@PathVariable Integer id) {
        Optional<Pessoa> findPessoa = pessoaService.consultarPessoaComEndereco(id);
        return ResponseEntity.ok().body(findPessoa);
    }

    //consulta todos PessoaDTO
    @GetMapping("/consultar")
    public ResponseEntity<?> consultar() {
        List<PessoaDTO> findPessoa = pessoaService.consultarPessoas();
        return ResponseEntity.ok().body(findPessoa);
    }


    //consulta todos Pessoa
    @GetMapping("/consultarAll")
    public ResponseEntity<List<Pessoa>> consultarAll() {
        List<Pessoa> findPessoas = pessoaService.consultarPessoasComEndereco();
        return ResponseEntity.ok().body(findPessoas);
    }

    
}
