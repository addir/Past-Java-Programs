import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Create an app that draws a realistic web advertisement for a fake company/service of your choice.
 * This can be done with: polygons, rectangles, lines, text, fonts, filled shapes, and colors.
 * Your WebAd should be 480 px wide by 480 px tall, and include both text (company slogan or name AND a random price)
 * as well as a simple graphic (using draw and fill statements). Create a custom JPanel that draws your ad.
 * You MUST have at least 20 total draw/fill statements.*/

public class WebAd extends JFrame implements ActionListener {
	// declare and instantiate our objects:
	JPanel panel = new JPanel();
	JButton b = new JButton("Create Ad");
	BigDecimal price;
	public WebAd(BigDecimal price) {
		this.add(panel);
		this.setSize(480, 480);
		this.setVisible(true);
		panel.setSize(480, 480);
		panel.setVisible(true);
		panel.add(b);
		b.addActionListener(this);
		this.price = price;
	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// set up the UI with draw / style statements
		Graphics g = this.getGraphics();
		g.setFont(new Font("Caribbean", 0, 18));
		g.setColor(Color.BLACK);
		g.drawString("Pirate Ships n More", 145, 100);
		g.setFont(new Font("Caribbean", 0, 12));
		g.drawString("Limited Time Only", 185, 120);
		final NumberFormat scaleformat = NumberFormat.getInstance();
		scaleformat.setMaximumFractionDigits(2);
		String s = scaleformat.format(price);
		g.drawString("Pirate Ships No. 199", 10, 200);
		g.drawString("Price:   "+s+" dollars", 10, 220);
		g.drawString("Fastest Ships in the World", 150, 400);
		g.drawString("The Pirate Co", 190, 440);
		g.drawString("www.pirateco.com", 185, 460);
		g.setColor(new Color(156, 93, 82));
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

}
