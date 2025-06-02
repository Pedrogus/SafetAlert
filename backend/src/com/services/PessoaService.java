package com.services;


import com.models.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar(Pessoa p) {
        pessoas.add(p);
    }

    public List<Pessoa> listar() {
        return pessoas;
    }

    public Pessoa buscarPorId(int id) {
        for (Pessoa p : pessoas) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean atualizar(int id, String novoNome, String novaLocalizacao, String novoTelefone) {
        Pessoa p = buscarPorId(id);
        if (p != null) {
            p.setNome(novoNome);
            p.setLocalizacao(novaLocalizacao);
            p.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        Pessoa p = buscarPorId(id);
        if (p != null) {
            pessoas.remove(p);
            return true;
        }
        return false;
    }
}
