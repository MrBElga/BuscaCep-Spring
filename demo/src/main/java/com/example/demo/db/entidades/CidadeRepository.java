package com.example.demo.db.entidades;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.db.repositorio.Cidade;
//import com.example.demo.db.repositorio.Endereco;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public Cidade findAllByNome(String Nome);

}