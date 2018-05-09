/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.CandidatoController;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cargo;
import br.ufsc.ine5605.model.Partido;
import java.util.ArrayList;
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
                    candidatoController.listaPartido();
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
        int numeroPartido;
        int cargoOpcao;
        Cargo cargo = Cargo.PADRAO;
        String nome;
        String nomeCidade;
        
        System.out.println("Qual é o nome do candidato?");
        nomeCidade = teclado.next();
        candidatoController.listaPartido();
        System.out.println("Digite o numero do Partido:");
        numeroPartido = teclado.nextInt();
        System.out.println("Qual é o cargo do candidato?");
        System.out.println("digite 1 para GOVERNADOR");
        System.out.println("digite 2 para DEP. ESTADUAL");
        cargoOpcao = teclado.nextInt();
        if(cargoOpcao == 1){
            cargo = Cargo.GOVERNADOR;
        }else if(cargoOpcao == 2){
            cargo = Cargo.DEPUTADO_ESTADUAL;
        }
        System.out.println("Digite o Nome do Candidato:");
        nome = teclado.next();
        
        candidatoController.cadastrarCandidato(numeroPartido, cargo, nome, nomeCidade);
    }
    
    public void excluirCandidato(){
        String nome;
        
        System.out.println("Digite o Nome do Candidato a ser Excluido:");
        nome = teclado.next();
        
        //candidatoController.excluirCandidatoByNome(nome);
    }
    
    public void listarCandidatos(ArrayList<Candidato> candidatos){
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println(candidatos.get(i).getNomePessoa() + " " + candidatos.get(i).getCargo() + " " + candidatos.get(i).getPartido().getNumeroPartido());
        }
        
    }
    
}
