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
public class Candidato extends Pessoa {

    private Partido partido;
    private Cargo cargo;
    private int numeroCandidato;
    private int numeroDeVotos;
    private int numeroPartido;

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
    }
    

    public int getNumeroDeVotos() {
        return numeroDeVotos;
    }
    
    public int getNumeroCandidato() {
        return numeroCandidato;
    } 
    
    public Partido getPartido() {
        return partido;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public void setNumeroDeVotos(int numeroDeVotos) {
        this.numeroDeVotos = numeroDeVotos;
    }
    
    

  

}
