import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class AtomicNumberGame {
	
	JFrame frame = new JFrame();
	JPanel mainpanel = new JPanel();	
	JPanel elementpanel = new JPanel();
	JPanel buttonpanel = new JPanel();
	JPanel hintpanel = new JPanel();
	JPanel textpanel = new JPanel();
	JTextField text = new JTextField(100); 
	JButton submit= new JButton("Submit Answer");
	JButton newElement= new JButton("Generate new Element");
	JButton quit= new JButton("Quit Game");
	JLabel elementNo = new JLabel ();
	JLabel hint1 = new JLabel ();
	JLabel hint2 = new JLabel ();
	HashMap <Integer,String> list= new HashMap<Integer,String>();
	ArrayList <Integer> intList = new ArrayList <Integer>();
	ArrayList <String> eList = new ArrayList <String>();
	
	int count=0;
	int turns=0;
	
	public static void main(String[] args) {
		AtomicNumberGame gui = new AtomicNumberGame();
		gui.go();
		}
	public void go () {
		text.setHorizontalAlignment(JTextField.CENTER);
		elementNo.setHorizontalAlignment(JLabel.CENTER);
		elementpanel.add(elementNo);
		mainpanel.add(elementpanel);
		textpanel.add(text);
		mainpanel.add(textpanel);
		buttonpanel.add(submit);
		buttonpanel.add(newElement);
		buttonpanel.add(quit);
		mainpanel.add(buttonpanel);
		hintpanel.add(hint1);
		hintpanel.add(hint2);
		mainpanel.add(hintpanel);
		
		mainpanel.setLayout(new GridLayout(4,1));
		
		elementpanel.setBackground(Color.CYAN);
		textpanel.setBackground(Color.CYAN);
		buttonpanel.setBackground(Color.CYAN);
		hintpanel.setBackground(Color.CYAN);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(mainpanel);
		frame.setTitle("Chemistry Game");
		frame.setSize(400, 600);
		frame.setVisible(true);
		addElement();
		
		submit.addActionListener(new SubmitClass());
		quit.addActionListener(new QuitClass());
		newElement.addActionListener(new ElementClass());
		
		elementNo.setText("Element No: "+intList.get(count));


		count+=1;
	
	}
	
	public void addElement() {
		addeElement();
		for (int i=1; i<=118;i++) {
			intList.add(i);
			list.put(i,eList.get(i-1));
		}
		

		
		Collections.shuffle(intList);
		

	}
	public void addeElement() {
		eList.add("H");eList.add("He");eList.add("Li");eList.add("Be");eList.add("B");eList.add("C");eList.add("N");eList.add("O");eList.add("F");eList.add("Ne");
		eList.add("Na");eList.add("Mg");eList.add("Al");eList.add("Si");eList.add("P");eList.add("S");eList.add("Cl");eList.add("Ar");eList.add("K");eList.add("Ca");
		eList.add("Sc");eList.add("Ti");eList.add("V");eList.add("Cr");eList.add("Mn");eList.add("Fe");eList.add("Co");eList.add("Ni");eList.add("Cu");eList.add("Zn");
		eList.add("Ga");eList.add("Ge");eList.add("As");eList.add("Se");eList.add("Br");eList.add("Kr");eList.add("Rb");eList.add("Sr");eList.add("Y");eList.add("Zr");
		eList.add("Nb");eList.add("Mo");eList.add("Tc");eList.add("Ru");eList.add("Rh");eList.add("Pd");eList.add("Ag");eList.add("Cd");eList.add("In");eList.add("Sn");
		eList.add("Sb");eList.add("Te");eList.add("I");eList.add("Xe");eList.add("Cs");eList.add("Ba");eList.add("La");eList.add("Ce");eList.add("Pr");eList.add("Nd");
		eList.add("Pm");eList.add("Sm");eList.add("Eu");eList.add("Gd");eList.add("Tb");eList.add("Dy");eList.add("Ho");eList.add("Er");eList.add("Tm");eList.add("Yb");
		eList.add("Lu");eList.add("Hf");eList.add("Ta");eList.add("W");eList.add("Re");eList.add("Os");eList.add("Ir");eList.add("Pt");eList.add("Au");eList.add("Hg");
		eList.add("Tl");eList.add("Pb");eList.add("Bi");eList.add("Po");eList.add("At");eList.add("Rn");eList.add("Fr");eList.add("Ra");eList.add("Ac");eList.add("Th");
		eList.add("Pa");eList.add("U");eList.add("Np");eList.add("Pu");eList.add("Am");eList.add("Cm");eList.add("Bk");eList.add("Cf");eList.add("Es");eList.add("Fm");
		eList.add("Md");eList.add("No");eList.add("Lr");eList.add("Rf");eList.add("Db");eList.add("Sg");eList.add("Bh");eList.add("Hs");eList.add("Mt");eList.add("Ds");
		eList.add("Rg");eList.add("Cn");eList.add("");eList.add("Fl");eList.add("Mc");eList.add("Lv");eList.add("Ts");eList.add("Og");
	}
	


	
	public class QuitClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
	
	
	public class SubmitClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int nc=count-1;
			turns+=1;
			
			String temp = list.get(intList.get(nc)); 
			
			
			if (text.getText().equals(temp)) {
				
				JOptionPane.showMessageDialog(null,"You Won!");
				elementNo.setText("Element No: "+intList.get(count));
				
				turns=0;
				text.setText("");
				hint1.setText("");
				hint2.setText("");
			
				
				count+=1;

			}
			else if (text.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Please enter something");
				turns-=1;

			}
			
			
			else {
					
			if (turns<5) {
					int left=5-turns;
					JOptionPane.showMessageDialog(null,"Your answer is incorrect\nTake anonther Guess\nTurns left: "+left);
						//turns+=1; 
					hints();
					
				}
				else {
					JOptionPane.showMessageDialog(null,"SORRY\nGame Over!!\nCorrect Ans: "+temp);
					text.setText("");
					hint1.setText("");
					hint2.setText("");
					elementNo.setText("");
					text.setEnabled(false);
					submit.setEnabled(false);
					newElement.setEnabled(false);
				}
			text.setText("");
			
			}
			
		}
		
		public void hints() {
			if (intList.get(count-1)==1) {
				hint1.setText("No element to the left\n");
				hint2.setText("Element to right is: "+list.get(intList.get(count-1)+1)+"\n");
			}
			else if (intList.get(count-1)==118) {
				hint2.setText("No element to the right\n");
				hint1.setText("Element to left is: "+list.get(intList.get(count-1)-1)+"\n");
			}
			else {
				hint1.setText("Element to left is: "+list.get(intList.get(count-1)-1)+"\n");
				hint2.setText("Element to right is: "+list.get(intList.get(count-1)+1)+"\n");
			}
			
		}
	}
	
	
	
	public class ElementClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			elementNo.setText("Element No: "+intList.get(count));
			
			count+=1;
			text.setText("");
			hint1.setText("");
			hint2.setText("");
			
		}
		
	}

}	
