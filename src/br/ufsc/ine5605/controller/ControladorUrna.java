package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaUrna;
import java.util.ArrayList;

public class ControladorUrna {

    private ArrayList<Urna> urnas;
    private Urna urna;
    private TelaUrna telaUrna;
    private ControladorPrincipal principalController;

    
    public ControladorUrna(ControladorPrincipal principalController, ControladorCandidato candidatoController) {
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

        if (urnas.size() == 0) {
            urnas.add(urna);
        } else {
            for (int i = 0; i < urnas.size(); i++) {
                if (urnas.get(i) != null && urnas.get(i).getSecao() == secao) {
                    telaUrna.urnaJaCadastrada();
                    break;
                } else {
                    urnas.add(urna);
                }
            }
        }

    }

    public void excluirUrna(int secao) {
        if (findUrnaBySecao(secao).equals(null)) {
        } else {
            urnas.remove(findUrnaBySecao(secao));
            telaUrna.removeuUrna();
        }

    }

    private Urna findUrnaBySecao(int secao) {
        for (int i = 0; i < urnas.size(); i++) {
            if (urnas.get(i) != null && urnas.get(i).getSecao() == secao) {
                urna = urnas.get(i);
            }
        }
        return urna;
    }
    
    public ArrayList urnasCadastradas(){
        return urnas;
    }
    
    
}
