package com.example.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO {
    private Integer id;
    private String logadouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Boolean endPrincipal;
    
    public EnderecoDTO(Integer id, String logadouro, String cep, Integer numero, String cidade, Boolean endPrincipal) {
        this.id = id;
        this.logadouro = logadouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.endPrincipal = endPrincipal;
    }

    
}
