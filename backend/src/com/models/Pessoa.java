package com.models;

public class Pessoa {

    private int id;
    private String nome;
    private String telefone;
    private String localizacao;

    public Pessoa(int id, String nome, String localizacao, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.localizacao = localizacao;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getLocalizacao() {return localizacao;}
    public void setLocalizacao(String localizacao) {this.localizacao = localizacao;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}


    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", CEP= " + localizacao + ", telefone=" + telefone + "]";
    }

}
