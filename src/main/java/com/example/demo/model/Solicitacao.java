package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Solicitacao {

    @Id
    private Integer id;

    private String assunto;
    
    @ManyToOne
    @JoinColumn(name = "ID_ATENDENTE")
    private Atendente atendente;

    @ManyToOne
    @JoinColumn(name = "ID_FILASOLICITACAO")
    private FilaSolicitacao filaSolicitacao;
}
