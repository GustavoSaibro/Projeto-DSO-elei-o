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
public class Partido {
    
    private String nomePartido;
    private int numeroPartido;   

    public Partido(){}
    
    public Partido(String nomePartido, int numeroPartido) {
        this.nomePartido = nomePartido;
        this.numeroPartido = numeroPartido;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public void setNomePartido(String nomePartido) {
        this.nomePartido = nomePartido;
    }

    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
    }
    
    
    
}
