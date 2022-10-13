package Ex2_Processos_SO1.view;

import Ex2_Processos_SO1.controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController test = new KillController();
		
		String systemName = test.typeSystem();
		test.listActiveProcess(systemName);
		
//		String param = "1939";
		String param = "gnome-mines";
		test.killProcess(systemName, param);

	}

}
