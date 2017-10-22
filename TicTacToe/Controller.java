package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ControllerInterface {

        Model model;
        JButton[][] buttons;

    Controller(Model model)
    {
        this.model = model;
        buttons = model.getButtonsMatrix();
        addActionListeners();

    }

    private void addActionListeners() {

        for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++)
                buttons[row][column].addActionListener(this);
        }

        model.getResetButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setSymbolPlayer();
        model.decrementTurnsLeft();
        model.setTurnText("'X': Player 1");
        if(model.turnsLeft%2 == 1) {
             model.setTurnText("'X': Player 1");
        } else{
            model.setTurnText("'O': Player 2");
        }
        ((JButton)e.getSource()).setText(model.userSymbol);
        ((JButton)e.getSource()).setEnabled(false);
        if (diagonalCheck() || columnRowCheck()){
            model.setTurnText("Player "+model.player + " wins");
            disableButtons();
        }
        else if(model.turnsLeft==0){
            model.setTurnText("Draw");
        }
    }


     public boolean diagonalCheck(){
        if (buttons[0][0].getText() == buttons[1][1].getText() &&
                buttons[1][1].getText() == buttons[2][2].getText() &&
                buttons[0][0].getText()  != "")
            return(true);

        if (buttons[2][0].getText() == buttons[1][1].getText() &&
                buttons[1][1].getText() == buttons[0][2].getText() &&
                buttons[2][0].getText()  != "")
            return(true);
        return(false);
    }

    public boolean columnRowCheck(){
            for (int i=0; i<3; i++)
            {
                if (buttons[0][i].getText() == buttons[1][i].getText() &&
                        buttons[1][i].getText() == buttons[2][i].getText() &&
                        buttons[0][i].getText() != "")
                    return (true);
                if (buttons[i][0].getText() == buttons[i][1].getText()&&
                        buttons[i][1].getText() == buttons[i][2].getText() &&
                        buttons[i][0].getText() != "")
                    return (true);
            }
            return(false);
    }


    public void disableButtons(){
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                buttons[row][column].setText("");
                buttons[row][column].setEnabled(true);
            }
        }
        model.player = 1;
        model.turnsLeft = 9;
        model.setTurnText("Player 1 to play 'X'");
    }
}
