package determinewinner;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

/*package*/ class GUI_winner {
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
      		Node[2].setText("S");
      		return Node;
      		
      	}
   
   /*package*/ JButton[] create_filled() {
      JButton[] Node = new JButton[9];
      		JPanel Grid = new JPanel();
      
      		for (int i = 0; i <9; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      			Node[i].setText("S");
      		}
      		
      		return Node;
      		
      	}
   
   }
