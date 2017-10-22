package TicTacToe;

import javax.swing.*;

class Model {
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
    void setSymbolPlayer(){
        if (turnsLeft%2 == 1){
            userSymbol = "X";
            player = 1;
        }
        else{
            userSymbol = "O";
            player = 2;
        }
    }

    void decrementTurnsLeft(){
        turnsLeft--;
    }



    JButton[][] getButtonsMatrix(){

        return view.blocks;
    }

    JButton getResetButton(){

        return view.reset;
    }

    void setTurnText(String message){

        view.setPlayerTurn(message);
    }
}
