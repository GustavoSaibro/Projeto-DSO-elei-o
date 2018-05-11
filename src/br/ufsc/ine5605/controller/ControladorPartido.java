package br.ufsc.ine5605.controller;

import java.util.ArrayList;

import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaPartido;

public class ControladorPartido {
    private ArrayList<Partido> partidos;
    private Partido partido;
    private TelaPartido telaPartido;
    private ControladorPrincipal principalController;

    public ControladorPartido(ControladorPrincipal principalController) {
        this.principalController = principalController;
        partidos = new ArrayList<>();
        telaPartido = new TelaPartido(this);
    }

    public void iniciaTelaPartido() {
        telaPartido.opcoesPartido();
    }

    public void cadastrarPartido(String nomePartido, int numeroPartido) {
        partido = new Partido();
        partido.setNomePartido(nomePartido);
        partido.setNumeroPartido(numeroPartido);

        if (partidos.size() == 0) {
            partidos.add(partido);
        } else {

            //aqui percorro o array de partidos verificando se já esta cadastrado, caso já esteja passa uma mensagem de erro.
            for (int i = 0; i < partidos.size(); i++) {
                if (partidos.get(i) != null && partidos.get(i).getNumeroPartido() == numeroPartido) {
                    telaPartido.jaCadastrado();
                    break;
                } else {
                    partidos.add(partido);
                }
            }
        }
        listarPartidos();
    }

    public void excluirPartido(int numeroPartido) {
        if (findPartidoByNumero(numeroPartido).equals(null)) {

        } else {
            partidos.remove(findPartidoByNumero(numeroPartido));
            telaPartido.removeuPartido();
        }
    }

    public void listarPartidos() {
        telaPartido.listarPartido(partidos);
    }

    public Partido findPartidoByNumero(int numeroPartido) {
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i) != null && partidos.get(i).getNumeroPartido() == numeroPartido) {
                partido = partidos.get(i);
            }
        }
        return partido;
    }

    public void voltarAoMenuPrincipal() {
        principalController.iniciaSistema();
    }

    ArrayList getPartidos() {
        return partidos;
    }

}
