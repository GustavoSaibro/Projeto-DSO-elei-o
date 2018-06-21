package br.ufsc.ine5605.main;

import br.ufsc.ine5605.controller.ControladorPartido;
import br.ufsc.ine5605.controller.ControladorPrincipal;

public class Main {
	public static void main(String[] args) {
            ControladorPartido.getInstancia().cadastrarPartido("PT", 13);
            ControladorPartido.getInstancia().cadastrarPartido("PMDB", 15);
		ControladorPrincipal.getInstancia().iniciaSistema();
		
	}
	

}
