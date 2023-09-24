package com.example.projetoauto.model;

import com.example.projetoauto.helper.FirebaseHelper;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class Automovel {

    private String id;
    private String titulo;
    private String descricao;
    private String placa;
    private String modelo;
    private String ano;
    private String quilometragem;
    private String valorVendido;
    private String valorComprado;

    private String idEmpresa;
    private String idTipo;

    private List<String> urlImagens = new ArrayList<>();

    private Endereco endereco;



    public Automovel() {
        DatabaseReference automovelRef = FirebaseHelper.getDatabaseReference();
        this.setId(automovelRef.push().getKey());
    }


    public void salvar(){

    }

    public void remover(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(String valorVendido) {
        this.valorVendido = valorVendido;
    }

    public String getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(String valorComprado) {
        this.valorComprado = valorComprado;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public List<String> getUrlImagens() {
        return urlImagens;
    }

    public void setUrlImagens(List<String> urlImagens) {
        this.urlImagens = urlImagens;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
