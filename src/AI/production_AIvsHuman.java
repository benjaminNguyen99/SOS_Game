package AI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class production_AIvsHuman {
   /*package*/ boolean player1 = true;
   /*package*/ boolean player2 = false;
   public class multi
	{
		int sc;
		public String no;
		multi(int a, String b)
		{
			sc = a;
			no = b; 
		}
	}
   public JButton[] forAI() {
      int signal = -10000;
      
      		int pick_index = 0;
      		int c =0;
      		int score =0, score2=0;
      		String pickit="";
      		GUI_AI win = new GUI_AI(); 
      		JButton[] Node = new JButton[9]; //case if player 1 is the winner
      		Node = win.create();
      		
      
      		for (int a = 0; a < 9; a++)
      		{
      			if(Node[a].getText()== "")
      			{
      				
      				
      			
      				Node[a].setForeground(new Color(255, 0, 0));
      				Node[a].setText("S");
      		
      				score = minimax(Node, 0, false,a, -1000000, 1000000);
      				Node[a].setForeground(null);
      				Node[a].setText("");
      				Node[a].setForeground(new Color(255, 0, 0));
      				Node[a].setText("O");
      				score2 = minimax(Node, 0, false,a, -1000000, 1000000);
      				Node[a].setForeground(null);
      				Node[a].setText("");
      				
      			
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
      		
      			if (player1)
      			{
      				player1= false;
      				player2=true;
      				Node[pick_index].setFont(new Font("Tahoma", Font.PLAIN, 20));
      		
      			}
      			else
      			{
      				player1= true;
      				player2=false;
      				Node[pick_index].setFont(new Font("Tahoma", Font.PLAIN, 20));
      			
      			}
      			Node[pick_index].setText(pickit);
      
      		
      	
      			multi checker = checkwinner(Node, pick_index, true);
      			
      			if (checker.no != "tie")
      			{
      				return Node;					
      			}
      			else if (checker.no == "tie")
      			{
      				return Node;
      			}
      			else
      			{
      				return Node;
      			}
      
      		}
   
   public int minimax(JButton[] Node, int depth, boolean currentstate, int c, int alpha, int beta) {
      boolean cond = true;
      			multi basecase = checkwinner(Node ,c, currentstate);
      			
      			if (basecase.no == "player 2" || basecase.no == "player 1")
      			{
      				return 1;
      			}
      			else if (basecase.no == "tie")
      			{
      				return 0;
      			}
      			else if (basecase.no == "nothing")
      			{
      				return -1;
      			}
      		
      		if (currentstate == cond)
      		{
      			int best = -1000;
      			int d = depth+1;
      			for (int i = 0; i <9; i++)
      			{
      				if (Node[i].getText() == "")
      				{
      
      					Node[i].setText("S");
      					int score = minimax(Node, d, false, i, alpha, beta); 
      					Node[i].setText("");
      					
      					
      					if (score == 1  )
      					{
      						best = score;
      						break;
      					}
      					else 
      					{
      		
      						Node[i].setText("O");
      						int score2 = minimax(Node, d, false, i, alpha, beta);
      						Node[i].setText("");
      						
      						if (score2 > score )
      						{
      							best = score2;
      							break;
      						}
      						
      					}
      
      					
      				}
      			}
      			return best;
      		}
      		else
      		{
      			int best = 1000;
      			int d = depth+1;
      			for (int i = 0; i < 9; i++)
      			{
      				if (Node[i].getText() == "")
      				{
      				
      					Node[i].setText("S");
      					int score = minimax(Node, d, true,i, alpha, beta);
      					Node[i].setText("");
      					
      					if (score == -1)
      					{
      						best= score;
      						break;
      					}
      						
      					else
      					{
      					
      						Node[i].setText("O");
      						int score2 = minimax(Node, d, true,i, alpha, beta);
      					
      						Node[i].setText("");
      						
      						if (score2 < score)
      						{
      							best = score2;
      							break;
      						}
      						
      					}
      					
      				}
      			}
      			return best;
      		}
      	}
   
   public multi checkwinner(JButton[] Node, int assign, boolean player) {
      int count =0;
      		int search_row = 0;
      		int search_column = 0;
      		int limit = (3 * 3)-1;
      		int total_row = 3;
      		int[] each_row = new int[3]; 
      		int[] each_column = new int[3]; 
      		
      		
      		for (int i =0; i < 3; i++)
      		{
      			each_row[i]=i;
      		}
      		for (int i =0; i < 3; i++)
      		{
      			if (i == 0)
      			{
      				each_column[i]=i;
      			}
      			else
      			{
      				each_column[i] = each_column[i-1]+ 3;
      			}
      			
      		}
      		outer : for (int i =0; i < total_row; i++)
      		{
      			for (int b : each_column)
      			{
      				if (assign != b)
      				{
      					search_column += 1;
      					if (search_column == 3)
      					{
      						for (int c = 0; c < each_column.length; c++)
      						{
      							each_column[c] += 1;
      						}
      						search_column = 0;
      					}
      				}
      				else
      				{
      					break outer;
      				}
      			}
      		}
      		
      		outer : for (int i =0; i < total_row; i++)
      		{
      			for (int b : each_row)
      			{
      				if (assign != b)
      				{
      					search_row += 1;
      					if (search_row == 3)
      					{
      						for (int c = 0; c < each_row.length; c++)
      						{
      							each_row[c] += 3;
      						}
      						search_row = 0;
      					}
      				}
      				else
      				{
      					break outer;
      				}
      			}
      				
      		}
      		if ( (!(assign-3<0)) &&  ((assign+3<limit)) )
      		{
      			if (Node[assign].getText() == "O" && Node[assign-3].getText() == "S" && Node[assign+3].getText() == "S" )
      			{
      				Node[assign-3].setForeground(Node[assign].getForeground());
      				Node[assign+3].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		
      		if ( (!(assign-3-1<0)) &&  ((assign+3+1<limit)) && (assign != each_row[0]) && (assign != each_row[3-1]))
      		{
      			if (Node[assign].getText() == "O" && Node[assign-3-1].getText() == "S" && Node[assign+3+1].getText() == "S" )
      			{
      				Node[assign-3-1].setForeground(Node[assign].getForeground());
      				Node[assign+3+1].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}	
      		if ( (!(assign-3+1<0)) &&  ((assign+3-1<limit)) && (assign != each_row[0]) && (assign != each_row[3-1]))
      		{
      			if (Node[assign].getText() == "O" && Node[assign-3+1].getText() == "S" && Node[assign+3-1].getText() == "S" )
      			{
      				Node[assign-3+1].setForeground(Node[assign].getForeground());
      				Node[assign+3-1].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if ( (!(assign-1<0)) &&  ((assign+1<limit)) && (!(assign-1<each_row[0])) && (!(assign +1>each_row[3-1])))
      		{
      			if (Node[assign].getText() == "O" && Node[assign-1].getText() == "S" && Node[assign+1].getText() == "S" )
      			{
      				Node[assign-1].setForeground(Node[assign].getForeground());
      				Node[assign+1].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if ( ((!(assign-3<0)) && (!(assign-(3*2)<0))))
      		{
      			if (Node[assign].getText() == "S" && Node[assign-3].getText() == "O" && Node[assign-(3*2)].getText() == "S" )
      			{
      				Node[assign-3].setForeground(Node[assign].getForeground());
      				Node[assign-(3*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      			
      		}
      		if ( (((assign+3<limit))  &&  ((assign+(3*2)<limit))))
      		{
      			
      			if (Node[assign].getText() == "S" && Node[assign+3].getText() == "O" && Node[assign+(3*2)].getText() == "S" )
      			{
      				Node[assign+3].setForeground(Node[assign].getForeground());
      				Node[assign+(3*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if ( ((!(assign-1<0)) && (!(assign-2<0))) && (!(assign-1<each_row[0])) && (!(assign -2 < each_row[0])))
      		{
      			if (Node[assign].getText() == "S" && Node[assign-1].getText() == "O" && Node[assign-2].getText() == "S" )
      			{
      				Node[assign-1].setForeground(Node[assign].getForeground());
      				Node[assign-2].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if (   (assign+1<limit) &&  (assign+2<limit) && (!(assign+1>each_row[3-1])) && (!(assign+2 > each_row[3-1])))
      		{
      			
      			if (Node[assign].getText() == "S" && Node[assign+1].getText() == "O" && Node[assign+2].getText() == "S" )
      			{
      				Node[assign+1].setForeground(Node[assign].getForeground());
      				Node[assign+2].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
       		if (   ((assign+3+1<limit))&& ((assign+((3+1)*2)<limit)) && (assign!=each_row[3-1])  )
      		{
      			if (Node[assign].getText() == "S" && Node[assign+3+1].getText() == "O" && Node[assign+((3+1)*2)].getText() == "S" )
      			{
      				Node[assign+3+1].setForeground(Node[assign].getForeground());
      				Node[assign+((3+1)*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if (  (!(assign-3-1<0)) && (!(assign+((-3-1)*2)<0)) && (assign!=each_row[0]))
      		{
      			if (Node[assign].getText() == "S" && Node[assign-3-1].getText() == "O" && Node[assign+((-3-1)*2)].getText() == "S" )
      			{
      				Node[assign-3-1].setForeground(Node[assign].getForeground());
      				Node[assign+((-3-1)*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if (  (!(assign+3-1>limit)) && (!(assign+((3-1)*2)>limit)) && (assign!=each_row[0])&& (assign!=each_row[1]))
      		{
      			if (Node[assign].getText() == "S" && Node[assign+3-1].getText() == "O" && Node[assign+((3-1)*2)].getText() == "S" )
      			{
      				Node[assign+3-1].setForeground(Node[assign].getForeground());
      				Node[assign+((3-1)*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		if (  (!(assign-3+1<0)) && (!(assign+((-3+1)*2)<0))&& (assign!=each_row[3-1] && (assign!=each_row[3-2] )))
      		{
      			if (Node[assign].getText() == "S" && Node[assign-3+1].getText() == "O" && Node[assign+((-3+1)*2)].getText() == "S" )
      			{
      				Node[assign-3+1].setForeground(Node[assign].getForeground());
      				Node[assign+((-3+1)*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      			
      		}
      		if (   ((assign+3+1<limit))&& ((assign+((3+1)*2)<limit)) && (assign!=each_row[3-1]) )
      		{
      			
      			if (Node[assign].getText() == "S" && Node[assign+3+1].getText() == "O" && Node[assign+((3+1)*2)].getText() == "S" )
      			{
      				Node[assign+3+1].setForeground(Node[assign].getForeground());
      				Node[assign+((3+1)*2)].setForeground(Node[assign].getForeground());
      				count++;
      			}
      		}
      		int c = 0;
      		for (int i =0; i < limit; i++)
      		{
      			if (Node[i].getText() != "")
      			{
      				c+=1;
      			}
      		}
      		
      		if (count != 0 && player == true)
      		{
      			
      			return new multi(count, "player 1");
      		}
      		else if (count != 0 && player == false)
      		{
      			
      			return new multi(count, "player 2");
      		}
      		else if (c==3*3 && count == 0) 
      		{
      			return new multi(count, "tie");
      		}
      		else
      		{
      			return new multi(count, "nothing");
      		}
      	}
   
   }
