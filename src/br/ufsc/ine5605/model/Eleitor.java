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
public class Eleitor extends Pessoa implements Serializable{
    
    private int secao;
    
    public Eleitor(String nomePessoa, int zonaEleitoral, Cidade cidade, int tituloEleitor, int secao) {
        super(nomePessoa, zonaEleitoral, cidade, tituloEleitor);
        this.secao = secao;
    }

    public int getSecao() {
        return secao;
    }
    
    

    public void setSecao(int secao) {
        this.secao = secao;
    }
   
    
    
}
