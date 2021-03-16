
package br.uninove;

                    //é 
public class Aluno extends Pessoa {
//    String nome;
//    String cpf;
//    int idade;
    private int ra;
    private Curso curso;

    public Aluno(String nome, String cpf, int idade, int ra, Curso curso) {
       super(nome, cpf, idade);
       this.ra = ra;
       this.curso = curso;
    }
    
    public Aluno(){
        super();
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
 
}
