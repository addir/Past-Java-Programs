import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*Create a new app using a button and a text area to provide an order summary report.
 * When the user presses the button 'Load Report', generate a list of items between 1-15.
 * Use a loop to list each item in the text area and give it a random stock # and price.
 * Underneath the item list, summarize the order by displaying the total amount, average, lowest & highest price.
 * Make sure all monetary amounts are displayed as properly rounded money.
 * Make your app window large enough to hold 15 items and the summary data, but not much larger.*/

public class OrderSummary extends JFrame implements ActionListener {
	// declare and instantiate our objects:
	JPanel cpanel = new JPanel();
	JButton b = new JButton("Load Report");
	JTextArea txt = new JTextArea("");
	Random r = new Random();

	// set up the UI
	public OrderSummary() {
		this.add(cpanel, BorderLayout.SOUTH);
		this.setSize(480, 480);
		this.setVisible(true);
		cpanel.setVisible(true);
		this.add(txt, BorderLayout.NORTH);
		cpanel.add(b);
		txt.setColumns(350);
		txt.setLineWrap(true);
		txt.setWrapStyleWord(true);
		txt.setVisible(true);
		b.addActionListener(this);
		b.setLocation(150, 375);
		b.setPreferredSize(new Dimension(350, 50));
		this.repaint();
	}

	public static void main(String[] args) {
		// The main method is run automatically by the virtual machine
		OrderSummary odr = new OrderSummary();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// the event handlers
		StringBuilder sb = new StringBuilder();
		sb.append("item\t\tprice\n");
		sb.append("---------------------------------------------\n");
		double total = 0;
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		int num = 15;
		for (int i = 0; i < num; i++) {
			sb.append(i);
			sb.append(". Stock Number ");
			sb.append(r.nextInt(100) + 100);
			sb.append("\t$");
			double price = (double) r.nextInt(10000) / 100;
			String p = String.format("%-10.2f", price);
			sb.append(p);
			sb.append("\n");
			total += price;
			if (min > price) {
				min = price;
			}
			if (max < price) {
				max = price;
			}
		}
		sb.append("---------------------------------------------\n");
		String p = String.format("%-10.2f", total);
		sb.append("Order Total: $" + p + "\n");
		p = String.format("%-10.2f", (total / num));
		sb.append("Average Price: $" + p + "\n");
		p = String.format("%-10.2f", max);
		sb.append("Highest Price: $" + p + "\n");
		p = String.format("%-10.2f", min);
		sb.append("Lowest Price: $" + p + "\n");
		txt.setText(sb.toString());
		this.repaint();
	}

}
