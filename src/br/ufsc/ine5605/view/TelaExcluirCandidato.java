package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorCandidato;
import br.ufsc.ine5605.controller.ControladorPrincipal;
import br.ufsc.ine5605.model.Candidato;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaExcluirCandidato extends JFrame{
    
    private JLabel label;
    private JButton botao1;
    private JButton botao2;
    private JTextField text;
    private JTable table;
    private JScrollPane scrollPane;
    private ArrayList candidatos;
    private Candidato candidato;
    private Candidato candidato2;
    
    public TelaExcluirCandidato(){
        super("Tela de Exclusão de Candidato - MASSAAAAAA");
        
        GerenciadorDeBotao btManager = new GerenciadorDeBotao();
        
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, 1));
        
        label = new JLabel("Digite o numero do Candidato para ser excluido");
        label.setBounds(80, 10, 300, 50);
        
        candidatos = new ArrayList();
        candidatos = ControladorCandidato.getInstancia().getCandidatos();
        candidato = new Candidato();
        candidato2 = new Candidato();
        String[] colunas = {"Numero", "Nome do Candidato"};
        
        if(candidatos.size() == 0){
            Object[][] dados = {
            {new Integer(0), "Sem Candidato"},
            {new Integer(0), "Sem Candidato"}
            };
            table = new JTable(dados, colunas);
        }else{ 
            if(candidatos.size()==1){
                candidato = (Candidato)candidatos.get(0);
                Object[][] dados = {
                {new Integer(candidato.getNumeroCandidato()), candidato.getNomePessoa()},
                {new Integer(0), "Sem Segundo Candidato"}
                };
                table = new JTable(dados, colunas);
            }else{
                if(candidatos.size()>=2){
                    candidato = (Candidato)candidatos.get(0);
                    candidato2 = (Candidato)candidatos.get(1);
                    Object[][] dados = {
                    {new Integer(candidato.getNumeroCandidato()), candidato.getNomePessoa()},
                    {new Integer(candidato2.getNumeroCandidato()), candidato2.getNomePessoa()}
                    };
                    table = new JTable(dados, colunas);
                }
            }
        } 
        
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(250,40));
        
        scrollPane = new JScrollPane(table);
        text = new JTextField();
        text.setBounds(75, 110, 250, 40);
        botao1 = new JButton("Excluir");
        botao1.setBounds(75, 160, 250, 40);
        
        botao2 = new JButton("Voltar");
        botao2.setBounds(75, 210, 250, 40);
        
        botao1.setActionCommand("1");
        botao2.setActionCommand("2");
        
        container.add(label);
        container.add(scrollPane);
        container.add(text);
        container.add(botao1);
        container.add(botao2);
        //container.add(text);
        
        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);
        
        setSize(400 , 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private class GerenciadorDeBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String opcao = ae.getActionCommand();
            
            switch (opcao) {
                case "1":
                    ControladorCandidato.getInstancia().excluirCandidato(Integer.parseInt(text.getText()));
                    ControladorCandidato.getInstancia().abrirTelaCandidato();
                    dispose();
                    break;
                case "2":
                    ControladorCandidato.getInstancia().abrirTelaCandidato();
                    dispose();
                    break;
                default:
                    break;
            }
        }
    }
    
    
    
}
