package view;

import Ex4_Threads_SO1.controller.KanguroController;


public class Principal {
	

	public static void main(String[] args) {
		String[] names = {"Maria", "Jo�o", "Jos�", "Tereza", "Carlos"};
		for(int i=0; i<5 ; i++){
			Thread kanguro = new KanguroController(30, names[i]);
			kanguro.start();
		}
	}
	

}
