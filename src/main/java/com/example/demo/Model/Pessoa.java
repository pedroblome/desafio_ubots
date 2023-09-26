package com.example.demo.Model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    @Id
    private Integer id;
    private String nome;
    private Date dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos;
    
}
