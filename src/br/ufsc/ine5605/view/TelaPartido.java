/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorPartido;
import java.util.Scanner;

/**
 *
 * @author 45336757861
 */
public class TelaPartido {
    private Scanner teclado;
    private ControladorPartido c;

    public TelaPartido(ControladorPartido c) {
        this.c = c;
    }
    
    public void startPartido(){
        teclado = new Scanner(System.in);
		int opcao = 0;
		System.out.println("--------- OPÇÕES DO PARTIDO ---------");
		System.out.println("-------O que voc� deseja fazer?--------");
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.println("-----Tecle 1 - Para cadastrar um partido-----");
		System.out.println("--Tecle 2 - Para excluir um partido---");
		System.out.println("---Tecle 3 - Para listar um partido----");
		opcao = teclado.nextInt(); 
        
        switch(opcao){
            case 1:
                cadastrarPartido();
                break;
            default:
                break;
        }
    }

    private void cadastrarPartido() {
        String nomePartido = "";
        int numeroPartido = 0;
        System.out.println("Por favor, digite o nome do partido");
        nomePartido = teclado.next();
        System.out.println("Por favor, digite o número do partido");
        numeroPartido = teclado.nextInt();
        c.cadastrarPartido(nomePartido, numeroPartido);
    }
    
}
