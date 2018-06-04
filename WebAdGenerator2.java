
/*Detect the mouse location and change the background fill color on mouse-over.
 * Detect mouse clicks on the ad and raise the displayed monetary amount by 10% for each click. */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WebAdGenerator2 extends JFrame implements ActionListener, MouseListener {
	// declare and instantiate our objects:
	JPanel panel = new JPanel();
	JButton b = new JButton("Create Ad");
	String[] shipcolors = { "brown", "black", "red", "green", "blue" };
	JComboBox box = new JComboBox(shipcolors);
	String slogan = "Fastest Ships in the World";
	Random ran = new Random();
	int price = (ran.nextInt(100) + 100);
	JTextField txt = new JTextField(slogan);
	Color bg;
	int sign[] = { 1, 1, 1 };

	public WebAdGenerator2() {
		this.add(panel);
		this.setSize(480, 480);
		this.setVisible(true);
		this.addMouseListener(this);
		panel.setSize(480, 480);
		panel.setVisible(true);
		panel.add(b);
		panel.add(box);
		box.addActionListener(this);
		b.addActionListener(this);
		panel.add(txt);
		txt.addActionListener(this);
		bg = this.getBackground();
	}

	public static void main(String[] args) {
		// The main() method is run automatically by the virtual machine
		WebAdGenerator2 frame = new WebAdGenerator2();
	}

	public void paint(Graphics g) {
		// Set up the UI with draw/style statements
		super.paint(g);
		panel.setBackground(bg);
		String ship = (String) box.getSelectedItem();
		g.setColor(panel.getBackground());
		g.setFont(new Font("Caribbean", 0, 12));
		g.drawString(slogan, 150, 400);
		slogan = txt.getText();
		g.setFont(new Font("Caribbean", 0, 18));
		g.setColor(Color.BLACK);
		g.drawString("Pirate Ships n More", 145, 100);
		g.setFont(new Font("Caribbean", 0, 12));
		g.drawString("Limited Time Only", 185, 120);
		g.drawString(slogan, 150, 400);
		g.drawString("Pirate Ships No. 199", 10, 200);
		g.drawString("Price: " + price + " Dollars", 10, 220);
		g.drawString("The Pirate Co", 190, 440);
		g.drawString("www.pirateco.com", 185, 460);
		Color shipsy = new Color(156, 93, 82);
		if (ship.equals("black")) {
			shipsy = Color.BLACK;
		} else if (ship.equals("red")) {
			shipsy = Color.RED;
		} else if (ship.equals("green")) {
			shipsy = Color.GREEN;
		} else if (ship.equals("blue")) {
			shipsy = Color.BLUE;
		}

		g.setColor(shipsy);
		((Graphics2D) g).setStroke(new BasicStroke(5));
		g.fillArc(130, 160, 250, 200, 0, -180);
		g.drawLine(130, 260, 380, 260); // deck
		g.drawLine(200, 260, 200, 200); // left mast
		g.drawLine(250, 260, 250, 160); // center mast
		g.drawLine(300, 260, 300, 200); // right mast
		Polygon polly = new Polygon();
		polly.addPoint(202, 205);
		polly.addPoint(202, 220);
		polly.addPoint(225, 212);
		g.setColor(Color.BLACK);
		g.fillPolygon(polly);
		Polygon rightflag = new Polygon();
		rightflag.addPoint(302, 205);
		rightflag.addPoint(302, 220);
		rightflag.addPoint(325, 212);
		g.setColor(Color.BLACK);
		g.fillPolygon(rightflag);
		Polygon centerflag = new Polygon();
		centerflag.addPoint(252, 165);
		centerflag.addPoint(252, 180);
		centerflag.addPoint(275, 172);
		g.setColor(Color.BLACK);
		g.fillPolygon(centerflag);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// paint when mouse is clicked
		Graphics g = this.getGraphics();
		g.setColor(panel.getBackground());
		g.setFont(new Font("Caribbean", 0, 12));
		g.drawString("Price: " + price + " Dollars", 10, 220);
		g.setColor(Color.BLACK);
		price = (int) (1.1 * (double) price);
		g.drawString("Price: " + price + " Dollars", 10, 220);
		repaint();
	}

	public void paintbackground() {
		bg = panel.getBackground();
		int index = ran.nextInt(3);
		int rgb[] = new int[3];
		rgb[0] = bg.getRed();
		rgb[1] = bg.getGreen();
		rgb[2] = bg.getBlue();
		rgb[index] = (int) ((1 + sign[index] * .1) * (double) (1 + rgb[index]));
		if (rgb[index] > 255) {
			sign[index] *= -1;
			rgb[index] = 255;
		} else if (rgb[index] <= 120) {
			sign[index] *= -1;
			rgb[index] = 120;
		}
		bg = new Color(rgb[0], rgb[1], rgb[2]);
		System.out.println(bg);
		panel.setBackground(bg);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// repaints background as mouse hovers in panel
		paintbackground();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// repaints background as mouse hovers out of panel
		paintbackground();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
