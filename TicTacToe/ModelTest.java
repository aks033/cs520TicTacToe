package TicTacToe;

import junit.framework.TestCase;

public class ModelTest extends TestCase {
    public void testSetSymbolPlayer() throws Exception {
        TicTacToe.View view = new TicTacToe.View();
        TicTacToe.Model model = new TicTacToe.Model(view);

        assertEquals("X", model.userSymbol);
    }

}