package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.mapeador.UrnaDAO;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaUrna;
import java.util.ArrayList;

public class ControladorUrna {

    private UrnaDAO urnaDAO;
    private Urna urna;
    private TelaUrna telaUrna;
    private static ControladorUrna instanciaUrna;
    
    public ControladorUrna() {
        urnaDAO = new UrnaDAO();
        telaUrna = new TelaUrna();     
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
    
    public ArrayList<Urna> getUrnas(){
        return new ArrayList<Urna>(urnaDAO.getUrnas());
    }

    public void cadastrarUrna(int secao, String cidadeUrna) {
        Cidade c = new Cidade();
        c.setNome(cidadeUrna);
        urna = new Urna();
        urna.setCidade(c);
        urna.setSecao(secao);

        if (getUrnas().size() == 0) {
            urnaDAO.put(urna);
        } else {
            for (int i = 0; i < getUrnas().size(); i++) {
                if (getUrnas().get(i) != null && getUrnas().get(i).getSecao() == secao) {
                    telaUrna.urnaJaCadastrada();
                    break;
                } else {
                    urnaDAO.put(urna);
                }
            }
        }
        listarUrnas();
    }

    public void excluirUrna(int secao) {
        if (findUrnaBySecao(secao).equals(null)) {
        } else {
            //urnas.remove(findUrnaBySecao(secao));
            telaUrna.removeuUrna();
        }

    }

    public Urna findUrnaBySecao(int secao) {
        for (int i = 0; i < getUrnas().size(); i++) {
            if (getUrnas().get(i) != null && getUrnas().get(i).getSecao() == secao) {
                urna = getUrnas().get(i);
            }
        }
        return urna;
    }
    
    public void listarUrnas(){
        telaUrna.listarUrnas(getUrnas());
    }

    public void voltarAoMenuPrincipal() {
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public ArrayList<Urna> findUrnaByCidade(String cidade) {
        ArrayList<Urna> urnasDaCidade = new ArrayList<>();
        for (int i = 0; i < getUrnas().size(); i++) {
            if(getUrnas().get(i).getCidade().getNome() == cidade){
                urnasDaCidade.add(getUrnas().get(i));
            }
        }
        return urnasDaCidade;
    }
    
    
}
