package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ControllerInterface extends ActionListener {
    @Override
    void actionPerformed(ActionEvent e);
    boolean diagonalCheck()throws Exception;
    boolean columnRowCheck()throws Exception;
    void disableButtons()throws Exception;
    void resetGame()throws Exception;

}
