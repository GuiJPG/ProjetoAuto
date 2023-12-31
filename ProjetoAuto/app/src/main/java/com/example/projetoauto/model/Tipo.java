package com.example.projetoauto.model;

import java.io.Serializable;

public class Tipo implements Serializable {

    private int caminho;
    private String nome;

    public Tipo(int caminho, String nome) {
        this.caminho = caminho;
        this.nome = nome;
    }

    public int getCaminho() {
        return caminho;
    }

    public void setCaminho(int caminho) {
        this.caminho = caminho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
