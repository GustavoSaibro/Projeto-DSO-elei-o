/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorEleitor;
import br.ufsc.ine5605.model.Eleitor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaEleitor {

    private Scanner teclado;
    private ControladorEleitor eleitorController;

    public TelaEleitor() {
    }

    public TelaEleitor(ControladorEleitor eleitorController) {
        this.eleitorController = eleitorController;
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
			cadastrarEleitor();
			break;
		case 2:
			ExcluirEleitorByTitulo();
			break;
		case 3:
			eleitorController.ListaEleitores();
			break;
                default:
			break;
		}

    }

    private void cadastrarEleitor() {
        String nomeEleitor = "";
        int zonaEleitoral = 0;
        String nomeCidade = "";
        int titulo = 0;
        int secao = 0;
        System.out.println("Por favor, digite o nome do eleitor");
        nomeEleitor = teclado.next();
        System.out.println("Por favor, digite o número da zona eleitoral");
        teclado = new Scanner(System.in);
        zonaEleitoral = teclado.nextInt();
        System.out.println("Por favor, digite o nome da cidade do eleitor");
        teclado = new Scanner(System.in);
        nomeCidade = teclado.next();
        System.out.println("Por favor, digite o título do eleitor");
        teclado = new Scanner(System.in);
        titulo = teclado.nextInt();
        System.out.println("Por favor, digite a seção do eleitor");
        secao = teclado.nextInt();
        
        eleitorController.cadastrarEleitor(nomeEleitor, zonaEleitoral, nomeCidade, titulo,secao);
    }

    private void ExcluirEleitorByTitulo() {
        int titulo = 0;
        System.out.println("Por favor, digite o título do eleitor que desejas excluir");
        titulo = teclado.nextInt();
        eleitorController.excluirEleitorByTitulo(titulo);
    }

    public void listarEleitor(ArrayList<Eleitor> eleitores) {
        for (int i = 0; i < eleitores.size(); i++) {
            System.out.println(eleitores.get(i).getNomePessoa() + " " +
                    eleitores.get(i).getCidade().getNome() + " " + eleitores.get(i).getTituloEleitor());
        }
        eleitorController.voltarAoMenuPrincipal();
    }

    public void erroDeCadastro() {
        System.out.println("Não foi possivel cadastrar. Numero já cadastrado!!");
    }

    public void removeu() {
        System.out.println("Eleitor removido com sucesso!!");
    }
    
    

}
