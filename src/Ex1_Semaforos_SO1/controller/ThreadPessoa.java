package Ex1_Semaforos_SO1.controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	
	private int idPessoa;
	private static int posChegada;
	private Semaphore semaforo;

	public ThreadPessoa(int idPessoa, Semaphore semaforo){
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();
		//--------Inicio da Se��o Cr�tica --------
		try {
			semaforo.acquire();
			pessoaPassouPelaPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		//--------Fim da Se��o Cr�tica --------

	}

	private void pessoaPassouPelaPorta() {
		System.out.println("#" + idPessoa + " chegou na porta");
		int  tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#" + idPessoa + " passou pela na porta");
	}

	private void pessoaAndando() {
		int distancia = 20;
		int velocidade = (int) (Math.random()* 3) + 4 ;
		int distanciaPercorrida = 0;
		int tempo = 1000;
		while(distanciaPercorrida < distancia ){
			distanciaPercorrida += velocidade;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " pessoa j� andou " + distanciaPercorrida + " metros");
		}
		posChegada++;
		System.out.println("#" + idPessoa + " pessoa foi o " + posChegada + "� a chegar");
	}
	
	
}
