package br.ufsc.ine5605.view;

import java.util.Scanner;

import br.ufsc.ine5605.controller.PrincipalController;

public class TelaPrincipal {
	private Scanner teclado;
	private PrincipalController principalController;
        
        public TelaPrincipal(PrincipalController principalController){
            this.principalController = principalController;
        }
	
	public void start(){
		teclado = new Scanner(System.in);
		int opcao = 0;
		System.out.println("--------- OLÁ, SEJA BEM VINDO ---------");
		System.out.println("-------O que voc� deseja fazer?--------");
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.println("-----Tecle 1 - Para Op��es da urna-----");
		System.out.println("--Tecle 2 - Para Op��es de candidato---");
		System.out.println("---Tecle 3 - Para Op��es de Partido----");
		System.out.println("--------Tecle 4 - Para vota��o---------");
		opcao = teclado.nextInt();
		
		switch (opcao) {
		case 1:
			principalController.iniciarUrna();
			break;
		case 2:
			principalController.iniciarCandidato();
			break;
		case 3:
			principalController.iniciarPartido();
			break;
		case 4:
			principalController.iniciarVotacao();
		default:
			break;
		}
		
	}

}
