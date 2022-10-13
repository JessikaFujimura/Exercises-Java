package Ex6_Threads_SO1.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ex6_Threads_SO1.controller.RoletaThread;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Roleta extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField roleta2;
	private JTextField roleta1;
	private JTextField roleta3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roleta frame = new Roleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Roleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField roleta2 = new JTextField();
		roleta2.setEditable(false);
		roleta2.setHorizontalAlignment(SwingConstants.CENTER);
		roleta2.setFont(new Font("Tahoma", Font.BOLD, 20));
		roleta2.setText("1");
		roleta2.setBounds(190, 86, 52, 48);
		contentPane.add(roleta2);
		roleta2.setColumns(10);
		
		JTextField roleta1 = new JTextField();
		roleta1.setEditable(false);
		roleta1.setText("1");
		roleta1.setHorizontalAlignment(SwingConstants.CENTER);
		roleta1.setFont(new Font("Tahoma", Font.BOLD, 20));
		roleta1.setColumns(10);
		roleta1.setBounds(116, 86, 52, 48);
		contentPane.add(roleta1);
		
		JTextField roleta3 = new JTextField();
		roleta3.setEditable(false);
		roleta3.setText("1");
		roleta3.setHorizontalAlignment(SwingConstants.CENTER);
		roleta3.setFont(new Font("Tahoma", Font.BOLD, 20));
		roleta3.setColumns(10);
		roleta3.setBounds(265, 86, 52, 48);
		contentPane.add(roleta3);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setForeground(Color.BLUE);
		btnJogar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Thread thread1 = new RoletaThread(roleta1, btnJogar);
				Thread thread2 = new RoletaThread(roleta2, btnJogar);
				Thread thread3 = new RoletaThread(roleta3, btnJogar);
				thread1.start();
				thread2.start();
				thread3.start();
			}
		});
		btnJogar.setBounds(170, 185, 100, 31);
		contentPane.add(btnJogar);
	}
}
