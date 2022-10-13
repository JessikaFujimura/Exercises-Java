package Ex1_Semaforos_SO1.view;

import java.util.concurrent.Semaphore;

import Ex1_Semaforos_SO1.controller.ThreadPessoa;

public class Corredor {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPessoa = 0; idPessoa < 4 ; idPessoa++){
			Thread tPessoa = new ThreadPessoa(idPessoa, semaforo);
			tPessoa.start();
		}
	}

}
