/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.mapeador;

import br.ufsc.ine5605.model.Candidato;
import java.util.HashMap;

/**
 *
 * @author pedro
 */
public class CandidatoDAO {
    private HashMap<Integer, Candidato> cacheCandidatos = new HashMap<>();
    private static CandidatoDAO instancia = new CandidatoDAO();

    public CandidatoDAO() {
        load();
    }
    
    public static CandidatoDAO getInstancia(){
        if(instancia == null){
            instancia = new CandidatoDAO();
        }        
        return instancia;
    }
    
    public void put(Candidato candidato){
        cacheCandidatos.put(candidato.getNumeroCandidato(), candidato);
    }

    private void load() {
        //socorro
    }
}
