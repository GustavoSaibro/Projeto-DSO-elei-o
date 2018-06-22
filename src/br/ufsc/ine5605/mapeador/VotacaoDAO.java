/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.mapeador;


import br.ufsc.ine5605.model.Urna;
import br.ufsc.ine5605.model.Voto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Gustavo Saibro
 */
public class VotacaoDAO implements Serializable {
    
    private HashMap<Integer, Voto> cacheVotacao = new HashMap<>();
    private final String fileName = "votacao.dat";
    
    public VotacaoDAO(){
        load();
    }

    public Voto get(Integer irVotacao) {
        return cacheVotacao.get(irVotacao);
    }

    public void put(Voto voto) {
        System.out.println(voto.getEleitor().getTituloEleitor());
        cacheVotacao.put(voto.getEleitor().getTituloEleitor(), voto);
        persist();
    }
    
    public Collection<Voto> getVoto(){
        return cacheVotacao.values();
    }

    public void persist() {

        try {

            FileOutputStream fout = new FileOutputStream(fileName);

            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheVotacao);

            oo.flush();
            fout.flush();

            oo.close();
            fout.close();
 
           oo = null;
            fout = null;

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void load() {

        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oi = new ObjectInputStream(fin);

            this.cacheVotacao = (HashMap<Integer, Voto>) oi.readObject();

            oi.close();
            fin.close();

            oi = null;
            fin = null;

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            
            System.out.println(ex);
            persist();
        } catch(IOException ex){
            System.out.println(ex);
        }

    }
    
    
}
