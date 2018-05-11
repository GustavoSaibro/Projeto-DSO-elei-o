package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.view.TelaApuracao;
import br.ufsc.ine5605.view.TelaPrincipal;
import java.util.ArrayList;

public class ControladorPrincipal {
	private ControladorPartido partidoController;
	private ControladorUrna urnaController;
	private ControladorCandidato candidatoController;
	private ControladorEleitor eleitorController;
	private ControladorVotacao votacaoController;
	private TelaPrincipal telaPrincipal;
        private TelaApuracao telaApuracao;
	
	public ControladorPrincipal(){
            telaPrincipal = new TelaPrincipal(this);
            partidoController = new ControladorPartido(this);
            eleitorController = new ControladorEleitor(this);
            candidatoController = new ControladorCandidato(this);
            urnaController = new ControladorUrna(this);
            telaApuracao = new TelaApuracao(this);
            votacaoController = new ControladorVotacao(this);

	}

	public ControladorPrincipal(ControladorPartido controladorPartido,
			ControladorUrna urnaController,
			ControladorCandidato candidatoController,
			ControladorEleitor eleitorController,
			ControladorVotacao votacaoController) {
		super();
		this.partidoController = controladorPartido;
		this.urnaController = urnaController;
		this.candidatoController = candidatoController;
		this.eleitorController = eleitorController;
		this.votacaoController = votacaoController;
	}
	
	public void iniciaSistema(){
		telaPrincipal.iniciarTelaPrincipal();
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
            
            candidatoController.iniciarTelaCandidato();
		
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
        return candidatoController.findCandidatoByNumero(numeroCandidato);
    }

    public void listarCandidato() {
        candidatoController.listarCandidato();
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
            cidade = "sao jose";
        }
        ArrayList<Urna> urnasDaCidade = findUrnasByCidade(cidade);
        votacaoController.findVotosByCidade(urnasDaCidade);
    }
    
    public ArrayList<Urna> findUrnasByCidade(String cidade){
        return urnaController.findUrnaByCidade(cidade);
    }

 
}
