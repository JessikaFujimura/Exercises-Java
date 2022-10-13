package Ex2_Processos_SO1.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController(){
		super();
	}
	
	public String typeSystem(){
		String name = System.getProperty("os.name");
		return name;
	}
	
	public void listActiveProcess(String name){
		String process ="";
		if(name.contains("Windows 10")){
			process = "TASKLIST /FO TABLE";
		}
		if(name.contains("Linux")){
			process = "ps -ef";
		}
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			while(line != null){
				System.out.println(line);
				line = buffer.readLine();
			}
			buffer.close();
			reader.close();
			flow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void killProcess(String name ,String param){
		String pidProcess = "";
		String nameProcess = "";
		if(name.contains("Windows 10")){
			pidProcess = "TASKKILL /PID";
			nameProcess = "TASKKILL /IM";
		}
		if(name.contains("Linux")){
			pidProcess = "kill ";
			nameProcess = "pkill ";
		}
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid = Integer.parseInt(param);
			buffer.append(pidProcess);
			buffer.append(" ");
			buffer.append(pid);
		} catch (NumberFormatException e){
			buffer.append(nameProcess);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString());
	}
	
	
	private void callProcess(String process){
			try{
				Runtime.getRuntime().exec(process);
			}
			catch (Exception e) {
				String msgErr = e.getMessage();
				System.err.println(msgErr);
			}
		}
	
}
