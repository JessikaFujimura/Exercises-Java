package Ex1_Processos_SO1.view;

import Ex1_Processos_SO1.controller.RedesController;

public class Main {

	public static void main(String[] args) {
		String name = System.getProperty("os.name");
			
		RedesController test = new RedesController();
		String resultPing = test.ping(name);
		String resultIP = test.ip(name);
		System.out.println(resultPing);
		System.out.println(resultIP);
	}

}
