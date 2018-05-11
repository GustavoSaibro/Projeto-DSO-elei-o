package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaVotacao;
import java.util.ArrayList;

public class ControladorVotacao {

    private TelaVotacao telaVotacao;
    private ArrayList<Urna> urnas;
    private ControladorPrincipal principalController;


    public ControladorVotacao(ControladorPrincipal principalController) {
        this.telaVotacao = new TelaVotacao(this);        
        this.principalController = principalController; 
    }
    
    public void iniciarTelaVotacao(){
        telaVotacao.opcoesVotacao();
    }
    
    public void votar(int titulo, int numeroCandidato){
        ArrayList candidatos = principalController.mostraCandidatos();
        ArrayList eleitores = principalController.mostraEleitores();
        
        Candidato candidato = principalController.findCandidatoByNumero(numeroCandidato);
        Eleitor eleitor = principalController.findEleitorByTitulo(titulo);
        
       candidato.setNumeroDeVotos(candidato.getNumeroDeVotos() + 1);
        
        
     }
    
    
    
}
