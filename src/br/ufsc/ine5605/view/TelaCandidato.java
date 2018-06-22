package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorCandidato;
import br.ufsc.ine5605.controller.ControladorPrincipal;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaCandidato extends JFrame {
    private JLabel label;
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;
        
        
    public TelaCandidato(){
        super("Tela Candidato - IHUUUL");
        
        GerenciadorDeBotao btManager = new GerenciadorDeBotao();
        
        Container container = getContentPane();
        container.setLayout(null);
        
        label = new JLabel("Opções de Candidato");
        label.setBounds(130, 10, 200, 50);
        
        botao1 = new JButton("Cadastro de Candidato");
        botao1.setBounds(75, 60, 250, 40);
        botao1.addActionListener(btManager);
        
        botao2 = new JButton("Exluir Candidato");
        botao2.setBounds(75, 110, 250, 40);
        
        botao3 = new JButton("Lista de Candidatos");
        botao3.setBounds(75, 160, 250, 40);
        
        botao4 = new JButton("Voltar");
        botao4.setBounds(75, 210, 250, 40);
        
        botao1.setActionCommand("1");
        botao2.setActionCommand("2");
        botao3.setActionCommand("3");
        botao4.setActionCommand("4");
        
        container.add(label);
        container.add(botao1);
        container.add(botao2);
        container.add(botao3);
        container.add(botao4);
        
        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);
        botao3.addActionListener(btManager);
        botao4.addActionListener(btManager);
        
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
                    ControladorCandidato.getInstancia().abrirTelaCadastroCandidato();
                    dispose();
                    break;
                case "2":
                    ControladorCandidato.getInstancia().abrirTelaExcluirCandidato();
                    dispose();
                    break;
                case "3":
                    ControladorCandidato.getInstancia().abrirTelaListaCandidato();
                    dispose();
                    break;
                case "4":
                    ControladorPrincipal.getInstancia().iniciaSistema();
                    break;
                default:
                    break;
            }
        }
    }
}
