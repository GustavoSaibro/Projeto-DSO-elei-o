package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaPrincipal;

public class ControladorPrincipal {
	private ControladorPartido controladorPartido;
	private ControladorUrna urnaController;
	private ControladorCandidato candidatoController;
	private ControladorEleitor eleitorController;
	private ControladorVotacao votacaoController;
	private TelaPrincipal telaPrincipal;
	
	public ControladorPrincipal(){
            telaPrincipal = new TelaPrincipal(this);
            controladorPartido = new ControladorPartido(this);
            eleitorController = new ControladorEleitor(this);
            candidatoController = new ControladorCandidato(this);
            urnaController = new ControladorUrna(this);
	}

	public ControladorPrincipal(ControladorPartido controladorPartido,
			ControladorUrna urnaController,
			ControladorCandidato candidatoController,
			ControladorEleitor eleitorController,
			ControladorVotacao votacaoController) {
		super();
		this.controladorPartido = controladorPartido;
		this.urnaController = urnaController;
		this.candidatoController = candidatoController;
		this.eleitorController = eleitorController;
		this.votacaoController = votacaoController;
	}
	
	public void iniciaSistema(){
		telaPrincipal.iniciarTelaPrincipal();
	}
	
	public void iniciarPartido(){
                controladorPartido.iniciaTelaPartido();
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
		System.out.println("iniciou vota��o");
		
	}

    public void listarPartido() {
        controladorPartido.listarPartidos();
    }

    public Partido findPartidoByNumero(int numeroPartido) {
        return controladorPartido.findPartidoByNumero(numeroPartido);
    }

}
