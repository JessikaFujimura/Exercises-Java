package Ex3_Semaforos_SO1.controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	private String idCarro;
	private static int pos = 0;
	private static int[] conjunto = new int[42];
	private Semaphore semaforo;
	
	public ThreadCarro(String idCarro, Semaphore semaforo){
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			volta();
			if(pos==42){
				ranking();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			semaforo.release();
		}

	}

	private void ranking() {
		Arrays.sort(conjunto);
		System.out.println("----------------RANKING----------------");
		for(int t: conjunto){
			System.out.println(t);
		}
	}

	private void volta() {
		for(int i = 1; i <= 3; i++){
			int tempo = (int) (Math.random() *1001) + 1;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			conjunto[pos] = tempo;
			System.out.println(idCarro + " volta n� " + i + " tempo: " +  tempo + " ms");
			pos++;
		}
		
	}

}
