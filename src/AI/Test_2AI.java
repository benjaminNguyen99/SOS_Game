package AI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

class Test_2AI {

	@Test
	void test() {
		production_2AI test = new production_2AI(); 
		GUI_AI board = new GUI_AI();
		JButton[] newBoard = board.create_general();
		boolean p = true;
		for (int i =0; i < 9; i++)
		{
			if (p == true)
			{
				newBoard = test.forAI(i, newBoard, p);
				p = false;
			}
			else
			{
				newBoard = test.forAI(i, newBoard, p);
				p = true;
			}
				
	
			
			
		}
		for (int i =0; i < 9; i++)
		{
			assertEquals(newBoard[i].getText(), "S");
		}
	}

}
