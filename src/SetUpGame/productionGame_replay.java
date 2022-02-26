package SetUpGame;


public class productionGame_replay {
   /*package*/ productionGUI_replay gui;
   /*package*/ int score1 = 10;
   /*package*/ int score2 = 5;
   public void resetgame(productionGUI_replay gui) {
      for (int i = 0; i <64; i++)
      		{
      			gui.Node[i].setText("");
      		}
      	}
   
   }
