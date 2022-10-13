package Ex4_Semaforos_SO1.controller;

import java.util.concurrent.Semaphore;

public class ThreadDeposito extends Thread {
	
	private int conta;
	private int saldo;
	private int valor;
	private Semaphore semaforo;
	
	public ThreadDeposito(int conta, int saldo, int valor, Semaphore semaforo){
		this.conta = conta;
		this.valor = valor;
		this.saldo = saldo;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			depositar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
	}

	private void depositar() {
		int novoSaldo = saldo + valor;
		System.out.println("conta: "+ conta  + "\nsaldo: " + saldo + " reais"+ "\nvalor depositado: " + valor + " reais" + "\nsaldo atual: " + novoSaldo + " reais\n\n" );
		saldo = novoSaldo;
	}

	
}
