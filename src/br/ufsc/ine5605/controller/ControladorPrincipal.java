package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaPrincipal;
import java.util.ArrayList;

public class ControladorPrincipal {
	private ControladorPartido partidoController;
	private ControladorUrna urnaController;
	private ControladorCandidato candidatoController;
	private ControladorEleitor eleitorController;
	private ControladorVotacao votacaoController;
	private TelaPrincipal telaPrincipal;
	
	public ControladorPrincipal(){
            telaPrincipal = new TelaPrincipal(this);
            partidoController = new ControladorPartido(this);
            eleitorController = new ControladorEleitor(this);
            candidatoController = new ControladorCandidato(this);

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
		System.out.println("iniciou vota��o");
		
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
    
}
