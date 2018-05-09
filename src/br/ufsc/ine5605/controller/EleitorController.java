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
private PrincipalController principalController;

public EleitorController(PrincipalController principalController){
    this.principalController = principalController;
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

    
             eleitores.add(eleitor);
            
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

 public void voltarAoMenuPrincipal(){
     principalController.iniciaSistema();
 
 }
}
