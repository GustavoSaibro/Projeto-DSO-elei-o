/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.view;

import br.ufsc.ine5605.controller.UrnaController;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class TelaUrna {
    
    private Scanner teclado;
    private UrnaController urnaController;

    public TelaUrna() {
        teclado = new Scanner(System.in);
    }

    public TelaUrna(UrnaController urnaController) {
        teclado = new Scanner(System.in);
        this.urnaController = urnaController;
    }
    
    public void opcoesUrna(){}
    public void cadastrarUrna(){}
    public void excluirUrna(){}
    public void listarUrnas(){}
    
}
