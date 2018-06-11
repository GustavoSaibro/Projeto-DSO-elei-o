package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaApuracao;
import br.ufsc.ine5605.view.TelaPrincipal;
import br.ufsc.ine5605.view.TelaPrincipalG;
import java.util.ArrayList;

public class ControladorPrincipal {
	private ControladorPartido partidoController;
	private ControladorUrna urnaController;
	private ControladorCandidato candidatoController;
	private ControladorEleitor eleitorController;
	private ControladorVotacao votacaoController;
	private TelaPrincipalG telaPrincipal;
        private TelaApuracao telaApuracao;
        private static ControladorPrincipal instanciaPrincipal = new ControladorPrincipal();
	
	public ControladorPrincipal(){
            telaPrincipal = new TelaPrincipalG();
            telaApuracao = new TelaApuracao(this);
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
                partidoController.iniciaTelaPartido();
	}
        public void iniciarEleitor(){
           
            eleitorController.iniciaTelaEleitor();
        }
	public void iniciarUrna(){
            urnaController.iniciarTelaUrna();
		
	}
	public void iniciarCandidato(){
            
            ControladorCandidato.getInstancia().iniciarTelaCandidato();
		
	}
	public void iniciarVotacao(){
            votacaoController.iniciarTelaVotacao();

	}
        public void iniciarApuracao(){
            iniciarTelaApuracao();
        }
        
        public void iniciarTelaApuracao(){
            telaApuracao.opcoesApuracao();
        }

    public void listarPartido() {
        partidoController.listarPartidos();
    }

    public Partido findPartidoByNumero(int numeroPartido) {
        return partidoController.findPartidoByNumero(numeroPartido);
    }
    
    public ArrayList mostraEleitores(){
        return eleitorController.getEleitores();
    }
    
    public ArrayList mostraCandidatos(){
        return partidoController.getPartidos();
    }
    
    public Eleitor findEleitorByTitulo(int titulo){
        return eleitorController.findEleitorByTitulo(titulo);
    }
    
    public Candidato findCandidatoByNumero(int numeroCandidato){
        return ControladorCandidato.getInstancia().findCandidatoByNumero(numeroCandidato);
    }

    public void listarCandidato() {
        ControladorCandidato.getInstancia().listarCandidato();
    }

    public void listarUrna() {
        urnaController.listarUrnas();
    }
    public Urna findUrnaBySecao(int secao){
        return urnaController.findUrnaBySecao(secao);
    }
    
    public void listarVotosByUrna(int secao){
        Urna u = findUrnaBySecao(secao);
        votacaoController.findVotosByUrna(u);
    }
    
    public void listarVotosByCidade(int escolhaCidade){
        String cidade;
        if (escolhaCidade == 1) {
            cidade = "florianopolis";
        }else{
            cidade = "saojose";
        }
        ArrayList<Urna> urnasDaCidade = findUrnasByCidade(cidade);
        votacaoController.findVotosByCidade(urnasDaCidade);
    }
    
    public ArrayList<Urna> findUrnasByCidade(String cidade){
        return urnaController.findUrnaByCidade(cidade);
    }

 
}
