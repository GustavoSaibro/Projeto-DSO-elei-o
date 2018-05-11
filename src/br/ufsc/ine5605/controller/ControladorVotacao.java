package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cargo;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.model.Voto;
import br.ufsc.ine5605.view.TelaVotacao;
import java.util.ArrayList;
import java.util.List;

public class ControladorVotacao {

    private TelaVotacao telaVotacao;
    private ArrayList<Urna> urnas;
    private ControladorPrincipal principalController;
    private Voto voto;
    private ArrayList<Voto> votos;

    public ControladorVotacao(ControladorPrincipal principalController) {
        this.telaVotacao = new TelaVotacao(this);        
        this.principalController = principalController; 
        votos = new ArrayList<>();
    }
    
    public void iniciarTelaVotacao(){
        telaVotacao.opcoesVotacao();
    }
    
    public void votar(int titulo, int numeroCandidato, int secaoEleitoral, Cargo cargo){
        boolean achouVoto = false;
        for (int i = 0; i < votos.size(); i++) {
            if (votos.get(i).getCandidato().getNumeroCandidato() == numeroCandidato && votos.get(i).getUrna().getSecao() == secaoEleitoral) {
                achouVoto = true;
            }
        }
        if (!achouVoto) {
            voto = new Voto();
            voto.setCandidato(principalController.findCandidatoByNumero(numeroCandidato));
            voto.setEleitor(principalController.findEleitorByTitulo(titulo));
            voto.setUrna(principalController.findUrnaBySecao(secaoEleitoral));
            voto.setCargo(cargo);
            votos.add(voto);
        }
       
       
     }

    public void listarCandidato() {
        principalController.listarCandidato();
    }

    public void listarUrna() {
        principalController.listarUrna();
    }

    public void voltarAoMenuPrincipal() {
        principalController.iniciaSistema();
    }
    
    public void findVotosByUrna(Urna u){
        List<Voto> votosDaUrna = new ArrayList<>();
        for (int i = 0; i < votos.size(); i++) {
            if (votos.get(i).getUrna().equals(u)) {
                votosDaUrna.add(votos.get(i));
            }
        }
        
        telaVotacao.listarVotos(votosDaUrna);
    }

    void findVotosByCidade(ArrayList<Urna> urnasDaCidade) {
        List<Voto> votosdasUrnas = new ArrayList<>();
        for (int i = 0; i < urnasDaCidade.size(); i++) {
            for (int j = 0; j < votos.size(); j++) {
                if (votos.get(i).getUrna().equals(urnasDaCidade.get(j))) {
                    votosdasUrnas.add(votos.get(i));
                }
            }
        }
        telaVotacao.listarVotos(votosdasUrnas);
    }
    
    
    
}
