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
import br.ufsc.ine5605.controller.ControladorCandidato;

public class ControladorVotacao {

    private TelaVotacao telaVotacao;
    private ArrayList<Urna> urnas;
    private Voto voto;
    private ArrayList<Voto> votos;
    private ArrayList<Candidato> candidatos;
    private static ControladorVotacao instanciaVotacao;
   
    
    
    public ControladorVotacao() {
        this.telaVotacao = new TelaVotacao();        
        votos = new ArrayList<>();
    }
    
    public static ControladorVotacao getInstancia(){
        if(instanciaVotacao == null){
            instanciaVotacao = new ControladorVotacao();
        }
        return instanciaVotacao;
    }
    
    public void iniciarTelaVotacao(){
        telaVotacao.opcoesVotacao();
    }
    
    public void votar(int titulo, int numeroCandidato, int secaoEleitoral, Cargo cargo){
        boolean achouVoto = false;
        for (int i = 0; i < votos.size(); i++) {
            if (votos.get(i).getCandidato().getNumeroCandidato() == numeroCandidato) {
                votos.get(i).getCandidato().setNumeroDeVotos(votos.get(i).getCandidato().getNumeroDeVotos() + 1);
                achouVoto = true;
            }
        }
        if (!achouVoto) {
            voto = new Voto();
            voto.setCandidato(ControladorPrincipal.getInstancia().findCandidatoByNumero(numeroCandidato));
            voto.getCandidato().setNumeroDeVotos(voto.getCandidato().getNumeroDeVotos() + 1);
            voto.setEleitor(ControladorPrincipal.getInstancia().findEleitorByTitulo(titulo));
            voto.setUrna(ControladorPrincipal.getInstancia().findUrnaBySecao(secaoEleitoral));
            voto.setCargo(cargo);
            votos.add(voto);
        }      
     }
 
    
    

    public void listarCandidato() {
        ControladorPrincipal.getInstancia().listarCandidato();
    }

    public void listarUrna() {
        ControladorPrincipal.getInstancia().listarUrna();
    }

    public void voltarAoMenuPrincipal() {
        ControladorPrincipal.getInstancia().iniciaSistema();
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
