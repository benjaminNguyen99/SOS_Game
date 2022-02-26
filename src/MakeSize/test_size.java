package MakeSize;

import static org.junit.Assert.assertEquals;

import javax.swing.JButton;

import org.junit.Test;

/*package*/ class test_size {
   @Test
   /*package*/ void test () 
   {
      GUI_makesize New = new GUI_makesize(); 
      		JButton[] a = New.createboardwithsize(3); //test board size with input = 3
      		assertEquals(a.length, 9);
      		JButton[] b = New.createboardwithsize(4); //test board size with input = 4
      		assertEquals(b.length, 16);
      		JButton[] c = New.createboardwithsize(5); //test board size with input = 5
      		assertEquals(c.length, 25);
      		JButton[] d = New.createboardwithsize(6); //test board size with input = 6
      		assertEquals(d.length, 36);
      		JButton[] e = New.createboardwithsize(7); //test board size with input = 7
      		assertEquals(e.length, 49);
      	}
   }
