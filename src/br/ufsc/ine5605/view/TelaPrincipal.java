package br.ufsc.ine5605.view;

import java.util.Scanner;

import br.ufsc.ine5605.controller.ControladorPrincipal;

public class TelaPrincipal {

    private Scanner teclado;
    private ControladorPrincipal principalController;
/*
    public TelaPrincipal(ControladorPrincipal principalController) {
        this.principalController = principalController;
    }

    public void iniciarTelaPrincipal() {
        teclado = new Scanner(System.in);
        int opcao = 0;
        System.out.println("    Olá, Seja Bem Vindo!    ");
        System.out.println("    O que deseja?");
        System.out.println("");
        System.out.println("1- Para Opções da Urna");
        System.out.println("2- Para Opções de Candidato");
        System.out.println("3- Para Opções de Partido");
        System.out.println("4- Para Opções de Votação");
        System.out.println("5- Para Opções de Eleitor");
        System.out.println("6- Para Opções de Apuração");
        
          
        
        try{

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
            case 6:
                principalController.iniciarApuracao();
                break;
            default:
                erroOpcoes();
                break;
        }

    }
        catch(Exception e){
            System.out.println("Valor inválido! Digite apenas numeros, por favor");
            iniciarTelaPrincipal();
        }
    
    }

    private void erroOpcoes() {
        System.out.println("Voce digitou um valor não valido!");
        iniciarTelaPrincipal();
    }
*/
}
