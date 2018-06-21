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

import br.ufsc.ine5605.controller.ControladorUrna;
import br.ufsc.ine5605.model.Urna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import br.ufsc.ine5605.controller.ControladorPrincipal;
import java.awt.GridBagConstraints;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo Saibro
 */
public class TelaUrnaG extends JFrame {
    
    

    private JLabel label;
    private JButton botao0;
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;
    private JButton botao5;
    private JButton botao6;
    private JButton botao7;
    private JButton botao8;
    private JButton botao9;
    
    private JButton confirma;
    private JButton corrige;
    
    private JTextField jTextCampNum;
    

    private final static boolean shouldFill = true;
    private final static boolean shouldWeightX = true;
    private final static boolean RIGHT_TO_LEFT = false;

    public TelaUrnaG() {
        super("Tela da Urna");
        iniciaTelaUrna();
    }

    public void iniciaTelaUrna() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        TelaUrnaG.GerenciadorDeBotao btManager;
        btManager = new TelaUrnaG.GerenciadorDeBotao();
        jTextCampNum = new JTextField("",2);

        GridBagConstraints bgc = new GridBagConstraints();

        label = new JLabel();
        label.setName("Opções:");
        container.add(label);

        if (shouldFill) {
            bgc.fill = GridBagConstraints.HORIZONTAL;
        }

        botao0 = new JButton();
        if (shouldWeightX) {
            bgc.weightx = 0.5;
        }
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 3;
        bgc.gridy = 1;
        container.add(botao1, bgc);

        botao1 = new JButton();
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(botao1, bgc);

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

        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 0;
        bgc.gridy = 1;
        container.add(botao4, bgc);

        botao5 = new JButton();

        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 1;
        bgc.gridy = 1;
        container.add(botao5, bgc);

        botao6 = new JButton();

        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 2;
        bgc.gridy = 1;
        container.add(botao6, bgc);

        botao7 = new JButton();

        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 0;
        bgc.gridy = 2;
        container.add(botao6, bgc);

        botao8 = new JButton();

        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 1;
        bgc.gridy = 2;
        container.add(botao6, bgc);

        botao9 = new JButton();
        //bgc.ipady = 4;
        bgc.weightx = 0.5;
        bgc.gridwidth = 1;
        bgc.gridx = 2;
        bgc.gridy = 2;
        container.add(botao6, bgc);
        
        confirma = new JButton();
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 3;
        bgc.gridy = 2;
        container.add(botao1, bgc);
        
        corrige = new JButton();
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 3;
        bgc.gridy = 0;
        container.add(botao1, bgc);
        
        
        corrige.setText("CORRIGE");
        confirma.setText("CONFIRMA");
        botao0.setText("0");
        botao1.setText("1");
        botao2.setText("2");
        botao3.setText("3");
        botao4.setText("4");
        botao5.setText("5");
        botao6.setText("6");
        botao7.setText("7");
        botao8.setText("8");
        botao9.setText("9");

        setSize(500, 250);

        botao1.addActionListener(btManager);

        corrige.setActionCommand("CORRIGE");
        confirma.setActionCommand("CONFIRMA");
        botao0.setActionCommand("0");
        botao1.setActionCommand("1");
        botao2.setActionCommand("2");
        botao3.setActionCommand("3");
        botao4.setActionCommand("4");
        botao5.setActionCommand("5");
        botao6.setActionCommand("6");
        botao6.setActionCommand("7");
        botao6.setActionCommand("8");
        botao6.setActionCommand("9");

        corrige.addActionListener(btManager);
        confirma.addActionListener(btManager);
        botao0.addActionListener(btManager);
        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);
        botao3.addActionListener(btManager);
        botao4.addActionListener(btManager);
        botao5.addActionListener(btManager);
        botao6.addActionListener(btManager);
        botao7.addActionListener(btManager);
        botao8.addActionListener(btManager);
        botao9.addActionListener(btManager);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private class GerenciadorDeBotao implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String opcao = ae.getActionCommand();
            opcao = "";

            switch (opcao) {
                case "0":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "1":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "2":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "3":
                   opcao = opcao + jTextCampNum.getText();
                   jTextCampNum.setText(opcao);
                    break;
                case "4":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "5":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "6":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "7":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "8":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case "9":
                    opcao = opcao + jTextCampNum.getText();
                    jTextCampNum.setText(opcao);
                    break;
                case"CONFIRMA":
                    int op = Integer.parseInt(opcao);
                    ControladorUrna.getInstancia().cadastrarUrna(op, opcao);
                    break;
                case "CORRIGE":
                    opcao.substring(0);
                    break;
                default:
                    break;
                    
                
            }
            
            

        }

    }

}
