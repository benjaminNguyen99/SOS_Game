package SetUpGame;

import java.awt.Font;

import javax.swing.JButton;

public class productionGUI_newgame {
   /*package*/ productionGame_newgame game;
   /*package*/ JButton replay = new JButton("New Game");
   /*package*/ JButton[] Node = new JButton[64];
   public void GUI() {
      for (int i = 0; i <64; i++)
      		{
      			Node[i]= new JButton();
      
      			Node[i].setFocusable(false);
      			Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));
      		}
      		replay.setFont(new Font("Tahoma", Font.PLAIN, 30));
      		replay.setBounds(878, 768, 172, 67);	
      	}
   
   }
