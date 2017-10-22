package TicTacToe;

import javax.swing.*;


final class Model implements ModelInterface {
    private View view; //
    int turnsLeft;
    String userSymbol;
    int player;

    Model(View view) {
        this.view = view;
        turnsLeft = 9;
        userSymbol = "X";
        player = 1;
    }

    /***
     * This method sets the symbol for the player after each click.
     */
    public void setSymbolPlayer(){
        if (turnsLeft%2 == 1){
            userSymbol = "X";
            player = 1;
        }
        else{
            userSymbol = "O";
            player = 2;
        }
    }

    /***
     * Method to decrement the value of turnLeft
     */
    public void decrementTurnsLeft(){
        turnsLeft--;
    }


    /***
     * Method to get the buttons from the view
     * @return: Jbutton[][] - returns the play buttons reference to Model
     */
    public JButton[][] getButtonsMatrix(){

        return view.blocks;
    }
    /***
     * Method to get the reset-button from the view
     * @return: Jbutton- returns the reset button reference to Model
     */
    public JButton getResetButton(){

        return view.reset;
    }

    /***
     * Method to set the text on the GUI by the view
     * @param message: message string to be printed on the view.
     */
    public void setTurnText(String message){

        view.setPlayerTurn(message);
    }
}
