package com.services;

import com.models.AreaDeRisco;
import java.util.ArrayList;
import java.util.List;



public class AreaDeRiscoService {
    private List<AreaDeRisco> areas = new ArrayList<>();

    public void cadastrar(AreaDeRisco area) {
        areas.add(area);
    }

    public List<AreaDeRisco> listar() {
        return areas;
    }

    public AreaDeRisco buscarPorId(int id) {
        for (AreaDeRisco area : areas) {
            if (area.getId() == id) {
                return area;
            }
        }
        return null;
    }

    public boolean atualizar(int id, String nome, boolean status) {
        AreaDeRisco area = buscarPorId(id);
        if (area != null) {
            area.setNome(nome);
            area.setStatus(status);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        AreaDeRisco area = buscarPorId(id);
        if (area != null) {
            areas.remove(area);
            return true;
        }
        return false;
    }
}
