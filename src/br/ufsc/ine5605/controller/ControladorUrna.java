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
    private static ControladorUrna instanciaUrna = new ControladorUrna();
    
    public ControladorUrna() {
        urnas = new ArrayList<>();
        telaUrna = new TelaUrna(this);     
    }
    
    public static ControladorUrna getInstancia(){
        if(instanciaUrna == null){
            instanciaUrna = new ControladorUrna();
        }
        return instanciaUrna;
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
        listarUrnas();
    }

    public void excluirUrna(int secao) {
        if (findUrnaBySecao(secao).equals(null)) {
        } else {
            urnas.remove(findUrnaBySecao(secao));
            telaUrna.removeuUrna();
        }

    }

    public Urna findUrnaBySecao(int secao) {
        for (int i = 0; i < urnas.size(); i++) {
            if (urnas.get(i) != null && urnas.get(i).getSecao() == secao) {
                urna = urnas.get(i);
            }
        }
        return urna;
    }
    
    public void listarUrnas(){
        telaUrna.listarUrnas(urnas);
    }

    public void voltarAoMenuPrincipal() {
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public ArrayList<Urna> findUrnaByCidade(String cidade) {
        ArrayList<Urna> urnasDaCidade = new ArrayList<>();
        for (int i = 0; i < urnas.size(); i++) {
            if(urnas.get(i).getCidade().getNome() == cidade){
                urnasDaCidade.add(urnas.get(i));
            }
        }
        return urnasDaCidade;
    }
    
    
}
