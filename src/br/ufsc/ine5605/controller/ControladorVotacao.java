package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.model.Voto;
import br.ufsc.ine5605.view.TelaVotacao;
import java.util.ArrayList;

public class ControladorVotacao {

    private TelaVotacao telaVotacao;
    private ArrayList<Urna> urnas;
    private Voto voto;
    private ControladorPrincipal principalController;
    private ArrayList<Voto> votos;

    public ControladorVotacao(TelaVotacao telaVotacao,ControladorPrincipal principalController) {
        this.telaVotacao = telaVotacao;        
        this.principalController = principalController; 
    }
    
    
    
}
