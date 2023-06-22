package com.example.demo.db.entidades;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.db.repositorio.Bairro;
//import com.example.demo.db.repositorio.Endereco;

public interface BairroRepository extends JpaRepository<Bairro, Long> {

}
