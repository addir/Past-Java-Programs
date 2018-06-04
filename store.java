import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/* You are building an app to allow a customer to order multiple web ads based on your own design
 * You may re-use the drawn web ad design from earlier as a basis for this one. The store app
 * should display the ordered web ads in JList along with buttons that allow the indicated
 * features (add, remove, show stats, view drawn ad).
 * 
 * Create a class describing WebAd objects. This class should be a subclass of JPanel and also
 * include at least the following attributes: unitPrice (random BigDecimal), discountRate (random
 * BigDecimal between 0-50%), taxRate (static BigDecimal rate set by app), and adjustedPrice (
 * final BigDecimal price w/ discount and tax applied)
 * 
 * The WebAd constructor should generate a random price for a new object along with a random
 * discount rate. Then, the constructor should calculate the adjusted price by applying the
 * discount and adding tax. Ideally, all calculations will be carried out in BigDecimal. Finally,
 * a description of the new WebAd object should be added to the JTable (using a getRow() )
 * or JList (using toString() ). Create new web ads using: WebAd ad = new WebAd()
 * 
 * The store app should calculate basic stats for the WebAd objects currently in the shopping
 * cart (JList). For example, these stats should be displayed in an option pane like this:
 * 
 * When the user hits the "view selected ad" button, a new JFrame should appear containing
 * the 480x480 drawn ad:
 * 
 * 
 * 
 * 
 */


public class store extends JFrame implements ActionListener {

	// Declare the buttons:
	JButton addWebAd = new JButton("Add WebAd");
	JButton removeAd = new JButton("Remove Selected Ad");
	JButton showStats = new JButton("Show Stats");
	JButton viewAd = new JButton("View Selected Ad");

	// Declare JPanels: 
	JPanel listPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	

	//Declare JLabels:
	JLabel webAdLbl = new JLabel("WebAd Price");
	JLabel discountLbl = new JLabel("Discount");
	JLabel taxLbl = new JLabel("Tax");
	JLabel totalLbl = new JLabel("Total");
	JLabel displaylbl = new JLabel("xxx");
	 


	//Declare JList

	JList<WebAd2> list;

	
	//Declare font variables: 
	Font regText = new Font("Bangla Sangam MN", 0, 12);
	Font subHeadText = new Font("Kohinoor Bangla", 0, 20) ;
	Font headText = new Font("Herculanum", 1, 36) ;
	Font btnText = new Font("Bangla Sangam MN", 1, 20);
	
	//Declare background color variables: 
	Color backColor1 =  new Color( 223, 223, 223, 150) ;
	Color backColor2 = new Color( 71, 71, 71, 255);
	Color backColor3 = new Color( 2, 46, 91, 216) ;
	Color btnColor = new Color( 197, 197, 197, 219) ;
	Color headColor = new Color( 0, 0, 113, 255);
	
	WebAd2[] adds = new WebAd2[5];

			
	class ButtonListener implements ActionListener {
		  ButtonListener() {
		  }

