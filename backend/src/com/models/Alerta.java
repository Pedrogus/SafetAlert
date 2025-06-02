package com.models;



public class Alerta {

    private int id;
    private String mensagem;
    private int areaDeRiscoId;

    public Alerta(int id, String mensagem, int areaDeRiscoId) {
        this.id = id;
        this.mensagem = mensagem;
        this.areaDeRiscoId = areaDeRiscoId;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getMensagem() {return mensagem;}
    public void setMensagem(String mensagem) {this.mensagem = mensagem;}

    public int getAreaDeRiscoId() {return areaDeRiscoId;}
    public void setAreaDeRiscoId(int areaDeRiscoId) {this.areaDeRiscoId = areaDeRiscoId;}

    @Override
    public String toString() {
        return "Alerta [id= " + id + ", mensagem = " + mensagem +  ", areaDeRiscoId= " + areaDeRiscoId + "]";
    }


}
