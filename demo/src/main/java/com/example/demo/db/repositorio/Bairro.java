package com.example.demo.db.repositorio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bai_id")
    private Long id;

    @Column(name = "bai_nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cid_id", nullable = false)
    private Cidade cidade;

    public Bairro() {
    }

    public Bairro(Long id, String nome, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
