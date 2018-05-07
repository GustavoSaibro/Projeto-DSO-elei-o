package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.view.TelaEleitor;
import java.util.ArrayList;

public class EleitorController {

private Eleitor eleitor;
private ArrayList<Eleitor> eleitores;
private TelaEleitor telaEleitor;

public void iniciaTelaEleitor(){
    this.telaEleitor = telaEleitor;
    //telaEleitor.start();
}

public void cadastrarEleitor(int zonaEleitoral,Cidade nomeCidade,int titulo){
     eleitor = new Eleitor(zonaEleitoral,nomeCidade,titulo);
}


}
