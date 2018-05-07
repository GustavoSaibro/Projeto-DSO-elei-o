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
    //telaEleitor.opcoesEleitor();
}

public void cadastrarEleitor(int zonaEleitoral,Cidade nomeCidade,int titulo){
     eleitor = new Eleitor(zonaEleitoral,nomeCidade,titulo);
     
     /*
     aqui faço uma isntancia de eleitor e percorro o array verificando se 
     o mesmo já esta cadastrado.
     */
     
     for(Eleitor e: eleitores){
         if(!eleitor.equals(e)){
             eleitores.add(eleitor);
             break;
         }
     }
}

public ArrayList ListaEleitores(){
    return eleitores;
}

public void excluirEleitorByTitulo(int titulo){
    
    /*
    aqui verifico na lista de eleitores o tituo e se for igual ao passo de parametro eu excluo.
    
    */
    
    
    for(Eleitor e : eleitores){
        if(e != null && e.getTituloEleitor() == titulo){
            e = null;
        }
    }
}
}
