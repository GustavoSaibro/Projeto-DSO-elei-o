/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.UrnaController;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaUrna {
    
    private Scanner teclado;
    private UrnaController urnaController;

    public TelaUrna() {
        teclado = new Scanner(System.in);
    }

    public TelaUrna(UrnaController urnaController) {
        teclado = new Scanner(System.in);
        this.urnaController = urnaController;
    }
    
    public void opcoesUrna(){
    
    int opcao = 0;
        System.out.println("O que você deseja fazer?");
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("1- Para Cadastrar Urna");
        System.out.println("2- Para Excluir Urna");
        System.out.println("3- Para Listar Urnas");
        System.out.println("4- Voltar");

        opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                cadastrarUrna();
                break;
            case 2:
                excluirUrna();
                break;
            case 3:
                listarUrnas();
                break;
            case 4:
                voltar();
                break;
            default:
                erroOpcoes();
                break;
        }
    }
    
    private void erroOpcoes() {
        System.out.println("Voce digitou um valor não valido!");
        opcoesUrna();
    }
    
    private void cadastrarUrna(){
        //urnaController.cadastrarUrna();
    }
    private void excluirUrna(){
        //urnaController.excluirUrna();
    }
    private void listarUrnas(){
        //urnaController.listarUrnas();
    }
    
    private void voltar(){
        //urnaController.opcoes();
    }
    
}
