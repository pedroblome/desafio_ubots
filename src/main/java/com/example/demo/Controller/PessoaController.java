package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.ok().body(newPessoa);
        
    }
    
}
