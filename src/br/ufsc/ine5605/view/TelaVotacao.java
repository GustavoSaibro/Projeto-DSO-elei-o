package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.VotacaoController;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaVotacao {
    
    private Scanner teclado;
    private VotacaoController votacaoController;

    public TelaVotacao() {
        teclado = new Scanner(System.in);
    }
    
    public TelaVotacao(VotacaoController votacaoController) {
        teclado = new Scanner(System.in);
        this.votacaoController = votacaoController;
    }
    
    public void opcoesVotacao(){
        System.out.println("Opções da Votação");
        System.out.println("1- Votar");
        System.out.println("2- Voltar");
        int opcao;
        opcao = teclado.nextInt();
        
        switch (opcao) {
            case 1:
                votar();
                break;
            case 2:
                voltar();
                break;
            default:
                erroOpcoes();
                break;
        }
    }
    
    private void erroOpcoes() {
        System.out.println("Voce digitou um valor não valido!");
        opcoesVotacao();
    }
    
    private void votar(){
        //votacaoController.votar();
    }
    
    private void voltar(){
        //votacaoController.opcoes();
    }
    
}
