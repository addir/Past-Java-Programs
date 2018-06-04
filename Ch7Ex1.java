
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ch7Ex1 extends JFrame implements ActionListener {

	JPanel p = new JPanel();
//	JButton b = new JButton("Draw");
	
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Please enter proposed pizza name");
		if(name.contains("arrg")) {
			JOptionPane.showMessageDialog(null, "Very Piratey!");
		}
		if(name.equals("Parrot")) {
			JOptionPane.showMessageDialog(null, "We don't serve real Parrot meat!");

		}
					
//		Ch7Ex1 app = new Ch7Ex1();
//		app.setSize(250, 200);
//		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		app.setTitle("Drawing Like a 3rd Grader");
//		app.setVisible(true);
	}
	
	Ch7Ex1() {
		this.setLayout(new BorderLayout());
//		b.addActionListener(this);
//		add(p, BorderLayout.CENTER);
//		add(b, BorderLayout.NORTH);	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Graphics g = p.getGraphics();
	}
}


		
