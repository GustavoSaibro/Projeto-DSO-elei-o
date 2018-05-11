package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cargo;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaCandidato;
import java.util.ArrayList;

public class ControladorCandidato {
    private ArrayList<Candidato> candidatos;
    private Candidato candidato;
    private TelaCandidato telaCandidato;
    private ControladorPrincipal principalController;
   
    public ControladorCandidato(ControladorPrincipal principalController){
        this.principalController = principalController;
        telaCandidato = new TelaCandidato(this);
        candidatos = new ArrayList<>();
    }
    
    public void iniciarTelaCandidato(){
        telaCandidato.opcoesCandidato();
    }
    
    public void cadastrarCandidato(int numeroPartido, Cargo cargo, String nomeCandidato, String nomeCidade){
        Partido p = principalController.findPartidoByNumero(numeroPartido);
        Cidade c = new Cidade();
        c.setNome(nomeCidade);
        candidato = new Candidato();
        candidato.setCargo(cargo);
        candidato.setNomePessoa(nomeCandidato);
        candidato.setPartido(p);
        candidato.setCidade(c);
        
        candidatos.add(candidato);
        listarCandidato();
        voltarAoMenuPrincipal();
    }

    public void listarPartido() {
        principalController.listarPartido();
    }
    
    public void listarCandidato(){
        telaCandidato.listarCandidatos(candidatos);
    }
    
    public void voltarAoMenuPrincipal(){
        principalController.iniciaSistema();
    }

}
