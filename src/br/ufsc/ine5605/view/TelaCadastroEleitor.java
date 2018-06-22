/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorEleitor;
import br.ufsc.ine5605.model.Eleitor;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo Saibro
 */
public class TelaCadastroEleitor extends JFrame {

    private Eleitor eleitor;
    private ArrayList eleitores;
    private JButton botao1;
    private JButton botao2;
    private JLabel label;
    private JLabel labe1;
    private JLabel labe2;
    private JLabel labe3;
    private JLabel labe4;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JTextField text5;

    public TelaCadastroEleitor() {

        Container container = getContentPane();
        container.setLayout(null);
        TelaCadastroEleitor.GerenciadorDeBotao btManager;
        btManager = new TelaCadastroEleitor.GerenciadorDeBotao();
        GridBagConstraints bgc = new GridBagConstraints();

        label = new JLabel();
        label.setName("Cadastro do eleitor:");
        label.setBounds(145, 10, 200, 50);

        eleitores = new ArrayList();
        eleitores = ControladorEleitor.getInstancia().getEleitores();

        labe1 = new JLabel();
        labe1.setName("Cadastro do eleitor:");
        labe1.setBounds(58, 98, 200, 50);

        text1 = new JTextField();
        text1.setBounds(55, 95, 250, 25);

        labe2 = new JLabel();
        labe2.setName("Cadastro do eleitor:");
        labe2.setBounds(68, 108, 200, 50);

        text2 = new JTextField();
        text2.setBounds(65, 105, 250, 25);

        labe3 = new JLabel();
        labe3.setName("Cadastro do eleitor:");
        labe3.setBounds(78, 118, 200, 50);

        text3 = new JTextField();
        text3.setBounds(75, 115, 250, 25);

        labe4 = new JLabel();
        labe4.setName("Cadastro do eleitor:");
        labe4.setBounds(88, 128, 200, 50);

        text4 = new JTextField();
        text4.setBounds(85, 125, 250, 25);
        
        
        
        botao1 = new JButton();
        botao1.setBounds(75, 160, 250, 40);
        
        
        botao2 = new JButton();
        botao2.setBounds(75, 210, 250, 40);
        
        botao1.setActionCommand("1");
        botao2.setActionCommand("2");        
        

        container.add(label);
        container.add(labe1);
        container.add(labe2);
        container.add(labe3);
        container.add(labe4);
        container.add(botao1);
        container.add(botao2);
        container.add(text1);
        container.add(text2);
        container.add(text3);
        container.add(text4);
        container.add(text5);
        
        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);
        
        setSize(400 , 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        

    }

    private class GerenciadorDeBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String opcao = ae.getActionCommand();

            switch (opcao) {
                case "1":
                    try {

                      
                    } catch (Exception e) {

                    }
                    break;
                case "2":

                    break;
                default:
                    break;
            }
        }

    }

}
