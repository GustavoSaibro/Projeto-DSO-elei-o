package br.ufsc.ine5602.view;

import java.util.Scanner;

import br.ufsc.ine5602.controller.PrincipalController;

public class TelaPrincipal {
	private Scanner teclado;
	private PrincipalController principalController;
	
	public void start(){
		teclado = new Scanner(System.in);
		int opcao = 0;
		System.out.println("--------- OLÁ, SEJA BEM VINDO ---------");
		System.out.println("-------O que você deseja fazer?--------");
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.println("-----Tecle 1 - Para Opções da urna-----");
		System.out.println("--Tecle 2 - Para Opções de candidato---");
		System.out.println("---Tecle 3 - Para Opções de Partido----");
		System.out.println("--------Tecle 4 - Para votação---------");
		opcao = teclado.nextInt();
		
		switch (opcao) {
		case 1:
			principalController = new PrincipalController();
			principalController.iniciarUrna();
			break;
		case 2:
			principalController = new PrincipalController();
			principalController.iniciarCandidato();
			break;
		case 3:
			principalController = new PrincipalController();
			principalController.iniciarPartido();
			break;
		case 4:
			principalController = new PrincipalController();
			principalController.iniciarVotacao();
		default:
			break;
		}
		
	}

}
