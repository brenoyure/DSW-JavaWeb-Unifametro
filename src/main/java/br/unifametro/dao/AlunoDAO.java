package br.unifametro.dao;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

import br.unifametro.entidades.Aluno;

public class AlunoDAO {

    private static List<Aluno> bd = new ArrayList<>();

    public void cadastrar(Aluno aluno) {
        bd.add(aluno);
    }

    public List<Aluno> findAll() {
        return unmodifiableList(bd);
    }

}
