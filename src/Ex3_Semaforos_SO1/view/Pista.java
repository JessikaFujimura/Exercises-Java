package Ex3_Semaforos_SO1.view;

import java.util.concurrent.Semaphore;

import Ex3_Semaforos_SO1.controller.ThreadCarro;

public class Pista {

	public static void main(String[] args) {
		String[] escuderia = {"carro1 - Ferrari", "carro1 - mcLaren", "carro1 - Mercedes", "carro1 - Willians" , "carro1 - Alfa Romeo Racing", "carro1 - AlphaTauri","carro1 - Renault F1", "carro2 - Ferrari", "carro2 - mcLaren", "carro2 - Mercedes", "carro2 - Willians" , "carro2 - Alfa Romeo Racing", "carro2 - AlphaTauri", "carro2 - Renault F1"};

		int permissoes = 5;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(String carro: escuderia){
				Thread tCarro = new ThreadCarro(carro, semaforo);
				tCarro.start();
		}
		
	}

}
