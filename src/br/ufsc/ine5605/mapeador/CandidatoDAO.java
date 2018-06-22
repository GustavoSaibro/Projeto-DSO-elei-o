/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.mapeador;

import br.ufsc.ine5605.model.Candidato;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class CandidatoDAO {
    private HashMap<Integer, Candidato> cacheCandidatos = new HashMap<>();
    private static CandidatoDAO instancia = new CandidatoDAO();
    private final String filename = "candidatos.dat";

    public CandidatoDAO(){
        load();
    }
    
    public static CandidatoDAO getInstancia(){
        if(instancia == null){
            instancia = new CandidatoDAO();
        }        
        return instancia;
    }
    
    public Candidato get(Integer idCandidato){
        return cacheCandidatos.get(idCandidato);
    }
    
    public void put(Candidato candidato){
        cacheCandidatos.put(candidato.getNumeroCandidato(), candidato);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheCandidatos);
            
            oo.flush();
            fout.flush();
            
            oo.close();
            fout.close();
            
            oo = null;
            fout = null;
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }
    
    private void load(){
        
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);
                    
            this.cacheCandidatos = (HashMap<Integer, Candidato>) oi.readObject();
            
            oi.close();
            fin.close();
            
            oi = null;
            fin = null;
            
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        } catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
    
    public Collection<Candidato> getCandidato(){
        return cacheCandidatos.values();
    }
}
