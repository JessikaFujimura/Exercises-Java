package Ex6_Threads_SO1.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class RoletaThread extends Thread{
	
	private JTextField roleta;
	private JButton btnJogar;
	
	public RoletaThread(JTextField roleta, JButton btnJogar){
		this.roleta = roleta;
		this.btnJogar = btnJogar;
	}

	@Override
	public void run() {
		girarRoleta();
	}
	
	private void girarRoleta(){
		btnJogar.setEnabled(false);
		Random random = new Random();
		for(int i = 1; i<=150; i++){
			String num =Integer.toString(random.nextInt(7) + 1);
			roleta.setText(num);
			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		btnJogar.setEnabled(true);
	}
	
	

}
