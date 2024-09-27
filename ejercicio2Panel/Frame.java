package ejercicio2Panel;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame = null;
	private ArrayList<JPanel> panels = null;
	
	
	public void initilize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 717, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panels = new ArrayList<JPanel>();
		
		Ejer2Panel ejer2Panel = new Ejer2Panel(panels);
		JPanel panel1 = ejer2Panel.getPanel();
		panel1.setVisible(true);
		panels.add(panel1);
		frame.getContentPane().add(panel1);
		frame.setVisible(true);
		
	}
	

}
