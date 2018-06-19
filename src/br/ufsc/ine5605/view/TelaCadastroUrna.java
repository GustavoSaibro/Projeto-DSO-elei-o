/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorPrincipal;
import br.ufsc.ine5605.controller.ControladorUrna;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class TelaCadastroUrna extends JFrame {
    JLabel lblPrincipal;
    JLabel lblNomeCidade;
    JLabel lblNomeSecao;
    JTextField txtSecao;
    JButton btnConfirmar;
   
    private final static boolean shouldFill = true;
    private final static boolean shouldWeightX = true;
    private final static boolean RIGHT_TO_LEFT = false;

    public TelaCadastroUrna() {
        super("Cadastro de urna");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints bgc = new GridBagConstraints();
        
        lblPrincipal = new JLabel("Cidade: ");
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(lblPrincipal, bgc);
        
        lblNomeCidade = new JLabel("Florianópolis");
        bgc.gridx = 1;
        bgc.gridy = 0;
        container.add(lblNomeCidade, bgc);
        
        lblNomeSecao = new JLabel("Seção: ");
        bgc.gridx = 0;
        bgc.gridy = 1;
        container.add(lblNomeSecao, bgc);
        
        txtSecao = new JTextField("Digite a seção aqui");
        bgc.gridx = 1;
        bgc.gridy = 1;
        container.add(txtSecao, bgc);
        
        btnConfirmar = new JButton("Cadastrar");
        bgc.gridx = 0;
        bgc.gridy = 2;
        bgc.gridwidth = 2;
        btnConfirmar.addActionListener(new GerenciadorDeBotao(btnConfirmar, txtSecao));
        container.add(btnConfirmar, bgc);
        
        setSize(500, 250);
        setLocationRelativeTo(null);
    }
    
    
    
    public void iniciarTelaCadastro() {
        setVisible(true);
    }
    
    private class GerenciadorDeBotao implements ActionListener {
        
        JTextField txtSecao;
        JButton btnConfirmar;
        String secao;
        
        public GerenciadorDeBotao(JButton btnConfirmar, JTextField txtSecao) {
            this.btnConfirmar = btnConfirmar;
            this.txtSecao = txtSecao;
        }        
        @Override
        public void actionPerformed(ActionEvent ae) {            
            int sec = Integer.parseInt(txtSecao.getText());
            ControladorUrna.getInstancia().cadastrarUrna(sec, "Florianopolis");
        }

    }
    
}
