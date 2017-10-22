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

    /***
     * Method to attach action listener to each play button of the grid and the reset button.
     * If reset button is pressed, it resets the entire game.
     */
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

    /***
     * This Method performs the logic of the game as and when the button is clicked on the GUI, it checks
     * diagonals, columns and rows to check if a player has won or if the match was a draw.
     * @param e: Action event
     */
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

    /***
     * This methods checks if the three characters present on any of the diagonals are the same.
     * @return : returns true if a diagonal check is met otherwise returns false
     */
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

    /***
     * This methods checks if the three characters present in any of the columns rows are the same.
     * @return returns true if a column or row check is met otherwise returns false
     */
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

    /***
     * This method disables the buttons when the game gets over.
     */
    public void disableButtons(){
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    /***
     * This method resets the game when the reset button is asserted. It resets the data in the model and also
     * clears the text associated with the buttons
     */
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
