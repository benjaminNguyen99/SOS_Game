package MakeMove;

import java.util.Random;
import javax.swing.JButton;

public class productionMove {
   /*package*/ Random rnd = new Random();
   /*package*/ boolean player1;
   /*package*/ boolean player2;
   /*package*/ GUImove gui;
   public JButton[] makemove(JButton[] Check, int player, int number, int i) {
      JButton[] New = Check;
      		int p = player;
      		int n = number;
      		
      			if (p == 0 && n == 0)
      			{
      				
      				if(New[i].getText()== "")
      				{
      					New[i].setText("S");
      					player1= false;
      					player2=true;
      				}
      				else if (New[i].getText()!= "")
      				{
      					player1= true;
      					player2=false;
      				}
      			}
      			else if (p == 0 && n == 1)
      			{
      				
      				if(New[i].getText()== "")
      				{
      					New[i].setText("O");
      					player1= false;
      					player2=true;
      				}
      				else if (New[i].getText()!= "")
      				{
      					player1= true;
      					player2=false;
      				}
      			}
      			else if (p == 1 && n == 2)
      			{
      				
      				if(New[i].getText()== "")
      				{
      					New[i].setText("S");
      					player1= true;
      					player2=false;
      				}
      				else if (New[i].getText()!= "")
      				{
      					player1= false;
      					player2=true;
      				}
      			}
      			else if (p == 1 && n == 3)
      			{
      				
      				if(New[i].getText()== "")
      				{
      					New[i].setText("O");
      					player1= true;
      					player2=false;
      				}
      				else if (New[i].getText()!= "")
      				{
      					player1= false;
      					player2=true;
      				}
      			}
      		
      		return New;
      	}
   
   }
