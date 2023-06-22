package com.example.demo.controllers;

import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entidades.BairroRepository;
import com.example.demo.db.entidades.CidadeRepository;
import com.example.demo.db.entidades.EnderecoRepository;
import com.example.demo.db.repositorio.Endereco;

@CrossOrigin
@RestController
@RequestMapping("/apis")
public class CepRestController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping(value = "/consultarCep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultarCep(@PathVariable("cep") String cep) {
        Endereco endereco = enderecoRepository.findByCep(cep);

        if (endereco != null) {
            String cidadeNome = endereco.getCidade().getNome();
            String bairroNome = endereco.getBairro().getNome();

            String enderecoCompleto = endereco.getLocalEnd() + ", " + bairroNome + ", " + cidadeNome;

            Map<String, String> response = new HashMap<>();
            response.put("enderecoCompleto", enderecoCompleto);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Endereço não encontrado");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
