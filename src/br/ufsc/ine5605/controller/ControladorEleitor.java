package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaEleitor;
import java.util.ArrayList;

public class ControladorEleitor {

    private Eleitor eleitor;
    private ArrayList<Eleitor> eleitores;
    private TelaEleitor telaEleitor;
    private ControladorPrincipal principalController;

    public ControladorEleitor(ControladorPrincipal principalController) {
        this.principalController = principalController;
        telaEleitor = new TelaEleitor(this);
        eleitores = new ArrayList<>();

    }

    public void iniciaTelaEleitor() {

        telaEleitor.opcoesEleitor();
    }

    public void cadastrarEleitor(String nomeEleitor, int zonaEleitoral, String nomeCidade, int titulo, int secao) {
        // CRIA UMA NOVA CIDADE
        Cidade c = new Cidade();
        c.setNome(nomeCidade);

        eleitor = new Eleitor(nomeEleitor, zonaEleitoral, c, titulo, secao);

        if (eleitores.size() == 0) {
            eleitores.add(eleitor);
        } else {
            
            
            //aqui percorro o array de eleitores verificando caso tenha um mesmo titulo cadastrado, caso tenha aparece mensagem de erro.
            
           
            for (int i = 0; i < eleitores.size(); i++) {
                if (eleitores.get(i) != null && eleitores.get(i).getTituloEleitor() == titulo) {
                    telaEleitor.erroDeCadastro();
                    break;
                }else{
                    eleitores.add(eleitor);
                }
            }            
        }

        ListaEleitores();
    }

    public void ListaEleitores() {
        telaEleitor.listarEleitor(eleitores);
    }

    public void excluirEleitorByTitulo(int titulo) {
        if (findEleitorByTitulo(titulo).equals(null)) {

        } else {
            eleitores.remove(findEleitorByTitulo(titulo));
            telaEleitor.removeu();
        }
        ListaEleitores();
    }

    private Eleitor findEleitorByTitulo(int titulo) {
        for (int i = 0; i < eleitores.size(); i++) {
            if (eleitores.get(i) != null && eleitores.get(i).getTituloEleitor() == titulo) {
                eleitor = eleitores.get(i);
            }
        }
        return eleitor;
    }

    public void voltarAoMenuPrincipal() {
        principalController.iniciaSistema();

    }

    ArrayList getEleitores() {
        return eleitores;
    }
}
