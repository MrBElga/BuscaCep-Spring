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
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_cep")
    private String cep;

    @Column(name = "end_local")
    private String localEnd;

    @ManyToOne
    @JoinColumn(name = "cid_id", nullable = false)
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "bai_id", nullable = false)
    private Bairro bairro;

    public Endereco() {
    }

    public Endereco(String cep, String localEnd, Cidade cidade, Bairro bairro) {
        this.cep = cep;
        this.localEnd = localEnd;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalEnd() {
        return localEnd;
    }

    public void setLocalEnd(String localEnd) {
        this.localEnd = localEnd;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

}
