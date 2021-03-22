package br.uninove;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Aluno a = new Aluno();
        Curso curso = new Curso();
        ArrayList<Disciplina> listaDisciplinas = new ArrayList();
        Disciplina d1 = new Disciplina();
        Disciplina d2 = new Disciplina();
        Disciplina d3 = new Disciplina();
        
        d1.setNome("Programação Avançada");
        d1.setCargaHoraria(50);
        d1.setEmenta("Disciplina de Java EE ....");
        
        d2.setNome("Banco de dados");
        d2.setCargaHoraria(50);
        d2.setEmenta("Disciplina de Oracle ....");
        
        d3.setNome("Ética");
        d3.setCargaHoraria(25);
        d3.setEmenta("Disciplina de filosofia...");
        
        listaDisciplinas.add(d1);
        listaDisciplinas.add(d2);
        listaDisciplinas.add(d3);
        
        curso.setNomeCurso("Ciência da Computação");
        curso.setDisciplinas(listaDisciplinas);
        
        a.setNome("Fulaninho");
        a.setIdade(20);
        a.setCpf("123.123.123.00");
        a.setRa(6764);
        a.setCurso(curso);
                
        System.out.println("Aluno: " + a.getNome());
        System.out.println(a.getCurso().toString());
    }
}