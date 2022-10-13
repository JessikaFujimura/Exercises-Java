package Ex2_Semaforos_SO1.controller;

import java.util.concurrent.Semaphore;

public class ThreadCarrinho extends Thread {
	
	private String sentido;
	private Semaphore semaforo;
	private String destino;

	public ThreadCarrinho(String sentido, Semaphore semaforo){
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		sentidoDestino();
		try {
			semaforo.acquire();
			passandoPeloCruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
	}

	private void passandoPeloCruzamento() {
		System.out.println("Passando pelo cruzamento: \ncarro " + sentido + " indo para " + destino + "\n");
	}

	private void sentidoDestino() {
		switch(sentido){
		case "norte": destino = "sul";break;
		case "sul": destino = "norte";break;
		case "leste": destino = "oeste";break;
		case "oeste": destino = "leste";break;	
		}
		
	}
}
