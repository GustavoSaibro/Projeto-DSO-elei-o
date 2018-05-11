package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorVotacao;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cargo;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Voto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaVotacao {
    
    private Scanner teclado;
    private ControladorVotacao votacaoController;

    public TelaVotacao() {
        teclado = new Scanner(System.in);
    }
    
    public TelaVotacao(ControladorVotacao votacaoController) {
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
    
    public void votar(){
        int titulo = 0;
        int cargoEscolha = 0;
        int numeroCandidato = 0;
        int secaoDaUrna = 0;
        Cargo cargo = Cargo.PADRAO;
        System.out.println("Digite qual é o título do eleitor");
        titulo = teclado.nextInt();
        System.out.println("Qual é o cargo para qual deseja votar?");
        System.out.println("Digite 1 para Dep. Estadual");
        System.out.println("Digite 2 para Governador");
        cargoEscolha = teclado.nextInt();
        if (cargoEscolha == 1) {
            cargo = Cargo.DEPUTADO_ESTADUAL;
        } else if(cargoEscolha == 2){
            cargo = Cargo.GOVERNADOR;
        }
        votacaoController.listarCandidato();
        System.out.println("Digite o numero do candidato que deseja votar");
        numeroCandidato = teclado.nextInt();
        votacaoController.listarUrna();
        System.out.println("Digite a seção eleitoral da urna");
        secaoDaUrna = teclado.nextInt();
        
        votacaoController.votar(titulo, numeroCandidato, secaoDaUrna, cargo);
        votacaoController.voltarAoMenuPrincipal();
        
    }
    
    public void listarVotos(List<Voto> votos){
        
        for (int i = 0; i < votos.size(); i++) {
            System.out.println(votos.get(i).getCandidato().getNomePessoa() + "Numero de votos" + votos.get(i).getCandidato().getNumeroDeVotos());
        }
        
    }
    private void voltar(){}
    
}
