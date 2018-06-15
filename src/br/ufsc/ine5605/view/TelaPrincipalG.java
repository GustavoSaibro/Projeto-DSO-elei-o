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

import br.ufsc.ine5605.controller.ControladorPrincipal;
import java.awt.GridBagConstraints;

/**
 *
 * @author Gustavo Saibro
 */
public class TelaPrincipalG extends JFrame {

    private JLabel label;
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;
    private JButton botao5;
    private JButton botao6;

    private final static boolean shouldFill = true;
    private final static boolean shouldWeightX = true;
    private final static boolean RIGHT_TO_LEFT = false;

    private ControladorPrincipal principalController;

    

    public TelaPrincipalG() {
        super("Tela Principal");

    }

    public void iniciaTelaPrincipal() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GerenciadorDeBotao btManager;        
        btManager = new GerenciadorDeBotao();

        GridBagConstraints bgc = new GridBagConstraints();

        label = new JLabel();
        label.setName("Opções:");
        container.add(label);

        if (shouldFill) {
            bgc.fill = GridBagConstraints.HORIZONTAL;
        }

        //label.setText("Menu de opções:");
        botao1 = new JButton();
        if (shouldWeightX) {
            bgc.weightx = 0.5;
        }
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(botao1, bgc);;

        botao2 = new JButton();
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.weightx = 0.5;
        bgc.gridx = 1;
        bgc.gridy = 0;
        container.add(botao2, bgc);

        botao3 = new JButton();
        bgc.weightx = 0.5;
        bgc.gridx = 2;
        bgc.gridy = 0;
        container.add(botao3, bgc);

        botao4 = new JButton();
        //bgc.ipady = 4;
        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 0;
        bgc.gridy = 1;
        container.add(botao4, bgc);

        botao5 = new JButton();
        //bgc.ipady = 4;
        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 1;
        bgc.gridy = 1;
        container.add(botao5, bgc);

        botao6 = new JButton();
        //bgc.ipady = 4;
        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 2;
        bgc.gridy = 1;
        container.add(botao6, bgc);

        botao1.setText("Opções da Urna");
        botao2.setText("Opções do Candidato");
        botao3.setText("Opções do Partido");
        botao4.setText("Opções da Votação");
        botao5.setText("Opções do Eleitor");
        botao6.setText("Opções da Apuração");

      
        setSize(500, 250);

        botao1.addActionListener(btManager);

        botao1.setActionCommand("1");
        botao2.setActionCommand("2");
        botao3.setActionCommand("3");
        botao4.setActionCommand("4");
        botao5.setActionCommand("5");
        botao6.setActionCommand("6");

        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);
        botao3.addActionListener(btManager);
        botao4.addActionListener(btManager);
        botao5.addActionListener(btManager);
        botao6.addActionListener(btManager);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

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
                    principalController.iniciarUrna();                    
                    break;
                case "2":
                    principalController.iniciarCandidato();
                    break;
                case "3":
                    principalController.iniciarPartido();
                    break;
                case "4":
                    principalController.iniciarVotacao();
                    break;
                case "5":
                    principalController.iniciarEleitor();
                    break;
                case "6":
                    principalController.iniciarApuracao();
                    break;
                default:
                    break;
            }

        }

    }

}
