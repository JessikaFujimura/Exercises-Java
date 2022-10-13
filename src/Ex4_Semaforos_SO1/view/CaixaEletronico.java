package Ex4_Semaforos_SO1.view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import Ex4_Semaforos_SO1.controller.ThreadDeposito;
import Ex4_Semaforos_SO1.controller.ThreadSaque;

public class CaixaEletronico {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int permissoes = 2;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i = 0; i < 20; i++){
			int transacao = random.nextInt(2) + 1;
			int conta = random.nextInt(1000)+1;
			int saldo = random.nextInt(1000)+1;
			int valor = random.nextInt(1000)+1;
			
			if(transacao == 1){
				Thread tSaque = new ThreadSaque(conta, saldo, valor, semaforo);
				tSaque.start();
			} else {
				Thread tDeposito = new ThreadDeposito(conta, saldo, valor, semaforo);
				tDeposito.start();
			}
		}

	}

}
