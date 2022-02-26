package GameModeTest;

import javax.swing.JRadioButton;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ProductionGUI {
   /*package*/ JRadioButton simplegame = new JRadioButton("Simple Game");
   /*package*/ JRadioButton genegame = new JRadioButton("General Game");
   public JButton[] Node;
   @Test
   public void GUI () 
   {
      ButtonGroup mode = new ButtonGroup();
      	simplegame.setFont(new Font("Tahoma", Font.PLAIN, 26));
      	simplegame.setBounds(306, 164, 234, 59);
      	simplegame.setSelected(false);
      	
      	genegame.setFont(new Font("Tahoma", Font.PLAIN, 26));
      	genegame.setBounds(581, 164, 195, 59);
      	mode.add(simplegame); mode.add(genegame);
      	
      	assertNotNull(mode);	
      }
   }
