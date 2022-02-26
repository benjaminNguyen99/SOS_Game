package SOSpackage;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class GUI extends JPanel implements ActionListener {
   /*package*/ Game game;
   /*package*/ int Isize = isNumeric();
   /*package*/ JButton[] Node = new JButton[Isize*Isize];
   /*package*/ JPanel Grid = new JPanel();
   /*package*/ JLabel greenturn = new JLabel("");
   /*package*/ JLabel redturn = new JLabel("");
   /*package*/ JRadioButton S1 = new JRadioButton("S");
   /*package*/ JRadioButton O1 = new JRadioButton("O");
   /*package*/ JRadioButton S2 = new JRadioButton("S");
   /*package*/ JRadioButton O2 = new JRadioButton("O");
   /*package*/ ButtonGroup SO1 = new ButtonGroup();
   /*package*/ ButtonGroup SO2 = new ButtonGroup();
   /*package*/ ButtonGroup mode = new ButtonGroup();
   /*package*/ ButtonGroup p2 = new ButtonGroup();
   /*package*/ ButtonGroup p1 = new ButtonGroup();
   /*package*/ JButton replay = new JButton("Replay");
   /*package*/ JButton newgame = new JButton("New Game");
   /*package*/ JButton P1score = new JButton("0");
   /*package*/ JButton P2score = new JButton("0");
   /*package*/ JRadioButton comp1 = new JRadioButton("Computer");
   /*package*/ JRadioButton human1 = new JRadioButton("Human");
   /*package*/ JRadioButton human2 = new JRadioButton("Human");
   /*package*/ JRadioButton comp2 = new JRadioButton("Computer");
   /*package*/ JRadioButton simplegame = new JRadioButton("Simple Game");
   /*package*/ JRadioButton genegame = new JRadioButton("General Game");
   /*package*/ JButton btnStartGame = new JButton("Start Game");
   /*package*/ JLabel greenside = new JLabel("");
   /*package*/ JLabel redside = new JLabel("");
   /*package*/ JLabel intromode = new JLabel("");
   /*package*/ JButton P1score_1_1 = new JButton("0");
   /*package*/ JButton P1score_1 = new JButton("0");
   public static int isNumeric() {
      String S = JOptionPane.showInputDialog("Enter a number \"n\" to create your board (nxn)\n n:" );
      		
      		int d =0;
      		
      	    while (true)
      	    {
      	    	if (S == null) {
      	    		System.exit(0);
      	    		JOptionPane.showMessageDialog(null, "Please enter a valid number to create board!");
      	    		
      		    }
      	    	
      	    	else
      	    	{
      	    		try {
      			        d = Integer.parseInt(S);
      			        if (d <3)
      			        {
      			        	JOptionPane.showMessageDialog(null, "The size must be from 3!");
      			        	S = JOptionPane.showInputDialog("Enter a number n to create your board (nxn) :");
      			        }
      			        else 
      			        {
      			        	return d;
      			        }
      			        
      			    } catch (NumberFormatException nfe) {
      			    	
      			    	JOptionPane.showMessageDialog(null, "Valid input must be a number");
      			    	S = JOptionPane.showInputDialog("Enter a number n to create your board (nxn) :");
      			    }
      			    
      	    	}
      		    
      		    
      	    }
      	    
      	}
   
   public void initial() {
      redturn.setText("");
      		greenturn.setText("");
      		SO1.clearSelection();
      		SO2.clearSelection();
      		
      
      	}
   
   public void p1first() {
      greenturn.setText("Green Turn");
      		greenturn.setForeground(Color.GREEN);
      	}
   
   public void p2first() {
      redturn.setText("Red Turn");
      		redturn.setForeground(Color.RED);
      	}
   
   public void change1(int c) {
      redturn.setText("Red Turn");
      		greenturn.setText("");
      		redturn.setForeground(Color.RED);
      		Node[c].setForeground(Color.GREEN);
      	}
   
   public void getboard() {
      for (int i = 0; i <Isize*Isize; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      			Node[i].addActionListener(this);
      		}
      		
      	}
   
   public void change2(int d) {
      greenturn.setText("Green Turn");
      		redturn.setText("");
      		greenturn.setForeground(Color.GREEN);
      		Node[d].setForeground(Color.RED);
      	}
   
   public GUI (Game parentGame) {
      game = parentGame;
      		setLayout(null);
      		
      		JLabel Title = new JLabel("Benjamin Nguyen SOS Game");
      		Title.setFont(new Font("Tahoma", Font.PLAIN, 40));
      		Title.setBounds(282, 105, 529, 52);
      		add(Title);
      		
      		
      		human1.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		human1.setBounds(23, 267, 172, 59);
      		add(human1);
      		
      
      		S1.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		S1.setBounds(55, 329, 172, 59);
      		add(S1);
      		
      		
      		
      		O1.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		O1.setBounds(55, 401, 172, 59);
      		add(O1);
      		
      		
      		comp1.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		comp1.setBounds(23, 475, 172, 59);
      		add(comp1);
      		
      		
      		human2.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		human2.setBounds(893, 267, 172, 59);
      		add(human2);
      		
      		
      		S2.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		S2.setBounds(934, 329, 172, 59);
      		add(S2);
      		
      		
      		O2.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		O2.setBounds(934, 401, 172, 59);
      		add(O2);
      		
      		
      		comp2.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		comp2.setBounds(893, 475, 172, 59);
      		add(comp2);
      		
      		
      		simplegame.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		simplegame.setBounds(306, 164, 234, 59);
      		add(simplegame);
      		
      		genegame.setFont(new Font("Tahoma", Font.PLAIN, 26));
      		genegame.setBounds(581, 164, 195, 59);
      		add(genegame);
      		
      		Grid.setForeground(Color.WHITE);
      		Grid.setSize(470, 476);
      		Grid.setLocation(306, 231);
      		Grid.setLayout(new GridLayout(Isize, Isize));
      		Grid.setBackground(new Color(150, 150, 150));
      		
      		getboard();
      		
      		
      		add(Grid);
      		
      		replay.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				btnStartGame.setEnabled(true);
      				game.enableradio();
      				initial();
      				game.resetgame();
      				greenside.setText("");
      				redside.setText("");
      				intromode.setText("");
      			}
      		});
      		
      		replay.setFont(new Font("Tahoma", Font.PLAIN, 30));
      		replay.setBounds(878, 768, 172, 67);
      		add(replay);
      		
      		btnStartGame.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				btnStartGame.setEnabled(false);
      				game.disableradio();
      				initial();
      				game.resetgame();
      				game.whogofirst();
      				game.printnoti();
      				
      				
      				
      				if (simplegame.isSelected() && (comp2.isSelected() || comp1.isSelected()))
      				{
      					game.frame =   new SimpleGamewithAI(game.gui); 
      					if (comp1.isSelected() && comp2.isSelected())
      					{
      						for (int i =0; i < Isize*Isize; i++)
      						{
      							if (game.player1 || game.player2)
      							{
      								game.forAI();	
      							}
      						}
      						      					}
      				}
      				else if (genegame.isSelected() && (comp2.isSelected() || comp1.isSelected()))
      				{
      					game.frame =   new GeneralGamewithAI(game.gui); 
      					if (comp1.isSelected() && comp2.isSelected())
      					{
      						for (int i =0; i < Isize*Isize; i++)
      						{
      							if (game.player1 || game.player2)
      							{
      								game.forAI();	
      							}
      						}
      						
      						
      					}
      				}
      				else if (simplegame.isSelected())
      				{
      					game.frame =   new SimpleGame(game.gui); 
      				}
      				else if (genegame.isSelected())
      				{
      					game.frame =   new GeneralGame(game.gui); 
      				}
      				
      				
      			}
      		});
      		
      		replay.setFont(new Font("Tahoma", Font.PLAIN, 30));
      		replay.setBounds(878, 768, 172, 67);
      		add(replay);
      		add(btnStartGame);
      		
      		
      		newgame.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      			
      				
      				initial();
      				game.enableradio();
      				game.resetgame();
      				btnStartGame.setEnabled(true);
      				P1score.setText("0");
      				P2score.setText("0");
      				greenside.setText("");
      				redside.setText("");
      				intromode.setText("");
      				game.score1 = 0;
      				game.score2 = 0;
      				
      			}
      		});
      		newgame.setFont(new Font("Tahoma", Font.PLAIN, 28));
      		newgame.setBounds(878, 861, 172, 67);
      		add(newgame);
      		
      		
      		greenturn.setFont(new Font("Tahoma", Font.PLAIN, 30)); greenturn.setBounds(39, 630, 188, 44); add(greenturn);
      		redturn.setFont(new Font("Tahoma", Font.PLAIN, 30)); redturn.setBounds(862, 630, 188, 44); add(redturn);
      		
      		p1.add(human1); p1.add(comp1);
      		
      		p2.add(human2); p2.add(comp2);
      		
      		SO1.add(S1); SO1.add(O1);
      		
      		SO2.add(S2); SO2.add(O2);
      		
      		mode.add(simplegame); mode.add(genegame);
       
       JLabel P1 = new JLabel("Player 1");
       P1.setFont(new Font("Tahoma", Font.PLAIN, 33));
       P1.setBounds(39, 108, 140, 52);
       add(P1);
       
       
       P1score.setFont(new Font("Tahoma", Font.PLAIN, 30));
       P1score.setBounds(55, 164, 89, 61);
       add(P1score);
       
       JLabel P2 = new JLabel("Player 2");
       P2.setFont(new Font("Tahoma", Font.PLAIN, 33));
       P2.setBounds(896, 108, 140, 52);
       add(P2);
       
       P2score.setFont(new Font("Tahoma", Font.PLAIN, 30));
       P2score.setBounds(912, 162, 89, 61);
       add(P2score);
       
       JLabel lblNewLabel = new JLabel("Board Size");
       lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
       lblNewLabel.setBounds(842, 38, 164, 59);
       add(lblNewLabel);
       btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 30));
       btnStartGame.setBounds(25, 721, 214, 67);
       greenside.setFont(new Font("Tahoma", Font.PLAIN, 20));
       greenside.setBounds(306, 732, 204, 44);
       
       add(greenside);
       redside.setFont(new Font("Tahoma", Font.PLAIN, 20));
       redside.setBounds(572, 732, 204, 44);
       
       add(redside);
       intromode.setFont(new Font("Tahoma", Font.PLAIN, 20));
       intromode.setBounds(306, 787, 470, 44);
       
       add(intromode);
       
       JButton displaysize = new JButton("");
       displaysize.setFont(new Font("Tahoma", Font.PLAIN, 20));
       displaysize.setBounds(1003, 38, 89, 49);
       add(displaysize);
       displaysize.setText(String.valueOf(Isize));
       
       
       P1score_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
       P1score_1.setBounds(154, 173, 49, 52);
       add(P1score_1);
       
      
       P1score_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
       P1score_1_1.setBounds(853, 171, 49, 52);
       add(P1score_1_1);
       
      
      	
      	}
   
   @Override
   public void actionPerformed (ActionEvent e) 
   {
      game.actionPerformed(e);
      		
      		
      	}
   }
