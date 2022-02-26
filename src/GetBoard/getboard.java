package GetBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.Test;

public class getboard {
   @Test
   public void main () 
   {
      JButton[] a = createboardwithsize(3); //test board size with input = 3
      		assertEquals(a.length, 9);
      		JButton[] b = createboardwithsize(4); //test board size with input = 4
      		assertEquals(b.length, 16);
      		JButton[] c = createboardwithsize(5); //test board size with input = 5
      		assertEquals(c.length, 25);
      		JButton[] d = createboardwithsize(6); //test board size with input = 6
      		assertEquals(d.length, 36);
      		JButton[] e = createboardwithsize(7); //test board size with input = 7
      		assertEquals(e.length, 49);
      		
      		
      		
      	}
   /*package*/ JButton[] createboardwithsize(int size) {
      JButton[] Node = new JButton[size*size];
      		JPanel Grid = new JPanel();
      		String charS = "S";
      		String charO = "O";
      		for (int i = 0; i <size*size; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      			assertNotEquals(Node[i].getText(), charS);
      			assertNotEquals(Node[i].getText(), charO);
      		}
      		assertNotNull(Grid);
      		return Node;
      	}
   
   }
