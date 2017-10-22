package TicTacToe;

import javax.swing.*;

public interface ModelInterface {
    void setSymbolPlayer()throws Exception;
    void decrementTurnsLeft()throws Exception;
    JButton[][] getButtonsMatrix()throws Exception;
    JButton getResetButton()throws Exception;
    void setTurnText(String message)throws Exception;
}
