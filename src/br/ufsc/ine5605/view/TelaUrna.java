/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorUrna;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaUrna {
    
    private Scanner teclado;
    private ControladorUrna urnaController;

    public TelaUrna() {
        teclado = new Scanner(System.in);
    }

    public TelaUrna(ControladorUrna urnaController) {
        teclado = new Scanner(System.in);
        this.urnaController = urnaController;
    }
    
    public void opcoesUrna(){
        int opcao = 0;
        System.out.println("--------- OPÇÕES DE URNA ---------");
        System.out.println("----------------------------------");
        System.out.println("1 - Cadastrar Urna");
        System.out.println("2 - Excluir Urna");
        System.out.println("3 - Listar Urna");
        opcao = teclado.nextInt();
        
        switch(opcao){
            case 1:
                cadastrarUrna();
                break;
            
            case 2:
                excluirUrna();
                break;
            
            case 3:
                listarUrnas();
                break;
        }
    }
    public void cadastrarUrna(){
        int secao = 0;
        String cidadeUrna = " ";
        System.out.println("Digite a seção da urna");
        secao = teclado.nextInt();
        System.out.println("Digite a cidade a qual a urna irá pertencer");
        cidadeUrna = teclado.next();
        
        urnaController.cadastrarUrna(secao, cidadeUrna);
    }
    public void excluirUrna(){}
    public void listarUrnas(){}
    
}
