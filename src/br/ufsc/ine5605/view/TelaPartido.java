/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;


import br.ufsc.ine5605.controller.ControladorPartido;
import br.ufsc.ine5605.model.Partido;
import java.util.ArrayList;
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
    
    public void opcoesPartido(){
        teclado = new Scanner(System.in);
		int opcao = 0;
		System.out.println("Opções de Partido");
		System.out.println("");
		System.out.println("1- Para cadastrar um partido-----");
		System.out.println("2- Para excluir um partido---");
		System.out.println("3- Para listar um partido----");
                System.out.println("4- Voltar");
                System.out.println("");
		opcao = teclado.nextInt(); 
        
        switch(opcao){
            case 1:
                cadastrarPartido();
                break;
            case 2:
                excluirPartido();
                break;
            case 3:
                c.listarPartidos();
                break;
            case 4:
                c.voltarAoMenuPrincipal();
                break;
            default:
                erroOpcoes();
                break;
        }
    }
    
    private void erroOpcoes(){
        System.out.println("Voce digitou um valor não valido!");
        opcoesPartido();
    }

    private void cadastrarPartido() {
        String nomePartido = "";
        int numeroPartido = 0;
        System.out.println("Por favor, digite o nome do partido");
        nomePartido = teclado.next();
        System.out.println("Por favor, digite o número do partido");
        numeroPartido = teclado.nextInt();
        c.cadastrarPartido(nomePartido, numeroPartido);
        c.voltarAoMenuPrincipal();
    }

    private void excluirPartido() {
        int numeroPartido = 0;
        c.listarPartidos();
        System.out.println("Por favor, digite o número do partido que desejas excluir");
        numeroPartido = teclado.nextInt();
        c.excluirPartido(numeroPartido);
        c.listarPartidos();
    }

    public void listarPartido(ArrayList<Partido> partidos) {
        for (int i = 0; i <  partidos.size(); i++) {
            System.out.println(partidos.get(i).getNomePartido() + "-" + partidos.get(i).getNumeroPartido());
        }
        
    }

    public void jaCadastrado() {
        System.out.println("Erro ao cadastrar o partido. Partido já cadastrado!!");
    }

    public void removeuPartido() {
        System.out.println("Partido removido com sucesso!!");
    }
    
}
