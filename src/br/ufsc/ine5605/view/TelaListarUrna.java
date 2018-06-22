/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorPrincipal;
import br.ufsc.ine5605.controller.ControladorUrna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class TelaListarUrna extends JFrame{
     private JLabel label;
    private JButton botao1;
    private JButton botao2;
    private JTextField txtSecao;
    private JTable table;
    private JScrollPane scrollPane;

    private boolean ok = false;
    
    public TelaListarUrna(){
        super("Tela de Exclusão de Candidato - MASSAAAAAA");
                
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints bgc = new GridBagConstraints();
        
        
        
        table = new JTable(ControladorUrna.getInstancia().getUrnas().size(), 2);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(250,40));
        String[] colunas = {"Seção", "Cidade"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        for (int i = 0; i < ControladorUrna.getInstancia().getUrnas().size(); i++) {
            modelo.addRow(new String[]{Integer.toString(ControladorUrna.getInstancia().getUrnas().get(i).getSecao()), ControladorUrna.getInstancia().getUrnas().get(i).getCidade().getNome()});
        }
        table.setModel(modelo);
        scrollPane = new JScrollPane(table);   
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(scrollPane, bgc);
        
        label = new JLabel("Digite a seção da urna que deseja excluir");
        bgc.gridx = 0;
        bgc.gridy = 1;
        bgc.gridwidth = 3;
        container.add(label, bgc);
        
        txtSecao = new JTextField("Digite a seção");
        bgc.gridx = 1;
        bgc.gridy = 1;
        bgc.gridwidth = 1;
        container.add(txtSecao, bgc);
        
        botao1 = new JButton("Excluir");
        bgc.gridx = 2;
        bgc.gridy = 1;
        botao1.addActionListener(new GerenciadorDeBotao(txtSecao));
        container.add(botao1);
        
        setSize(600 , 200);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void iniciarTelaListarUrna() {
        setVisible(true);
    }

    private static class GerenciadorDeBotao implements ActionListener {
        private JTextField txtSecao;
        private String secao;

        public GerenciadorDeBotao(JTextField txtSecao) {
            this.txtSecao = txtSecao;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            secao = txtSecao.getText();
            ControladorUrna.getInstancia().excluirUrna(Integer.parseInt(secao));
        }
    }
}
