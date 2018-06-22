package br.ufsc.ine5605.controller;

import br.ufsc.ine5605.mapeador.EleitorDAO;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Eleitor;
import br.ufsc.ine5605.model.Partido;
import br.ufsc.ine5605.view.TelaEleitorG;
import java.util.ArrayList;

public class ControladorEleitor {

    private Eleitor eleitor;
    private EleitorDAO eleitorDAO;
    private TelaEleitorG telaEleitor;
    private static ControladorEleitor instanciaEleitor;

    public ControladorEleitor() {
        eleitorDAO = new EleitorDAO();
    }
    
    public static ControladorEleitor getInstancia(){
        if(instanciaEleitor == null){
            instanciaEleitor = new ControladorEleitor();
        }
        return instanciaEleitor;
    }

    public void iniciaTelaEleitor() {

        telaEleitor = new TelaEleitorG();
    }

    public void cadastrarEleitor(String nomeEleitor, String nomeCidade, int titulo, int secao) {
        
        boolean jahTem = false;
        
        if (nomeCidade.charAt(0) == 'f' || nomeCidade.charAt(0) == 'F') {
            nomeCidade = "florianopolis";
        } else {
            nomeCidade = "saojose";
        }
        // CRIA UMA NOVA CIDADE
        Cidade c = new Cidade();
        c.setNome(nomeCidade);
        System.out.print(nomeEleitor);
        eleitor = new Eleitor(nomeEleitor, c, titulo, secao);

        if (getEleitor().size() == 0) {
            eleitorDAO.put(eleitor);
        } else {

            //aqui percorro o array de eleitores verificando caso tenha um mesmo titulo cadastrado, caso tenha aparece mensagem de erro.
        
            
            
            for (int i = 0; i < getEleitor().size(); i++) {
                Eleitor e = getEleitor().get(i);               
                if (getEleitor().get(i) != null && eleitor.getTituloEleitor() == e.getTituloEleitor()) {
                    jahTem = true;
                    //telaEleitor.erroDeCadastro();
                    break;
                } 
            }
            
              if (jahTem == false) {
                  eleitorDAO.put(eleitor);
              }
        }

        ListaEleitores();
    }
    
    public ArrayList<Eleitor> getEleitor(){
        return new ArrayList<Eleitor>(eleitorDAO.getEleitor());
    }

    public void ListaEleitores() {
       // telaEleitor.listarEleitor(eleitores);
    }

    public void excluirEleitorByTitulo(int titulo) {

            eleitorDAO.removeEleitor(titulo);
            //telaEleitor.removeu();
        
    }

    public Eleitor findEleitorByTitulo(int titulo) {
        for (int i = 0; i < getEleitor().size(); i++) {
            if (getEleitor().get(i) != null && getEleitor().get(i).getTituloEleitor() == titulo) {
                eleitor = getEleitor().get(i);
            }
        }
        return eleitor;
    }

    public void voltarAoMenuPrincipal() {
        ControladorPrincipal.getInstancia().iniciaSistema();

    }

   public  ArrayList getEleitores() {
        return getEleitor();
    }
}
