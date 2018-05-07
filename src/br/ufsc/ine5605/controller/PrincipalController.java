package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.view.TelaPrincipal;

public class PrincipalController {
	private ControladorPartido controladorPartido;
	private UrnaController urnaController;
	private CandidatoController candidatoController;
	private EleitorController eleitorController;
	private VotacaoController votacaoController;
	private TelaPrincipal telaPrincipal;
	
	public PrincipalController(){
		
	}

	public PrincipalController(ControladorPartido controladorPartido,
			UrnaController urnaController,
			CandidatoController candidatoController,
			EleitorController eleitorController,
			VotacaoController votacaoController) {
		super();
		this.controladorPartido = controladorPartido;
		this.urnaController = urnaController;
		this.candidatoController = candidatoController;
		this.eleitorController = eleitorController;
		this.votacaoController = votacaoController;
	}
	
	public void iniciaSistema(){
		telaPrincipal = new TelaPrincipal();
		telaPrincipal.start();
	}
	
	public void iniciarPartido(){
		System.out.println("Iniciou partido");
	}
	public void iniciarUrna(){
		System.out.println("Iniciou urna");
		
	}
	public void iniciarCandidato(){
		System.out.println("Iniciou candidato");
		
	}
	public void iniciarVotacao(){
		System.out.println("iniciou vota��o");
		
	}

}
