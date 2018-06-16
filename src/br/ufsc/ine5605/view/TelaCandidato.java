/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorCandidato;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cargo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaCandidato {
    
    private Scanner teclado;

    public TelaCandidato() {
    }
    
    public void opcoesCandidato(){
        teclado = new Scanner(System.in);
        	int opcao;
		System.out.println("Opções de Candidato:");
                System.out.println("O que você deseja fazer?");
		System.out.println("");
		System.out.println("1- Para Cadastrar Candidato");
		System.out.println("2- Para Excluir Candidato---");
		System.out.println("3- Para Listar Candidatos");
		System.out.println("4- Para Voltar");
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
                    ControladorCandidato.getInstancia().listarCandidato();
                    break;
                case 4:
                    ControladorCandidato.getInstancia().voltarAoMenuPrincipal();
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
        teclado = new Scanner(System.in);
        int numeroPartido;
        int cargoOpcao;
        int numeroCandidato = 0;
        Cargo cargo = Cargo.PADRAO;
        String nome;
        String nomeCidade;
        
        System.out.println("Qual é o nome da cidade?");
        nomeCidade = teclado.next();
        ControladorCandidato.getInstancia().listaPartido();
        teclado = new Scanner(System.in);
        System.out.println("Digite o numero do Partido:");
        numeroPartido = teclado.nextInt();
        System.out.println("Qual é o cargo do candidato?");
        System.out.println("digite 1 para GOVERNADOR");
        System.out.println("digite 2 para DEP. ESTADUAL");
        cargoOpcao = teclado.nextInt();
        if(cargoOpcao == 1){
            cargo = Cargo.GOVERNADOR;
            numeroCandidato = numeroPartido;
        }else if(cargoOpcao == 2){
            cargo = Cargo.DEPUTADO_ESTADUAL;
            System.out.println("Digite o Numero do Candidato");
            numeroCandidato = teclado.nextInt();
        }
        System.out.println("Digite o Nome do Candidato:");
        nome = teclado.next();
        
        ControladorCandidato.getInstancia().cadastrarCandidato(numeroPartido, cargo, nome, numeroPartido, nomeCidade);
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
