package com.services;
import com.models.Alerta;
import java.util.ArrayList;
import java.util.List;


public class AlertaService {
    private List<Alerta> alertas = new ArrayList<>();

    public void cadastrar(Alerta alerta) {
        alertas.add(alerta);
    }

    public List<Alerta> listar() {
        return alertas;
    }

    public Alerta buscarPorId(int id) {
        for (Alerta alerta :  alertas) {
            if (alerta.getId() == id) {
                return alerta;
            }
        }
        return null;
    }

    public boolean atualizar(int id, String mensagem, int areaDeRiscoId) {
        Alerta alerta = buscarPorId(id);
        if (alerta != null) {
            alerta.setMensagem(mensagem);
            alerta.setAreaDeRiscoId(areaDeRiscoId);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        Alerta alerta = buscarPorId(id);
        if (alerta != null) {
            alertas.remove(alerta);
            return true;
        }
        return false;
    }
}
