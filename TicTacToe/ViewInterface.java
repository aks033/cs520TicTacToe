package TicTacToe;

import javax.swing.*;

public interface ViewInterface {
    JButton[][] blocks = new JButton[3][3];
    JButton reset = new JButton("Reset");
    JTextArea playerturn= new JTextArea();

    void setPlayerTurn(String message);
}
