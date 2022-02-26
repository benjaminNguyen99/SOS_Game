package SetUpGame;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class productionGUI_replay {
   /*package*/ productionGame_replay game;
   /*package*/ JButton replay = new JButton("Replay");
   /*package*/ JButton[] Node = new JButton[64];
   public void GUI() {
      JPanel Grid = new JPanel();
      		for (int i = 0; i <64; i++)
      		{
      			Node[i]= new JButton();
      			Grid.add(Node[i]);
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      
      		}
      		
      		
      		replay.setFont(new Font("Tahoma", Font.PLAIN, 30));
      		replay.setBounds(878, 768, 172, 67);
      		
      	
      		
      	}
   
   }
