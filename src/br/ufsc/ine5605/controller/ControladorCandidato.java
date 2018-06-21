package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaCadastroCandidato;
import br.ufsc.ine5605.view.TelaCandidato;
import br.ufsc.ine5605.view.TelaExcluirCandidato;
import br.ufsc.ine5605.view.TelaListaCandidato;
import java.util.ArrayList;

public class ControladorCandidato {
    private ArrayList<Candidato> candidatos;
    private Candidato candidato;
    private TelaCandidato telaCandidato;
    private static ControladorCandidato instanciaCandidato;
   
    private ControladorCandidato(){
        telaCandidato = new TelaCandidato();
        candidatos = new ArrayList<>();
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
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).getNumeroCandidato() == numeroCandidato){
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
            candidatos.add(candidato);
            System.out.println(nomeCandidato);
            System.out.println(numeroCandidato);
        }
    }

    public void listarCandidato(){
        //VER COMO LISTAR EM TABELA
    }
    
    public void excluirCandidato(int numeroCandidato){
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i) != null && candidatos.get(i).getNumeroCandidato() == numeroCandidato){
                candidatos.remove(candidatos.get(i));
            }
        }
    }
    
    public void voltarAoMenuPrincipal(){
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public Candidato findCandidatoByNumero(int numeroCandidato){
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i) != null && candidatos.get(i).getNumeroCandidato() == numeroCandidato){
                candidato = candidatos.get(i);
                return candidato;
            }
        }
        return candidato;
    }
    
    public ArrayList getCandidatos(){
        return candidatos;
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
}
