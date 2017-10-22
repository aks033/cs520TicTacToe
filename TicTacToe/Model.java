package TicTacToe;

import javax.swing.*;

class Model implements ModelInterface {
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

    public void decrementTurnsLeft(){
        turnsLeft--;
    }



    public JButton[][] getButtonsMatrix(){

        return view.blocks;
    }

    public JButton getResetButton(){

        return view.reset;
    }

    public void setTurnText(String message){

        view.setPlayerTurn(message);
    }
}
