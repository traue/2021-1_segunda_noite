package br.uninove;

import java.util.List;

public class Curso {

    private String nomeCurso;
    private List<Disciplina> disciplinas;

    public Curso() {
    }

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        int cargaHoraria = 0;
        try {
            for (Disciplina d : disciplinas) {
                cargaHoraria += d.getCargaHoraria();
            }
            return cargaHoraria;
        } catch (NullPointerException e) {
            return 0;
        }

    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    @Override
    public String toString() {
        String info = "";
        info += "Curso: " + getNomeCurso() + " - " + getCargaHoraria() + "horas";
        info += "\nDisciplinas: \n";
        for(Disciplina d : getDisciplinas()) {
            info += "\t - " + d.toString() + "\n";
        }
        return info;
    }
}
