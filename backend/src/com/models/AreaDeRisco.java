package com.models;

public class AreaDeRisco {

    private int id;
    private String nome;
    private String cordenadas;
    private boolean status;


    public AreaDeRisco(int id, String nome, String cordenadas,  boolean status) {
        this.id = id;
        this.nome = nome;
        this.cordenadas = cordenadas;
        this.status = status;

    }


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCordenadas() {return cordenadas;}
    public void setCordenadas(String cordenadas) {this.cordenadas = cordenadas;}

    public boolean isStatus() {return status;}
    public void setStatus(boolean status) {this.status = status;}


    @Override
    public String toString() {
        return "Area de risco [id=" + id + ", nome= " + nome +  ", status= " + status +  ", cordenadas= " + cordenadas + "]";
    }
}
