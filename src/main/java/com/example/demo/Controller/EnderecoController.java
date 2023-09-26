package com.example.demo.Controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Endereco;
import com.example.demo.Service.EnderecoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarEndereco(@RequestBody Endereco endereco) {
        Endereco newEndereco = enderecoService.criarEndereco(endereco);
        return ResponseEntity.ok().body(newEndereco);

    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultarEndereco(@PathVariable Integer id) {
        Optional<Endereco> findEndereco = enderecoService.consultaEnderecoById(id);
        return ResponseEntity.ok().body(findEndereco);

    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarEnderecos() {
        List<Endereco> findEndereco = enderecoService.consultarEnderecos();
        return ResponseEntity.ok().body(findEndereco);
    }

    @GetMapping("/consultarIdPessoa/{id}")
    public ResponseEntity<?> consultarEnderecoByPessoa(@PathVariable Integer id) {
        List<Endereco> findEndereco = enderecoService.consultarEnderecosByPessoa(id);
        return ResponseEntity.ok().body(findEndereco);

    }

    @PutMapping("/enderecoPrincipal/{id}")
    public ResponseEntity<?> mudaEnderecoPrincipal(@PathVariable Integer id) {
        Optional<Endereco> endereco = enderecoService.setEnderecoPrincipal(id);
        return ResponseEntity.ok().body(endereco);

    }

}
