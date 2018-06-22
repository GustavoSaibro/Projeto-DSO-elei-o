/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorEleitor;
import br.ufsc.ine5605.controller.ControladorPrincipal;
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
 * @author José Felipe
 */
public class TelaCadastroEleitor extends JFrame {

    private JButton btnCadastrar;
    private JLabel lblNomeEleitor;
    private JLabel lblTitulo;
    private JLabel lblSecao;
    private JTextField txtNomeEleitor;
    private JTextField txtTitulo;
    private JTextField txtSecao;

    public TelaCadastroEleitor(){

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        TelaCadastroEleitor.GerenciadorDeBotao btManager;
        GridBagConstraints bgc = new GridBagConstraints();

        lblNomeEleitor = new JLabel("Nome do eleitor: ");
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(lblNomeEleitor, bgc);
        
        txtNomeEleitor = new JTextField("Digite o nome do eleitor");
        bgc.gridx = 1;
        bgc.gridy = 0;
        container.add(txtNomeEleitor, bgc);
        
        lblTitulo = new JLabel("Título de eleitor: ");
        bgc.gridx = 0;
        bgc.gridy = 1;
        container.add(lblTitulo, bgc);
        
        txtTitulo = new JTextField("Digite o título de eleitor");
        bgc.gridx = 1;
        bgc.gridy = 1;
        container.add(txtTitulo, bgc);
        
        lblSecao = new JLabel("Seção: ");
        bgc.gridx = 0;
        bgc.gridy = 2;
        container.add(lblSecao, bgc);
        
        txtSecao = new JTextField("Digite a seção eleitoral");
        bgc.gridx = 1;
        bgc.gridy = 2;
        container.add(txtSecao, bgc);
        
        btnCadastrar = new JButton("Cadastrar");
        bgc.gridwidth = 2;
        bgc.gridx = 0;
        bgc.gridy = 3;
        btnCadastrar.addActionListener(new GerenciadorDeBotao(txtNomeEleitor, txtTitulo, txtSecao));
        container.add(btnCadastrar, bgc);
       
        
        setSize(400 , 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        

    }
    
    public void iniciarTelaCadastro(){
        setVisible(true);
    }

    private class GerenciadorDeBotao implements ActionListener {
        private JTextField txtNomeEleitor;
        private JTextField txtTitulo;
        private JTextField txtSecao;
        String nomeEleitor;
        String titulo;
        String secao;

        public GerenciadorDeBotao(JTextField txtNomeEleitor, JTextField txtTitulo, JTextField txtSecao) {
            this.txtNomeEleitor = txtNomeEleitor;
            this.txtTitulo = txtTitulo;
            this.txtSecao = txtSecao;
        }
        
        

        @Override
        public void actionPerformed(ActionEvent ae) {
           nomeEleitor = txtNomeEleitor.getText();
           titulo = txtTitulo.getText();
           secao = txtSecao.getText();
            ControladorEleitor.getInstancia().cadastrarEleitor(nomeEleitor, "florianopolis", Integer.parseInt(titulo), Integer.parseInt(secao));
        }

    }

}
