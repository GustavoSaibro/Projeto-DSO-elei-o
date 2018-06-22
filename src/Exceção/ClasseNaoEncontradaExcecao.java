/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceção;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Saibro
 */
public class ClasseNaoEncontradaExcecao extends Exception{
    
        private JOptionPane joError;
     public ClasseNaoEncontradaExcecao(){
         JOptionPane.showMessageDialog(joError, "Classe não encontrada", "Verifique a existencia desta classe", JOptionPane.ERROR_MESSAGE);         
     }
       public ClasseNaoEncontradaExcecao (String message) {
         super(message);
        }
    
}
