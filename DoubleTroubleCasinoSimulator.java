import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 /* Addison Rodriguez DoubleTroubleCasino Simulator*/
 
public class DoubleTroubleCasinoSimulator extends JFrame {
 
                // declare and instantiate objects
                JButton roll = new JButton("Roll");
                DefaultTableModel model = new DefaultTableModel(100, 4); // rows, columns
                JTable table = new JTable(model);
                JScrollPane sp = new JScrollPane(table);
 
                public static void main(String[] args) {
 
                                // create the app
                                DoubleTroubleCasinoSimulator app = new DoubleTroubleCasinoSimulator();
                                app.setSize(400, 700);
                                app.setTitle("DoubleTrouble Casino Simulator");
                                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                app.setVisible(true);
 
                }
 
                DoubleTroubleCasinoSimulator() {
 
                                // set column headers
                                Object[] columnNames = { "Game No.", "No. Rolls", "Game Win/Loss", "Running Total" };
                                model.setColumnIdentifiers(columnNames);
 
                                // set up the UI
                                add(roll, BorderLayout.SOUTH);
                                add(sp, BorderLayout.CENTER);
 
                                // add action listener
                                roll.addActionListener(new ActionListener() {
 
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
 
                                                               
                                                }
 
                                });
 
                }
 
}