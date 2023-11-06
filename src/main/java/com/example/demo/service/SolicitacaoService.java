package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    public Object getAllSolicitacao() {
        System.out.println((solicitacaoRepository.findAll().toString()));
        return solicitacaoRepository.findAll();

    }

}
