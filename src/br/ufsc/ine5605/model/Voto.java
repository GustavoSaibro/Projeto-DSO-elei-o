/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.model;

import java.io.Serializable;

/**
 *
 * @author Gustavo
 */
public class Voto implements Serializable{
   
    private Eleitor eleitor;
    private Candidato candidato;
    private Urna urna;
    private Cargo cargo;

    public Voto(Eleitor eleitor, Candidato candidato, Urna urna, Cargo cargo) {
        this.eleitor = eleitor;
        this.candidato = candidato;
        this.urna = urna;
        this.cargo = cargo;
    }
    
    public Voto(){}

    public Eleitor getEleitor() {
        return eleitor;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
