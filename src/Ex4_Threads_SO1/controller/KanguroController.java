package Ex4_Threads_SO1.controller;


import java.util.Random;

public class KanguroController extends Thread {
	
	private int trackLength;
	private String name;
	private static int position;
	
	public KanguroController(int trackLength, String name){
		this.trackLength = trackLength;
		this.name = name;
	}


	@Override
	public void run() {
		race();
	}
	
	private void race(){
		Random distance = new Random();
		int sum = 0; 
		while(sum < trackLength){
			int jump = distance.nextInt(10);
			sum += jump;
			System.out.println(name + " pulou " + jump + " metros \nTotal percorrido: " + sum + " metros\n");
		}
		position++;
		System.out.print(
				"************************************\n" 
				+ position + " posi��o: " + name +
				" chegou!\n" + 
				"************************************\n"
		);
	}


}
