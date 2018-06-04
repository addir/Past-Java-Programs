/*  A. Make an app that creates an array (or an ArrayList, if you’re already familiar
with them) of Pirate objects and fills it with at least 3 pirates. Display the
array contents at the console. */

//12 1A 

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Ex1 extends JFrame implements ActionListener{
JPanel p = new JPanel();
JButton b = new JButton("Add Pirate");

ArrayList<Pirates> pirate$= new ArrayList<Pirates>();

public static void main(String[] args) {
Ex1 app = new Ex1();
app.setSize(300, 300);
app.setTitle(app.getClass().getCanonicalName());
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
app.setVisible(true);
}

Ex1 (){
b.addActionListener(this);
add(b, BorderLayout.SOUTH);
pirate$.add(new Pirates("Addison Scurvy", 9));
pirate$.add(new Pirates("Addi Arg", 5));
pirate$.add(new Pirates("Pirate Addison", 3));
pirate$.add(new ActivePirates("Addison Scurvy", 10, "Skulls n Bones"));
pirate$.add(new ActivePirates("Addi Arg", 6, "Black Pearl"));
pirate$.add(new ActivePirates("Pirate Addison", 4, "Kraken"));
pirate$.toString();
}


class Pirates {
String name;
double doubloons;
Pirates(String n, double d) {
name = n;
doubloons = d;

}
public String toString() {
// for ()
return name + " has " + doubloons + " doubloons.\n";
}
}


class ActivePirates extends Pirates{
String Ship;
ActivePirates(String n, double d, String string) {
super(n, d);
Ship = string;
// TODO Auto-generated constructor stub
}
public String toString(){
return name + " is serving the " + Ship + " with " + doubloons + " doubloons.\n";
}
}
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
for (int t = 0; t < pirate$.size(); t++) {
System.out.println(pirate$.get(t));
}
}
}