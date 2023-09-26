package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Pessoa;
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

    @PutMapping("/editar")
    public ResponseEntity<?> editarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.editarPessoa(pessoa);
        return ResponseEntity.ok().body(newPessoa);

    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultarbyId(@PathVariable Integer id) {
        Pessoa findPessoa = pessoaService.consultarPessoa(id);
        return ResponseEntity.ok().body(findPessoa);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultar() {
        List<Pessoa> findPessoa = pessoaService.consultarPessoas();
        return ResponseEntity.ok().body(findPessoa);
    }

}
