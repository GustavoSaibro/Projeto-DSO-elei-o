package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaApuracao;
import br.ufsc.ine5605.view.TelaCadastroUrna;
import br.ufsc.ine5605.view.TelaListarUrna;
import br.ufsc.ine5605.view.TelaPrincipalG;
import java.util.ArrayList;

public class ControladorPrincipal {
    
    private TelaPrincipalG telaPrincipal;
    private TelaApuracao telaApuracao;
    private TelaCadastroUrna telaCadastroUrna;
    private static ControladorPrincipal instanciaPrincipal;
    private TelaListarUrna telaListarUrna;
	
    public ControladorPrincipal(){
        telaPrincipal = new TelaPrincipalG();
        telaApuracao = new TelaApuracao();
        telaCadastroUrna = new TelaCadastroUrna();
        telaListarUrna = new TelaListarUrna();
    }
        
    public static ControladorPrincipal getInstancia(){
        if(instanciaPrincipal == null){
            instanciaPrincipal = new ControladorPrincipal();
        }
        return instanciaPrincipal;
    }
	
    public void iniciaSistema(){
        telaPrincipal.iniciaTelaPrincipal();
    }
	
    public void iniciarPartido(){
        ControladorPartido.getInstancia().iniciaTelaPartido();
    }
 
    public void iniciarEleitor(){
        ControladorEleitor.getInstancia().iniciaTelaEleitor();
    }

    public void iniciarUrna(){
        ControladorUrna.getInstancia().iniciarTelaUrna();
    }

    public void iniciarCandidato(){
        ControladorCandidato.getInstancia().iniciarTelaCandidato();
    }
    
    public void iniciarVotacao(){
        ControladorVotacao.getInstancia().iniciarTelaVotacao();
    }
        
    public void iniciarApuracao(){
        iniciarTelaApuracao();
    }
        
    public void iniciarTelaApuracao(){
        telaApuracao.opcoesApuracao();
    }

    public void listarPartido() {
        ControladorPartido.getInstancia().listarPartidos();
    }

    public Partido findPartidoByNumero(int numeroPartido) {
        return ControladorPartido.getInstancia().findPartidoByNumero(numeroPartido);
    }
    
    public ArrayList mostraEleitores(){
        return ControladorEleitor.getInstancia().getEleitores();
    }
    
    public ArrayList mostraCandidatos(){
        return ControladorCandidato.getInstancia().getCandidatos();
    }
    
    public Eleitor findEleitorByTitulo(int titulo){
        return ControladorEleitor.getInstancia().findEleitorByTitulo(titulo);
    }
    
    public Candidato findCandidatoByNumero(int numeroCandidato){
        return ControladorCandidato.getInstancia().findCandidatoByNumero(numeroCandidato);
    }

    public void listarCandidato() {
        ControladorCandidato.getInstancia().listarCandidato();
    }

    public void listarUrna() {
        ControladorUrna.getInstancia().listarUrnas();
    }
    public Urna findUrnaBySecao(int secao){
        return ControladorUrna.getInstancia().findUrnaBySecao(secao);
    }

    public void telaCadastroUrna() {
        telaCadastroUrna.iniciarTelaCadastro();
    }

    public void telaListarUrna() {
        telaListarUrna.iniciarTelaListarUrna();
    }
    
}
