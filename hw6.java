import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//. Create an app that allows the user to
//enter values in four text fields for each of the parameters you need (size, toppings,
//crust style, and coupon code). Display the resulting price. 
public class hw6 extends JFrame implements ActionListener {
	JTextField size = new JTextField("small");
	JLabel sizelabel = new JLabel("size s/m/l");
	JTextField toppings = new JTextField("0");
	JLabel toppingslabel = new JLabel("number of toppings 0-6");
	JTextField crust = new JTextField("thin");
	JLabel crustlabel = new JLabel("Thin/Thick/Deep Dish");
	JTextField discount = new JTextField("code");
	JLabel discountlabel = new JLabel("discountcode");
	JPanel panel = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	JLabel pricelabel = new JLabel();
	int pizzasize = 0;
	int numtoppings = 0;
	int pizzacrust = 0;
	String pizzadiscount = "code";
	double price = price(pizzasize,numtoppings,pizzacrust,pizzadiscount);
	public hw6() {
		size.addActionListener(this);
		toppings.addActionListener(this);
		crust.addActionListener(this);
		discount.addActionListener(this);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(sizelabel,c);
		c.gridx = 100;
		c.gridy = 0;
		panel.add(size,c);
		size.setPreferredSize(new Dimension(150,20));
		c.gridx = 0;
		c.gridy = 100;
		panel.add(toppingslabel,c);
		toppings.setPreferredSize(new Dimension(150,20));
		c.gridx = 100;
		c.gridy = 100;
		panel.add(toppings,c);
		c.gridx = 0;
		c.gridy = 200;
		panel.add(crustlabel,c);
		crust.setPreferredSize(new Dimension(150,20));
		c.gridx = 100;
		c.gridy = 200;
		panel.add(crust,c);
		c.gridx = 0;
		c.gridy = 300;
		panel.add(discountlabel,c);
		discount.setPreferredSize(new Dimension(150,20));
		c.gridx = 100;
		c.gridy = 300;
		panel.add(discount,c);
		c.gridx = 0;
		c.gridy = 400;
		panel.add(pricelabel,c);
		price = price(pizzasize,numtoppings,pizzacrust,pizzadiscount);
		pricelabel.setText(String.format("$%.2f", price));
		panel.setSize(400, 500);
		panel.setVisible(true);
		this.add(panel);
		this.setVisible(true);
		this.setSize(500, 600);
		sizelabel.setSize(200, 100);
		size.setSize(200, 100);
		toppingslabel.setSize(200, 100);
		toppings.setSize(200, 100);
		crustlabel.setSize(200, 100);
		crust.setSize(200, 100);
		discountlabel.setSize(200, 100);
		discount.setSize(200, 100);
	}

	public static double validate(String code) {
		if (code.equals("10off")) {
			return 10;
		} else if (code.equals("holiday")) {
			return 5;
		}
		return 0;
	}

	public static double price(int size, int toppings, int crust, String code) {
		double[] price = new double[3];
		price[0] = 8;
		price[1] = 12;
		price[2] = 16;
		double[] style = new double[3];
		style[0] = 0;
		style[1] = 1;
		style[2] = 2;
		double discount = validate(code);
		double p = price[size] + toppings + style[crust] - discount;
		return p;
	}

	public static void main(String[] args) {
		hw6 mypizza = new hw6();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sizestring = size.getText();
		String toppingsstring = toppings.getText();
		String cruststring = crust.getText();
		pizzadiscount = discount.getText();
		if(sizestring.charAt(0)=='s') {
			pizzasize = 0;
		} else if(sizestring.charAt(0)=='m') {
			pizzasize = 1;
		} else {
			pizzasize=2;
		}
		numtoppings = Integer.parseInt(toppingsstring);
		if(cruststring.equals("thin")) {
			pizzacrust = 0;
		} else if(cruststring.equals("thick")) {
			pizzacrust = 1;
		} else {
			pizzacrust=2;
		}
		price = price(pizzasize,numtoppings,pizzacrust,pizzadiscount);
		pricelabel.setText(String.format("$%.2f", price));
		System.out.print(e);
	}

}