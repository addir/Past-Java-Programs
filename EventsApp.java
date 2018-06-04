import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventsApp extends JFrame implements ActionListener {
	// Step 1: Implement the listener ---------------^

	// declare and instantiate our objects:
	JButton b = new JButton("Hit Counter");
	JTextField t = new JTextField("   0");
	JPanel p = new JPanel();
	int bCount = 0;

	// the main() method is run automatically by the JVM
	public static void main(String[] args) {
		EventsApp app = new EventsApp();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setSize(200, 70);
		app.setTitle(app.getClass().getCanonicalName());
		app.setup();
		app.setVisible(true);
	}

	void setup() {
		t.setEditable(false);
		b.addActionListener(this); // Step 2: Register b
		
		p.add(b);
		p.add(t);
		add(p);
	}

	// Step 3: Provide the event-handler:
	public void actionPerformed(ActionEvent e) {
		System.out.println("Stop hitting yourself");
		bCount++;
		t.setText(""+bCount);
	}
}

