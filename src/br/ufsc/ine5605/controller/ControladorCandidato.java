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
    //private ControladorPrincipal principalController;
    private static ControladorCandidato instanciaCandidato = new ControladorCandidato();
   
    private ControladorCandidato(){
    //    this.principalController = principalController;
        telaCandidato = new TelaCandidato(this);
        candidatos = new ArrayList<>();
    }
    
    public static ControladorCandidato getInstancia(){
        if(instanciaCandidato == null){
            instanciaCandidato = new ControladorCandidato();
        }
        return instanciaCandidato;
    }
    
    
    public void iniciarTelaCandidato(){
        telaCandidato.opcoesCandidato();
    }
    
    public void cadastrarCandidato(int numeroPartido, Cargo cargo, String nomeCandidato, int numeroCandidato, String nomeCidade){
        Partido p = ControladorPrincipal.getInstancia().findPartidoByNumero(numeroPartido);
        Cidade c = new Cidade();
        
        if (nomeCidade.charAt(0) == 'f' || nomeCidade.charAt(0) == 'F') {
            nomeCidade = "florianopolis";
        } else {
            nomeCidade = "saojose";
        }
        c.setNome(nomeCidade);
        candidato = new Candidato();
        candidato.setCargo(cargo);
        candidato.setNomePessoa(nomeCandidato);
        candidato.setNumeroPartido(numeroPartido);
        candidato.setPartido(p);
        candidato.setCidade(c);
                       
        candidatos.add(candidato);
        listarCandidato();
        voltarAoMenuPrincipal();
    }

    public void listaPartido() {
        ControladorPrincipal.getInstancia().listarPartido();
    }
    
    public void listarCandidato(){
        telaCandidato.listarCandidatos(candidatos);
    }
    
    public void voltarAoMenuPrincipal(){
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    ArrayList getCandidatos() {
        return candidatos;
    }
    
    public Candidato findCandidatoByNumero(int numeroCandidato){
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i) != null && candidatos.get(i).getNumeroCandidato() == numeroCandidato){
                candidato = candidatos.get(i);
            }
        }
        return candidato;
    }

}
