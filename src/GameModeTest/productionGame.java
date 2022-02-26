package GameModeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class productionGame {
   /*package*/ ProductionGUI gui = new ProductionGUI();
   /*package*/ int i = 0;
   /*package*/ ProductionGUI gui_1 = new ProductionGUI();
   @Test
   public int choosesimple (ProductionGUI gui2) 
   {
      gui2.simplegame.setSelected(true);
      		gui2.genegame.setSelected(false);
      		assertEquals(gui2.simplegame.isSelected(), true);
      		return i;
      	}
   public int choosegene(ProductionGUI gui3) {
      i =1;
      		gui3.simplegame.setSelected(false);
      		gui3.genegame.setSelected(true);
      		return i;
      	}
   
   }
