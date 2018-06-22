package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorUrna;
import br.ufsc.ine5605.controller.ControladorVotacao;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Cargo;
import br.ufsc.ine5605.model.Cidade;
import br.ufsc.ine5605.model.Voto;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author José Felipe
 */
public class TelaVotacao extends JFrame{
    private JLabel lblNumeroCandidato;
    private JLabel lblNumeroTitulo;
    private JLabel lblSecaoUrna;
    private JTextField txtNumeroCandidato;
    private JTextField txtNumeroTitulo;
    private JTextField txtSecao;
    private JButton btnConfirmar;

    public TelaVotacao() {
        super("Votação");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints bgc = new GridBagConstraints();
        
        lblNumeroCandidato = new JLabel("Numero do candidato: ");
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(lblNumeroCandidato, bgc);
        
        txtNumeroCandidato = new JTextField("Numero");
        bgc.gridx = 1;
        bgc.gridy = 0;
        container.add(txtNumeroCandidato, bgc);
        
        lblNumeroTitulo = new JLabel("Digite o número do título: ");
        bgc.gridx = 0;
        bgc.gridy = 1;
        container.add(lblNumeroTitulo, bgc);
        
        txtNumeroTitulo = new JTextField("Numero");
        bgc.gridx = 1;
        bgc.gridy = 1;
        container.add(txtNumeroTitulo, bgc);
        
        lblSecaoUrna = new JLabel("Digite a Seção da urna: ");
        bgc.gridx = 0;
        bgc.gridy = 2;
        container.add(lblSecaoUrna, bgc);
        
        txtSecao = new JTextField("Numero");
        bgc.gridx = 1;
        bgc.gridy = 2;
        container.add(txtSecao, bgc);
        
        btnConfirmar = new JButton("Votar!");
        bgc.gridx = 0;
        bgc.gridy = 3;
        bgc.gridwidth = 3;
        btnConfirmar.addActionListener(new GerenciadorDeBotao(txtNumeroCandidato, txtNumeroTitulo, txtSecao));
        container.add(btnConfirmar, bgc);
        
        setSize(500, 250);
        setLocationRelativeTo(null);
    }
 
    
    public void opcoesVotacao(){
        setVisible(true);   
    }
    
    
    private void erroOpcoes() {
        System.out.println("Voce digitou um valor não valido!");
        opcoesVotacao();
    }
    
    public void votar(){
        
    }
    
    public void listarVotos(List<Voto> votos){
        
        for (int i = 0; i < votos.size(); i++) {
            System.out.println(votos.get(i).getCandidato().getNomePessoa() + "Numero de votos" + votos.get(i).getCandidato().getNumeroDeVotos());
        }
        
    }
    private void voltar(){}
    
     private class GerenciadorDeBotao implements ActionListener {
        
        private JTextField txtNumeroCandidato;
        private JTextField txtNumeroTitulo;
        private JTextField txtSecao;
        private String numeroCandidato;
        private String numeroTitulo;
        private String secao;
        Cargo cargo = Cargo.GOVERNADOR;
        
        public GerenciadorDeBotao(JTextField txtNumeroCandidato, JTextField txtNumeroTitulo, JTextField txtSecao) {
            this.txtNumeroCandidato = txtNumeroCandidato;
            this.txtNumeroTitulo = txtNumeroTitulo;
            this.txtSecao = txtSecao;
        }        
        @Override
        public void actionPerformed(ActionEvent ae) {            
            numeroCandidato = txtNumeroCandidato.getText();
            numeroTitulo = txtNumeroTitulo.getText();
            secao = txtSecao.getText();
            
            ControladorVotacao.getInstancia().votar(Integer.parseInt(numeroTitulo), Integer.parseInt(numeroCandidato), Integer.parseInt(secao), cargo);
        }

    }
    
    
}
