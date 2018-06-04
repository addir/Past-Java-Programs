

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class paycheck extends JFrame implements ActionListener {

	JPanel p = new JPanel();
//	JButton b = new JButton("Draw");
	
	public static void main(String[] args) {
		double salary = 50000;
		double biweekly = salary / 26;
		double tax = biweekly * .26;
		double deductions = 681.22;
		double takehomepay = biweekly - tax - deductions;
		String txt = 
				"     takehomepay; " + String.format("$%.2f",takehomepay);			
		paycheck app = new paycheck();
		app.setSize(250, 200);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setTitle("Drawing Like a 3rd Grader");
		JLabel label = new JLabel(txt);
		app.add(label);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVisible(true);
		app.setVisible(true);
	}
	
	paycheck() {
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


		
