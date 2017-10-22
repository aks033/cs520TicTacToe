package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ControllerInterface extends ActionListener {
    @Override
    void actionPerformed(ActionEvent e);
    boolean diagonalCheck();
    boolean columnRowCheck();
    void disableButtons();
    void resetGame();

}
