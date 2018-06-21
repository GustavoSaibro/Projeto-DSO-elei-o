package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorCandidato;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaListaCandidato extends JFrame{
    
    private JLabel label;
    private JButton botao1;
    private JTable table;
    private JScrollPane scrollPane;
    private ArrayList candidatos;
    private Candidato candidato;
    private Candidato candidato2;

    
    public TelaListaCandidato(){
        super("Tela de Listagem de Candidatos - UHUUUUUUL");
        
        GerenciadorDeBotao btManager = new GerenciadorDeBotao();
        
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, 1));
        
        label = new JLabel("Candidatos Cadastrados:");
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
        
        botao1 = new JButton("Voltar");
        botao1.setBounds(75, 210, 250, 40);
        botao1.setActionCommand("1");
        
        container.add(label);
        container.add(scrollPane);
        container.add(botao1);
        
        botao1.addActionListener(btManager);
        setSize(400 , 300);
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
                    ControladorCandidato.getInstancia().abrirTelaCandidato();
                    dispose();
                    break;
                default:
                    break;
            }
        }
    }
    
}
