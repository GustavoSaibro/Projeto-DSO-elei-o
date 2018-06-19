/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.mapeador;


import br.ufsc.ine5605.model.Eleitor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Gustavo Saibro
 */
public class EleitorDAO implements Serializable {
    
     private HashMap<Integer, Eleitor> cacheEleitores = new HashMap<>();
    private final String fileName = "eleitor.dat";

    public Eleitor get(Integer idEleitor) {
        return cacheEleitores.get(idEleitor);
    }

    public void put(Eleitor eleitor) {
        cacheEleitores.put(eleitor.getTituloEleitor(), eleitor);
    }

    public void persist() {

        try {

            FileOutputStream fout = new FileOutputStream(fileName);

            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheEleitores);

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

            this.cacheEleitores = (HashMap<Integer, Eleitor>) oi.readObject();

            oi.close();
            fin.close();

            oi = null;
            fin = null;

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            persist();
            System.out.println(ex);
        } catch(IOException ex){
            System.out.println(ex);
        }

    }
    
}
