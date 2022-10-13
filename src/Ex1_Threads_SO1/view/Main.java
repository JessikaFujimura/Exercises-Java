package Ex1_Threads_SO1.view;

import java.util.Random;

import Ex1_Threads_SO1.controller.ThreadVector;

public class Main {
	
	public static void main(String[] args) {
		Random random = new Random();
		int[] vetor = new int[1000];
		int thread1 = 1;
		int thread2 = 2;
		for(int i = 0; i < 1000; i++){
			vetor[i] = random.nextInt(100);
		}
		Thread threadpar = new ThreadVector(thread2, vetor);
		threadpar.start();
		Thread threadimpar = new ThreadVector(thread1, vetor);
		threadimpar.start();

	}

}