		  public void actionPerformed(ActionEvent e) {
			  int selx = list.getSelectedIndex();
		    if (e.getActionCommand().equals("View Selected Ad")) {
		    	System.out.println(list.getSelectedIndex());
		    	JFrame frame = null;
		    	switch(list.getSelectedIndex()) {
		    	case 0:
		    		frame = new WebAd(adds[selx].getadjustedPrice());
		    		break;
		    	case 1:
		    		frame = new WebAd(adds[selx].getadjustedPrice());
		    		break;
		    	case 2:
		    		frame = new WebAd(adds[selx].getadjustedPrice());
		    		break;
		    	case 3:
		    		frame = new WebAd(adds[selx].getadjustedPrice());
		    		break;
		    	case 4:
		    		frame = new WebAd(adds[selx].getadjustedPrice());
		    		break;
		    		default:
		    			System.out.println("Invalid Selection");
		    	}
		      System.out.println("Button1 has been clicked");
		    } else if (e.getActionCommand().equals("Remove Selected Ad")) {
		    	System.out.printf("Remove %d %d\n",selx, adds.length);
		    	if(selx < 0) {
		    		System.out.println("Must Select an Ad to be Removed");
		    		return;
		    	}
		    	WebAd2[] addsCopy = new WebAd2[adds.length-1];
		    	int j = 0;
		    	for(int i = 0; i<adds.length&&j<addsCopy.length; i++) {
		    		
		    		addsCopy[j] = adds[i];
		    				if(i!=selx) {
				    			j++;
				    		}
		    	}
		    	adds = addsCopy;
		    	((DefaultListModel<WebAd2>)list.getModel()).removeAllElements(); 
				for(int i=0; i<adds.length; i++) {
					((DefaultListModel<WebAd2>)list.getModel()).addElement(adds[i]);
				}
				BigDecimal sum = new BigDecimal(0);
				for(int i = 0; i<adds.length;i++) {
					adds[i] = new WebAd2();
					sum = sum.add(adds[i].getadjustedPrice());

				}
		   	 String s =  String.format( "%s", NumberFormat.getCurrencyInstance().format(sum));
				displaylbl.setText(s);
		    	listPanel.repaint();
		    }  else if (e.getActionCommand().equals("Add WebAd")) {
		    	if(selx >= 14) {
		    		System.out.println("Maximum Ads");
		    		return;
		    	}
		    	WebAd2[] addsCopy = new WebAd2[adds.length+1];
				for(int i = 0; i<adds.length;i++) {
					addsCopy[i] = adds[i];
					
				}
				addsCopy[adds.length]= new WebAd2();
				adds = addsCopy;
				System.out.println("Adds "+selx);
				((DefaultListModel<WebAd2>)list.getModel()).removeAllElements(); 
				for(int i=0; i<adds.length; i++) {
					((DefaultListModel<WebAd2>)list.getModel()).addElement(adds[i]);
				}
				BigDecimal sum = new BigDecimal(0);
				for(int i = 0; i<adds.length;i++) {
					adds[i] = new WebAd2();
					sum = sum.add(adds[i].getadjustedPrice());

				}
		   	 String s =  String.format( "%s", NumberFormat.getCurrencyInstance().format(sum));
				displaylbl.setText(s);
				
		    	listPanel.repaint();
		    }  else if (e.getActionCommand().equals("Show Stats")) {
		    	BigDecimal min = new BigDecimal(Double.MAX_VALUE);
		    	BigDecimal max = new BigDecimal(Double.MIN_VALUE);
		    	BigDecimal avg = new BigDecimal(0);
		    	for(int i = 0; i<adds.length; i++) {
		    		BigDecimal next = adds[i].getadjustedPrice();
		    		if(next.compareTo(min)<0) {
		    			min = next;
		    		}
		    		if(next.compareTo(max)>0) {
		    			max = next;
		    		}
		    		avg = avg.add(next);
		    	}
		    	avg = avg.divide(new BigDecimal(adds.length), 2, RoundingMode.HALF_UP);
		    	 String s =  String.format( "Low Price = %10s\nHigh Price = %10s\nAvg Price =%10s", NumberFormat.getCurrencyInstance().format(min),
		    			NumberFormat.getCurrencyInstance().format(max),
						NumberFormat.getCurrencyInstance().format(avg));
		    	JOptionPane.showMessageDialog(null, s, "Summary Statistics", JOptionPane.DEFAULT_OPTION);
		    }
		  }
	}
	public static void main(String[] args) {

		//create: 
		store app = new store(); 
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setSize(800, 600);
		app.setVisible(true);
		app.setTitle("My WebAd Store");


	}

	store() {

		// set the size and location for the JPanels
		this.setLayout(new BorderLayout());

		listPanel.setBounds(567, 0, 933, 371);
		listPanel.setLayout(null);
		listPanel.setBackground(Color.WHITE);
		btnPanel.add(viewAd);
		btnPanel.add(addWebAd);
		btnPanel.add(removeAd);
		btnPanel.add(showStats);
		btnPanel.add(displaylbl);
		viewAd.setVisible(true);
		addWebAd.setVisible(true);
		removeAd.setVisible(true);
		showStats.setVisible(true);
		viewAd.addActionListener(new ButtonListener());
		addWebAd.addActionListener(new ButtonListener());
		removeAd.addActionListener(new ButtonListener());
		showStats.addActionListener(new ButtonListener());
		
		//set the parameters for the List Panel: 

		webAdLbl.setFont(subHeadText);
		webAdLbl.setBounds(40, 20, 200, 20); 

		discountLbl.setFont(subHeadText);
		discountLbl.setBounds(260, 20, 200, 20); 

		taxLbl.setFont(subHeadText);
		taxLbl.setBounds(480, 20, 200, 20);

		totalLbl.setFont(subHeadText);
		totalLbl.setBounds(670, 20, 200, 20);
		WebAd2.settaxRate(new BigDecimal(7.5));
		adds = new WebAd2[5];

		BigDecimal sum = new BigDecimal(0);
		for(int i = 0; i<adds.length;i++) {
			adds[i] = new WebAd2();
			sum = sum.add(adds[i].getadjustedPrice());

		}
   	 String s =  String.format( "%s", NumberFormat.getCurrencyInstance().format(sum));
		displaylbl.setText(s);
		list = new JList<WebAd2>(new DefaultListModel<WebAd2>());

		for(int i=0; i<adds.length; i++) {
			((DefaultListModel<WebAd2>)list.getModel()).addElement(adds[i]);
		}
		list.setBounds(3, 100, 933, 225); 

//		//add objects to the List Panel:

		listPanel.add(list);
		listPanel.add(webAdLbl);
		listPanel.add(discountLbl);
		listPanel.add(taxLbl);
		listPanel.add(totalLbl);
		listPanel.setBackground(Color.WHITE);

		// add the panels to the UI:
		add(listPanel);
		add(btnPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		System.out.println("Action Performed");
	}
}