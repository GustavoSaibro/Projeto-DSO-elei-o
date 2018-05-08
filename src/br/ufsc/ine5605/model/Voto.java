/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.model;

/**
 *
 * @author Gustavo
 */
public class Voto {
   
    private Eleitor eleitor;
    private Candidato candidato;
    private Urna urna;

    public Voto(Eleitor eleitor, Candidato candidato, Urna urna) {
        this.eleitor = eleitor;
        this.candidato = candidato;
        this.urna = urna;
    }
    
    public Voto(){}

    public Eleitor getEleitor() {
        return eleitor;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Urna getUrna() {
        return urna;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public void setUrna(Urna urna) {
        this.urna = urna;
    }
    
    
    
    
}
