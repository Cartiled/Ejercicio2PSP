package ejercicio2Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ejer2Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	private JTextArea textArea2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	public Ejer2Panel(ArrayList<JPanel>panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 717, 546);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(77, 105, 117, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(293, 105, 117, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(505, 105, 117, 20);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String appName = textField.getText();
					ProcessBuilder processBuilder = new ProcessBuilder(appName);
					Process process = processBuilder.start();
					Long pid = process.pid();
					label1.setText(Long.toString(pid));
					Long pidP = ProcessHandle.current().pid();
					label4.setText(Long.toString(pidP));
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,
							"Se ha ocurrido un error.",
							"OK!", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(88, 156, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = "cmd /c " + textField_1.getText();
				Process process;
				try {
					process = Runtime.getRuntime().exec(cmd);
					InputStream is = process.getInputStream();
					InputStreamReader isr = new InputStreamReader(is,"gbk");
					
					BufferedReader br = new BufferedReader(isr);
					String line = br.readLine();
					Long pid = process.pid();
					label2.setText(Long.toString(pid));
					Long pidP = ProcessHandle.current().pid();
					label5.setText(Long.toString(pidP));
					while (line != null) {
						textArea.append(line + "\n");
						line = br.readLine();
					}
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnStart.setBounds(310, 156, 89, 23);
		panel.add(btnStart);
		
		JButton btnStart_1 = new JButton("Start");
		btnStart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String algo = textField_2.getText();
				
				for(int i = 0; i <5; i++) {
					try {
						ProcessBuilder builder = new ProcessBuilder("java", "ejercicio2Panel.EjemploLectura");
						builder.directory(new File("bin"));
						builder.environment().put("ALGO_INPUT", algo);
						Process process = builder.start();
						Long pid = process.pid();
						
						label3.setText(Long.toString(pid));
						
						Long pidP = ProcessHandle.current().pid();
						label6.setText(Long.toString(pidP));
						
						InputStream is = process.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br = new BufferedReader(isr);

						String line = br.readLine();
						while (line != null) {
							textArea2.append("Introduce una cadena....." + "\n");
							textArea2.append(line + "\n");
							line = br.readLine();
							break;
						}
						process.waitFor();
						
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
			
		});
		btnStart_1.setBounds(525, 156, 89, 23);
		panel.add(btnStart_1);
		
		JLabel lblNewLabel = new JLabel("PID");
		lblNewLabel.setBounds(28, 208, 62, 23);
		panel.add(lblNewLabel);
		
		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(28, 242, 62, 23);
		panel.add(lblPidPadre);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(28, 367, 62, 23);
		panel.add(lblResultado);
		
		textArea = new JTextArea();
		JScrollPane scroPane = new JScrollPane(textArea);
		scroPane.setBounds(100, 272, 261, 250);
		textArea.setEditable(false);
		panel.add(scroPane);
		
		textArea2 = new JTextArea();
		JScrollPane scroPane2 = new JScrollPane(textArea2);
		scroPane2.setBounds(371, 272, 261, 250);
		textArea2.setEditable(false);
		panel.add(scroPane2);
		
		label1 = new JLabel("");
		label1.setBounds(131, 212, 63, 14);
		panel.add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(336, 212, 63, 14);
		panel.add(label2);
		
		label3 = new JLabel("");
		label3.setBounds(551, 212, 156, 14);
		panel.add(label3);
		
		label4 = new JLabel("");
		label4.setBounds(131, 246, 63, 14);
		panel.add(label4);
		
		label5 = new JLabel("");
		label5.setBounds(336, 246, 63, 14);
		panel.add(label5);
		
		label6 = new JLabel("");
		label6.setBounds(551, 246, 62, 14);
		panel.add(label6);
		
		
	}
	public JPanel getPanel() {
		return panel;
	}
	
	
}
