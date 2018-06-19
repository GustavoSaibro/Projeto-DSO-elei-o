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
public class ArquivoNaoAchadoExcecao extends Exception{
        private JOptionPane joError;
     public ArquivoNaoAchadoExcecao(){
         JOptionPane.showMessageDialog(joError, "Arquivo não encontrado", "Verifique a existencia do arquivo", JOptionPane.ERROR_MESSAGE);         
     }
       public ArquivoNaoAchadoExcecao(String message) {
         super(message);
        }
    
}
