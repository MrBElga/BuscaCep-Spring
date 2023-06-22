package com.example.demo.db.entidades;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.db.repositorio.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    public Endereco findByCep(String cep);
}
