package determinewinner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*package*/ class test_winner {
   /*package*/ GUI_winner win = new GUI_winner();
   @Test
   /*package*/ void test () 
   {
      production_winner test = new production_winner(); // case in simple game, when 1 player created SOS first, game ends
      		assertEquals(test.simplegame(), true);			 //  (player 1 makes SOS, then game ends)
      		
      		production_winner test2 = new production_winner(); // case in simple game, when the board is filled up in all nodes, game ends
      		assertEquals(test2.simplegame_fullboard(), true); //  (Nodes are filled, no one got any point, I initially assigned "S" for all nodes)
      
      		production_winner test3 = new production_winner(); //case in general game, when a player got 1 point but the game still continues
      		assertEquals(test3.generalgame(), false);          //(player 1 create 1 SOS but because all nodes are not filled, so the game continues)
      	}
   }
