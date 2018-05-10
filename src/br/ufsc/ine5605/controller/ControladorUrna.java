package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaUrna;
import java.util.ArrayList;

public class ControladorUrna {
    private ArrayList<Urna> urnas;
    private Urna urna;
    private TelaUrna telaUrna;
    private ControladorPrincipal  principalController;
    
    public ControladorUrna(ControladorPrincipal principalController){
        urnas = new ArrayList<>();
        this.principalController = principalController;
        telaUrna = new TelaUrna(this);
    }
    
    public void iniciarTelaUrna() {
        telaUrna.opcoesUrna();
    }

    public void cadastrarUrna(int secao, String cidadeUrna) {
        Cidade c = new Cidade();
        c.setNome(cidadeUrna);
        urna = new Urna();
        urna.setCidade(c);
        urna.setSecao(secao);
        urnas.add(urna);
        
    }
    
    public void excluirUrna(int secao){
        
    }

}
