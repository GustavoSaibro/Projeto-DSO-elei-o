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
		System.out.println("--------- OPÇÕES DO PARTIDO ---------");
		System.out.println("-------O que voc� deseja fazer?--------");
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.println("-----Tecle 1 - Para cadastrar um partido-----");
		System.out.println("--Tecle 2 - Para excluir um partido---");
		System.out.println("---Tecle 3 - Para listar um partido----");
                System.out.println("---Tecle 4 - Para encerrar o programa -----");
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
        opcoesPartido();
    }
    
}
