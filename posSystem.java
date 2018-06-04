import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// Team 7 - Veronica Fabiano, Sumner Gravely, Addison Rodriguez, Ashley Hawkins, and Junyi Zhu

public class posSystem extends JFrame {

	// Declare the buttons:
	JButton createOrder = new JButton("Create Order");
	JButton removeItem = new JButton("Remove Item");
	JButton mgrOverride = new JButton("Manager Override");
	JButton genReceipt = new JButton("Generate Receipt");
	JButton DeleteItem = new JButton("Remove Item");
	JButton clearOrder = new JButton("Clear Order");
	JButton applySupport = new JButton("Apply Discounts");

	// Declare JPanels:
	JPanel invPanel = new JPanel();
	JPanel tablePanel = new JPanel();
	JPanel totalsPanel = new JPanel();
	JPanel supportPanel = new JPanel();
	JPanel paymentPanel = new JPanel();


	// Declare JLabels:
	JLabel invLbl = new JLabel("Inventory");
	JLabel totalItemsLbl = new JLabel();
	JLabel totalPriceLbl = new JLabel();
	JLabel totalItemsNumLbl = new JLabel();
	JLabel totalPriceNumLbl = new JLabel();
	JLabel supportLbl = new JLabel("Support");
	JLabel couponCodeLbl = new JLabel("Coupon Code:");
	JLabel employeeDiscountLbl = new JLabel("Employee Discount:");
	JLabel paymentLbl = new JLabel("Payment");
	JLabel pmtTypeLbl = new JLabel("Payment Type:");
	JLabel orderSummaryLbl = new JLabel("Order Summary");
	JLabel itemNameLbl = new JLabel("Item Name");
	JLabel itemNumLbl = new JLabel("Item Number");
	JLabel quantityLbl = new JLabel("Quantity");
	JLabel priceLbl = new JLabel("Price");
	JLabel itemName1Lbl = new JLabel("Skull With Swords");
	JLabel itemName2Lbl = new JLabel("Classic Skull Head");
	JLabel itemName3Lbl = new JLabel("Decorated Skull Head");
	JLabel itemName4Lbl = new JLabel("Triple Skull Head");
	JLabel itemName5Lbl = new JLabel("Side View Skull Head");
	JLabel itemName6Lbl = new JLabel("Zoomed In Skull Head");
	JLabel price1Lbl = new JLabel("Price: $15");
	JLabel price2Lbl = new JLabel("Price: $20");
	JLabel price3Lbl = new JLabel("Price: $22");
	JLabel price4Lbl = new JLabel("Price: $17");
	JLabel price5Lbl = new JLabel("Price: $11");
	JLabel price6Lbl = new JLabel("Price: $10");
	JLabel qty1Lbl = new JLabel("Qty:");
	JLabel qty2Lbl = new JLabel("Qty:");
	JLabel qty3Lbl = new JLabel("Qty:");
	JLabel qty4Lbl = new JLabel("Qty:");
	JLabel qty5Lbl = new JLabel("Qty:");
	JLabel qty6Lbl = new JLabel("Qty:");

	// Declare TFs:
	JTextField couponCodeTf = new JTextField(20);
	JTextField employeeDiscountTf = new JTextField(20);
	JTextField item1Tf = new JTextField(3);
	JTextField item2Tf = new JTextField(3);
	JTextField item3Tf = new JTextField(3);
	JTextField item4Tf = new JTextField(3);
	JTextField item5Tf = new JTextField(3);
	JTextField item6Tf = new JTextField(3);

	// Declare RadioButtons
	JRadioButton cashBtn = new JRadioButton("Cash");
	JRadioButton creditBtn = new JRadioButton("Credit");
	JRadioButton checkBtn = new JRadioButton("Check");

	// JTable
	DefaultTableModel model = new DefaultTableModel(1, 4); // rows, columns
	JTable table = new JTable(model);
	JScrollPane sp = new JScrollPane(table);

	// remove after class implemented
	String s;
	Double dTotal;
	int i;

