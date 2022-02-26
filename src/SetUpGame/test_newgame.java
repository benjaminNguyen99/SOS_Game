package SetUpGame;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Font;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

class test_newgame {
	productionGUI_newgame gui;
	int score =10;
	int score2 = 9;
	@Test
	void test() {
		productionGame_newgame test = new productionGame_newgame();
		gui = new productionGUI_newgame();
		for (int i = 0; i <64; i++)
		{
			gui.Node[i]= new JButton();
			gui.Node[i].setText("S");
			gui.Node[i].setFocusable(false);
			gui.Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));

		}
		test.newgame(gui);
		score = test.resetscore(score);
		score2 = test.resetscore(score);
		for (int i = 0; i <64; i++)
		{
			assertNotEquals(gui.Node[i].getText(), "S");
			assertNotEquals(gui.Node[i].getText(), "O");
		}
		assertEquals(score, 0);
		assertEquals(score2, 0);
	}

}
