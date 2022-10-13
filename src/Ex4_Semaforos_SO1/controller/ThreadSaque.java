package Ex4_Semaforos_SO1.controller;

import java.util.concurrent.Semaphore;

public class ThreadSaque extends Thread {
	
	private int conta;
	private int saldo;
	private int valor;
	private Semaphore semaforo;
	
	public ThreadSaque(int conta, int saldo, int valor, Semaphore semaforo){
		this.conta = conta;
		this.valor = valor;
		this.saldo = saldo;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			sacar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally {
			semaforo.release();
		}
	}



	private void sacar() {
		int novoSaldo;
		if(valor <= saldo){
			novoSaldo = saldo - valor;
			System.out.println("conta: "+ conta +"\nsaldo: " + saldo + " reais"  + " reais\nvalor sacado: " + valor + " reais" + "\nsaldo atual: " + novoSaldo + " reais\n\n" );
		}else {
			System.out.println("Saldo insuficiente!!!\n");
		}
	}
	
}
