package determinewinner;

import javax.swing.JButton;

/*package*/ class production_winner {
	class multi
	{
		int sc;
		public String no;
		multi(int a, String b)
		{
			sc = a;
			no = b; 
		}
	}
   public boolean simplegame() {
	   
      GUI_winner win = new GUI_winner(); 
      		JButton[] Node = new JButton[9]; //case if player 1 is the winner
      		Node = win.create();
      		production_winner test = new production_winner();
      		determinewinner.production_winner.multi result = test.checkwinner(Node, 2, true); 
      		if (result.sc == 1)
      		{
      			return true;
      		}
      		return false;
      	}
   
   public boolean simplegame_fullboard() {
      GUI_winner win = new GUI_winner(); 
      		JButton[] Node2 = new JButton[9]; //case if board is full in simple game
      		Node2 = win.create_filled();
      		
      		production_winner test2 = new production_winner();
      		determinewinner.production_winner.multi result2 = test2.checkwinner(Node2, 2, true); 
      		int c = 0;
      		for (int i =0; i < 9; i ++)
      		{
      			if (Node2[i].getText() != "")
      			{
      				c++;
      			}
      		}
      		if (result2.sc == 0 && c == 9)
      		{
      			return true;
      		}
      		else 
      		{
      			return false;
      		}
      	}
   
   public boolean generalgame() {
      GUI_winner win = new GUI_winner(); 
      		JButton[] Node = new JButton[9]; //case if board is full in simple game
      		Node = win.create();
      		
      		production_winner test = new production_winner();
      		determinewinner.production_winner.multi result = test.checkwinner(Node, 2, true); 
      		int c = 0;
      		for (int i =0; i < 9; i ++)
      		{
      			if (Node[i].getText() != "")
      			{
      				c++;
      			}
      		}
      		if (c != 9 && result.sc != 0)
      		{
      			return false;
      		}
      		else if (c!= 9 && result.sc == 0)
      		{
      			return false;
      		}
      		else
      		{
      			return true;
      		}
      	}
   
   public multi checkwinner(JButton[] Node, int assign, boolean player) {
      int count =0;
      		int search_row = 0;
      		int search_column = 0;
      		int limit = (3 * 3);
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
      		else if (c==3* 3 && count == 0) 
      		{
      			return new multi(count, "tie");
      		}
      		else
      		{
      			return new multi(count, "nothing");
      		}
      	}
   
   }
