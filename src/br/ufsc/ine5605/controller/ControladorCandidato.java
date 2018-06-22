package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.mapeador.CandidatoDAO;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaCadastroCandidato;
import br.ufsc.ine5605.view.TelaCandidato;
import br.ufsc.ine5605.view.TelaExcluirCandidato;
import br.ufsc.ine5605.view.TelaListaCandidato;
import java.util.ArrayList;

public class ControladorCandidato {
    private CandidatoDAO candidatoDAO;
    private Candidato candidato;
    private TelaCandidato telaCandidato;
    private static ControladorCandidato instanciaCandidato;
   
    private ControladorCandidato(){
        telaCandidato = new TelaCandidato();
        candidatoDAO = new CandidatoDAO();
    }
    
    public static ControladorCandidato getInstancia(){
        if(instanciaCandidato == null){
            instanciaCandidato = new ControladorCandidato();
        }
        return instanciaCandidato;
    }
    
    
    public void iniciarTelaCandidato(){
        TelaCandidato t = new TelaCandidato();
        
    }
    
    public void cadastrarCandidato(int numeroCandidato, String nomeCandidato){
        boolean naoTem = true;
        for(int i = 0; i < getCandidato().size(); i++){
            if(getCandidato().get(i).getNumeroCandidato() == numeroCandidato){
                //DAR AVISO QUE JÁ TEM
                naoTem = false;
            }else{
                naoTem = true;
            }
        }
        if(naoTem){
            candidato = new Candidato();
            candidato.setNumeroCandidato(numeroCandidato);
            candidato.setNomePessoa(nomeCandidato);
            candidatoDAO.put(candidato);
        }
    }

    public void listarCandidato(){
        //VER COMO LISTAR EM TABELA
    }
    
    public void excluirCandidato(int numeroCandidato){
        for(int i = 0; i < getCandidato().size(); i++){
            if(getCandidato().get(i) != null && getCandidato().get(i).getNumeroCandidato() == numeroCandidato){
                getCandidato().remove(getCandidato().get(i));
            }
        }
    }
    
    public void voltarAoMenuPrincipal(){
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public Candidato findCandidatoByNumero(int numeroCandidato){
        for(int i = 0; i < getCandidato().size(); i++){
            if(getCandidato().get(i) != null && getCandidato().get(i).getNumeroCandidato() == numeroCandidato){
                candidato = getCandidato().get(i);
                return candidato;
            }
        }
        return candidato;
    }
    
    public ArrayList getCandidatos(){
        return getCandidato();
    }

    public void abrirTelaCandidato(){
        TelaCandidato telaCandidato = new TelaCandidato();
    }
    
    public void abrirTelaCadastroCandidato(){
        TelaCadastroCandidato telaCadastroCandidato = new TelaCadastroCandidato();
    }
    
    public void abrirTelaExcluirCandidato(){
        TelaExcluirCandidato telaExcluirCandidato = new TelaExcluirCandidato();
    }
    
    public void abrirTelaListaCandidato(){
        TelaListaCandidato telaListaCandidato = new TelaListaCandidato();
    }
    public ArrayList<Candidato> getCandidato(){
        return new ArrayList<Candidato>(candidatoDAO.getCandidato());
    }
}
