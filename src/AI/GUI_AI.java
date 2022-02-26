package AI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI_AI {
   /*package*/ JButton[] create() {
      JButton[] Node = new JButton[9];
      		JPanel Grid = new JPanel();
      
      		for (int i = 0; i <9; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      		}
      		Node[0].setText("S");
      		Node[1].setText("O");
      
      		return Node;
      		
      	}
   
   /*package*/ JButton[] create_general() {
      JButton[] Node = new JButton[9];
      		JPanel Grid = new JPanel();
      
      		for (int i = 0; i <9; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      		}
      		
      
      		return Node;
      		
      	}
   
   }
