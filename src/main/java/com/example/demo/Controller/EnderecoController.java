package com.example.demo.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Endereco;
import com.example.demo.Service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarEndereco(@RequestBody Endereco endereco){
        Endereco newEndereco = enderecoService.criarEndereco(endereco);
        return ResponseEntity.ok().body(newEndereco);
        
    }


    
}
