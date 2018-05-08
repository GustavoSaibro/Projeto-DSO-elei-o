package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaEleitor;
import java.util.ArrayList;

public class EleitorController {

private Eleitor eleitor;
private ArrayList<Eleitor> eleitores;
private TelaEleitor telaEleitor;

public EleitorController(){
    telaEleitor = new TelaEleitor(this);
    eleitores = new ArrayList<>();

}

public void iniciaTelaEleitor(){

    telaEleitor.opcoesEleitor();
}

public void cadastrarEleitor(String nomeEleitor, int zonaEleitoral,String nomeCidade,int titulo){
    // CRIA UMA NOVA CIDADE
    Cidade c = new Cidade();
    c.setNome(nomeCidade);
    
    eleitor = new Eleitor(nomeEleitor, zonaEleitoral, c, titulo);
     
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
     ListaEleitores();
}

public void ListaEleitores(){
    telaEleitor.listarEleitor(eleitores);
}

public void excluirEleitorByTitulo(int titulo){
    if(findEleitorByTitulo(titulo).equals(null)){
        
    }else{
        eleitores.remove(findEleitorByTitulo(titulo));
    }
    ListaEleitores();
}

private Eleitor findEleitorByTitulo(int titulo) {
        for (int i = 0; i < eleitores.size(); i++) {
            if (eleitores.get(i).getTituloEleitor() == titulo) {
                eleitor = eleitores.get(i);
            }
        }
        return eleitor;
    }
}
