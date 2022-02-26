package MakeMove;

import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GUImove {
   /*package*/ JRadioButton S1 = new JRadioButton("S");
   /*package*/ JRadioButton O1 = new JRadioButton("O");
   /*package*/ JRadioButton S2 = new JRadioButton("S");
   /*package*/ JRadioButton O2 = new JRadioButton("O");
   /*package*/ ButtonGroup SO1 = new ButtonGroup();
   /*package*/ ButtonGroup SO2 = new ButtonGroup();
   /*package*/ JButton[] Node = new JButton[64];
   public void GUI() {
      S1.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		S1.setBounds(55, 329, 172, 59);
      
      		O1.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		O1.setBounds(55, 401, 172, 59);
      		
      		S2.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		S2.setBounds(934, 329, 172, 59);
      
      		O2.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		O2.setBounds(934, 401, 172, 59);
      		
      		SO1.add(S1); SO1.add(O1);
      		SO2.add(S2); SO2.add(O2);
      		
      	}
   
   public JButton[] createboard() {
      JButton[] empty = new JButton[64];
      		for (int i = 0; i <64; i++)
      		{
      			empty[i]= new JButton();
      			empty[i].setFocusable(false);
      			empty[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      
      		}
      		return empty;
      	}
   
   }
