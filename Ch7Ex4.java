
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
public class Ch7Ex4 extends JFrame implements ActionListener {

	JPanel p = new JPanel();
//	JButton b = new JButton("Draw");
	
	public static void main(String[] args) {
		String size = JOptionPane.showInputDialog("Please enter pizza size");
		String topping = JOptionPane.showInputDialog("Please enter number of toppings");
		String crust = JOptionPane.showInputDialog("Please enter crust style");
		double[] price = new double[3];
		price[0] = 8;
		price[1] = 12;
		price[2] = 16;
		double[] style = new double[3];
		style[0] = 0;
		style[1] = 1;
		style[2] = 2;
		int sizenum = Integer.parseInt(size);
		int toppingnum = Integer.parseInt(topping);
		int crustnum = Integer.parseInt(crust);
		double totalprice = price[sizenum - 1] + toppingnum + style[crustnum - 1];
		String txt = "price equals  " + String.format("$%.2f", totalprice);
			JOptionPane.showMessageDialog(null, txt);
		
					
//		Ch7Ex4 app = new Ch7Ex4();
//		app.setSize(250, 200);
//		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		app.setTitle("Drawing Like a 3rd Grader");
//		app.setVisible(true);
	}
	
	Ch7Ex4() {
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


		
