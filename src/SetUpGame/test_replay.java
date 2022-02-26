package SetUpGame;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Font;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

import SetUpGame.productionGame_replay;
import SetUpGame.productionGUI_replay;

class test_replay {
	productionGUI_replay gui;
	@Test
	void test() {
		productionGame_replay test = new productionGame_replay();
		gui = new productionGUI_replay();
		for (int i = 0; i <64; i++)
		{
			gui.Node[i]= new JButton();
			gui.Node[i].setText("S");
			gui.Node[i].setFocusable(false);
			gui.Node[i].setFont(new Font("Tahoma", Font.PLAIN, 31));

		}
		test.resetgame(gui);
		for (int i = 0; i <64; i++)
		{
			assertNotEquals(gui.Node[i].getText(), "S");
			assertNotEquals(gui.Node[i].getText(), "O");
			assertNotEquals(test.score1, 0);
			assertNotEquals(test.score2, 0);

		}
	}

}
