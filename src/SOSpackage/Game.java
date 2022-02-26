package SOSpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	 /*package*/ boolean player1;
	   /*package*/ boolean player2;
	   /*package*/ GUI gui;
	   /*package*/ int score1 = 0;
	   /*package*/ int score2 = 0;
	   /*package*/ int temp_score1 = 0;
	   /*package*/ int temp_score2 = 0;
	   /*package*/ Random rnd = new Random();
	   /*package*/ static Game frame = new Game();

	   
	   
	   public class multi
		{
			int sc;
			public String no;
			public multi(int a, String b)
			{
				sc = a;
				no = b; 
			}
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		   
		
	}
	

	/**
	 * Create the frame.
	 */
	


	
	  
	   /**
	    * Launch the application.
	    */
	   
	   public Game () {
	      gui = new GUI(this);
	      		
	      		this.add(gui);
	      		
	      	}
	   
	   /*package*/ void winner_simple (int b, String c) 
	   {
	   }
	   /*package*/ void winner_general (int b, int c, String o, boolean p) 
	   {
	   }
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
	      				if (score == 1 )
	      				{
	      					pickit = "S";
	      					signal = score;
	      					pick_index = a;
	      					break;
	      				}
	      				gui.Node[a].setForeground(Color.RED);
	      				gui.Node[a].setText("O");
	      				score2 = minimax(gui.Node, 0, false,a);
	      				gui.Node[a].setForeground(null);
	      				gui.Node[a].setText("");
	      				if (score2 == 1 )
	      				{
	      					pickit = "O";
	      					signal = score2;
	      					pick_index = a;
	      					break;
	      				}
	      
	      				else
	      				{
	      					if (score > signal ) 
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
	      						break;
	      					}
	      				}
	      				
	      			}
	      		}
	      		
	      			if (player1 ==true)
	      			{
	      				player1= false;
	      				player2=true;
	      				gui.Node[pick_index].setFont(new Font("Tahoma", Font.PLAIN, 20));
	      				gui.change1(pick_index);
	      			}
	      			else
	      			{
	      				player1= true;
	      				player2=false;
	      				gui.Node[pick_index].setFont(new Font("Tahoma", Font.PLAIN, 20));
	      				gui.change2(pick_index);
	      			}
	      			gui.Node[pick_index].setText(pickit);
	      
	      		
	      	
	      			multi checker = checkwinner(pick_index, false);
	      			if (gui.simplegame.isSelected())
	      			{
	      				if (checker.no != "tie")
	      				{
	      					frame.winner_simple(checker.sc, checker.no);					
	      				}
	      				else if (checker.no == "tie")
	      				{
	      					JOptionPane.showMessageDialog(gui, "tie");
	      					player1 = true;
	      					gui.change1(pick_index);
	      					recordgame(0);
	      					resetgame();
	      				}
	      			}
	      			else
	      			{
	      				frame.winner_general(checker.sc, pick_index, checker.no,player1);					
	      			}
	      			
	      		
	      	}
	   
	   public multi checkwinner(int assign, boolean player) {
		   
	      int count =0;
	      		int search_row = 0;
	      		int search_column = 0;
	      		int limit = (gui.Isize * gui.Isize);
	      		int total_row = gui.Isize;
	      		int[] each_row = new int[gui.Isize]; 
	      		int[] each_column = new int[gui.Isize]; 
	      		
	      		
	      		for (int i =0; i < gui.Isize; i++)
	      		{
	      			each_row[i]=i;
	      		}
	      		for (int i =0; i < gui.Isize; i++)
	      		{
	      			if (i == 0)
	      			{
	      				each_column[i]=i;
	      			}
	      			else
	      			{
	      				each_column[i] = each_column[i-1]+ gui.Isize;
	      			}
	      			
	      		}
	      		outer : for (int i =0; i < total_row; i++)
	      		{
	      			for (int b : each_column)
	      			{
	      				if (assign != b)
	      				{
	      					search_column += 1;
	      					if (search_column == gui.Isize)
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
	      					if (search_row == gui.Isize)
	      					{
	      						for (int c = 0; c < each_row.length; c++)
	      						{
	      							each_row[c] += gui.Isize;
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
	      		if ( (!(assign-gui.Isize<0)) &&  ((assign+gui.Isize<limit)) )
	      		{
	      			if (gui.Node[assign].getText() == "O" && gui.Node[assign-gui.Isize].getText() == "S" && gui.Node[assign+gui.Isize].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		
	      		if ( (!(assign-gui.Isize-1<0)) &&  ((assign+gui.Isize+1<limit)) && (assign != each_row[0]) && (assign != each_row[gui.Isize-1]))
	      		{
	      			if (gui.Node[assign].getText() == "O" && gui.Node[assign-gui.Isize-1].getText() == "S" && gui.Node[assign+gui.Isize+1].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}	
	      		if ( (!(assign-gui.Isize+1<0)) &&  ((assign+gui.Isize-1<limit)) && (assign != each_row[0]) && (assign != each_row[gui.Isize-1]))
	      		{
	      			if (gui.Node[assign].getText() == "O" && gui.Node[assign-gui.Isize+1].getText() == "S" && gui.Node[assign+gui.Isize-1].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if ( (!(assign-1<0)) &&  ((assign+1<limit)) && (!(assign-1<each_row[0])) && (!(assign +1>each_row[gui.Isize-1])))
	      		{
	      			if (gui.Node[assign].getText() == "O" && gui.Node[assign-1].getText() == "S" && gui.Node[assign+1].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if ( ((!(assign-gui.Isize<0)) && (!(assign-(gui.Isize*2)<0))))
	      		{
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign-gui.Isize].getText() == "O" && gui.Node[assign-(gui.Isize*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      			
	      		}
	      		if ( (((assign+gui.Isize<limit))  &&  ((assign+(gui.Isize*2)<limit))))
	      		{
	      			
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign+gui.Isize].getText() == "O" && gui.Node[assign+(gui.Isize*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if ( ((!(assign-1<0)) && (!(assign-2<0))) && (!(assign-1<each_row[0])) && (!(assign -2 < each_row[0])))
	      		{
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign-1].getText() == "O" && gui.Node[assign-2].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if (   (assign+1<limit) &&  (assign+2<limit) && (!(assign+1>each_row[gui.Isize-1])) && (!(assign+2 > each_row[gui.Isize-1])))
	      		{
	      			
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign+1].getText() == "O" && gui.Node[assign+2].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	       		if (   ((assign+gui.Isize+1<limit))&& ((assign+((gui.Isize+1)*2)<limit)) && (assign!=each_row[gui.Isize-1])  )
	      		{
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign+gui.Isize+1].getText() == "O" && gui.Node[assign+((gui.Isize+1)*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if (  (!(assign-gui.Isize-1<0)) && (!(assign+((-gui.Isize-1)*2)<0)) && (assign!=each_row[0]))
	      		{
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign-gui.Isize-1].getText() == "O" && gui.Node[assign+((-gui.Isize-1)*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if (  (assign+gui.Isize-1<limit) && (assign+((gui.Isize-1)*2)<limit) && (assign!=each_row[0])&& (assign!=each_row[1]))
	      		{
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign+gui.Isize-1].getText() == "O" && gui.Node[assign+((gui.Isize-1)*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		if (  (!(assign-gui.Isize+1<0)) && (!(assign+((-gui.Isize+1)*2)<0))&& (assign!=each_row[gui.Isize-1] && (assign!=each_row[gui.Isize-2] )))
	      		{
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign-gui.Isize+1].getText() == "O" && gui.Node[assign+((-gui.Isize+1)*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      			
	      		}
	      		if (   ((assign+gui.Isize+1<limit))&& ((assign+((gui.Isize+1)*2)<limit)) && (assign!=each_row[gui.Isize-1]) )
	      		{
	      			
	      			if (gui.Node[assign].getText() == "S" && gui.Node[assign+gui.Isize+1].getText() == "O" && gui.Node[assign+((gui.Isize+1)*2)].getText() == "S" )
	      			{
	      				
	      				count++;
	      			}
	      		}
	      		int c = 0;
	      		for (int i =0; i < limit; i++)
	      		{
	      			if (gui.Node[i].getText() != "")
	      			{
	      				c+=1;
	      			}
	      		}
	      		
	      		
	      		if (gui.simplegame.isSelected() == true)
	      		{
	      			if (count != 0 && player == true )
	      			{
	      				
	      				return new multi(count, "player 1");
	      			}
	      			else if (count != 0 && player == false)
	      			{
	      				
	      				return new multi(count, "player 2");
	      			}
	      			else if (c==gui.Isize* gui.Isize) 
	      			{
	      				return new multi(count, "tie");
	      			}
	      			else
	      			{
	      				return new multi(count, "nothing");
	      			}
	      		}
	      		else
	      		{
	      			if (count != 0 && player == true && c <= limit)
	      			{
	      				
	      				return new multi(count, "player 1");
	      			}
	      			else if (count != 0 && player == false && c <= limit)
	      			{
	      				
	      				return new multi(count, "player 2");
	      			}
	      			else if (c==gui.Isize* gui.Isize) 
	      			{
	      				return new multi(count, "tie");
	      			}
	      			else
	      			{
	      				return new multi(count, "nothing");
	      			}
	      		}
	      	}
	   
	   public void whogofirst() {
	      if (gui.comp1.isSelected())
	      		{
	      			player2 = true;
	      			gui.p2first();
	      		}
	      		else if (gui.comp2.isSelected())
	      		{
	      			player1 = true;
	      			gui.p1first();
	      		}
	      		else
	      		{
	      			if (rnd.nextInt(2)==0)
	      			{ 
	      				
	      				player1= true;
	      				gui.p1first();
	      				
	      			}
	      			else
	      			{
	      				player2=true;
	      				gui.p2first();
	      			}
	      		}
	      		
	      	}
	   
	   public void printnoti() {
	      if (gui.human1.isSelected() && gui.human2.isSelected() && gui.simplegame.isSelected())
	      		{
	      			gui.greenside.setForeground(Color.GREEN);
	      			gui.greenside.setText("Green Player: Human");
	      			gui.redside.setForeground(Color.RED);
	      			gui.redside.setText("Red Player: Human");
	      			gui.intromode.setText("Simple Game Mode: Winner creates SOS first!!!");
	      		}
	      		else if (gui.human1.isSelected() && gui.human2.isSelected() && gui.genegame.isSelected())
	      		{
	      			gui.greenside.setForeground(Color.GREEN);
	      			gui.greenside.setText("Green Player: Human");
	      			gui.redside.setForeground(Color.RED);
	      			gui.redside.setText("Red Player: Human");
	      			gui.intromode.setText("General Game Mode: Winner creates more SOS!!!");
	      		}
	      		if (gui.human1.isSelected() && gui.comp2.isSelected() && gui.simplegame.isSelected())
	      		{
	      			gui.greenside.setForeground(Color.GREEN);
	      			gui.greenside.setText("Green Player: You");
	      			gui.redside.setForeground(Color.RED);
	      			gui.redside.setText("Red Player: Computer");
	      			gui.intromode.setText("Simple Game Mode: Winner creates SOS first!!!");
	      		}
	      		else if (gui.human2.isSelected() && gui.comp1.isSelected() && gui.genegame.isSelected())
	      		{
	      			gui.greenside.setForeground(Color.GREEN);
	      			gui.greenside.setText("Green Player: Computer");
	      			gui.redside.setForeground(Color.RED);
	      			gui.redside.setText("Red Player: You");
	      			gui.intromode.setText("General Game Mode: Winner creates more SOS!!!");
	      		}
	      		
	      	}
	   
	   public void enableradio() {
	      JRadioButton[] buttons = new JRadioButton[]{gui.human1, gui.human2, gui.simplegame, gui.genegame, gui.comp1, gui.comp2};
	      		for (JRadioButton btn : buttons) {
	      	         btn.setEnabled(true);
	      	    }
	      	}
	   
	   public void disableradio() {
	      JRadioButton[] buttons = new JRadioButton[]{gui.human1, gui.human2, gui.simplegame, gui.genegame, gui.comp1, gui.comp2};
	      		for (JRadioButton btn : buttons) {
	      	         btn.setEnabled(false);
	      	    }
	      	}
	   
	   public void P1move(int index, boolean SorO) {
	      gui.change1(index);
	      		gui.Node[index].setFont(new Font("Tahoma", Font.PLAIN, 20));
	      		if (SorO == true)
	      		{
	      			
	      			gui.Node[index].setText("S");
	      		}
	      		else
	      		{
	      			gui.Node[index].setText("O");
	      		}
	      		int c =0;
	      		for (int i =0; i < gui.Isize*gui.Isize; i ++)
	      		{
	      			if (gui.Node[i].getText() != "")
	      			{
	      				c+=1;
	      			}
	      		}
	      		if (index == gui.Isize * gui.Isize && c == gui.Isize * gui.Isize)
	      		{
	      			player1= true;
	      		}
	      		else
	      		{
	      			player1= false;
	      			player2=true;
	      		}
	      		
	      		multi checker = checkwinner(index, true);
	      
	      		if (gui.simplegame.isSelected() == true)
	      		{
	      			if (checker.no == "player 1")
	      			{
	      				frame.winner_simple(checker.sc, checker.no);
	      			}
	      			else if (checker.no == "tie")
	      			{
	      				frame.tie(index);
	      
	      			}
	      		}
	      		else
	      		{
	      			if (checker.no == "player 1")
	      			{
	      				frame.winner_general(checker.sc, index, checker.no, player1);
	      			}
	      			else if (checker.no == "tie")
	      			{
	      				frame.winner_general(checker.sc, index, checker.no,player1);
	      				
	      			}
	      		}
	      		
	      	}
	   
	   public void P2move(int index2, boolean SorO2) {
	      gui.change2(index2);
	      		gui.Node[index2].setFont(new Font("Tahoma", Font.PLAIN, 20));
	      		if (SorO2 == true)
	      		{
	      			gui.Node[index2].setText("S");
	      		}
	      		else
	      		{
	      			gui.Node[index2].setText("O");
	      		}
	      		int c =0;
	      		for (int i =0; i < gui.Isize*gui.Isize; i ++)
	      		{
	      			if (gui.Node[i].getText() != "")
	      			{
	      				c+=1;
	      			}
	      		}
	      		if (index2 == gui.Isize * gui.Isize && c == gui.Isize * gui.Isize)
	      		{
	      			player2= true;
	      		}
	      		else
	      		{
	      			player1 = true;
	      			player2 = false;
	      		}
	      	
	      	
	      		multi checker = checkwinner(index2, false);
	      		if (gui.simplegame.isSelected() == true)
	      		{
	      			if (checker.no == "player 2")
	      			{
	      				frame.winner_simple(checker.sc, checker.no);
	      			}
	      			else if (checker.no == "tie")
	      			{
	      				frame.tie(index2);
	      				
	      			}
	      			
	      		}
	      		else
	      		{
	      				frame.winner_general(checker.sc, index2, checker.no, player1);
	      		}
	      	}
	   
	   public void resetgame() {
	      for (int i = 0; i <gui.Isize * gui.Isize ; i++)
	      		{
	      			gui.Node[i].setText("");
	      			
	      		}
	      		temp_score1 = 0;
	      		temp_score2 = 0;
	      		gui.P1score_1.setText("0");
	      		gui.P1score_1_1.setText("0");
	      		
	      		
	      
	      	}
	   
	   public void tie(int b) {
	      JOptionPane.showMessageDialog(gui, "Tie");
	      		if (player1)
	      		{
	      			gui.change2(b);
	      		}
	      		else
	      		{
	      			gui.change1(b);
	      		}
	      		recordgame(0);
	      		resetgame();
	      	}
	   
	   public void humanmove(int loc) {
	      if (player1 && gui.S1.isSelected())
	      		{
	      			
	      			if(gui.Node[loc].getText()== "")
	      			{
	      				P1move(loc, true);	
	      			}
	      			
	      		}
	      		else if (player1 && gui.O1.isSelected())
	      		{
	      			
	      			if(gui.Node[loc].getText()== "")
	      			{
	      				P1move(loc, false);
	      				
	      			}
	      		}
	      
	      		else if (player2 && gui.S2.isSelected())
	      		{	
	      			if(gui.Node[loc].getText()== "")
	      			{
	      				P2move(loc, true);
	      			}
	      		}
	      		else if (player2 && gui.O2.isSelected())
	      		{	
	      			if(gui.Node[loc].getText()== "")
	      			{
	      				P2move(loc, false);
	      			}
	      		}
	      	}
	   
	   public Game (GUI a) {
	      gui = a;
	      		
	      		
	      	}
	   
	   public int minimax(JButton[] Board, int depth, boolean currentstate, int c) {
	      boolean cond = true;
	      			multi basecase = checkwinner(c, currentstate);
	      			if (basecase.no == "player 1")
	      			{
	      				return -1;
	      			}
	      			else if (basecase.no == "player 2")
	      			{
	      				return 1;
	      			}
	      			else if (basecase.no == "tie")
	      			{
	      				return 0;
	      			}
	      		
	      		if (currentstate == cond)
	      		{
	      			int best = -1000;
	      			int d = depth+1;
	      			for (int i = 0; i < gui.Isize* gui.Isize; i++)
	      			{
	      				if (gui.Node[i].getText() == "")
	      				{
	      
	      					gui.Node[i].setText("S");
	      					int score = minimax(gui.Node, d, false, i); 
	      					gui.Node[i].setText("");
	      					
	      					
	      					if (score == 1  || score == 0)
	      					{
	      						best = score;
	      						break;
	      					}
	      					else 
	      					{
	      		
	      						gui.Node[i].setText("O");
	      						int score2 = minimax(gui.Node, d, false, i);
	      						gui.Node[i].setText("");
	      						
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
	      			for (int i = 0; i < gui.Isize * gui.Isize; i++)
	      			{
	      				if (gui.Node[i].getText() == "")
	      				{
	      				
	      					gui.Node[i].setText("S");
	      					int score = minimax(gui.Node, d, true,i);
	      					gui.Node[i].setText("");
	      					
	      					if (score == -1  || score == 0)
	      					{
	      						best= score;
	      						break;
	      					}
	      						
	      					else
	      					{
	      					
	      						gui.Node[i].setText("O");
	      						int score2 = minimax(gui.Node, d, true,i);
	      					
	      						gui.Node[i].setText("");
	      						
	      						if (score2 < score  )
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
	   
	   public void recordgame(int win)
	   {
		   try {
		       FileWriter file = new FileWriter("C:\\Users\\phuc3\\eclipse-workspace\\SOS_CS449\\src\\SOSpackage\\Record.txt", true);
		       file.write("\nThe board size is " + gui.Isize + "*" + gui.Isize  + "\n");
		       if (gui.simplegame.isSelected())
		       {
		    	 file.write("Simple Game is Selected!\n");
		    	 
		       }
		       else
		       {
		    	   file.write("General Game is Selected!\n");
		       }
		       if (gui.human1.isSelected())
		       {
		    	   file.write("Player 1: Human vs ");
		       }
		       if (gui.human2.isSelected())
		       {
		    	   file.write("Player 2: Human \n");
		       }
		       if (gui.comp1.isSelected())
		       {
		    	   file.write("Player 1: Computer vs ");
		       }
		       if (gui.comp2.isSelected())
		       {
		    	   file.write("Player 2: Computer \n");
		       }
		       for (int i = 0; i < gui.Isize * gui.Isize; i++)
		       {
		    	   if (gui.Node[i].getText() == "S")
		    	   {
		    		   if (gui.Node[i].getForeground() == Color.GREEN)
		    		   {
		    			   file.write("Player 1: Node " + (i+1) + "- S \n");
		    		   }
		    		   else 
		    		   {
		    			   file.write("Player 2: Node " + (i+1) + "- S \n");
		    		   }
		    	   }
		    	   else if (gui.Node[i].getText() == "O")
		    	   {
		    		   if (gui.Node[i].getForeground() == Color.GREEN)
		    		   {
		    			   file.write("Player 1: Node " + (i+1) + "- O \n");
		    		   }
		    		   else 
		    		   {
		    			   file.write("Player 2: Node " + (i+1) + "- O \n");
		    		   }
		    	   }
		       }
		       if (win == 1)
		       {
		    	   file.write("Player 1 wins this game \n");
		       }
		       else if (win == 2)
		       {
		    	   file.write("Player 2 wins this game \n");
		       }
		       else 
		       {
		    	   file.write("Game Draw! \n");
		       }
		       file.write("---------------------------------\n");
		       file.close();
		    } 
		   catch (IOException e) 
		   {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
	   }
	   
	   @Override
	   public void actionPerformed (ActionEvent e) 
	   {
	      if (gui.human1.isSelected() && gui.human2.isSelected() && gui.simplegame.isSelected())    // 2 humans play simple game
	      		{
	      				disableradio();
	      				
	      				
	      				for (int i =0; i < gui.Isize* gui.Isize; i++)
	      				{
	      					if (e.getSource() == gui.Node[i])
	      					{
	      						humanmove(i);
	      						}}}
	      		if (gui.human1.isSelected() && gui.human2.isSelected() && gui.genegame.isSelected())   // 2 humans play general game
	      		{
	      				disableradio();
	      
	      				for (int i =0; i < gui.Isize* gui.Isize; i++)
	      				{
	      					if (e.getSource() == gui.Node[i])
	      					{
	      						
	      						humanmove(i);
	      					}}}
	      		
	      		if (gui.human1.isSelected() && gui.comp2.isSelected() && gui.simplegame.isSelected())
	      		{
	      			
	      			for (int i =0; i < gui.Isize* gui.Isize; i++)
	      			{
	      				
	      					if (e.getSource() == gui.Node[i])
	      					{
	      						humanmove(i);
	      					}
	      
	      					
	      					if (player2) {forAI();}}
	      
	      		}
	      		if (gui.human2.isSelected() && gui.comp1.isSelected() && gui.simplegame.isSelected())
	      		{
	      			
	      			for (int i =0; i < gui.Isize* gui.Isize; i++)
	      			{
	      				
	      					if (player2)
	      					{
	      						if (e.getSource() == gui.Node[i])
	      						{
	      							humanmove(i);
	      						}
	      					}
	      
	      					
	      					else {forAI();}}
	      
	      		}
	      		if (gui.human1.isSelected() && gui.comp2.isSelected() && gui.genegame.isSelected())
	      		{
	      			
	      			
	      			for (int i =0; i < gui.Isize* gui.Isize; i++)
	      			{
	      				
	      					if (e.getSource() == gui.Node[i])
	      					{
	      						humanmove(i);
	      					}
	      
	      					
	      					if (player2) {forAI();}}
	      		}	
	      		if (gui.human2.isSelected() && gui.comp1.isSelected() && gui.genegame.isSelected())
	      		{
	      			
	      			for (int i =0; i < gui.Isize* gui.Isize; i++)
	      			{
	      				
	      					
	      						if (e.getSource() == gui.Node[i])
	      						{
	      							humanmove(i);
	      						}
	      					
	      
	      					
	      					if (player1== true) {forAI(); }}
	      
	      		}
	      
	   }
}
