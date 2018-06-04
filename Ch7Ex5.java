/*Use your String processing skills to create an app that will prompt the user for a number via a dialog box and then 
 * display it as money. Include a currency symbol and display the amount rounded and with the correct number of decimals 
 * in a message dialog*/

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
public class Ch7Ex5 extends JFrame implements ActionListener {

	JPanel p = new JPanel();
//	JButton b = new JButton("Draw");
	
	public static void main(String[] args) {
		String number = JOptionPane.showInputDialog("Please enter a number");
		double num = Double.parseDouble(number);
		
		
		String txt = "num equals  " + String.format("$%.2f", num);
			JOptionPane.showMessageDialog(null, txt);
		
					
//		Ch7Ex5 app = new Ch7Ex5();
//		app.setSize(250, 200);
//		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		app.setTitle("Drawing Like a 3rd Grader");
//		app.setVisible(true);
	}
	
	Ch7Ex5() {
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


		
