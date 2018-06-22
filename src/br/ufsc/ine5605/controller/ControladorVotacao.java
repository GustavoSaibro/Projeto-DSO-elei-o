package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.mapeador.VotacaoDAO;
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
    private Voto voto;
    private VotacaoDAO votacaoDAO;
    private static ControladorVotacao instanciaVotacao;
    
    public ControladorVotacao() {
        this.telaVotacao = new TelaVotacao();        
        this.votacaoDAO = new VotacaoDAO();
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
        voto = new Voto();
        voto.setCandidato(ControladorCandidato.getInstancia().findCandidatoByNumero(numeroCandidato));
        voto.setCargo(cargo);
        voto.setEleitor(ControladorEleitor.getInstancia().findEleitorByTitulo(titulo));
        voto.setUrna(ControladorUrna.getInstancia().findUrnaBySecao(secaoEleitoral));
       
        votacaoDAO.put(voto);
       
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
        for (int i = 0; i < getVoto().size(); i++) {
            if (getVoto().get(i).getUrna().equals(u)) {
                votosDaUrna.add(getVoto().get(i));
            }
        }
        
        telaVotacao.listarVotos(votosDaUrna);
    }

    void findVotosByCidade(ArrayList<Urna> urnasDaCidade) {
        List<Voto> votosdasUrnas = new ArrayList<>();
        for (int i = 0; i < urnasDaCidade.size(); i++) {
            for (int j = 0; j < getVoto().size(); j++) {
                if (getVoto().get(i).getUrna().equals(urnasDaCidade.get(j))) {
                    votosdasUrnas.add(getVoto().get(i));
                }
            }
        }
        telaVotacao.listarVotos(votosdasUrnas);
    }
    
    public ArrayList<Voto> getVoto(){
        return new ArrayList<Voto>(votacaoDAO.getVoto());
    }
    
}
