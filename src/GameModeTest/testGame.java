package GameModeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testGame {
   @Test
   public void test () 
   {
      ProductionGUI gui;
      		productionGame test = new productionGame();
      		gui = new ProductionGUI();
      		int check = test.choosesimple(gui);
      		if (check == 0)
      		{
      			assertEquals(gui.simplegame.isSelected(), true);
      			assertEquals(gui.genegame.isSelected(), false);
      		}
      		else if (check == 1)
      		{
      			assertEquals(gui.simplegame.isSelected(), false);
      			assertEquals(gui.genegame.isSelected(), true);
      		}
      		
      	}
   }
