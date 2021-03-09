package br.uninove;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
//        System.out.println("Palavra 1");
//        System.out.println("Palavra 2");
        int idade;
        String nome;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Sua idade: ");
        idade = sc.nextInt();
        
        System.out.print("Nome: ");
        nome = sc.next();
        
        System.out.println("Olá " + nome + ", você tem " + idade + " anos!");
        
        //paramos aqui.. continuaremos daqui aula que vem
    }
}
