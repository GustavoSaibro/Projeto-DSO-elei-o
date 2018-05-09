package br.ufsc.ine5605.controller;

import java.util.ArrayList;

import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaPartido;

public class ControladorPartido {
    private ArrayList<Partido> partidos = new ArrayList<>();
    private Partido partido;
    private TelaPartido telaPartido;
    private PrincipalController principalController;

    public void iniciaTelaPartido() {
        telaPartido = new TelaPartido(this);
        telaPartido.opcoesPartido();
    }

    public void cadastrarPartido(String nomePartido, int numeroPartido) {
        partido = new Partido();
        partido.setNomePartido(nomePartido);
        partido.setNumeroPartido(numeroPartido);
        partidos.add(partido);
        listarPartidos();
    }

    public void excluirPartido(int numeroPartido) {
        if (findPartidoByNumero(numeroPartido).equals(null)) {
            
        }else{
            partidos.remove(findPartidoByNumero(numeroPartido));   
        }
    }
    
    public void listarPartidos(){
        telaPartido.listarPartido(partidos);
    }

    public Partido findPartidoByNumero(int numeroPartido) {
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getNumeroPartido() == numeroPartido) {
                partido = partidos.get(i);
            }
        }
        return partido;
    }
    
    public void voltarAoMenuPrincipal(){
        principalController = new PrincipalController();
        principalController.iniciaSistema();
    }
	
	
	
}
