package TicTacToe;

import javax.swing.*;

public interface ModelInterface {
    void setSymbolPlayer();
    void decrementTurnsLeft();
    JButton[][] getButtonsMatrix();
    JButton getResetButton();
    void setTurnText(String message);
}
