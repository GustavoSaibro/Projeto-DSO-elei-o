/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.CandidatoController;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaCandidato {
    
    private Scanner teclado;
    private CandidatoController candidatoController;
    
    public TelaCandidato(CandidatoController candidatoController){
        this.candidatoController = candidatoController;
        teclado = new Scanner(System.in);
    }

    public TelaCandidato() {
    }
    
    public void opcoesCandidato(){
        	int opcao;
		System.out.println("Opções Candidato:");
		System.out.println("");
                System.out.println("O que você deseja fazer?");
		System.out.println("");
		System.out.println("");
		System.out.println("1- Para Cadastrar Candidato");
		System.out.println("2- Para Excluir Candidato---");
		System.out.println("3- Para Listar Candidatos");
		System.out.println("");
                
		opcao = teclado.nextInt();
		
		switch (opcao) {
		case 1:
                    cadastrarCandidato();
                    break;
		case 2:
                    excluirCandidato();
                    break;
		case 3:
                    listarCandidatos();
                    break;		
		default:
                        erroOpcoes();
			break;
		}	
    }
    
    private void erroOpcoes(){
        System.out.println("Voce digitou um valor não valido!");
        opcoesCandidato();
    }
    
    public void cadastrarCandidato(){
        String nomePartido;
        int numeroPartido;
        String cargo;
        String nome;
        
        System.out.println("Digite o nome do Partido:");
        nomePartido = teclado.next();
        System.out.println("Digite o numero do Partido:");
        numeroPartido = teclado.nextInt();
        System.out.println("Digite o Cargo do Cantidato:");
        cargo = teclado.next();
        System.out.println("Digite o Nome do Candidato:");
        nome = teclado.next();
        
        //candidatoController.cadastrarCandidato(nomePartido, numeroPartido, cargo, nome);
    }
    
    public void excluirCandidato(){
        String nome;
        
        System.out.println("Digite o Nome do Candidato a ser Excluido:");
        nome = teclado.next();
        
        //candidatoController.excluirCandidatoByNome(nome);
    }
    
    public void listarCandidatos(){
        //candidatoController.listarCandidatos();
    }
    
}
