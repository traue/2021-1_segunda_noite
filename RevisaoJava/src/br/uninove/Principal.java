package br.uninove;

//import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
//        System.out.println("Palavra 1");
//        System.out.println("Palavra 2");
//        int idade;
//        String nome;
//        
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Sua idade: ");
//        idade = sc.nextInt();
//        
//        System.out.print("Nome: ");
//        nome = sc.next();
//        
//        System.out.println("Olá " + nome + ", você tem " + idade + " anos!");
          Pessoa p = new Pessoa();
          p.setNome("Thiago G. Traue");
          p.setIdade(33);
          p.setCpf("123.123.321-00");
          
          Pessoa p2 = new Pessoa("Fulano", "321.321.321-00", 60);
          
          Aluno a1 = new Aluno();
          a1.setNome("Beltrano");
          a1.setRa(1234);
          a1.setCurso(new Curso("Medicina", 20000));
          //..
          
          Curso curso = new Curso();
          curso.setNomeCurso("Astronomia");
          curso.setCargaHoraria(600);

          Aluno a2 = new Aluno("Super Mario", "444.444.444-00", 60, 64, curso);

    }
}


/*
    DESAFIO DO TIO:
    CRIAR UMA CLASSE CHAMADA DISCIPLINA COM OS ATRIBUTOS:
         - NOME
         - CH
         - EMENTA

    criar a classe professor com:
        - matricula
        - ch;
*/