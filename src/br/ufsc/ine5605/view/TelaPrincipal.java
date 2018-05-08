package br.ufsc.ine5605.view;

import java.util.Scanner;

import br.ufsc.ine5605.controller.PrincipalController;

public class TelaPrincipal {

    private Scanner teclado;
    private PrincipalController principalController;

    public TelaPrincipal(PrincipalController principalController) {
        this.principalController = principalController;
    }

    public void iniciarTelaPrincipal() {
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
        System.out.println("--------Tecle 5 - Para eleitor---------");

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
                break;
            case 5:
                principalController.iniciarEleitor();
                break;
            default:
                erroOpcoes();
                break;
        }

    }

    private void erroOpcoes() {
        System.out.println("Voce digitou um valor não valido!");
        iniciarTelaPrincipal();
    }

}
