/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorPrincipal;
import br.ufsc.ine5605.controller.ControladorUrna;
import br.ufsc.ine5605.model.Urna;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author pedro
 */
public class TelaUrna extends JFrame{
    private JLabel label;
    private JButton botao1;
    private JButton botao2;
    
    private final static boolean shouldFill = true;
    private final static boolean shouldWeightX = true;
    private final static boolean RIGHT_TO_LEFT = false;
    
    // PARA A APLICAÇÃO SER MAIS EFICIENTE, É RECOMENDÁVEL
    // ADICIONAR A TELA NO CONSTRUTOR
    public TelaUrna() {
        super("Tela urna");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        TelaUrna.GerenciadorDeBotao btManager;        
        btManager = new TelaUrna.GerenciadorDeBotao();

        GridBagConstraints bgc = new GridBagConstraints();
        
        label = new JLabel();
        label.setName("Tela - urna");
        container.add(label);
        
        if (shouldFill) {
            bgc.fill = GridBagConstraints.HORIZONTAL;
        }

        //BOTÃO 1
        botao1 = new JButton();
        if (shouldWeightX) {
            bgc.weightx = 0.5;
        }
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.gridx = 0;
        bgc.gridy = 0;
        botao1.setText("Cadastrar urna");
        botao1.setActionCommand("1");
        botao1.addActionListener(btManager);
        container.add(botao1, bgc);
        
        // BOTÃO 2
        botao2 = new JButton();
        bgc.fill = GridBagConstraints.HORIZONTAL;
        bgc.weightx = 0.5;
        bgc.gridx = 1;
        bgc.gridy = 0;
        botao2.setText("Listar urnas");
        botao2.setActionCommand("2");
        botao2.addActionListener(btManager);
        container.add(botao2, bgc);
        

        setSize(500, 250);
        setLocationRelativeTo(null);

    }
    
    public void opcoesUrna(){        
        setVisible(true);        
    }
    
    private void erroOpcoes() {
        System.out.println("Voce digitou um valor não valido!");
        opcoesUrna();
    }
    
    public void cadastrarUrna(){
        
    }
    public void excluirUrna(){
    
    
    }
    
    
    public void listarUrnas(ArrayList<Urna> urnas){
        for (int i = 0; i < urnas.size(); i++) {
            System.out.println("Urna Seção:"+urnas.get(i).getSecao() + ", Cidade :" + urnas.get(i).getCidade().getNome());

        }
    }

    public void urnaJaCadastrada() {
        System.out.println("Urna com esta secão já cadastrada!!");
    }

    public void removeuUrna() {
        System.out.println("Urna removida com sucesso!!");
    }
    
    private class GerenciadorDeBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {            
            String opcao = ae.getActionCommand();
            
            switch (opcao) {
                case "1":
                    ControladorPrincipal.getInstancia().telaCadastroUrna();                    
                    break;
                case "2":
                    ControladorPrincipal.getInstancia().telaListarUrna();
                    break;
                default:
                    break;
            }

        }

    }
    
}
