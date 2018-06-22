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
    
    private String nomePessoa;
    private int zonaEleitoral;
    private Cidade cidade;
    private int tituloEleitor;
    
    public Pessoa(){
        
    }

    public Pessoa(String nomePessoa, Cidade cidade, int tituloEleitor) {
        this.nomePessoa = nomePessoa;
        this.cidade = cidade;
        this.tituloEleitor = tituloEleitor;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
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

    
    
    
    
    
}
