/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.model;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Urna {
    
    private ArrayList<Voto> votos;
    private int secao;
    private Cidade cidade;

    public Urna(){}
    
    
    public Urna(ArrayList<Voto> votos, int secao, Cidade cidade) {
        this.votos = votos;
        this.secao = secao;
        this.cidade = cidade;
    }

    public ArrayList<Voto> getVotos() {
        return votos;
    }

    public int getSecao() {
        return secao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setVotos(ArrayList<Voto> votos) {
        this.votos = votos;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    /*
    private Urna getUrnaBySecao(int secao){
        Urna urnaEscolhida = null;
        return urnaEscolhida;
    }
    */
}
