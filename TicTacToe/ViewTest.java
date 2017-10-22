package TicTacToe;

import junit.framework.TestCase;

public class ViewTest extends TestCase {
    public void testSetPlayerTurn() throws Exception {
        TicTacToe.View view = new TicTacToe.View();

        assertEquals("Player 1 to play X",view.playerturn.getText());
    }

}