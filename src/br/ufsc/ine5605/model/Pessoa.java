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
public abstract class Pessoa {
    
    private int zonaEleitoral;
    private Cidade cidade;
    private int tituloEleitor;

    public Pessoa(int zonaEleitoral, Cidade cidade, int tituloEleitor) {
        this.zonaEleitoral = zonaEleitoral;
        this.cidade = cidade;
        this.tituloEleitor = tituloEleitor;
    }
    
    
    
	public int getZonaEleitoral() {
		return zonaEleitoral;
	}
	public void setZonaEleitoral(int zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public int getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(int tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

    Pessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
