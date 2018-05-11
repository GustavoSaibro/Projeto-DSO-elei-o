package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.model.Voto;
import br.ufsc.ine5605.view.TelaVotacao;
import java.util.ArrayList;

public class VotacaoController {

    private TelaVotacao telaVotacao;
    private ArrayList<Urna> urnas;
    private Voto voto;
    private PrincipalController principalController;
    private ArrayList<Voto> votos;

    public VotacaoController(TelaVotacao telaVotacao,PrincipalController principalController) {
        this.telaVotacao = telaVotacao;        
        this.principalController = principalController; 
    }
    
    
    
}
