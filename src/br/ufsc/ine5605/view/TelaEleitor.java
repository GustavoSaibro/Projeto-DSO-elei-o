/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.EleitorController;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaEleitor {

    private Scanner teclado;
    private EleitorController eleitorController;

    public TelaEleitor() {
    }

    public TelaEleitor(Scanner teclado) {
        this.teclado = teclado;
    }

    public void opcoesEleitor() {
        teclado = new Scanner(System.in);
        int opcao = 0;
        System.out.println("--------- OLÁ, SEJA BEM VINDO ---------");
        System.out.println("-------O que voce deseja fazer?--------");
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("----- 1- Para Cadastrar Eleitor -----");
        System.out.println("--- Tecle 2 - Para Excluir Eleitor ---");
        System.out.println("--- Tecle 3 - Para Listar Eleitores ----");
        opcao = teclado.nextInt();

        switch (opcao) {
		case 1:
			//eleitorController.cadastrarEleitor();
			break;
		case 2:
			//eleitorController.excluirEleitorByTitulo();
			break;
		case 3:
			//eleitorController.listarEleitores();
			break;
                default:
			break;
		}

    }

}
