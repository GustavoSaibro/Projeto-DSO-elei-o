/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import br.ufsc.ine5605.controller.ControladorEleitor;
import br.ufsc.ine5605.controller.ControladorPrincipal;
import br.ufsc.ine5605.model.Eleitor;
import java.awt.GridBagConstraints;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo Saibro
 */
public class TelaEleitorG extends JFrame {

    private JLabel label;
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;


    public TelaEleitorG() {
        super("Tela Eleitor");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GerenciadorDeBotao btManager;
        btManager = new GerenciadorDeBotao();

        GridBagConstraints bgc = new GridBagConstraints();

        label = new JLabel();
        label.setName("Opções:");
        container.add(label);

       

      
        botao1 = new JButton();
       
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(botao1, bgc);

        botao2 = new JButton();
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.weightx = 0.5;
        bgc.gridx = 0;
        bgc.gridy = 1;
        container.add(botao2, bgc);

        botao3 = new JButton();
        bgc.weightx = 0.5;
        bgc.gridx = 0;
        bgc.gridy = 2;
        container.add(botao3, bgc);

        botao1.setText("Cadastrar Eleitor");
        botao2.setText("Excluir Eleitor");
        botao3.setText("Listar Eleitores");

        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        botao1.addActionListener(btManager);

        botao1.setActionCommand("1");
        botao2.setActionCommand("2");
        botao3.setActionCommand("3");

        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);
        botao3.addActionListener(btManager);
        setVisible(true);
        
    }

   
    
    public void cadastroEleitor(){
        
        
    }

    /**
     *
     * @author Gustavo Saibro
     */
    private class GerenciadorDeBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String opcao = ae.getActionCommand();

            switch (opcao) {
                case "1":
                    
                    ControladorPrincipal.getInstancia().iniciarEleitor();
                    break;
                case "2":

                    break;
                case "3":

                    break;

                default:
                    break;
            }

        }

    }

}
