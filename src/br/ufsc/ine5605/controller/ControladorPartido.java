package br.ufsc.ine5605.controller;

import java.util.ArrayList;

import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaPartido;

public class ControladorPartido {
    private ArrayList<Partido> partidos;
    private Partido partido;
    private TelaPartido telaPartido;

    public void iniciaTelaPartido() {
        telaPartido = new TelaPartido(this);
        telaPartido.startPartido();
    }

    public void cadastrarPartido(String nomePartido, int numeroPartido) {
        partido = new Partido();
        partido.setNomePartido(nomePartido);
        partido.setNumeroPartido(numeroPartido);
        partidos = new ArrayList<>();
        partidos.add(partido);
    }
	
	
	
}
