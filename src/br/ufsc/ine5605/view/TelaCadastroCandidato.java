package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.ControladorCandidato;
import br.ufsc.ine5605.controller.ControladorPartido;
import br.ufsc.ine5605.model.Partido;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastroCandidato extends JFrame{
    
    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JButton botao1;
    private JButton botao2;
    private JComboBox comboBox;
    private ArrayList partidos;
    private ArrayList candidatos;
    private JTextField text;
    private Partido partido;

    
    public TelaCadastroCandidato(){
        super("Tela de Cadastro de Candidato - TOPZERAAAA");
        
        GerenciadorDeBotao btManager = new GerenciadorDeBotao();
        
        Container container = getContentPane();
        container.setLayout(null);
        
        label = new JLabel("Selecione o Partido");
        label.setBounds(145, 10, 200, 50);
        
        comboBox = new JComboBox();
        partido = new Partido();
        partidos = new ArrayList();
        partidos = ControladorPartido.getInstancia().getPartidos();
        
        if(partidos.size() == 0){
            comboBox.addItem("Sem Partido");
        }else{ 
            if(partidos.size()==1){
                partido = (Partido)ControladorPartido.getInstancia().getPartidos().get(0);
                comboBox.addItem(partido.getNomePartido());
            }else{
                if(partidos.size()==2){
                    partido = (Partido)ControladorPartido.getInstancia().getPartidos().get(0);
                    comboBox.addItem(partido.getNomePartido());
                    partido = (Partido)ControladorPartido.getInstancia().getPartidos().get(1);
                    comboBox.addItem(partido.getNomePartido());
                }
            }
        }
        
        
        comboBox.setBounds(125, 55, 150, 30);
        
        label2 = new JLabel("Digite o nome do Candidato:");
        label2.setBounds(130, 80, 200, 50);
        
        label3 = new JLabel("Ja existem 2 Candidatos cadastrados");
        label3.setBounds(100, 160, 250, 40);
        label3.setVisible(false);
        
        text = new JTextField();
        text.setBounds(75, 125, 250, 25);
       
        candidatos = new ArrayList();
        candidatos = ControladorCandidato.getInstancia().getCandidatos();        
        
        botao1 = new JButton("Cadastrar");
        botao1.setBounds(75, 160, 250, 40);
        if(candidatos.size() >= 2){
            botao1.setVisible(false);
            label3.setVisible(true);
        }
        
        botao2 = new JButton("Voltar");
        botao2.setBounds(75, 210, 250, 40);
        
        botao1.setActionCommand("1");
        botao2.setActionCommand("2");
        
        container.add(label);
        container.add(botao1);
        container.add(botao2);
        container.add(label2);
        container.add(label3);
        container.add(text);
        container.add(comboBox);
        
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
                    try{
                    ControladorCandidato.getInstancia().cadastrarCandidato(ControladorPartido.getInstancia().getNumeroPartidoByNome(comboBox.getSelectedItem().toString()), text.getText());
                    ControladorCandidato.getInstancia().abrirTelaCandidato();
                    dispose();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
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
