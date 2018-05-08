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
public class Cidade {
    
    private String nome;

    public Cidade(String nome) {
        this.nome = nome;
    }
    
    public Cidade(){
    	
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
