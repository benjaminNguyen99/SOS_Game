package SOSpackage;

import javax.swing.JOptionPane;

public class GeneralGame extends Game {
   public void winner_general(int b, int c, String o, boolean p) {
      if (gui.human1.isSelected() && gui.human2.isSelected())
      		{
      			if (o == "player 1")
      			{
      				temp_score1 += b;
      				gui.P1score_1.setText(String.valueOf(temp_score1));
      			}
      			else if (o == "player 2")
      			{
      				temp_score2 += b;
      				gui.P1score_1_1.setText(String.valueOf(temp_score2));
      			}
      			
      		}
      		if (gui.human1.isSelected() && gui.comp2.isSelected())
      		{
      			if (o == "player 1")
      			{
      				temp_score1 += b;
      				gui.P1score_1.setText(String.valueOf(temp_score1));
      			}
      			else if (o == "player 2")
      			{
      				temp_score2 += b;
      				gui.P1score_1_1.setText(String.valueOf(temp_score2));
      			}
      			
      		}
      		if (gui.human2.isSelected() && gui.comp1.isSelected())
      		{
      			
      			 if (o == "player 2")
      			{
      				 if (p == false)
      				 {
      					 temp_score1 += b;
      					gui.P1score_1.setText(String.valueOf(temp_score1));
      				 }
      				 else
      				 {
      					 temp_score2 += b;
      					gui.P1score_1_1.setText(String.valueOf(temp_score2));
      				 }
      				
      			}
      			
      		}
      		
      		int e =0;
      		for (int i =0; i < gui.Isize * gui.Isize; i++)
      		{
      			if (gui.Node[i].getText() != "")
      			{
      				e+=1;
      			}
      		}
      		if (e == gui.Isize * gui.Isize)
      		{
      			if (player1)
      			{
      				multi checker = checkwinner(gui.Isize*gui.Isize-1, true);
      				temp_score1+= checker.sc;
      			}
      			else if (player2)
      			{
      				multi checker = checkwinner(gui.Isize*gui.Isize-1, false);
      				temp_score2+= checker.sc;
      			}
      			if (temp_score1< temp_score2)
      			{
      				score2 += temp_score2;
      				score1 += temp_score1;
      				gui.P2score.setText(String.valueOf(score2));
      				gui.P1score.setText(String.valueOf(score1));
      				JOptionPane.showMessageDialog(gui, "player 2 wins");;
      				recordgame(2);
      				resetgame();
      			}
      			else if (temp_score1 > temp_score2)
      			{
      				score2 += temp_score2;
      				score1 += temp_score1;
      				gui.P2score.setText(String.valueOf(score2));
      				gui.P1score.setText(String.valueOf(score1));
      				JOptionPane.showMessageDialog(gui, "player 1 wins");
      				recordgame(1);
      				resetgame();
      			}
      			else if (temp_score1 == temp_score2)
      			{
      				score2 += temp_score2;
      				score1 += temp_score1;
      				gui.P2score.setText(String.valueOf(score2));
      				gui.P1score.setText(String.valueOf(score1));
      				JOptionPane.showMessageDialog(gui, "Tie");
      				gui.change2(c);
      				recordgame(0);
      				resetgame();
      			}
      		}
      	}
   
   public GeneralGame (GUI a) {
      super(a);
      		
      	}
   
   }
