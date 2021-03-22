package br.uninove;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private String ementa;

    public Disciplina() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @Override
    public String toString() {
        return getNome() + " (" + getCargaHoraria() + "hs)";
                
    }
    
}