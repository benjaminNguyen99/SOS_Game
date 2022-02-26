package SOSpackage;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class SimpleGame extends Game {
   void winner_simple(int b, String c) {
      if (c == "player 1")
      {
    	  JOptionPane.showMessageDialog(gui, "player 1 wins");
       	  score1+=b;
       	  gui.P1score.setText(String.valueOf(score1));
       	  recordgame(1);
      	  resetgame();
      }
      else if (c == "player 2")
      {
      	  JOptionPane.showMessageDialog(gui, "player 2 wins");
      	  score2 += b;
      	  gui.P2score.setText(String.valueOf(score2));
      	  recordgame(2);
      	  resetgame();
      }
   }
   
   public SimpleGame (GUI a) {
      super(a);
      	}
   }