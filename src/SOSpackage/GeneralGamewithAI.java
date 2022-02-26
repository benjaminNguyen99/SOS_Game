package SOSpackage;

import java.awt.Color;
import java.awt.Font;

public class GeneralGamewithAI extends GeneralGame {
   public void forAI() {
      int signal = -10000;
      		int pick_index = 0;
      		int c =0;
      		int score =0, score2=0;
      		String pickit="";
      		
      		for (int a = 0; a < gui.Isize * gui.Isize; a++)
      		{
      			if(gui.Node[a].getText()== "")
      			{
      				
      				
      			
      				gui.Node[a].setForeground(Color.RED);
      				gui.Node[a].setText("S");
      		
      				score = minimax(gui.Node, 0, false,a);
      				gui.Node[a].setForeground(null);
      				gui.Node[a].setText("");
      				gui.Node[a].setForeground(Color.RED);
      				gui.Node[a].setText("O");
      				score2 = minimax(gui.Node, 0, false,a);
      				gui.Node[a].setForeground(null);
      				gui.Node[a].setText("");
      				
      			
      				if (score > signal) 
      				{
      					
      					pickit = "S";
      					signal = score;
      					pick_index = a;
      					
      				}
      				if ( score2>signal )
      				{
      					pickit = "O";
      					signal = score2;
      					pick_index = a;
      				}
      			}
      		}
      		
      			player1= true;
      			player2=false;
      			gui.Node[pick_index].setFont(new Font("Tahoma", Font.PLAIN, 20));
      			gui.change2(pick_index);
      			gui.Node[pick_index].setText(pickit);
      
      		
      	
      			multi checker = checkwinner(pick_index, false);
      			if (checker.no == "player 2")
      			{
      				frame.winner_general(checker.sc, pick_index, checker.no, player1);				
      			}
      			else if (checker.no == "tie")
      			{
      				frame.tie(pick_index);
      			}
      		
      	}
   
   public GeneralGamewithAI (GUI a) {
      super(a);
      		
      	}
   
   }
