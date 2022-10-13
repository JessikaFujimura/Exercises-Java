package Ex3_Threads_SO1.controller;

public class SomaController extends Thread {
	
	private int[] num;
	private int pos;
	
	public SomaController(int[] num, int pos){
		this.num = num;
		this.pos = pos + 1 ;
	}

	@Override
	public void run() {
		int soma = 0;
		for(int pos : num ){
			soma += pos;
		}
		System.out.println("A soma da " + pos + "� linha = " + soma);
	}
	
	
}
