package MakeMove;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Random;

import javax.swing.JButton;

import org.junit.Test;

/*package*/ class test_move {
   /*package*/ GUImove gui = new GUImove();
   /*package*/ Random rnd = new Random();
   /*package*/ GUImove gui_1 = new GUImove();
   @Test
   /*package*/ void test () 
   {
      JButton[] Node = new JButton[64];
      		Node = gui.createboard();
      		boolean chooseS1 = true;
      	
      		productionMove test = new productionMove();
      		Node = test.makemove(Node, 0, 0, 6);
      		
      		assertEquals(Node[6].getText(), "S");
      		
      		Node = test.makemove(Node, 1, 3, 6);
      		assertNotEquals(Node[6].getText(), "O");
      	}
   }
