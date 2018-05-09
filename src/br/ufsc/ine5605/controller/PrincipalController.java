package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaPrincipal;

public class PrincipalController {
	private ControladorPartido controladorPartido;
	private UrnaController urnaController;
	private CandidatoController candidatoController;
	private EleitorController eleitorController;
	private VotacaoController votacaoController;
	private TelaPrincipal telaPrincipal;
	
	public PrincipalController(){
            telaPrincipal = new TelaPrincipal(this);
            controladorPartido = new ControladorPartido(this);
            eleitorController = new EleitorController(this);
            candidatoController = new CandidatoController(this);

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
		telaPrincipal.iniciarTelaPrincipal();
	}
	
	public void iniciarPartido(){
                controladorPartido.iniciaTelaPartido();
	}
        public void iniciarEleitor(){
           
            eleitorController.iniciaTelaEleitor();
        }
	public void iniciarUrna(){
		System.out.println("Iniciou urna");
		
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
