package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorCandidato;
import br.ufsc.ine5605.controller.ControladorEleitor;
import br.ufsc.ine5605.controller.ControladorUrna;
import br.ufsc.ine5605.model.Candidato;
import br.ufsc.ine5605.model.Eleitor;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaListaEleitor extends JFrame{
    private JLabel label;
    private JButton botao1;
    private JTextField txtTitulo;
    private JTable table;
    private JScrollPane scrollPane;
    private ArrayList eleitores;
    private Eleitor eleitor;

    
    public TelaListaEleitor(){
        super("Listagem de eleitor");
                
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints bgc = new GridBagConstraints();
        
        
        
        table = new JTable(ControladorEleitor.getInstancia().getEleitor().size(), 3);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(250,40));
        String[] colunas = {"Nome", "Cidade", "Seção", "Titulo"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        for (int i = 0; i < ControladorEleitor.getInstancia().getEleitor().size(); i++) {
            modelo.addRow(new String[]{ControladorEleitor.getInstancia().getEleitor().get(i).getNomePessoa(), "Florianopolis",
                Integer.toString(ControladorEleitor.getInstancia().getEleitor().get(i).getSecao()), Integer.toString(ControladorEleitor.getInstancia().getEleitor().get(i).getTituloEleitor())});
        }
        table.setModel(modelo);
        scrollPane = new JScrollPane(table);   
        bgc.gridx = 0;
        bgc.gridy = 0;
        container.add(scrollPane, bgc);
        
        label = new JLabel("Digite o título do eleitor que deseja excluir");
        bgc.gridx = 0;
        bgc.gridy = 1;
        bgc.gridwidth = 3;
        container.add(label, bgc);
        
        txtTitulo = new JTextField("Digite o título");
        bgc.gridx = 1;
        bgc.gridy = 1;
        bgc.gridwidth = 1;
        container.add(txtTitulo, bgc);
        
        botao1 = new JButton("Excluir");
        bgc.gridx = 2;
        bgc.gridy = 1;
        botao1.addActionListener(new GerenciadorDeBotao(txtTitulo));
        container.add(botao1);
        
        setSize(600 , 200);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void iniciarTelaListaEleitor(){
        setVisible(true);
    }
    
    private class GerenciadorDeBotao implements ActionListener {
        private JTextField txtTitulo;
        private String titulo;

        public GerenciadorDeBotao(JTextField txtTitulo) {
            this.txtTitulo = txtTitulo;
        }
        
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            titulo = txtTitulo.getText();
            ControladorEleitor.getInstancia().excluirEleitorByTitulo(Integer.parseInt(titulo));
            
        }
    }
    
}