	// Declare font variables:
	Font regText = new Font("Bangla Sangam MN", 0, 16);
	Font subHeadText = new Font("Kohinoor Bangla", 0, 24);
	Font headText = new Font("Herculanum", 1, 40);
	Font btnText = new Font("Bangla Sangam MN", 1, 20);

	// Declare background color variables:
	Color backColor1 = new Color(223, 223, 223, 150);
	Color backColor2 = new Color(71, 71, 71, 255);
	Color backColor3 = new Color(2, 46, 91, 216);
	Color btnColor = new Color(197, 197, 197, 219);
	Color headColor = new Color(0, 0, 113, 255);

	// Declare other variables:
	int item1Qty, item2Qty, item3Qty, item4Qty, item5Qty, item6Qty;
	double totalPrice;
	BigDecimal totalPriceBD;

	// Declare business variables
	ArrayList<ItemList> cart = new ArrayList<ItemList>();
	ItemList ad;
	NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
	Random r = new Random(); 

	public static void main(String[] args) {

		// create the app:
		posSystem app = new posSystem();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setSize(1500, 890);
		app.setVisible(true);
		app.setTitle("POS System");

	}

	posSystem() {

		// set the size and location for the JPanels
		this.setLayout(new BorderLayout());

		invPanel.setBounds(0, 0, 567, 890);
		invPanel.setLayout(null);
		invPanel.setBackground(backColor3);
		invPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		tablePanel.setBounds(567, 0, 933, 371);
		tablePanel.setLayout(null);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));

		totalsPanel.setBounds(567, 371, 933, 80);
		totalsPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
		totalsPanel.setLayout(null);
		totalsPanel.setBackground(Color.WHITE);

		supportPanel.setBounds(567, 451, 449, 582);
		supportPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
		supportPanel.setLayout(null);
		supportPanel.setBackground(Color.WHITE);

		paymentPanel.setBounds(1033, 451, 449, 582);
		paymentPanel.setLayout(null);
		paymentPanel.setBackground(Color.WHITE);

		// set the parameters for the invPanel labels
		invLbl.setForeground(Color.WHITE);
		invLbl.setFont(headText);
		invLbl.setBounds(180, 10, 250, 35);

		// Item 1
		itemName1Lbl.setForeground(Color.WHITE);
		itemName1Lbl.setFont(regText);
		itemName1Lbl.setBounds(85, 80, 200, 25);
		price1Lbl.setForeground(Color.WHITE);
		price1Lbl.setFont(regText);
		price1Lbl.setBounds(150, 250, 80, 25);
		qty1Lbl.setForeground(Color.WHITE);
		qty1Lbl.setFont(regText);
		qty1Lbl.setBounds(70, 250, 50, 25);
		item1Tf.setFont(regText);
		item1Tf.setBounds(110, 250, 35, 25);

		// Item 2
		itemName2Lbl.setForeground(Color.WHITE);
		itemName2Lbl.setFont(regText);
		itemName2Lbl.setBounds(335, 80, 200, 25);
		price2Lbl.setForeground(Color.WHITE);
		price2Lbl.setFont(regText);
		price2Lbl.setBounds(410, 250, 80, 25);
		qty2Lbl.setForeground(Color.WHITE);
		qty2Lbl.setFont(regText);
		qty2Lbl.setBounds(330, 250, 50, 25);
		item2Tf.setFont(regText);
		item2Tf.setBounds(370, 250, 35, 25);

		// Item 3
		itemName3Lbl.setForeground(Color.WHITE);
		itemName3Lbl.setFont(regText);
		itemName3Lbl.setBounds(65, 345, 200, 25);
		price3Lbl.setForeground(Color.WHITE);
		price3Lbl.setFont(regText);
		price3Lbl.setBounds(150, 505, 80, 25);
		qty3Lbl.setForeground(Color.WHITE);
		qty3Lbl.setFont(regText);
		qty3Lbl.setBounds(70, 505, 50, 25);
		item3Tf.setFont(regText);
		item3Tf.setBounds(110, 505, 35, 25);

		// Item 4
		itemName4Lbl.setForeground(Color.WHITE);
		itemName4Lbl.setFont(regText);
		itemName4Lbl.setBounds(340, 345, 200, 25);
		price4Lbl.setForeground(Color.WHITE);
		price4Lbl.setFont(regText);
		price4Lbl.setBounds(410, 505, 80, 25);
		qty4Lbl.setForeground(Color.WHITE);
		qty4Lbl.setFont(regText);
		qty4Lbl.setBounds(330, 505, 50, 25);
		item4Tf.setFont(regText);
		item4Tf.setBounds(370, 505, 35, 25);

		// Item 5
		itemName5Lbl.setForeground(Color.WHITE);
		itemName5Lbl.setFont(regText);
		itemName5Lbl.setBounds(60, 600, 200, 25);
		price5Lbl.setForeground(Color.WHITE);
		price5Lbl.setFont(regText);
		price5Lbl.setBounds(150, 760, 80, 25);
		qty5Lbl.setForeground(Color.WHITE);
		qty5Lbl.setFont(regText);
		qty5Lbl.setBounds(70, 760, 50, 25);
		item5Tf.setFont(regText);
		item5Tf.setBounds(110, 760, 35, 25);

		// Item 6
		itemName6Lbl.setForeground(Color.WHITE);
		itemName6Lbl.setFont(regText);
		itemName6Lbl.setBounds(310, 600, 200, 25);
		price6Lbl.setForeground(Color.WHITE);
		price6Lbl.setFont(regText);
		price6Lbl.setBounds(410, 760, 80, 25);
		qty6Lbl.setForeground(Color.WHITE);
		qty6Lbl.setFont(regText);
		qty6Lbl.setBounds(330, 760, 50, 25);
		item6Tf.setFont(regText);
		item6Tf.setBounds(370, 760, 35, 25);

		// images
		invPanel.add(AddImage("src/pic/Flag1.png", 50, 115, 200, 120));
		invPanel.add(AddImage("src/pic/Flag2.jpg", 305, 115, 200, 120));
		invPanel.add(AddImage("src/pic/Flag3.jpg", 50, 380, 200, 120));
		invPanel.add(AddImage("src/pic/Flag4.png", 305, 380, 200, 120));
		invPanel.add(AddImage("src/pic/Flag5.png", 40, 630, 200, 120));
		invPanel.add(AddImage("src/pic/Flag6.jpg", 295, 630, 200, 120));

		createOrder.setOpaque(true);
		createOrder.setContentAreaFilled(true);
		createOrder.setBorderPainted(false);
		createOrder.setBackground(btnColor);
		createOrder.setFont(btnText);
		createOrder.setBounds(3, 820, 560, 50);

		// create order button action listener
		createOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// clear the table
				model.setRowCount(0);
				totalPrice = 0;
				

				// add orders to the JTable
				try {

					String ItemNameList[] = { "Skull With Swords", "Classic Skull Head", "Decorated Skull Head",
							"Triple Skull Heads", "Side View Skull Head", "Zoomed In Skull Head" };
					Double ItemPriceList[] = { 15.99, 20.95, 22.45, 17.65, 11.88, 10.32 };
					double item1Price = 0;
					double item2Price = 0;
					double item3Price = 0;
					double item4Price = 0;
					double item5Price = 0;
					double item6Price = 0;
					ItemList IL = new ItemList();
					
				for (int t = 1; t <= 1 ; t++) {
					
					
					if (item1Tf.getText().equals("")) {
						item1Qty = 0;
					} else {
						item1Qty = Integer.parseInt(item1Tf.getText());
						item1Price = ItemPriceList[0] * item1Qty;
					
						for (int i = 1; i <= item1Qty; i++) { 
							
							IL.ItemName = ItemNameList[0];
							IL.ItemNumber = 1000 + r.nextInt(1999);
							IL.Quantity = 1;
							IL.Price = new BigDecimal("15.99", MathContext.DECIMAL32);
							String s = IL.toString();
							String[] s2 = IL.getRow();
							model.addRow(s2);

						}
					}
					if (item2Tf.getText().equals("")) {
						item2Qty = 0;
					} else {
						item2Qty = Integer.parseInt(item2Tf.getText());
						item2Price = ItemPriceList[1] * item2Qty;
						for (int i = 1; i <= item2Qty; i++) {
							
							IL.ItemName = ItemNameList[1];
							IL.ItemNumber = 2000 + r.nextInt(2999);
							IL.Quantity = 1;
							IL.Price = new BigDecimal("20.95", MathContext.DECIMAL32);
							String s = IL.toString();
							String[] s2 = IL.getRow();
							model.addRow(s2);
							
						}
					}
					if (item3Tf.getText().equals("")) {
						item3Qty = 0;
					} else {
						
						item3Qty = Integer.parseInt(item3Tf.getText());
						item3Price = ItemPriceList[2] * item3Qty;
						
						for (int i = 1; i <= item3Qty; i++) {
				
							IL.ItemName = ItemNameList[2];
							IL.ItemNumber = 3000 + r.nextInt(3999);
							IL.Quantity = 1;
							IL.Price = new BigDecimal("22.45", MathContext.DECIMAL32);
							String s = IL.toString();
							String[] s2 = IL.getRow();
							model.addRow(s2);
							
						}
					}
					if (item4Tf.getText().equals("")) {
						item4Qty = 0;
					} else {
						item4Qty = Integer.parseInt(item4Tf.getText());
						item4Price = ItemPriceList[3] * item4Qty;
						
						for (int i = 1; i <= item4Qty; i++) {
							
							IL.ItemName = ItemNameList[3];
							IL.ItemNumber = 4000 + r.nextInt(4999);
							IL.Quantity = 1;
							IL.Price = new BigDecimal("17.65", MathContext.DECIMAL32);
							String s = IL.toString();
							String[] s2 = IL.getRow();
							model.addRow(s2);
							
							
						}
					}
					if (item5Tf.getText().equals("")) {
						item5Qty = 0;
					} else {
						item5Qty = Integer.parseInt(item5Tf.getText());
						item5Price = ItemPriceList[4] * item5Qty;
						for (int i = 1; i <= item5Qty; i++) {
							
							IL.ItemName = ItemNameList[4];
							IL.ItemNumber = 5000 + r.nextInt(5999);
							IL.Quantity = 1;
							IL.Price = new BigDecimal("11.88", MathContext.DECIMAL32);
							String s = IL.toString();
							String[] s2 = IL.getRow();
							model.addRow(s2);
							
						}
					}
					if (item6Tf.getText().equals("")) {
						item6Qty = 0;
					} else {
						item6Qty = Integer.parseInt(item6Tf.getText());
						item6Price = ItemPriceList[5] * item6Qty;
						for (int i = 1; i <= item6Qty; i++) {
							
							IL.ItemName = ItemNameList[5];
							IL.ItemNumber = 6000 + r.nextInt(6999);
							IL.Quantity = 1;
							IL.Price = new BigDecimal("10.32", MathContext.DECIMAL32);
							String s = IL.toString();
							String[] s2 = IL.getRow();
							model.addRow(s2);
		
	
						}
					}
				}
					// calculate total price: 
					totalPrice = item1Price + item2Price + item3Price + item4Price + item5Price + item6Price;
					totalPriceBD = new BigDecimal(String.valueOf(totalPrice), MathContext.DECIMAL32);
					totalPriceNumLbl.setText(nf.format(totalPriceBD));
			
					}
				 catch (NumberFormatException g) {
					System.out.println("Wrong");
				}

				// update the item total:
				Integer numRows = table.getRowCount();
				totalItemsNumLbl.setText("" + numRows);
				
				// clear the text fields: 
				item1Tf.setText("");
				item2Tf.setText("");
				item3Tf.setText("");
				item4Tf.setText("");
				item5Tf.setText("");
				item6Tf.setText("");
				
			
			

			}

		});

		// add objects to the inventory Panel
		invPanel.add(invLbl);
		invPanel.add(itemName1Lbl);
		invPanel.add(price1Lbl);
		invPanel.add(qty1Lbl);
		invPanel.add(item1Tf);
		invPanel.add(itemName2Lbl);
		invPanel.add(price2Lbl);
		invPanel.add(qty2Lbl);
		invPanel.add(item2Tf);
		invPanel.add(itemName3Lbl);
		invPanel.add(price3Lbl);
		invPanel.add(qty3Lbl);
		invPanel.add(item3Tf);
		invPanel.add(itemName4Lbl);
		invPanel.add(price4Lbl);
		invPanel.add(qty4Lbl);
		invPanel.add(item4Tf);
		invPanel.add(itemName5Lbl);
		invPanel.add(price5Lbl);
		invPanel.add(qty5Lbl);
		invPanel.add(item5Tf);
		invPanel.add(itemName6Lbl);
		invPanel.add(price6Lbl);
		invPanel.add(qty6Lbl);
		invPanel.add(item6Tf);
		invPanel.add(createOrder);

		// set the parameters for the List Panel:
		// ALSO WEIRD PANEL. WHEN SETTING BOUNDS PRETEND PANEL STARTS AT 0,0.
		orderSummaryLbl.setForeground(headColor);
		orderSummaryLbl.setFont(headText);
		orderSummaryLbl.setBounds(290, 10, 400, 35);

		itemNameLbl.setFont(subHeadText);
		itemNameLbl.setBounds(70, 70, 200, 35); // left more space for this once since the Item Name might be long?

		itemNumLbl.setFont(subHeadText);
		itemNumLbl.setBounds(310, 70, 200, 35);

		quantityLbl.setFont(subHeadText);
		quantityLbl.setBounds(550, 70, 200, 35);

		priceLbl.setFont(subHeadText);
		priceLbl.setBounds(760, 70, 200, 35);

		sp.setBounds(10, 100, 933, 225);

		// delete item button:
		DeleteItem.setBounds(740, 330, 100, 35);
		clearOrder.setBounds(630, 330, 100, 35);

		// JTable setup
		Object[] columnNames = { "  ", "  ", "  ", "  " };
		model.setColumnIdentifiers(columnNames);
		table.setGridColor(Color.LIGHT_GRAY);
		model.setRowCount(0);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		// delete item action listener: 
		DeleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Remove Item from the table:

				int selectedRow = table.getSelectedRow();
				int quantityColumn = 2;
				int priceColumn = 3;
				String selectedPrice$ = (String) table.getValueAt(selectedRow, priceColumn);
				selectedPrice$ = selectedPrice$.replaceAll("\\$", "");
				Double selectedPrice = Double.parseDouble(selectedPrice$);
				totalPrice = (totalPrice - selectedPrice); 
				model.removeRow(selectedRow);

				// update the number of items:
				Integer numRows = table.getRowCount();
				totalItemsNumLbl.setText("" + numRows);
				
				// update the total price: 
				totalPriceBD = new BigDecimal(String.valueOf(totalPrice), MathContext.DECIMAL32);
				totalPriceNumLbl.setText(nf.format(totalPriceBD));

			}

		});
		
		// clear order action listener: 
		clearOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// clear the entire table 
				model.setRowCount(0);
				
				// update the number of items:
				Integer numRows = table.getRowCount();
				totalItemsNumLbl.setText("" + numRows);
				
				// update the total price: 
				totalPrice = 0; 
				totalPriceBD = new BigDecimal(String.valueOf(totalPrice), MathContext.DECIMAL32);
				totalPriceNumLbl.setText(nf.format(totalPriceBD));
				
			}
			
			
		});

		// add objects to the List Panel:
		tablePanel.add(orderSummaryLbl);
		tablePanel.add(clearOrder);
		tablePanel.add(DeleteItem);
		tablePanel.add(sp);
		tablePanel.add(itemNameLbl);
		tablePanel.add(itemNumLbl);
		tablePanel.add(quantityLbl);
		tablePanel.add(priceLbl);
		tablePanel.setBackground(Color.WHITE); // I set this white cause the White JList looked weird.

		// set the parameters for the totalsPanel:
		// THIS SECTION IS WEIRD. WHEN SETTING BONDS PRETEND PANEL BEGIN AT 0,0
		totalItemsLbl.setText("Total Items:   ");
		totalItemsLbl.setFont(new Font("Kohinoor Bangla", 0, 30));
		totalItemsLbl.setBounds(60, 20, 350, 35);

		totalPriceLbl.setText("Total Price: ");
		totalPriceLbl.setFont(new Font("Kohinoor Bangla", 0, 30));
		totalPriceLbl.setBounds(487, 20, 350, 35);

		totalPriceNumLbl.setText("$0.00");
		totalPriceNumLbl.setFont(new Font("Kohinoor Bangla", 0, 30));
		totalPriceNumLbl.setBounds(670, 20, 350, 35);

		totalItemsNumLbl.setText("0");
		totalItemsNumLbl.setFont(new Font("Kohinoor Bangla", 0, 30));
		totalItemsNumLbl.setBounds(250, 20, 350, 35);

		// add objects to the totals Panels:
		totalsPanel.add(totalItemsLbl);
		totalsPanel.add(totalPriceNumLbl);
		totalsPanel.add(totalPriceLbl);
		totalsPanel.add(totalItemsNumLbl);

		// set the parameters for the support Panel:
		// THIS SECTION IS WEIRD. WHEN SETTING BOUNDS PRETEND THE PANEL BEGINS AT 0,0
		supportLbl.setForeground(headColor);
		supportLbl.setFont(headText);
		supportLbl.setBounds(145, 10, 400, 35);

		couponCodeLbl.setFont(subHeadText);
		couponCodeLbl.setBounds(75, 85, 400, 35);

		couponCodeTf.setBounds(70, 125, 315, 30);

		employeeDiscountLbl.setFont(subHeadText);
		employeeDiscountLbl.setBounds(75, 195, 400, 35);

		employeeDiscountTf.setBounds(70, 235, 315, 30);

		applySupport.setOpaque(true);
		applySupport.setContentAreaFilled(true);
		applySupport.setBorderPainted(false);
		applySupport.setBackground(btnColor);
		applySupport.setFont(btnText);
		applySupport.setBounds(70, 350, 315, 40);
				
				

		// apply support action listener
		applySupport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// use a company policy so that coupon code and employee discount cannot be used at the same time:
				if (couponCodeTf.getText().isEmpty() == false && employeeDiscountTf.getText().isEmpty() == false) {
					
					JOptionPane.showMessageDialog(null, "Per company policy, you cannot use an employee discount and a coupon at the same time.");
				
				} else {
			
				// switch case for coupon code
				String code = couponCodeTf.getText();

				switch (code) {
				case "Pirate20":
					totalPrice = (totalPrice - (totalPrice * .2));
					break;
				case "Parrot15":
					totalPrice = (totalPrice - (totalPrice * .15));
					break;
				case "Ship10":
					totalPrice = (totalPrice - (totalPrice * .1));
					break;
				case "":
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid coupon code.");
					break;

				}

				// switch case for employee discount
				String empl = employeeDiscountTf.getText();

				switch (empl) {
				case "1234":
					totalPrice = (totalPrice - (totalPrice * .25));
					break;
				case "5678":
					totalPrice = (totalPrice - (totalPrice * .25));
					break;
				case "9876":
					totalPrice = (totalPrice - (totalPrice * .25));
					break;
				case "":
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid employee personell number.");
					break;
				}

				totalPriceBD = new BigDecimal(String.valueOf(totalPrice), MathContext.DECIMAL32);
				totalPriceNumLbl.setText(nf.format(totalPriceBD));
				
				}

				// clear the text from the text fields: 
				couponCodeTf.setText("");
				employeeDiscountTf.setText("");
				
				
			}

		});

		mgrOverride.setOpaque(true);
		mgrOverride.setContentAreaFilled(true);
		mgrOverride.setBorderPainted(false);
		mgrOverride.setBackground(btnColor);
		mgrOverride.setFont(btnText);
		mgrOverride.setBounds(70, 290, 315, 40);

		// manager override action listener
		mgrOverride.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// allows a price change to a selected item in the JTable
				int rowIndex = table.getSelectedRow();
				int itemNumColumnIndex = 1;
				int priceColumnIndex = 3;
					
				try { 
					if (rowIndex > -1 ) {
				String Password = JOptionPane.showInputDialog(null, "Enter Password: ");
				
				if (Password.equals("Manager1234")) {
					
					String currentPrice = (String) table.getValueAt(rowIndex, priceColumnIndex);
					currentPrice = currentPrice.replaceAll("\\$", "");
					double oldPrice = Double.parseDouble(currentPrice);
					// cartTotal = cartTotal - OldPrice;
					String itemNum = (String) table.getValueAt(rowIndex, itemNumColumnIndex);
					String enteredPrice = JOptionPane.showInputDialog(null,
							"What is the new price for item #" + itemNum + "? " + "(Format 00.00)");
					double newPrice = Double.parseDouble(enteredPrice);
					enteredPrice = "$" + enteredPrice;
					table.setValueAt(enteredPrice, rowIndex, priceColumnIndex);
					// update total price: 
					totalPrice = totalPrice - oldPrice + newPrice; 
					totalPriceBD = new BigDecimal(String.valueOf(totalPrice), MathContext.DECIMAL32);
					totalPriceNumLbl.setText(nf.format(totalPriceBD));; 
					
				} else {
					JOptionPane.showMessageDialog(null, "Password Incorrect");
				} 
					} else {
						JOptionPane.showMessageDialog(null, "Please select an item to override.");
					}
			} catch (NullPointerException h) {
				System.out.println("");
			}
			}

		});

		// add objects to the support Panel:
		supportPanel.add(applySupport);
		supportPanel.add(mgrOverride);
		supportPanel.add(supportLbl);
		supportPanel.add(couponCodeLbl);
		supportPanel.add(employeeDiscountLbl);
		supportPanel.add(couponCodeTf);
		supportPanel.add(employeeDiscountTf);

		// set the parameters for the Payment Panel:
		// THIS SECTION IS NORMAL. SETTING BOUNDS IS DEPENDENT ON THE ENTIRE GUI
		// THE PANEL BEGINS AT 1033,451
		paymentLbl.setForeground(headColor);
		paymentLbl.setFont(headText);
		paymentLbl.setBounds(1150, 461, 400, 35);

		pmtTypeLbl.setFont(subHeadText);
		pmtTypeLbl.setBounds(1155, 530, 400, 35);

		cashBtn.setFont(regText);
		cashBtn.setBounds(1190, 590, 400, 35);
		cashBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// This is where we put the dialog box to
				// accept input that would show up on the
				// receipt in the pmt info section

			}

		});

		checkBtn.setFont(regText);
		checkBtn.setBounds(1190, 640, 400, 35);
		checkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// This is where we put the dialog box to
				// accept input that would show up on the
				// receipt in the pmt info section

			}

		});

		creditBtn.setFont(regText);
		creditBtn.setBounds(1190, 690, 400, 35);
		creditBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// This is where we put the dialog box to
				// accept input that would show up on the
				// receipt in the pmt info section

			}

		});

		genReceipt.setOpaque(true);
		genReceipt.setContentAreaFilled(true);
		genReceipt.setBorderPainted(false);
		genReceipt.setBackground(btnColor);
		genReceipt.setFont(btnText);
		genReceipt.setBounds(1100, 761, 315, 40);
		genReceipt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// This is where we code so that the button
				// pulls up the receipt with JList and Payment Details

			}

		});

		// add objects to the Payment Panel:
		paymentPanel.add(paymentLbl);
		paymentPanel.add(pmtTypeLbl);
		paymentPanel.add(cashBtn);
		paymentPanel.add(checkBtn);
		paymentPanel.add(creditBtn);
		paymentPanel.add(genReceipt);

		// add the panels to the UI:
		add(invPanel);
		add(tablePanel);
		add(totalsPanel);
		add(supportPanel);
		add(paymentPanel);

	}

	// Method to add image. Put this in the constructor
	// input file path, xy coordinates for rectangle, rect length & height
	// example: invPanel.add(AddImage("src/download.jpeg",100,100,200,200));
	JLabel AddImage(String s, int x, int y, int a, int b) {
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(s));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;
		JLabel l = new JLabel(new ImageIcon(bi));
		l.setBounds(x, y, a, b);
		return l;
	}

	// create borders:
	public void MatteBorder(int top, int left, int bottom, int right, Color matteColor) {

	}

	class ReceiptPanel extends JPanel implements Printable {

		Font f = new Font("Helvetica", Font.PLAIN, 10);
		Image receiptIMG = Toolkit.getDefaultToolkit().getImage("ye-olde-receipt.png");
		ImageIcon receiptIMGICON = new ImageIcon(receiptIMG.getScaledInstance(240, 60, Image.SCALE_SMOOTH));
		Double total = Double.parseDouble(totalPriceNumLbl.getText());

		public void paintComponent(Graphics graphics) {

			super.paintComponent(graphics);

			this.setLayout(null);

			// make it smooth:
			Graphics2D g2d = (Graphics2D) graphics;
			RenderingHints hints = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
			g2d.setRenderingHints(hints);

			// title graphic:
			JLabel title_LBL = new JLabel();
			title_LBL.setIcon(receiptIMGICON);
			title_LBL.setBounds(10, 0, 240, 60);
			add(title_LBL);

			// date/time stamp:
			Calendar cal = new GregorianCalendar();
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Helvetica", Font.PLAIN, 12));
			g2d.drawString("PIRATE FLAG DEPOT", 24, 70);
			g2d.drawString((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/"
					+ cal.get(Calendar.YEAR) + "  " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE)
					+ " " + (cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM"), 66, 90);

			// list of ordered items:
			JLabel[] labels = new JLabel[cart.size()];
			for (int i = 0; i < cart.size(); i++) {
				labels[i] = new JLabel("" + (i + 1) + ". " + cart.get(i).toString());
				labels[i].setFont(f);
				labels[i].setBounds(10, 110 + (i * 12), 240, 12);
				add(labels[i]);
			}

			// total:
			g2d.setFont(new Font("Helvetica", Font.PLAIN, 18));
			g2d.drawString("Total: " + nf.format(total), 74, getHeight() - 55);

			// slogan:
			g2d.setFont(f.deriveFont(Font.ITALIC, 15));
			g2d.drawString("Thank you for doing business with us!", 47, getHeight() - 30);

		}

		// Method to add image. Put this in the constructor
		// input file path, xy coordinates for rectangle, rect length & height
		// example: invPanel.add(AddImage("src/download.jpeg",100,100,200,200));
		JLabel AddImage(String s, int x, int y, int a, int b) {
			BufferedImage bi = null;
			try {
				bi = ImageIO.read(new File(s));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;
			JLabel l = new JLabel(new ImageIcon(bi));
			l.setBounds(x, y, a, b);
			return l;
		}

		// create borders:
		public void MatteBorder(int top, int left, int bottom, int right, Color matteColor) {

		}

		public void doReceipt() {

			// generate on screen receipt:
			ReceiptPanel p = new ReceiptPanel();
			JFrame f = new JFrame();
			f.setSize(new Dimension(400, 400));
			f.add(p);
			f.setTitle("Receipt");
			f.setVisible(true);

			// submit print job:
			// only "p" needs to be customized prior to printing - everything else is cut
			// and paste from here
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(p);
			if (job.printDialog()) {
				try {
					job.print();
				} catch (PrinterException x_x) {
					System.out.println("Error printing: " + x_x);
				}
			}
		}

		// method for printing:
		@Override
		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

			return 0;
		}

	}
}
