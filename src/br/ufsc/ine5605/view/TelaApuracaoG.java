/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;


import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Saibro
 */
public class TelaApuracaoG extends JFrame{
    
 
   private JButton botao1; 
    
    public TelaApuracaoG() {
       super("Tela de apuração");
       
        TelaApuracaoG.GerenciadorDeBotao btManager = new TelaApuracaoG.GerenciadorDeBotao();
        
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        GridBagConstraints bgc = new GridBagConstraints();
         
        
        botao1 = new JButton();       
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 2;
        bgc.gridy = 1;
        container.add(botao1, bgc);
       
        botao1.setText("Apurar");
       
        
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        botao1.setActionCommand("1");
        botao1.addActionListener(btManager);
         setVisible(true);
       

        
        
       
        
    }

   
     private class GerenciadorDeBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String opcao = ae.getActionCommand();
            
            if(opcao.equals("1")){
                
            }
           
        }

    }
   
   
   
   
   
}
