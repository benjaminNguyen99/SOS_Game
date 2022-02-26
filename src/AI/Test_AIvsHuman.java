package AI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;


class Test_AIvsHuman {

	@Test
	void test() {
		production_AIvsHuman test = new production_AIvsHuman(); 
		JButton[] board = test.forAI();
		assertEquals(board[2].getText(), "S");
	
	}

}
