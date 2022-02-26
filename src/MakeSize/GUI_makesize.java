package MakeSize;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI_makesize {
   /*package*/ JButton[] createboardwithsize(int size) {
      JButton[] Node = new JButton[size*size];
      		JPanel Grid = new JPanel();
      
      		for (int i = 0; i <size*size; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      		}
      		
      		return Node;
      	}
   
   }
